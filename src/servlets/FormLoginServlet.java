package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAOImplementation;
import model.Usuario;
import model.Favourite;
import model.Historial;

@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";	
	
	public FormLoginServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		List<Usuario> usuarios = UsuarioDAOImplementation.getInstance().readAll();
		//List<TFG> tfgs = TFGDAOImplementation.getInstance().readAll();
		//TFG tfg = TFGDAOImplementation.getInstance().login(email, password);
		Usuario usuario = UsuarioDAOImplementation.getInstance().login(email, password);
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
			req.getSession().setAttribute("admin", true);
			req.getSession().setAttribute("usuarios", usuarios);
			//req.getSession().setAttribute("tfgs", tfgs);			     
            getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
		} else if ( null != usuario ) {
			req.getSession().setAttribute("usuario",UsuarioDAOImplementation.getInstance().read(usuario.getEmail()));
			List<Favourite> favourites = usuario.getViajes_fav();
			req.getSession().setAttribute("favourites", favourites);
			List<Historial> historial = usuario.getHistorial();
			req.getSession().setAttribute("historial", historial);
			getServletContext().getRequestDispatcher("/MainView.jsp").forward(req,resp);
		} else	{
	        getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
		}
	}
}
