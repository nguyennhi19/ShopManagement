package shopthucung.model;

public class Order {
    private int id;
    private String ngayban;
    private int id_khachhang;
    private double tongtien;
    private double vat;
    private double thanhtien;

    public Order() {
    }

    public Order(String ngayban, int id_khachhang, double tongtien, double vat, double thanhtien){
        this.ngayban = ngayban;
        this.id_khachhang = id_khachhang;
        this.tongtien = tongtien;
        this.vat = vat;
        this.thanhtien = thanhtien;
    }

    public Order(int id, String ngayban, int id_khachhang, double tongtien, double vat, double thanhtien) {
        this.id = id;
        this.ngayban = ngayban;
        this.id_khachhang = id_khachhang;
        this.tongtien = tongtien;
        this.vat = vat;
        this.thanhtien = thanhtien;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayban() {
        return ngayban;
    }

    public void setNgayban(String ngayban) {
        this.ngayban = ngayban;
    }

    public int getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(int id_khachhang) {
        this.id_khachhang = id_khachhang;
    }


    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

}