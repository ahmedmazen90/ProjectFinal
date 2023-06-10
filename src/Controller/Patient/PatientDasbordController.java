
package Controller.Patient;

import Model.Appointments;
import Model.BookedAppointments;
import Model.Users;
import Model.globalUser;
import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class PatientDasbordController implements Initializable {

    @FXML
    private TableColumn<Appointments, Date> AppointementdataCol;
    @FXML
    private TableColumn<Appointments, String> AppoinyementdayCol;
    @FXML
    private TableColumn<Appointments, String> AppoinyementtimeCol;
    @FXML
    private TableColumn<Appointments, String> StatesCol;
    @FXML
    private Button Showfreeappointement;
    @FXML
    private TableColumn<BookedAppointments, Integer> UserIDCol;
    @FXML
    private TableColumn<BookedAppointments, Integer> AppointemetIDCol;
    @FXML
    private TableColumn<BookedAppointments, String> StatesBookedCol;
    @FXML
    private TableColumn<BookedAppointments, String> DocterCommentCol;
    @FXML
    private Button bookanAppointement;
    @FXML
    private Button ShowmybookedFinised;
    @FXML
    private Button Showmybookedwaiting;
    @FXML
    private TableView<Appointments> TableViewAppointment;
    @FXML
    private TableView<BookedAppointments> TableViewBooked;
    @FXML
    private Button logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        AppointementdataCol.setCellValueFactory(new PropertyValueFactory("appointment_date"));
        AppoinyementdayCol.setCellValueFactory(new PropertyValueFactory("appointment_day"));
        AppoinyementtimeCol.setCellValueFactory(new PropertyValueFactory("appointment_time"));
        StatesCol.setCellValueFactory(new PropertyValueFactory("status"));

        UserIDCol.setCellValueFactory(new PropertyValueFactory("user_id"));
        AppointemetIDCol.setCellValueFactory(new PropertyValueFactory("appointment_id"));
        StatesBookedCol.setCellValueFactory(new PropertyValueFactory("status"));
        DocterCommentCol.setCellValueFactory(new PropertyValueFactory("doctor_comment"));

    }

    @FXML
    private void btnShowfreeappointement(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Appointments> AppointmentsList
                = FXCollections.observableArrayList(Appointments.getAllAppointments());
        TableViewAppointment.setItems(AppointmentsList);
    }

    @FXML
    private void btnbookanAppointement(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (TableViewAppointment.getSelectionModel().getSelectedItem() != null) {
            Appointments selectUser = TableViewAppointment.getSelectionModel().getSelectedItem();
            Integer A_id = selectUser.getId();
            Integer U_id = globalUser.userLogin.getId();
            BookedAppointments BA = new BookedAppointments(A_id, U_id, "waiting", "..");
            BA.Add();
            Appointments A = new Appointments();
            A.setId(A_id);
            A.booked();
        }
    }

    @FXML
    private void btnShowmybookedFinised(ActionEvent event) throws SQLException, ClassNotFoundException {
        Integer id = globalUser.userLogin.getId();
        ObservableList<BookedAppointments> mybookedFinised
                = FXCollections.observableArrayList(BookedAppointments.getAllMyAppointmentsFinished(id));
        TableViewBooked.setItems(mybookedFinised);
    }

    @FXML
    private void btnShowmybookedwaiting(ActionEvent event) throws SQLException, ClassNotFoundException {
        Integer id = globalUser.userLogin.getId();
        ObservableList<BookedAppointments> mybookedwaiting
                = FXCollections.observableArrayList(BookedAppointments.getAllMyAppointmentsWaiting(id));
        TableViewBooked.setItems(mybookedwaiting);
    }

    @FXML
    private void btnlogout(ActionEvent event) throws IOException {
        ViewManger.openPaitentDashboard();
        ViewManger.openLoginPage();
    }

}
