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
        float origin_lat = Float.parseFloat(req.getParameter("origin_lat"));
        float origin_long = Float.parseFloat(req.getParameter("origin_long"));
        float destiny_lat = Float.parseFloat(req.getParameter("destiny_lat"));
        float destiny_long = Float.parseFloat(req.getParameter("destiny_long"));
        Double cost = Double.valueOf(req.getParameter("cost"));

        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");

        Historial historial = new Historial();
        historial.setOrigin_lat(origin_lat);
        historial.setOrigin_long(origin_long);
        historial.setDestiny_lat(destiny_lat);
        historial.setDestiny_long(destiny_long);
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
