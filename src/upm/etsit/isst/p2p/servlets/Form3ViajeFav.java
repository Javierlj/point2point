package upm.etsit.isst.p2p.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upm.etsit.isst.p2p.dao.FavouriteDAOImplementation;
import upm.etsit.isst.p2p.model.Usuario;
import upm.etsit.isst.p2p.model.Favourite;

/**
 * Servlet implementation class Form3ViajeFav
 */
@WebServlet("/Form3ViajeFav")
public class Form3ViajeFav extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Form3ViajeFav() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String origin = req.getParameter("origin");
		String destiny = req.getParameter("destiny");

		float origin_lat = Float.parseFloat(req.getParameter("origin_lat"));
		float origin_long = Float.parseFloat(req.getParameter("origin_long"));
		float destiny_lat = Float.parseFloat(req.getParameter("destiny_lat"));
		float destiny_long = Float.parseFloat(req.getParameter("destiny_long"));

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Favourite favourite = new Favourite();
		favourite.setName(name);
		favourite.setOrigin_lat(origin_lat);
		favourite.setOrigin_long(origin_long);
		favourite.setDestiny_lat(destiny_lat);
		favourite.setDestiny_long(destiny_long);
		favourite.setDestiny(destiny);
		favourite.setOrigin(origin);

		favourite.setUsuario(usuario);

		FavouriteDAOImplementation.getInstance().create(favourite);

		List<Favourite> favourites = (List<Favourite>) req.getSession().getAttribute("favourites");
		favourites.add(favourite);

		req.getSession().setAttribute("favourites", favourites);
		req.getSession().setAttribute("usuario", usuario);
		getServletContext().getRequestDispatcher("/UserView.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}