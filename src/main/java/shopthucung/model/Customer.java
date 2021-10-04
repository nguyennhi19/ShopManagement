package shopthucung.model;

public class Customer {
    private int id;
    private String ten;
    private String sodienthoai;
    private String diachi;
    private String ghichu;

    public Customer() {
    }

    public Customer(String ten, String sodienthoai, String diachi, String ghichu){
        this.ten = ten;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.ghichu = ghichu;
    }

    public Customer(int id, String ten, String sodienthoai, String diachi, String ghichu) {
        this.id = id;
        this.ten = ten;
        this.sodienthoai = sodienthoai;
        this.diachi = diachi;
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
