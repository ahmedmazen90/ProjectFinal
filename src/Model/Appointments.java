
package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Appointments {

    private Integer id;
    private Date appointment_date;
    private String appointment_day;
    private String appointment_time;
    private String status;

    public Appointments() {
    }

    public Appointments(Integer id, Date appointment_date, String appointment_day, String appointment_time, String status) {
        this.id = id;
        this.appointment_date = appointment_date;
        this.appointment_day = appointment_day;
        this.appointment_time = appointment_time;
        this.status = status;
    }

    public Appointments(Date appointment_date, String appointment_day, String appointment_time, String status) {
        this.appointment_date = appointment_date;
        this.appointment_day = appointment_day;
        this.appointment_time = appointment_time;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public static ArrayList<Appointments> getAllAppointments() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Appointments> Appointments = new ArrayList<>();
        String sql = "SELECT * FROM Appointments Where status ='free'";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Appointments Appointment = new Appointments(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5));
            Appointment.setId(rs.getInt(1));
            Appointments.add(Appointment);

        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return Appointments;
    }

    public int Add() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "INSERT INTO Appointments ( appointment_date, appointment_day, appointment_time, status) VALUES (?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setDate(1, this.getAppointment_date());
        ps.setString(2, this.getAppointment_day());
        ps.setString(3, this.getAppointment_time());
        ps.setString(4, this.getStatus());

        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(this.getId() + " User was added succesfully");
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
        String sql = "UPDATE Appointments SET appointment_date=? , appointment_day=? , appointment_time=? , status=?  WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setDate(1, this.getAppointment_date());
        ps.setString(2, this.getAppointment_day());
        ps.setString(3, this.getAppointment_time());
        ps.setString(4, this.getStatus());
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
        String sql = "DELETE FROM Appointments WHERE ID=? ";
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

    public int booked() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0;
        String sql = "UPDATE Appointments SET  status='booked'  WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("Appointments with id : " + this.getId() + " was booked successfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCounter;
    }
}
