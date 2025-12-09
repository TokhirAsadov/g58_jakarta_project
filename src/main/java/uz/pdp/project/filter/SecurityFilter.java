package uz.pdp.project.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

@WebFilter(value = "/*")
public class SecurityFilter implements Filter {

    private static final List<String> WHITE_URL = List.of(
            "/",
            "/auth/login",
            "/auth/register"
    );

    private static final Predicate<String> checkUrl = WHITE_URL::contains;


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();
        System.out.println("uri: "+uri);

        if (checkUrl.test(uri)) {
            filterChain.doFilter(request,response);
        } else {
//            response.sendError(401);
            response.sendRedirect("/auth/login");
        }


    }

}
