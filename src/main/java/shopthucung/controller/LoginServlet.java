package shopthucung.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import shopthucung.dao.AccountDAO;
import shopthucung.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    AccountDAO accountDAO = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("account/login.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("submit");
        if(action == null){
            action="";
        }
        switch (action){
            case "LOGIN":
            {
                try {
                    login(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            }
            default:
            {
                req.getRequestDispatcher("account/login.jsp").forward(req,resp);
            }
        }}
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException, SQLException {
        String username = req.getParameter("username");
        String password = req.getParameter("pass");

        Account account = accountDAO.selectAccount(username, password);

        if(username.isEmpty()){
            req.setAttribute("mess", "hay dien ten dang nhap");
            RequestDispatcher dispatcher = req.getRequestDispatcher("account/login.jsp");
            dispatcher.forward(req, resp);
        }else {
            if (password.isEmpty()){
                req.setAttribute("mess", "hay dien mat khau");
                RequestDispatcher dispatcher = req.getRequestDispatcher("account/login.jsp");
                dispatcher.forward(req, resp);
            }else {
                if(account == null){
                    req.setAttribute("mess", "ten dang nhap hoac mat khau dung");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("account/login.jsp");
                    dispatcher.forward(req, resp);
                }else if(account.getIsAdmin()==0){
                    HttpSession session = req.getSession();
                    session.setAttribute("acc", username);
                    session.setAttribute("pass", password);
                    resp.sendRedirect("homes");
                } else {
                    HttpSession session = req.getSession();
                    session.setAttribute("acc", username);
                    session.setAttribute("pass", password);
                    resp.sendRedirect("product");
                }
            }
        }

    }
}