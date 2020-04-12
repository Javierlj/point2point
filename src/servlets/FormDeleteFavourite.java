package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavouritesDAOImplementation;
import model.Favourites;
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
		String origen = req.getParameter("favori");
		String destino = req.getParameter("favdest");	
		Favourites favorito = FavouritesDAOImplementation.getInstance().login(id,origen,destino);
				
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		List<Favourites>favoritos = usuario.getViajes_fav();
		favoritos.remove(favorito);
		FavouritesDAOImplementation.getInstance().delete(favorito);
		usuario.setViajes_fav(favoritos);
		
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
