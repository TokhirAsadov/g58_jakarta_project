package uz.pdp.project.servlet.book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BookDetailServlet", urlPatterns = "/book/detail/*")
public class BookDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Book List Servlet...");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/book/book_list.jsp");
        dispatcher.forward(req,resp);
    }

}
