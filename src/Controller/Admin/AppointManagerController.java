package Controller.Admin;

import Model.Appointments;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class AppointManagerController implements Initializable {

    @FXML
    private TableView<Appointments> TableViewUsers;
    @FXML
    private TableColumn<Appointments, Integer> IDCol;
    @FXML
    private TableColumn<Appointments, Date> DateCol;
    @FXML
    private TableColumn<Appointments, String> DayCol;
    @FXML
    private TableColumn<Appointments, String> TimeCol;
    @FXML
    private TableColumn<Appointments, String> StatusCol;
    @FXML
    private Button addnew;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @FXML
    private Button logout;
    @FXML
    private Button BtnpageUser;
    @FXML
    private Button BtnPageAppointments;
    @FXML
    private Button BtnPageBooked;
    @FXML
    private Button ShowallAppoint;
    @FXML
    private TextField TimeTF;
    @FXML
    private TextField DayTF;
    @FXML
    private DatePicker DateTF;
    @FXML
    private Label idlabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        IDCol.setCellValueFactory(new PropertyValueFactory("id"));
        DateCol.setCellValueFactory(new PropertyValueFactory("appointment_date"));
        DayCol.setCellValueFactory(new PropertyValueFactory("appointment_day"));
        TimeCol.setCellValueFactory(new PropertyValueFactory("appointment_time"));
        StatusCol.setCellValueFactory(new PropertyValueFactory("status"));
        TableViewUsers.getSelectionModel()
                .selectedItemProperty().addListener(e -> {
                    this.showSelectA();
                });

    }

    private void showSelectA() {

        Appointments A = TableViewUsers.getSelectionModel().getSelectedItem();
        if (A != null) {
            idlabel.setText(String.valueOf(A.getId()));
            TimeTF.setText(A.getAppointment_time());
            DayTF.setText(A.getAppointment_day());
        }

    }

    @FXML
    private void btnShowallAppoint(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<Appointments> AppointmentsList
                = FXCollections.observableArrayList(Appointments.getAllAppointments());
        TableViewUsers.setItems(AppointmentsList);
    }

    @FXML
    private void AddNewAppoint(ActionEvent event) throws SQLException, ClassNotFoundException {
        Date date = Date.valueOf(DateTF.getValue());
        String Day = DayTF.getText();
        String time = TimeTF.getText();
        Appointments A = new Appointments( date, Day, time, "free");
        A.Add();
    }

    @FXML
    private void btndelete(ActionEvent event) throws SQLException, ClassNotFoundException{
        if (TableViewUsers.getSelectionModel().getSelectedItem() != null) {
            Appointments selectUser = TableViewUsers.getSelectionModel().getSelectedItem();
            selectUser.delete();
        }
    }

    @FXML
    private void btnUpdate(ActionEvent event) throws SQLException, ClassNotFoundException{
        Integer id = Integer.parseInt(idlabel.getText());
        Date date = Date.valueOf(DateTF.getValue());
        String Day = DayTF.getText();
        String time = TimeTF.getText();

        Appointments newA = new Appointments( date, Day, time, "free");
        newA.setId(id);
        newA.update();
    }

    @FXML
    private void btnlogout(ActionEvent event) throws IOException {
        ViewManger.openLoginPage();
        ViewManger.closeAdminDashboard();
    }

    @FXML
    private void showPageUsers(ActionEvent event) {
        ViewManger.AdminDashboard.changeTOUserManager();

    }

    @FXML
    private void showPageAppointments(ActionEvent event) {
        ViewManger.AdminDashboard.changeTOAppointManager();

    }

    @FXML
    private void ShowPageBooked(ActionEvent event) {
        ViewManger.AdminDashboard.changeTOBookedManager();
    }
}
