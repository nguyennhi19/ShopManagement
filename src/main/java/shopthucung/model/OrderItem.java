package shopthucung.model;

public class OrderItem {
    private int id_hoadon;
    private int id_sanpham;
    private int soluong;
    private double gia;

    public OrderItem(){}

    public OrderItem(int id_hoadon, int id_sanpham, int soluong, double gia) {
        this.id_hoadon = id_hoadon;
        this.id_sanpham = id_sanpham;
        this.soluong = soluong;
        this.gia = gia;
    }

    public int getId_hoadon() {
        return id_hoadon;
    }

    public void setId_hoadon(int id_hoadon) {
        this.id_hoadon = id_hoadon;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}

