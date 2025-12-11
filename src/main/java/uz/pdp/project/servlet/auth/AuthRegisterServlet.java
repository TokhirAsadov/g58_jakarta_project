package uz.pdp.project.servlet.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.project.dao.UserDAO;
import uz.pdp.project.entity.User;
import uz.pdp.project.enums.UserStatus;
import uz.pdp.project.utils.EmailUtil;
import uz.pdp.project.utils.PasswordUtil;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "AuthRegisterServlet", value = "/auth/register")
public class AuthRegisterServlet extends HttpServlet {

    private static final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AuthLoginServlet Servlet is working.......");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/register.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("re-password");

        if (!EmailUtil.validate(email)){
            req.setAttribute("error_email","Email is invalid");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/register.jsp");
            dispatcher.forward(req,resp);
        }

        if (!password.equals(rePassword)){
            req.setAttribute("error_password","Password is invalid");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/register.jsp");
            dispatcher.forward(req,resp);
        }
        else {

            Optional<User> optionalUser = userDAO.findByEmail(email);

            if (optionalUser.isPresent()) {
                req.setAttribute("error_email","Email already taken");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/register.jsp");
                dispatcher.forward(req,resp);
            }


            User user = User.childBuilder()
                    .email(email)
                    .password(PasswordUtil.encode(password))
                    .role("USER")
                    .status(UserStatus.IN_ACTIVE)
                    .build();

            User save = userDAO.save(user);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/login.jsp");
            dispatcher.forward(req,resp);

        }
    }
}
