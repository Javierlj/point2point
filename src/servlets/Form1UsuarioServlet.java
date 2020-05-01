package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAOImplementation;
import model.Usuario;



/**
 * Servlet implementation class Form1NuevoUsuario
 */
@WebServlet("/Form1UsuarioServlet")
public class Form1UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form1UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String apellidos = req.getParameter("apellidos");
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setName(name);
		usuario.setLast_name(apellidos);
		UsuarioDAOImplementation.getInstance().create(usuario);
		req.getSession().setAttribute("usuario", usuario);	
		getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
