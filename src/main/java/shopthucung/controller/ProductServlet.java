package shopthucung.controller;

import shopthucung.dao.ProductDAO;
import shopthucung.model.Category;
import shopthucung.model.History;
import shopthucung.model.Product;
import shopthucung.utils.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showInsertProduct(request,response);
                break;
            case "edit":
                try {
                    showEditProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "info":
                try {
                    showInfoP(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteP(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "Search":
                try {
                    findProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "pet":
                listPet(request,response);
                break;
            case "product":
                listProduct(request,response);
                break;
            case "service":
                listService(request,response);
                break;
            case "history":
                listhistory(request,response);
                break;
            default:
                listAllProduct(request,response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void findProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String key = request.getParameter("key");
        List<Product> list = productDAO.searchProductByName(key);
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tensp = request.getParameter("name");
        String str_gia = request.getParameter("price");
        String sts_soluong = request.getParameter("quantity");
        String hinhanh = request.getParameter("image");
        String str_idLoai = request.getParameter("idLoai");
        int idLoai = Integer.parseInt(str_idLoai);
        String mieuta = request.getParameter("des");
        String ngaynhap = request.getParameter("ngaynhap");
        String str_gianhap = request.getParameter("gianhap");

        if(tensp.isEmpty()){
            request.setAttribute("error", "Hay nhap ten san pham!");
            showEditProduct(request,response);
        }else {
            if(str_gia.isEmpty()){
                request.setAttribute("error", "Hay nhap gia san pham!");
                showEditProduct(request,response);
            }else {
                if (hinhanh.isEmpty()){
                    request.setAttribute("error", "Hay nhap hinh anh san pham!");
                    showEditProduct(request,response);
                }else {
                    if (str_idLoai.isEmpty()){
                        request.setAttribute("error", "Hay nhap loai san pham!");
                        showEditProduct(request,response);
                    }else {
                        if (mieuta.isEmpty()){
                            request.setAttribute("error", "Hay nhap mieu ta san pham!");
                            showEditProduct(request,response);
                        }else {
                            if (sts_soluong.isEmpty()){
                                request.setAttribute("error", "Hay nhap so luong san pham!");
                                showEditProduct(request,response);
                            }else {
                                if (ngaynhap.isEmpty()){
                                    request.setAttribute("error", "Hay nhap ngay nhap san pham!");
                                    showEditProduct(request,response);
                                }if (str_gianhap.isEmpty()){
                                    request.setAttribute("error", "Hay nhap gia nhap san pham!");
                                    showEditProduct(request,response);
                                }else {
                                    if (!CommonUtil.isNumeric(str_gia)){
                                        request.setAttribute("error", "Hay nhap lai gia san pham!");
                                        showEditProduct(request,response);
                                    }else {
                                        if (!CommonUtil.isNumeric(sts_soluong)){
                                            request.setAttribute("error", "Hay nhap lai so luong san pham!");
                                            showEditProduct(request,response);
                                        }
                                        else {
                                            if (!CommonUtil.isNumeric(str_gianhap)){
                                                request.setAttribute("error", "Hay nhap lai gia nhap san pham!");
                                                showEditProduct(request,response);
                                            }else {
                                                double gia = Double.parseDouble(str_gia);
                                                int soluong = Integer.parseInt(sts_soluong);
                                                double gianhap = Double.parseDouble(str_gianhap);
                                                if (gia <= 0){
                                                    request.setAttribute("error", "gia san pham phai lon hơn 0");
                                                    showEditProduct(request,response);
                                                }else {
                                                    if (soluong<=0){
                                                        request.setAttribute("error", "so luong phai lon hon 0");
                                                        showEditProduct(request,response);
                                                    }else {
                                                        if (gianhap<=0){
                                                            request.setAttribute("error", "gia nhap phai lon hon 0");
                                                            showEditProduct(request,response);
                                                        }else {
                                                            if (gianhap > gia){
                                                                request.setAttribute("error", "gia nhap nho hon gia ban");
                                                                showEditProduct(request,response);
                                                            }else {
                                                                Product product = new Product(id,tensp, mieuta, gia, soluong, gianhap, ngaynhap, idLoai, hinhanh);
                                                                productDAO.updateProduct(product);
                                                                request.setAttribute("message","da sua san pham thanh cong");
                                                                showEditProduct(request,response);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void deleteP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.getProduct(id);
        List<Category> list = productDAO.selectAllCategory();
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
        request.setAttribute("data_category",list);
        request.setAttribute("data_product", product);
        dispatcher.forward(request, response);
    }

    private void showInfoP(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existing = productDAO.getProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/info.jsp");
        request.setAttribute("product", existing);
        dispatcher.forward(request, response);
    }


    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            productDAO.deleteProduct(id);
            List<Product> list = productDAO.getAllProduct();
            request.setAttribute("list",list);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
            requestDispatcher.forward(request,response);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.getProduct(id);
        List<Category> list = productDAO.selectAllCategory();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("data_category",list);
        request.setAttribute("data_product",product);
        requestDispatcher.forward(request,response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String tensp = request.getParameter("tensp");
        String str_gia = request.getParameter("gia");
        String sts_soluong = request.getParameter("soluong");
        String hinhanh = request.getParameter("hinhanh");
        String str_idLoai = request.getParameter("category");
        int idLoai = Integer.parseInt(str_idLoai);
        String mieuta = request.getParameter("mota");
        String ngaynhap = request.getParameter("ngaynhap");
        String str_gianhap = request.getParameter("gianhap");

        if(tensp.isEmpty()){
            request.setAttribute("error", "Hay nhap ten san pham!");
            showInsertProduct(request,response);
        }else {
            if(str_gia.isEmpty()){
                request.setAttribute("error", "Hay nhap gia san pham!");
                showInsertProduct(request,response);
            }else {
                if (hinhanh.isEmpty()){
                    request.setAttribute("error", "Hay nhap hinh anh san pham!");
                    showInsertProduct(request,response);
                }else {
                    if (str_idLoai.isEmpty()){
                        request.setAttribute("error", "Hay nhap loai san pham!");
                        showInsertProduct(request,response);
                    }else {
                        if (mieuta.isEmpty()){
                            request.setAttribute("error", "Hay nhap mieu ta san pham!");
                            showInsertProduct(request,response);
                        }else {
                            if (sts_soluong.isEmpty()){
                                request.setAttribute("error", "Hay nhap so luong san pham!");
                                showInsertProduct(request,response);
                            }else {
                                if (ngaynhap.isEmpty()){
                                    request.setAttribute("error", "Hay nhap ngay nhap san pham!");
                                    showInsertProduct(request,response);
                                }if (str_gianhap.isEmpty()){
                                    request.setAttribute("error", "Hay nhap gia nhap san pham!");
                                    showInsertProduct(request,response);
                                }else {
                                    if (!CommonUtil.isNumeric(str_gia)){
                                        request.setAttribute("error", "Hay nhap lai gia san pham!");
                                        showInsertProduct(request,response);
                                    }else {
                                        if (!CommonUtil.isNumeric(sts_soluong)){
                                            request.setAttribute("error", "Hay nhap lai so luong san pham!");
                                            showInsertProduct(request,response);
                                        }
                                        else {
                                            if (!CommonUtil.isNumeric(str_gianhap)){
                                                request.setAttribute("error", "Hay nhap lai gia nhap san pham!");
                                                showInsertProduct(request,response);
                                            }else {
                                                double gia = Double.parseDouble(str_gia);
                                                int soluong = Integer.parseInt(sts_soluong);
                                                double gianhap = Double.parseDouble(str_gianhap);
                                                if (gia <= 0){
                                                    request.setAttribute("error", "gia san pham phai lon hơn 0");
                                                    showInsertProduct(request,response);
                                                }else {
                                                    if (soluong<=0){
                                                        request.setAttribute("error", "so luong phai lon hon 0");
                                                        showInsertProduct(request,response);
                                                    }else {
                                                        if (gianhap<=0){
                                                            request.setAttribute("error", "gia nhap phai lon hon 0");
                                                            showInsertProduct(request,response);
                                                        }else {
                                                            if (gianhap > gia){
                                                                request.setAttribute("error", "gia nhap nho hon gia ban");
                                                                showInsertProduct(request,response);
                                                            }else {
                                                                Product product = new Product(tensp, mieuta, gia, soluong, gianhap, ngaynhap, idLoai, hinhanh);
                                                                productDAO.insertProduct(product);
                                                                request.setAttribute("message","da them san pham thanh cong");
                                                                showInsertProduct(request,response);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void listAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDAO.getAllProduct();
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDAO.getAllPhukien();
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void listPet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDAO.getAllThuCung();
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productDAO.getAllDichVu();
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        requestDispatcher.forward(request,response);
    }
    private void listhistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<History> list = productDAO.his();
        request.setAttribute("list",list);
        int total = 0;
        int totalgianhap = 0;
        int loinhuan = 0;
        try {
            total = productDAO.TotalThanhtien();
            totalgianhap = productDAO.TotalGianhap();
            loinhuan = total - totalgianhap;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("total",total);
        request.setAttribute("loinhuan",loinhuan);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/history.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showInsertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = productDAO.selectAllCategory();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("data",categoryList);
        requestDispatcher.forward(request,response);
    }
}

