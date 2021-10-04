package shopthucung.model;


public class Product {
    private int id;
    private String tensp;
    private String mieuta;
    private double gia;
    private int soluong;
    private double gianhap;
    private String ngayNhap;
    private int idLoai;
    private String hinhanh;
    private int soluongtronggio = 0;
    private double tonggia = 0;


    public Product() {
    }

    public Product(int id, String tensp, String mieuta, double gia, int soluong, double gianhap, String ngayNhap, int idLoai, String hinhanh) {
        this.id = id;
        this.tensp = tensp;
        this.mieuta = mieuta;
        this.gia = gia;
        this.soluong = soluong;
        this.gianhap = gianhap;
        this.ngayNhap = ngayNhap;
        this.idLoai = idLoai;
        this.hinhanh = hinhanh;
    }

    public Product( String tensp, String mieuta, double gia, int soluong, double gianhap, String ngayNhap, int idLoai, String hinhanh) {
        this.tensp = tensp;
        this.mieuta = mieuta;
        this.gia = gia;
        this.soluong = soluong;
        this.gianhap = gianhap;
        this.ngayNhap = ngayNhap;
        this.idLoai = idLoai;
        this.hinhanh = hinhanh;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMieuta() {
        return mieuta;
    }

    public void setMieuta(String mieuta) {
        this.mieuta = mieuta;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGianhap() {
        return gianhap;
    }

    public void setGianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }


    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getSoluongtronggio() {
        return soluongtronggio;
    }

    public void setSoluongtronggio(int soluongtronggio) {
        this.soluongtronggio = soluongtronggio;
    }

    public double getTonggia() {
        return tonggia;
    }

    public void setTonggia(double tonggia) {
        this.tonggia = tonggia;
    }
}
