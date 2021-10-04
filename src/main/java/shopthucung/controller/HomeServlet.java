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
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/homes")
public class HomeServlet extends HttpServlet {
    //    private SanPham sanPhamDAO = new SanPham();
    private ProductDAO sanPhamDAO = new ProductDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                try {
                    searchByName(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "addtocartInDetail":
                try {
                    addToCartInDetail(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "infop":
                try {
                    viewDetail(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "addtocartInHome":
                try {
                    addToCartInHome(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "1":
                try {
                    showListpet(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "2":
                try {
                    showListp(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "3":
                try {
                    showLists(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product sanpham = this.sanPhamDAO.getProduct(id);


        RequestDispatcher dispatcher;
        if (sanpham == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("sanpham", sanpham);

            dispatcher = request.getRequestDispatcher("Detail/index.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> listP = this.sanPhamDAO.getAllPhukien();
        request.setAttribute("listP", listP);
        List<Product> listPet = this.sanPhamDAO.getAllThuCung();
        request.setAttribute("listPe", listPet);
        List<Product> listS = this.sanPhamDAO.getAllDichVu();
        request.setAttribute("listS", listS);

        RequestDispatcher dispatcher = request.getRequestDispatcher("home/index.jsp");
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
        List<Product> dssanpham = this.sanPhamDAO.searchProductByName(nameProduct);
        request.setAttribute("productList", dssanpham);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("categoryHome/search.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListpet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listPet = this.sanPhamDAO.getAllThuCung();
        request.setAttribute("listP", listPet);
        RequestDispatcher dispatcher = request.getRequestDispatcher("categoryHome/pet.jsp");
        dispatcher.forward(request, response);
    }
    private void showListp(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listP = this.sanPhamDAO.getAllPhukien();
        request.setAttribute("listP", listP);
        RequestDispatcher dispatcher = request.getRequestDispatcher("categoryHome/accessory.jsp");
        dispatcher.forward(request, response);
    }
    private void showLists(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> listS = this.sanPhamDAO.getAllDichVu();
        request.setAttribute("listP", listS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("categoryHome/service.jsp");
        dispatcher.forward(request, response);
    }

    private void addToCartInHome(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Product sanpham = this.sanPhamDAO.getProduct(id);

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


        List<Product> listP = this.sanPhamDAO.getAllPhukien();
        request.setAttribute("listP", listP);
        List<Product> listPet = this.sanPhamDAO.getAllThuCung();
        request.setAttribute("listPe", listPet);
        List<Product> listS = this.sanPhamDAO.getAllDichVu();
        request.setAttribute("listS", listS);

        int lengthListSessonSanpham = (int) session.getAttribute("lengthListSessonSanpham") + 1;

        session.setAttribute("lengthListSessonSanpham", lengthListSessonSanpham);
        session.setAttribute("listSessionCartSanpham", listSessionSanpham);

        response.sendRedirect("homes");
    }

    private void addToCartInDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        int amont = Integer.parseInt(request.getParameter("soluong"));

        Product sanpham = this.sanPhamDAO.getProduct(id);
        HttpSession session = request.getSession();
        List<Product> listSessionSanpham = (List<Product>) session.getAttribute("listSessionCartSanpham");

        int count = 0;
        for (int i = 0; i < listSessionSanpham.size() ; i++){
            if(sanpham.getId() == listSessionSanpham.get(i).getId()){
                listSessionSanpham.get(i).setSoluongtronggio(listSessionSanpham.get(i).getSoluongtronggio() + amont);
                count++;
                listSessionSanpham.get(i).getSoluongtronggio();
            }
        }

        if(count == 0){
            listSessionSanpham.add(sanpham);
            for (int i = 0; i < listSessionSanpham.size() ; i++){
                if(sanpham.getId() == listSessionSanpham.get(i).getId()){
                    listSessionSanpham.get(i).setSoluongtronggio(listSessionSanpham.get(i).getSoluongtronggio() + amont);
                }
            }
        }



        int lengthListSessonSanpham = (int) session.getAttribute("lengthListSessonSanpham") + amont;


        session.setAttribute("lengthListSessonSanpham", lengthListSessonSanpham);
        session.setAttribute("listSessionCartSanpham", listSessionSanpham);

        request.setAttribute("sanpham", sanpham);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Detail/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
