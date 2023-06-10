
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Users {

    private Integer id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Integer age;
    private String email;
    private String phone;
    private String gender;
    private String role;

    public Users() {
    }

    public Users(String username, String password, String firstname, String lastname, Integer age, String email, String phone, String gender, String role) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }

    public Users(Integer id, String username, String password, String firstname, String lastname, Integer age, String email, String phone, String gender, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
     public static Users LoginAdmin(String username , String password) throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users User = new Users();
        String sql = "SELECT * FROM Users WHERE role = 'admin' AND username= '"+username+ "' AND password= '"+ password+"'";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            User.setId(rs.getInt("id"));
            User.setUsername(rs.getString("username"));
            User.setPassword(rs.getString("password"));
            User.setFirstname(rs.getString("firstname"));
            User.setLastname(rs.getString("lastname"));
            User.setAge(rs.getInt("age"));
            User.setEmail(rs.getString("email"));
            User.setPhone(rs.getString("phone"));
            User.setGender(rs.getString("gender"));
            User.setRole(rs.getString("role"));
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return User;
    }
     
       public static Users LoginPatient(String username , String password) throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users User = new Users();
        String sql = "SELECT * FROM Users WHERE role = 'patient' AND username= '"+username+ "' AND password= '"+ password+"'";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            User.setId(rs.getInt("id"));
            User.setUsername(rs.getString("username"));
            User.setPassword(rs.getString("password"));
            User.setFirstname(rs.getString("firstname"));
            User.setLastname(rs.getString("lastname"));
            User.setAge(rs.getInt("age"));
            User.setEmail(rs.getString("email"));
            User.setPhone(rs.getString("phone"));
            User.setGender(rs.getString("gender"));
            User.setRole(rs.getString("role"));
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return User;
    }

    public static ArrayList<Users> getByFirstName(String firsname) throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Users> Users = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE firstname = '"+firsname+"'";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Users User = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            User.setId(rs.getInt(1));
            Users.add(User);
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return Users;
    }

    public static ArrayList<Users> getAllUsers() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Users> Users = new ArrayList<>();
        String sql = "SELECT * FROM Users ";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Users User = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            User.setId(rs.getInt(1));
            Users.add(User);

        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return Users;
    }

    public int Add() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "INSERT INTO Users (USERNAME,PASSWORD, FIRSTNAME, LASTNAME, AGE, EMAIL, PHONE, GENDER , ROLE ) VALUES (?,?,?,?,?,?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setString(1, this.getUsername());
        ps.setString(2, this.getPassword());
        ps.setString(3, this.getFirstname());
        ps.setString(4, this.getLastname());
        ps.setInt(5, this.getAge());
        ps.setString(6, this.getEmail());
        ps.setString(7, this.getPhone());
        ps.setString(8, this.getGender());
        ps.setString(9, this.getRole());

        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(this.getUsername() + " User was added succesfully");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

    public int update() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "UPDATE Users SET USERNAME=?,PASSWORD=?, FIRSTNAME=?, LASTNAME=?, AGE=?, EMAIL=?, PHONE=?, GENDER=?, ROLE=? WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setString(1, this.getUsername());
        ps.setString(2, this.getPassword());
        ps.setString(3, this.getFirstname());
        ps.setString(4, this.getLastname());
        ps.setInt(5, this.getAge());
        ps.setString(6, this.getEmail());
        ps.setString(7, this.getPhone());
        ps.setString(8, this.getGender());
        ps.setString(9, this.getRole());
        ps.setInt(10, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("User with id : " + this.getId() + " was updated successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

    public int delete() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "DELETE FROM Users WHERE ID=? ";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("The User with id : " + this.getId() + " was deleted successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }

}
