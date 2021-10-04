package shopthucung.dao;


import shopthucung.model.*;
import shopthucung.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getAllProduct() {
        List<Product> listProduct = new ArrayList<>();


        DBConnection db = new DBConnection();

        Connection conn = db.getConnection();


        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "SELECT id,tensp,mieuta,gia,soluong,gianhap,ngaynhap,id_loai,hinhanh FROM sanpham ORDER BY id DESC";
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tensp = resultSet.getString("tensp");
                String mieuta = resultSet.getString("mieuta");
                double gia = resultSet.getDouble("gia");
                int soluong = resultSet.getInt("soluong");
                double gianhap = resultSet.getDouble("gianhap");
                java.text.DateFormat df = new java.text.SimpleDateFormat("YYYY/MM/dd");
                String ngaynhap = df.format(resultSet.getDate("ngaynhap"));
                int idLoai = resultSet.getInt("id_loai");

                String hinhanh = resultSet.getString("hinhanh");

                Product Product = new Product(id, tensp, mieuta, gia, soluong,
                        gianhap, ngaynhap, idLoai, hinhanh);

                listProduct.add(Product);
            }
        } catch (SQLException el) {
            el.printStackTrace();
        }

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    public List<Product> getAllThuCung() {
        List<Product> listProduct = new ArrayList<>();


        DBConnection db = new DBConnection();

        Connection conn = db.getConnection();


        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "SELECT id,tensp,mieuta,gia,soluong,gianhap,ngaynhap,id_loai,hinhanh FROM sanpham where id_loai =1 ORDER BY id DESC ";
        String sql = "SELECT p.id,p.tensp,p.mieuta,p.gia,p.soluong,p.gianhap,p.ngaynhap,c.ten,p.hinhanh FROM sanpham p left join loai c on p.id_loai = c.id where p.id_loai= 1 ORDER BY id DESC ;";
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tensp = resultSet.getString("tensp");
                String mieuta = resultSet.getString("mieuta");
                double gia = resultSet.getDouble("gia");
                int soluong = resultSet.getInt("soluong");
                double gianhap = resultSet.getDouble("gianhap");
                java.text.DateFormat df = new java.text.SimpleDateFormat("YYYY/MM/dd");
                String ngaynhap = df.format(resultSet.getDate("ngaynhap"));
                int idLoai = resultSet.getInt("id_loai");

                String hinhanh = resultSet.getString("hinhanh");

                Product Product = new Product(id, tensp, mieuta, gia, soluong,
                        gianhap, ngaynhap, idLoai, hinhanh);

                listProduct.add(Product);
            }
        } catch (SQLException el) {
            el.printStackTrace();
        }

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduct;
    }
    public List<Product> getAllPhukien() {
        List<Product> listProduct = new ArrayList<>();


        DBConnection db = new DBConnection();

        Connection conn = db.getConnection();


        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "SELECT id, tensp, mieuta, gia, soluong, gianhap, ngaynhap, id_loai, hinhanh FROM sanpham WHERE id_loai = 2 ORDER BY id DESC ";
           ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tensp = resultSet.getString("tensp");
                String mieuta = resultSet.getString("mieuta");
                double gia = resultSet.getDouble("gia");
                int soluong = resultSet.getInt("soluong");
                double gianhap = resultSet.getDouble("gianhap");
                java.text.DateFormat df = new java.text.SimpleDateFormat("YYYY/MM/dd");
                String ngaynhap = df.format(resultSet.getDate("ngaynhap"));
                int idLoai = resultSet.getInt("id_loai");

                String hinhanh = resultSet.getString("hinhanh");

                Product Product = new Product(id, tensp, mieuta, gia, soluong,
                        gianhap, ngaynhap, idLoai, hinhanh);

                listProduct.add(Product);
            }
        } catch (SQLException el) {
            el.printStackTrace();
        }

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    public List<Product> getAllDichVu() {
        List<Product> listProduct = new ArrayList<>();

        DBConnection db = new DBConnection();

        Connection conn = db.getConnection();


        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "SELECT id,tensp,mieuta,gia,soluong,gianhap,ngaynhap,id_loai,hinhanh FROM sanpham where id_loai = 3 ORDER BY id DESC  ";
        String sql = "SELECT p.id,p.tensp,p.mieuta,p.gia,p.soluong,p.gianhap,p.ngaynhap,c.ten,p.hinhanh FROM sanpham p left join loai c on p.id_loai = c.id where p.id_loai= 3 ORDER BY id DESC ;";
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tensp = resultSet.getString("tensp");
                String mieuta = resultSet.getString("mieuta");
                double gia = resultSet.getDouble("gia");
                int soluong = resultSet.getInt("soluong");
                double gianhap = resultSet.getDouble("gianhap");
                java.text.DateFormat df = new java.text.SimpleDateFormat("YYYY/MM/dd");
                String ngaynhap = df.format(resultSet.getDate("ngaynhap"));
                int idLoai = resultSet.getInt("id_loai");
                String hinhanh = resultSet.getString("hinhanh");

                Product Product = new Product(id, tensp, mieuta, gia, soluong,
                        gianhap, ngaynhap, idLoai, hinhanh);

                listProduct.add(Product);
            }
        } catch (SQLException el) {
            el.printStackTrace();
        }

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    public List<Product> searchProductByName(String nameString) throws SQLException {
        List<Product> productList = new ArrayList<>();

        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();


        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM sanpham WHERE tensp LIKE '%" + nameString + "%';";

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tensp = resultSet.getString("tensp");
                String mieuta = resultSet.getString("mieuta");
                double gia = resultSet.getDouble("gia");
                int soluong = resultSet.getInt("soluong");
                int gianhap = resultSet.getInt("gianhap");
                String ngayNhap = resultSet.getString("ngaynhap");
                int id_loai = resultSet.getInt("id_loai");
                String hinhanh = resultSet.getString("hinhanh");

                Product Product = new Product(id, tensp, mieuta, gia, soluong,
                        gianhap, ngayNhap, id_loai, hinhanh);

                productList.add(Product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public Product getProduct(int id) throws SQLException {
        Product Product = null;
        String sql = "SELECT * FROM sanpham WHERE id = ?";


        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            String tensp = resultSet.getString("tensp");
            String mieuta = resultSet.getString("mieuta");
            double gia = resultSet.getDouble("gia");
            int soluong = resultSet.getInt("soluong");
            double gianhap = resultSet.getDouble("gianhap");
            java.text.DateFormat df = new java.text.SimpleDateFormat("YYYY/MM/dd");
            String ngaynhap = df.format(resultSet.getDate("ngaynhap"));
            int id_loai = resultSet.getInt("id_loai");
            String hinhanh = resultSet.getString("hinhanh");

            Product = new Product(id, tensp, mieuta, gia, soluong, gianhap, ngaynhap, id_loai, hinhanh);
        }
        resultSet.close();
        statement.close();

        return Product;
    }

    public boolean createHoaDon(Order newHoaDon) throws SQLException {
        String sql = "INSERT INTO hoadon (ngayban,id_khachhang,tongtien,vat,thanhtien) VALUES (?,?,?,?,?)";

        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        statement.setString(1, newHoaDon.getNgayban());
        statement.setInt(2, newHoaDon.getId_khachhang());
        statement.setDouble(3, newHoaDon.getTongtien());
        statement.setDouble(4, newHoaDon.getVat());
        statement.setDouble(5, newHoaDon.getThanhtien());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }
    public int getidhoadon() throws SQLException {
        String sql = "SELECT * FROM hoadon ORDER BY id DESC LIMIT 1";

        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = statement.executeQuery(sql);
        int id = 0;
        if (resultSet.next()) {

            id = resultSet.getInt("id");
        }
        resultSet.close();
        statement.close();

        return id;
    }

    public boolean createChiTietHoaDon(OrderItem newChiTietHoaDon) throws SQLException {
        String sql = "INSERT INTO shopmeo.chitiethoadon (id_hoadon,id_sanpham,soluong,gia) VALUES (?,?,?,?);";

        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        statement.setInt(1, newChiTietHoaDon.getId_hoadon());
        statement.setInt(2, newChiTietHoaDon.getId_sanpham());
        statement.setInt(3, newChiTietHoaDon.getSoluong());
        statement.setDouble(4, newChiTietHoaDon.getGia());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }
    public boolean createkhachhang(Customer khachhang) throws SQLException {
        String sql = "INSERT INTO khachhang (ten,sodienthoai,diachi,ghichu) VALUES (?,?,?,?)";

        //L?y chu?i k?t n?i t?i CSDL truy?n vào bi?n conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        statement.setString(1, khachhang.getTen());
        statement.setString(2, khachhang.getSodienthoai());
        statement.setString(3, khachhang.getDiachi());
        statement.setString(4, khachhang.getGhichu());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        // region Gi?i phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    public int getidkhachhang() throws SQLException {

        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();


        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "SELECT id, ten, sodienthoai, diachi, ghichu FROM khachhang ORDER BY id DESC LIMIT 1";

        ResultSet resultSet = statement.executeQuery(sql);
        int id = 0;
        if (resultSet.next()) {

            id = resultSet.getInt("id");
        }
        resultSet.close();
        statement.close();

        return id;
    }


    final String SELECT_ALL_CATEGORY = "SELECT * FROM loai;";
    public List<Category> selectAllCategory() {
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        List<Category> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_CATEGORY);) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ten");
                Category category = new Category(id,name);
                list.add(category);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }


    private static final String INSERT_PS_SQL = "insert into sanpham(tensp,gia,soluong,hinhanh,id_loai,mieuta,ngaynhap,gianhap) values (?,?,?,?,?,?,?,?)";
    public void insertProduct(Product product) throws SQLException {
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        try (PreparedStatement preparedStatement = conn.prepareStatement(INSERT_PS_SQL);) {
            preparedStatement.setString(1, product.getTensp());
            preparedStatement.setDouble(2, product.getGia());
            preparedStatement.setInt(3, product.getSoluong());
            preparedStatement.setString(4, product.getHinhanh());
            preparedStatement.setInt(5, product.getIdLoai());
            preparedStatement.setString(6, product.getMieuta());
            preparedStatement.setString(7, product.getNgayNhap());
            preparedStatement.setDouble(8, product.getGianhap());


            preparedStatement.executeUpdate();
        }catch (SQLException e) {
        }
    }

    private static final String DELETE_PS_SQL = "delete from sanpham where id = ?;";
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDelete;
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        try (PreparedStatement preparedStatement = conn.prepareStatement(DELETE_PS_SQL);) {
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    private static final String UPDATE_P_SQL = "update sanpham set tensp =?, gia = ?, soluong = ?, hinhanh = ?, id_loai = ?, mieuta= ?, ngaynhap=?, gianhap=? where id = ?;";

    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdate;
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        try(PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_P_SQL);) {
            preparedStatement.setString(1, product.getTensp());
            preparedStatement.setDouble(2, product.getGia());
            preparedStatement.setInt(3, product.getSoluong());
            preparedStatement.setString(4, product.getHinhanh());
            preparedStatement.setInt(5, product.getIdLoai());
            preparedStatement.setString(6, product.getMieuta());
            preparedStatement.setString(7, product.getNgayNhap());
            preparedStatement.setDouble(8, product.getGianhap());
            preparedStatement.setInt(9,product.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    final String FIND_DATA = "SELECT p.id,p.tensp,p.mieuta,p.gia,p.soluong,p.gianhap,p.ngaynhap,c.ten,p.hinhanh as category from sanpham p left join loai c on p.id_loai=c.id where p.tensp like ? or p.gia like ? or p.mieuta like ? or c.ten like ?;";
    public List<Product> findData(String keyWord) {
        List<Product> list = new ArrayList<>();
        String key = "%" + keyWord + "%";
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        try(PreparedStatement preparedStatement = conn.prepareStatement(FIND_DATA);) {
            preparedStatement.setString(1,key);
            preparedStatement.setString(2,key);
            preparedStatement.setString(3,key);
            preparedStatement.setString(4,key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tensp = resultSet.getString("tensp");
                double gia = resultSet.getFloat("gia");
                int soluong = resultSet.getInt("soluong");
                String hinhanh = resultSet.getString("hinhanh");
                double gianhap = resultSet.getFloat("gianhap");
                int idLoai = resultSet.getInt("id_loai");
                String ngaynhap = resultSet.getString("ngaynhap");
                String mieuta = resultSet.getString("mieuta");
                Product product = new Product(id, tensp, mieuta, gia, soluong, gianhap, ngaynhap, idLoai, hinhanh);
                list.add(product);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return list;
    }

    public int TotalThanhtien() throws SQLException {
        DBConnection db = new DBConnection();

        Connection connection = db.getConnection();
        int total = 0;
        String Select_Total = "SELECT SUM(thanhtien) AS Total FROM shopmeo.hoadon";
        String Select_Totalgianhap = "SELECT SUM(gianhap) AS Total FROM shopmeo.sanpham s join shopmeo.chitiethoadon c on s.id = c.id_sanpham;";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(Select_Total);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                total = rs.getInt("Total");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return total;
    }

    public int TotalGianhap() throws SQLException {
        DBConnection db = new DBConnection();

        Connection connection = db.getConnection();
        int total = 0;
        String Select_Totalgianhap = "SELECT SUM(gianhap) AS Total FROM shopmeo.sanpham s join shopmeo.chitiethoadon c on s.id = c.id_sanpham;";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(Select_Totalgianhap);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                total = rs.getInt("Total");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return total;
    }


    public List<History> his() {
        List<History> list= new ArrayList<>();


        DBConnection db = new DBConnection();

        Connection conn = db.getConnection();


        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "SELECT t.id,t.id_hoadon,t.id_sanpham,c1.tensp,c1.gia,c1.gianhap,c2.ngayban,c2.id_khachhang,kh.ten,c2.tongtien,c2.thanhtien FROM shopmeo.chitiethoadon t JOIN shopmeo.sanpham c1 ON c1.id = t.id_sanpham join shopmeo.hoadon c2 on c2.id = t.id_hoadon JOIN shopmeo.khachhang kh ON kh.id = c2.id_khachhang;";
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_hoadon = resultSet.getInt("id_hoadon");
                int id_sanpham = resultSet.getInt("id_sanpham");
                int id_khachhang = resultSet.getInt("id_khachhang");
                String tensp = resultSet.getString("tensp");
                String tenkhachhang = resultSet.getString("ten");
                double gia = resultSet.getDouble("gia");
                double tongtien = resultSet.getDouble("tongtien");
                double thanhtienTT = resultSet.getDouble("thanhtien");
                double gianhap = resultSet.getDouble("gianhap");
                java.text.DateFormat df = new java.text.SimpleDateFormat("YYYY/MM/dd");
                String ngaynhap = df.format(resultSet.getDate("ngayban"));


                History history = new History(id,id_hoadon,id_sanpham,id_khachhang,tenkhachhang,tensp,gia,gianhap,ngaynhap,tongtien,thanhtienTT);

                list.add(history);
            }
        } catch (SQLException el) {
            el.printStackTrace();
        }

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
