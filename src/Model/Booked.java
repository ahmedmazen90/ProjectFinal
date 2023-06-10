
package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Booked {

    private Integer id;
    private Integer appointment_id;
    private Integer user_id;
    private String firstname;
    private String lastname;
    private Date appointment_date;
    private String appointment_day;
    private String appointment_time;
    private String status;
    private String doctor_comment;

    public Booked() {
    }

    public Booked(Integer id, Integer appointment_id, Integer user_id, String firstname, String lastname, Date appointment_date, String appointment_day, String appointment_time, String status, String doctor_comment) {
        this.id = id;
        this.appointment_id = appointment_id;
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.appointment_date = appointment_date;
        this.appointment_day = appointment_day;
        this.appointment_time = appointment_time;
        this.status = status;
        this.doctor_comment = doctor_comment;
    }

    public static ArrayList<Booked> getAllBooked() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Booked> Booked = new ArrayList<>();
        String sql = "SELECT ba.id , ba.appointment_id , ba.user_id , u.firstname , u.lastname , a.appointment_date , a.appointment_day, a.appointment_time, ba.status ,ba.doctor_comment "
                + "FROM booked_appointments ba "
                + "INNER JOIN users u ON ba.user_id = u.id "
                + "INNER JOIN appointments a ON ba.appointment_id = a.id";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Booked B = new Booked(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            Booked.add(B);
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return Booked;
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

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_day() {
        return appointment_day;
    }

    public void setAppointment_day(String appointment_day) {
        this.appointment_day = appointment_day;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
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

}
