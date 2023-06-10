/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MSI GF
 */
public class Rigster extends Stage {

    private Scene rigsterPage;

    public Rigster() throws IOException {
        Parent PrigsterPage = FXMLLoader.load(getClass().getResource("RegisrterFxml/Register.fxml"));
        rigsterPage = new Scene(PrigsterPage);
        this.setScene(rigsterPage);
        this.setTitle("Rigster Page");
    }


}
