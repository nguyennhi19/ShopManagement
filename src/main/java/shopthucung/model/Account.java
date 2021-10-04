package shopthucung.model;

public class Account {
    private int id;
    private String name;
    private String userName;
    private String pass;
    private String email;
    private String phone;
    private String address;
    private int isAdmin = 0;

    public Account() {
    }

    public Account(String name, String userName, String pass, String email,String phone, String address, int isAdmin) {
        this.name = name;
        this.userName = userName;
        this.pass = pass;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.isAdmin = isAdmin;
    }

    public Account(int id, String name, String userName, String pass, String email,String phone, String address, int isAdmin) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.pass = pass;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.isAdmin = isAdmin;
    }

    public Account(int id, String name, String userName, String pass, String email, int isAdmin) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.pass = pass;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public Account(String name, String userName, String pass, String email, int isAdmin) {
        this.name = name;
        this.userName = userName;
        this.pass = pass;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
