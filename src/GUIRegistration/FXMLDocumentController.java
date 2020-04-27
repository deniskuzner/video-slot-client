/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRegistration;

import Converter.GeneralFXMLDocumentController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable, GeneralFXMLDocumentController {

    @FXML
    public TextField username;

    @FXML
    public PasswordField password;

    @FXML
    public TextField firstName;

    @FXML
    public TextField lastName;

    @FXML
    public ComboBox gender;

    @FXML
    public DatePicker birthDate;

    @FXML
    public Button btnRegister;

    public GUIRegistrationController guiRegistrationController;
    public Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        guiRegistrationController = new GUIRegistrationController(this);
    }

    void setStage(Stage stage) {
        this.stage = stage;
    }

    void closeForm() {
        stage.close();
    }

}
