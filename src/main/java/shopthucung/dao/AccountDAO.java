package shopthucung.dao;

import shopthucung.model.Account;
import shopthucung.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    public AccountDAO(){

    }

    DBConnection db = new DBConnection();
    Connection connection = db.getConnection();

    public Account selectAccount(String username, String password) {
        Account account = null;
        try { PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE userName = ? AND `pass` = ?;");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString((2));
                String userName = rs.getString(3);
                String pass = rs.getString(4);
                String email= rs.getString(5);
                String phone= rs.getString(6);
                String address= rs.getString(7);
                int admin = rs.getInt(8);

                account = new Account(id,name, userName, pass, email,phone,address,admin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }

    public void addAccount(String username, String pass, String name, String email,String phone,String address){
        try{
            String query ="insert into user (name,userName, pass, email, phone, address, isAdmin) value(?,?,?,?,?,?,0)";

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,username);
            ps.setString(3,pass);
            ps.setString(4,email);
            ps.setString(5,phone);
            ps.setString(6,address);
            ps.executeUpdate();
        }catch (Exception e){

        }
    }

    public boolean checkNewAccount(String newUsername){
        boolean check =true;
        Account account = null;
        try {
            String query ="SELECT * FROM user  where username = ?;";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,newUsername);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                account = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
            check = !(newUsername.equals(account.getUserName()));
        }catch (Exception e){

        }
        return check;
    }
    public String getPassWord(String username, String name, String email){
        AccountDAO dao = new AccountDAO();
        String pass = null;
        List<Account> accounts = dao.accountList();
        for(Account account: accounts){
            Boolean check = true;
            if (!(username.equals(account.getUserName()))) {
                check = false;
            }
            if (!(name.equals(account.getName()))) {
                check = false;
            }
            if (!(email.equals(account.getEmail()))) {
                check = false;
            }
            if (check){
                pass = account.getPass();
            }
        }
        return pass;
    }

    public List<Account> accountList(){
        List<Account> accounts = new ArrayList<>();
        String query ="SELECT * FROM user";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                accounts.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        }catch (Exception e){
        }
        return accounts;
    }
}
