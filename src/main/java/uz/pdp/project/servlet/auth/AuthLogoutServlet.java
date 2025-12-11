package uz.pdp.project.servlet.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.project.dao.UserDAO;

import java.io.IOException;

@WebServlet(name = "AuthLogoutServlet", value = "/auth/logout")
public class AuthLogoutServlet extends HttpServlet {
    private static final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AuthLoginServlet Servlet is working.......");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/logout.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("id");
        session.removeAttribute("role");
        session.removeAttribute("email");
        resp.sendRedirect("/book/list");
    }
}
