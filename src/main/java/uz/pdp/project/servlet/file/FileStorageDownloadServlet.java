package uz.pdp.project.servlet.file;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.project.dao.UploadDAO;
import uz.pdp.project.entity.Upload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet(name = "FileStorageDownloadServlet", value = "/storage/download")
public class FileStorageDownloadServlet extends HttpServlet {
    private static final Path rootPath = Path.of("D:\\pdp\\G58\\Spring\\JakartaEE\\project\\books");

    private static final UploadDAO uploadDAO = new UploadDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileID = req.getParameter("fileID");
        Upload upload = uploadDAO.findById(fileID);
        Path path = rootPath.resolve(upload.getPreparedName());
        byte[] bytes = Files.readAllBytes(path);
        resp.addHeader("Content-Type", upload.getMimeType());
        resp.addHeader("Content-Disposition", "attachment; filename="+upload.getOriginalName());
        resp.getOutputStream().write(bytes);
    }
}
