package uz.pdp.project.servlet.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import uz.pdp.project.dao.BookDAO;
import uz.pdp.project.dao.UploadDAO;
import uz.pdp.project.entity.Book;
import uz.pdp.project.entity.Upload;
import uz.pdp.project.utils.FileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@WebServlet(name = "AdminBookCreateServlet", value = "/admin/book/create")
@MultipartConfig
public class AdminBookCreateServlet extends HttpServlet {

    private static final Path rootPath = Path.of("D:\\pdp\\G58\\Spring\\JakartaEE\\project\\books");

    private static final BookDAO bookDAO = new BookDAO();
    private static final UploadDAO uploadDAO = new UploadDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Book Create Servlet...");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/book/book_create.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        Part file = req.getPart("file");
        String originalName = file.getSubmittedFileName();
        String extension = FileUtil.getExtension(originalName);
        Upload upload = Upload.childBuilder()
                .originalName(originalName)
                .preparedName(UUID.randomUUID() + "." + extension)
                .extension(extension)
                .size(file.getSize())
                .mimeType(file.getContentType())
                .build();
        uploadDAO.save(upload);
        Book book = Book.childBuilder()
                .title(title)
                .author(author)
                .description(description)
                .file(upload)
                .build();
        bookDAO.save(book);

        Path resolve = rootPath.resolve(upload.getPreparedName());
        System.out.println("resolve: "+resolve);
        Files.copy(file.getInputStream(),resolve, StandardCopyOption.REPLACE_EXISTING);
        resp.sendRedirect("/book/list");
    }
}
