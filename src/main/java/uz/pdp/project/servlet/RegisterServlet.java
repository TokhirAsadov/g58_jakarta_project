package uz.pdp.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.project.service.UserService;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("register...............");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);
        System.out.println(password);

        boolean isCreated = UserService.createUser(firstname, lastname, email, password);
        if (isCreated) {
            Cookie cookie = new Cookie("g58_auth", email);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(24 * 3600);
            resp.addCookie(cookie);
            resp.sendRedirect("login.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }

    }
}
