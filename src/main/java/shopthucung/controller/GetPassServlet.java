package shopthucung.controller;

import shopthucung.dao.AccountDAO;
import shopthucung.utils.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "passServlet",urlPatterns = "/pass")
public class GetPassServlet extends HttpServlet {
    AccountDAO accountDAO = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("account/getpass.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String pass = accountDAO.getPassWord(username,fullName,email);
        if(username.isEmpty()){
            request.setAttribute("error","Hay nhap ten dang nhap !");
        }else {
            if (fullName.isEmpty()){
                request.setAttribute("error","Hay nhap ten !");
            }else {
                if (email.isEmpty()){
                    request.setAttribute("error","Hay nhap email !");
                }else {
                    if (!CommonUtil.isEmail(email)){
                        request.setAttribute("error","Hay nhap lai email !");
                    } else {
                        if (pass== null){
                            request.setAttribute("error","thong tin khong dung !");
                        }else {
                        request.setAttribute("success","Mat khau : "+ pass);
                        }
                    }
                }
            }
        }request.getRequestDispatcher("account/getpass.jsp").forward(request, response);


    }
}
