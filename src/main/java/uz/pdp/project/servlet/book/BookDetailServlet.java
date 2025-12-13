package uz.pdp.project.servlet.book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.project.dao.BookDAO;
import uz.pdp.project.entity.Book;

import java.io.IOException;

@WebServlet(name = "BookDetailServlet", urlPatterns = "/book/detail/*")
public class BookDetailServlet extends HttpServlet {

    private static final BookDAO bookDAO = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BookDetailServlet Servlet...");
        String pathInfo = req.getPathInfo();
        String bookId = pathInfo.substring(1);
        Book book = bookDAO.findById(bookId);
        req.setAttribute("book", book);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/book/book_detail.jsp");
        dispatcher.forward(req,resp);
    }

}
