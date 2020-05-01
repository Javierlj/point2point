package servlets;

import dao.HistorialDAOImplementation;
import model.Historial;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/Form4Historial")
public class Form4Historial extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Form4Historial() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String origen = req.getParameter("origen");
        String destino = req.getParameter("destino");
        Double cost = Double.valueOf(req.getParameter("cost"));

        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");

        Historial historial = new Historial();
        historial.setOrigen(origen);
        historial.setDestino(destino);
        historial.setCost(cost);
        historial.setAdvisor(usuario);
        historial.setDate(new Date());

        HistorialDAOImplementation.getInstance().create(historial);

        List<Historial> historialList = (List<Historial>) req.getSession().getAttribute("historial");
        historialList.add(historial);

        req.getSession().setAttribute("historial", historialList);

        getServletContext().getRequestDispatcher("/UserView.jsp").forward(req, res);
    }
}
