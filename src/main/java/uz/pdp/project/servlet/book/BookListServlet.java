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
import java.util.List;

@WebServlet(name = "BookListServlet", value = "/book/list")
public class BookListServlet extends HttpServlet {
    private static final BookDAO bookDAO = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Book List Servlet...");
        List<Book> books = bookDAO.findAll();
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/book/book_list.jsp");
        dispatcher.forward(req,resp);
    }

}
