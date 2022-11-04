package controller.filter;

import model.Account;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/user.jsp")
public class UserFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            res.sendRedirect("/login");
        } else if (account.getId_role() == 1) {
            chain.doFilter(req,res);
        } else {
            PrintWriter printWriter = res.getWriter();
            printWriter.println("<h1>Quyền Admin Không có quyền truy cập</h1>");
        }
    }
}