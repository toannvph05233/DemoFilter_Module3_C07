package controller;

import dao.LoginDAO;
import model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = LoginDAO.login(username, password);
        if (account != null) {
            HttpSession session = req.getSession();
            session.setAttribute("account",account);
            if (account.getId_role() == 1) {
                resp.sendRedirect("/user.jsp");
            } else {
                resp.sendRedirect("/admin.jsp");
            }
        } else {
            resp.sendRedirect("/login");
        }

    }
}
