package uz.pdp.project.servlet.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminBookUpdateServlet", urlPatterns = "/admin/book/update/*")
public class AdminBookUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Book Create Servlet...");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/book/book_create.jsp");
        dispatcher.forward(req,resp);
    }

}
