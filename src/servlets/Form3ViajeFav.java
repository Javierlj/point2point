package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavouriteDAOImplementation;
import model.Usuario;
import model.Favourite;

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
		String id = req.getParameter("id");
		String origen = req.getParameter("origen");
		String destino = req.getParameter("destino");

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Favourite favourite = new Favourite();
		favourite.setId(id);
		favourite.setOrigen(origen);
		favourite.setDestino(destino);
		favourite.setUsuario(usuario);

		FavouriteDAOImplementation.getInstance().create(favourite);

		List<Favourite> favourites = (List<Favourite>) req.getSession().getAttribute("favourites");
		favourites.add(favourite);

		req.getSession().setAttribute("favourites", favourites);
		req.getSession().setAttribute("usuario", usuario);
		getServletContext().getRequestDispatcher("/MainView.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
