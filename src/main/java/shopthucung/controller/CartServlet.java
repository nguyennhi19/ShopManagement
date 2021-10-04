package shopthucung.controller;

import shopthucung.dao.ProductDAO;
import shopthucung.model.Customer;
import shopthucung.model.Order;
import shopthucung.model.OrderItem;
import shopthucung.model.Product;
import shopthucung.utils.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private ProductDAO productDao = new ProductDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "thanhtoan":
                try {
                    pay(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "remove":
                removeSessionSanpham(request, response);
                break;
            case "them":
                try {
                    themsanpham(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "bot":
                try {
                    botsanpham(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                ShowCart(request, response);
                break;
        }

    }

    private void ShowCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<Product> listSessionSanpham = (List<Product>) session.getAttribute("listSessionCartSanpham");

        // Tính hóa đơn
        double tongtien = 0;
        for (int i = 0; i < listSessionSanpham.size() ; i++){
            listSessionSanpham.get(i).setTonggia(listSessionSanpham.get(i).getGia()*listSessionSanpham.get(i).getSoluongtronggio());
            tongtien += listSessionSanpham.get(i).getTonggia();
        }

        double vat = tongtien * 0.015;
        double thanhtien = tongtien + vat;
        Map<String, Double> hoadon = new HashMap<>();
        hoadon.put("tongtien", tongtien);
        hoadon.put("vat", vat);
        hoadon.put("thanhtien", thanhtien);
        session.setAttribute("hoadon", hoadon);
        Map<String, Double> hoadonView = (Map<String, Double>) session.getAttribute("hoadon");

        request.setAttribute("hoadonView", hoadonView);
        request.setAttribute("listSessionSanpham", listSessionSanpham);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/index.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pay(HttpServletRequest request,HttpServletResponse response) throws Exception {

        String tenkh = request.getParameter("tenkh");
        String sodienthoaikh = request.getParameter("sodienthoaikh");
        String diachi = request.getParameter("diachi");
        String ghichu = request.getParameter("ghichu");

        String ngayban = LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY/MM/dd"));
        if(tenkh.isEmpty()){
            request.setAttribute("mess", "Xin vui long nhap ten!");
            ShowCart(request,response);
        } else {
            if (sodienthoaikh.isEmpty()){
                request.setAttribute("mess", "Xin vui long nhap so dien thoai!");
                ShowCart(request,response);
            }else {
                if (diachi.isEmpty()){
                    request.setAttribute("mess", "Xin vui long nhap dia chi!");
                    ShowCart(request,response);
                }else {
                    if (!CommonUtil.isNumeric(sodienthoaikh)){
                        request.setAttribute("mess", "Xin vui long hay nhap lai so dien thoai hop le!");
                        ShowCart(request,response);
                    }else {
                        if (!CommonUtil.checkPhone(sodienthoaikh)){
                            request.setAttribute("mess", "Xin vui long hay nhap lai so dien thoai hop le!");
                            ShowCart(request,response);
                        }else {
                            HttpSession session = request.getSession();
                            List<Product> listSessionSanpham = (List<Product>) session.getAttribute("listSessionCartSanpham");

                            // Tạo khách hàng
                            Customer newKhachhang = new Customer(tenkh,sodienthoaikh,diachi,ghichu);
                            this.productDao.createkhachhang(newKhachhang);
                            int id_khachHang = this.productDao.getidkhachhang();

                            Map<String, Double> hoadon = (Map<String, Double>) session.getAttribute("hoadon");
                            // tạo hóa đơn
                            Order newHoaDon = new Order(ngayban,id_khachHang,hoadon.get("tongtien"),hoadon.get("vat"),hoadon.get("thanhtien"));
                            this.productDao.createHoaDon(newHoaDon);
                            int id_hoadon = this.productDao.getidhoadon();
                            // Tạo chi tiết hóa đơn
                            for (int i = 0; i < listSessionSanpham.size() ; i++){
                                OrderItem newChiTietHoaDon = new OrderItem(id_hoadon,listSessionSanpham.get(i).getId()
                                        ,listSessionSanpham.get(i).getSoluongtronggio(),listSessionSanpham.get(i).getTonggia());
                                this.productDao.createChiTietHoaDon(newChiTietHoaDon);
                            }

                            List<Product> listSessionCartSanpham = new ArrayList<>();
                            int lengthListSessonSanpham = 0;
                            session.setAttribute("lengthListSessonSanpham", lengthListSessonSanpham);
                            session.setAttribute("listSessionCartSanpham", listSessionCartSanpham);
                            Map<String, Double> hoadonnew = new HashMap<>();
                            session.setAttribute("hoadonView",hoadonnew);

                            List<Product> dssanpham = this.productDao.getAllProduct();

                            request.setAttribute("dssanpham", dssanpham);


                            request.setAttribute("message", "New customer was created");
                            try {
                                response.sendRedirect("homes");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    private void removeSessionSanpham(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        // Lấy dữ liệu từ session
        HttpSession session = request.getSession();
        List<Product> listSessionSanpham = (List<Product>) session.getAttribute("listSessionCartSanpham");
        int lengthListSessonSanpham = (int) session.getAttribute("lengthListSessonSanpham");


        for (int i = 0; i < listSessionSanpham.size(); i++){
            if(listSessionSanpham.get(i).getId() == id){
                lengthListSessonSanpham -= listSessionSanpham.get(i).getSoluongtronggio();
                listSessionSanpham.remove(i);
            }
        }

        double tongtien = 0;
        for (int i = 0; i < listSessionSanpham.size() ; i++){
            listSessionSanpham.get(i).setTonggia(listSessionSanpham.get(i).getGia()*listSessionSanpham.get(i).getSoluongtronggio());
            tongtien += listSessionSanpham.get(i).getTonggia();
        }

        double vat = tongtien * 0.015;
        double thanhtien = tongtien + vat;
        Map<String, Double> hoadon = new HashMap<>();
        hoadon.put("tongtien", tongtien);
        hoadon.put("vat", vat);
        hoadon.put("thanhtien", thanhtien);
        session.setAttribute("hoadon", hoadon);
        Map<String, Double> hoadonView = (Map<String, Double>) session.getAttribute("hoadon");

        // Chỉnh sửa lại session
        session.setAttribute("lengthListSessonSanpham", lengthListSessonSanpham);
        session.setAttribute("listSessionSanpham", listSessionSanpham);

        //gủi hóa đơn và ds sản phẩm theo request
        request.setAttribute("hoadonView", hoadonView);
        request.setAttribute("listSessionSanpham", listSessionSanpham);

        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void botsanpham(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Product sanpham = this.productDao.getProduct(id);

        HttpSession session = request.getSession();
        List<Product> listSessionSanpham = (List<Product>) session.getAttribute("listSessionCartSanpham");

        int count = 0;
        for (int i = 0; i < listSessionSanpham.size() ; i++){
            if(sanpham.getId() == listSessionSanpham.get(i).getId()){
                listSessionSanpham.get(i).setSoluongtronggio(listSessionSanpham.get(i).getSoluongtronggio() - 1);
                count++;
            }
        }
        if(count == 0) {
            sanpham.setSoluongtronggio(sanpham.getSoluongtronggio() - 1);
            listSessionSanpham.add(sanpham);
        }

        List<Product> dssanpham = this.productDao.getAllProduct();
        request.setAttribute("dssanpham", dssanpham);


        int lengthListSessonSanpham = (int) session.getAttribute("lengthListSessonSanpham") - 1;

        session.setAttribute("lengthListSessonSanpham", lengthListSessonSanpham);
        session.setAttribute("listSessionCartSanpham", listSessionSanpham);

        response.sendRedirect("cart");
    }
    private void themsanpham(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Product sanpham = this.productDao.getProduct(id);

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

        List<Product> dssanpham = this.productDao.getAllProduct();
        request.setAttribute("dssanpham", dssanpham);


        int lengthListSessonSanpham = (int) session.getAttribute("lengthListSessonSanpham") + 1;

        session.setAttribute("lengthListSessonSanpham", lengthListSessonSanpham);
        session.setAttribute("listSessionCartSanpham", listSessionSanpham);

        response.sendRedirect("cart");
    }
}

