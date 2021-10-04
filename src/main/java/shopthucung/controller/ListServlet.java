package shopthucung.controller;

import shopthucung.dao.ProductDAO;
import shopthucung.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListServlet",urlPatterns = "")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO = new ProductDAO();


    public void init() {
        productDAO = new ProductDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "search":
                    searchByName(req,resp);
                    break;
                case "admin":
                    admin(req,resp);
                    break;
                case "infop":
                    showInfoP(req,resp);
                    break;
                case "":
                    show(req,resp);
                    break;
                case "1":
                    showListpet(req,resp);
                    break;
                case "2":
                    showListp(req,resp);
                    break;
                case "3":
                    showLists(req,resp);
                    break;
                case "buy":
                    addToCartInHome(req,resp);
                    break;
                default:
                    show(req,resp);

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void addToCartInHome(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Product sanpham = this.productDAO.getProduct(id);

        HttpSession session = request.getSession();
        List<Product> listSessionSanpham = (List<Product>) session.getAttribute("listSessionCartSanpham");

        int count = 0;
        for (int i = 0; i < listSessionSanpham.size() ; i++){
            if(sanpham.getId() == listSessionSanpham.get(i).getId()){
                listSessionSanpham.get(i).setSoluongtronggio(listSessionSanpham.get(i).getSoluongtronggio() + 1);
                count++;
            }
        }
        if(count == 0) {
            sanpham.setSoluongtronggio(sanpham.getSoluongtronggio() + 1);
            listSessionSanpham.add(sanpham);
        }

        int lengthListSessonSanpham = (int) session.getAttribute("lengthListSessonSanpham") + 1;

        session.setAttribute("lengthListSessonSanpham", lengthListSessonSanpham);
        session.setAttribute("listSessionCartSanpham", listSessionSanpham);
        List<Product> listP = this.productDAO.getAllPhukien();
        request.setAttribute("listP", listP);
        List<Product> listPet = this.productDAO.getAllThuCung();
        request.setAttribute("listPe", listPet);
        List<Product> listS = this.productDAO.getAllDichVu();
        request.setAttribute("listS", listS);
        response.sendRedirect("");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void showInfoP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product sanpham = this.productDAO.getProduct(id);


        RequestDispatcher dispatcher;
        if (sanpham == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("sanpham", sanpham);

            dispatcher = request.getRequestDispatcher("category/info.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        String nameProduct = request.getParameter("search");
        List<Product> dssanpham = this.productDAO.searchProductByName(nameProduct);
        request.setAttribute("productList", dssanpham);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/search.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void show(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listP = this.productDAO.getAllPhukien();
        request.setAttribute("listP", listP);
        List<Product> listPet = this.productDAO.getAllThuCung();
        request.setAttribute("listPe", listPet);
        List<Product> listS = this.productDAO.getAllDichVu();
        request.setAttribute("listS", listS);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void admin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listP = this.productDAO.getAllPhukien();
        request.setAttribute("listP", listP);
        List<Product> listPet = this.productDAO.getAllThuCung();
        request.setAttribute("listPe", listPet);
        List<Product> listS = this.productDAO.getAllDichVu();
        request.setAttribute("listS", listS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
    private void showListpet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listPet = this.productDAO.getAllThuCung();
        request.setAttribute("listP", listPet);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/pet.jsp");
        dispatcher.forward(request, response);
    }
    private void showListp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listP = this.productDAO.getAllPhukien();
        request.setAttribute("listP", listP);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/accessory.jsp");
        dispatcher.forward(request, response);
    }
    private void showLists(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listS = this.productDAO.getAllDichVu();
        request.setAttribute("listP", listS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/service.jsp");
        dispatcher.forward(request, response);
    }
}
