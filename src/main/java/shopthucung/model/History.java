package shopthucung.model;

public class History {
    private int id;
    private int idHoadon;
    private int idSanpham;
    private int idKhachhang;
    private String tenSanPham;
    private String tenKhachHang;
    private double gia;
    private double giaNhap;
    private String ngayban;
    private double tongTienHang;
    private double tongtienTT;

    public History(int id, int idHoadon, int idSanpham, int idKhachhang, String tenSanPham, String tenKhachHang, double gia, double giaNhap, String ngayban, double tongTienHang, double tongtienTT) {
        this.id = id;
        this.idHoadon = idHoadon;
        this.idSanpham = idSanpham;
        this.idKhachhang = idKhachhang;
        this.tenSanPham = tenSanPham;
        this.tenKhachHang = tenKhachHang;
        this.gia = gia;
        this.giaNhap = giaNhap;
        this.ngayban = ngayban;
        this.tongTienHang = tongTienHang;
        this.tongtienTT = tongtienTT;
    }

    public History(int idHoadon, int idSanpham, int idKhachhang, String tenSanPham, String tenKhachHang, double gia, double giaNhap, String ngayban, double tongTienHang, double tongtienTT) {
        this.idHoadon = idHoadon;
        this.idSanpham = idSanpham;
        this.idKhachhang = idKhachhang;
        this.tenSanPham = tenSanPham;
        this.tenKhachHang = tenKhachHang;
        this.gia = gia;
        this.giaNhap = giaNhap;
        this.ngayban = ngayban;
        this.tongTienHang = tongTienHang;
        this.tongtienTT = tongtienTT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHoadon() {
        return idHoadon;
    }

    public void setIdHoadon(int idHoadon) {
        this.idHoadon = idHoadon;
    }

    public int getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(int idSanpham) {
        this.idSanpham = idSanpham;
    }

    public int getIdKhachhang() {
        return idKhachhang;
    }

    public void setIdKhachhang(int idKhachhang) {
        this.idKhachhang = idKhachhang;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getNgayban() {
        return ngayban;
    }

    public void setNgayban(String ngayban) {
        this.ngayban = ngayban;
    }

    public double getTongTienHang() {
        return tongTienHang;
    }

    public void setTongTienHang(double tongTienHang) {
        this.tongTienHang = tongTienHang;
    }

    public double getTongtienTT() {
        return tongtienTT;
    }

    public void setTongtienTT(double tongtienTT) {
        this.tongtienTT = tongtienTT;
    }
}
