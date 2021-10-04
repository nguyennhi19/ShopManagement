package shopthucung.controller;


import shopthucung.dao.AccountDAO;
import shopthucung.utils.CommonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    AccountDAO accountDAO = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("account/Register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("repassword");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        boolean check = ((password.equals(rePassword))&&(accountDAO.checkNewAccount(username)));

        if(username.isEmpty()){
            request.setAttribute("mess", "hay nhap ten dang nhap ");

        }else {
            if(password.isEmpty()){
                request.setAttribute("mess", "hay nhap password");

            }else {
                if (rePassword.isEmpty()){
                    request.setAttribute("mess", "hay nhap password");

                }else {
                    if (fullName.isEmpty()) {
                        request.setAttribute("mess", "hay nhap ho va ten");

                    }else {
                        if(email.isEmpty()){
                            request.setAttribute("mess", "hay nhap email");

                        }else {
                            if (phone.isEmpty()){
                                request.setAttribute("mess", "hay nhap phone");
                                response.sendRedirect("/register");
                            }else {
                                if (address.isEmpty()){
                                    request.setAttribute("mess", "hay nhap address");

                                }else {
                                    if (!password.equals(rePassword)){
                                        request.setAttribute("mess", "mat khau khong giong nhau");

                                    }else {
                                        try {
                                            if(CommonUtil.checkPhone(phone)){
                                                request.setAttribute("mess", "so dien thoai khong dung");

                                            }else {
                                                if (CommonUtil.isNumeric(phone)){
                                                    request.setAttribute("mess", "hay nhap lại so dien thoai");

                                                }else {
                                                    if (CommonUtil.isEmail(email)){
                                                        request.setAttribute("mess", "hay nhap lại email");

                                                    }else if (check){
                                                        accountDAO.addAccount(username,password,fullName,email,phone,address);
                                                        request.setAttribute("success","Successful");
                                                        request.getRequestDispatcher("account/Register.jsp").forward(request,response);
                                                    }else{
                                                        request.setAttribute("mess","username is exist or password is wrong !");
                                                        request.getRequestDispatcher("account/Register.jsp").forward(request,response);

                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }request.getRequestDispatcher("account/Register.jsp").forward(request, response);
    }
}
