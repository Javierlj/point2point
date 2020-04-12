package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavouriteDAOImplementation;
import model.Favourite;
import model.Usuario;

/**
 * Servlet implementation class FormDeleteFavourite
 */
@WebServlet("/FormDeleteFavourite")
public class FormDeleteFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormDeleteFavourite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("favid");

		Favourite favorito = FavouriteDAOImplementation.getInstance().readById(id);
				
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		List<Favourite> favoritos = usuario.getViajes_fav();
		favoritos.remove(favorito);
		FavouriteDAOImplementation.getInstance().delete(favorito);

		req.getSession().setAttribute("favourites", favoritos);
		req.getSession().setAttribute("usuario", usuario);
		
		getServletContext().getRequestDispatcher("/UsuarioView.jsp").forward(req, resp);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
