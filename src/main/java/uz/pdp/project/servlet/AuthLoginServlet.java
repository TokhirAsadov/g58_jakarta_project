package uz.pdp.project.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.project.dao.UserDAO;
import uz.pdp.project.entity.User;
import uz.pdp.project.utils.EmailUtil;
import uz.pdp.project.utils.PasswordUtil;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "AuthLoginServlet", value = "/auth/login")
public class AuthLoginServlet extends HttpServlet {
    private static final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AuthLoginServlet Servlet is working.......");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (
                !EmailUtil.validate(email)
                ||
                (password==null || password.isEmpty())
        ){
            req.setAttribute("error_message","Bad Credentials");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/login.jsp");
            dispatcher.forward(req,resp);
        }

        Optional<User> optionalUser = userDAO.findByEmail(email);
        optionalUser.ifPresentOrElse(
                (user) -> {
                    if (PasswordUtil.check(password, user.getPassword())){
                        HttpSession session = req.getSession();
                        session.setAttribute("id", user.getId());
                        session.setAttribute("role", user.getRole());
                        session.setAttribute("email", user.getEmail());
                        try {
                            resp.sendRedirect("/book/list");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                () -> {
                    req.setAttribute("error_message","User does not exist by email: "+email);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/login.jsp");
                    try {
                        dispatcher.forward(req,resp);
                    } catch (ServletException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
