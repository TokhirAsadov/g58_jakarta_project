package uz.pdp.project.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@WebFilter(value = "/*")
public class SecurityFilter implements Filter {

    private static final List<String> WHITE_URL = List.of(
            "/",
            "/auth/login",
            "/auth/register",
            "/book/list"
    );

    private static final Predicate<String> checkUrl = WHITE_URL::contains;

    private static final Predicate<String> isAdminUrl = (url) -> url.startsWith("/admin");

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String uri = request.getRequestURI();
        System.out.println("uri: " + uri);

        if (checkUrl.test(uri)) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            Object id = session.getAttribute("id");
            Object role = session.getAttribute("role");
            if (id == null) {
                response.sendRedirect("/auth/login?next="+uri);
            } else {
                if (Objects.equals("USER",role) && isAdminUrl.test(uri)) {
                    response.sendError(403);
                } else {
                    filterChain.doFilter(request, response);
                }

            }
        }


    }

}
