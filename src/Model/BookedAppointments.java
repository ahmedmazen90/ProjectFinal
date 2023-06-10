package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BookedAppointments {

    private Integer id;
    private Integer appointment_id;
    private Integer user_id;
    private String status;
    private String doctor_comment;

    public BookedAppointments() {
    }

    public BookedAppointments(Integer appointment_id, Integer user_id, String status, String doctor_comment) {
        this.id = id;
        this.appointment_id = appointment_id;
        this.user_id = user_id;
        this.status = status;
        this.doctor_comment = doctor_comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(Integer appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctor_comment() {
        return doctor_comment;
    }

    public void setDoctor_comment(String doctor_comment) {
        this.doctor_comment = doctor_comment;
    }

    public static ArrayList<BookedAppointments> getAllMyAppointmentsWaiting(Integer User_id) throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedAppointments> BookedAppointments = new ArrayList<>();
        String sql = "SELECT * FROM booked_appointments Where status ='waiting' AND user_id = '" + User_id + "'";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointments BA = new BookedAppointments(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            BA.setId(rs.getInt(1));
            BookedAppointments.add(BA);
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return BookedAppointments;
    }

    public static ArrayList<BookedAppointments> getAllMyAppointmentsFinished(Integer User_id) throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedAppointments> BookedAppointments = new ArrayList<>();
        String sql = "SELECT * FROM booked_appointments Where status ='finished' AND user_id = '" + User_id + "'";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointments BA = new BookedAppointments(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            BA.setId(rs.getInt(1));
            BookedAppointments.add(BA);

        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return BookedAppointments; 
    }

    public static ArrayList<BookedAppointments> getAllBookedAppointments() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedAppointments> BookedAppointments = new ArrayList<>();
        String sql = "SELECT * FROM booked_appointments ";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedAppointments BA = new BookedAppointments(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            BA.setId(rs.getInt(1));
            BookedAppointments.add(BA);

        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return BookedAppointments;
    }

    public int Add() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "INSERT INTO booked_appointments (appointment_id, user_id, status, doctor_comment) VALUES (?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getAppointment_id());
        ps.setInt(2, this.getUser_id());
        ps.setString(3, this.getStatus());
        ps.setString(4, this.getDoctor_comment());

        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(this.getUser_id() + " Booked was added succesfully");
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
        String sql = "UPDATE booked_appointments SET  appointment_id = ?,user_id=?, status=?, doctor_comment=?  WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getAppointment_id());
        ps.setInt(2, this.getUser_id());
        ps.setString(3, this.getStatus());
        ps.setString(4, this.getDoctor_comment());
        ps.setInt(5, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("Appointments with id : " + this.getId() + " was updated successfully!");
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
        String sql = "DELETE FROM booked_appointments WHERE ID=? ";
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
