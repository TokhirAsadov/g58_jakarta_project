package uz.pdp.project.servlet.file;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(name = "FileStorageShowServlet", value = "/storage/show")
public class FileStorageShowServlet extends HttpServlet {
    private static final Path rootPath = Path.of("D:\\pdp\\G58\\Spring\\JakartaEE\\project\\books");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        Path path = rootPath.resolve(filename);
        byte[] bytes = Files.readAllBytes(path);
        resp.getOutputStream().write(bytes);
    }
}
