/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRegistration;

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
public class FXMLDocumentController implements Initializable {

    @FXML
    public TextField txtUsername;

    @FXML
    public PasswordField txtPassword;

    @FXML
    public TextField txtFirstName;

    @FXML
    public TextField txtLastName;

    @FXML
    public ComboBox cmbGender;

    @FXML
    public DatePicker dpBirthDate;

    @FXML
    public Button btnRegister;

    public GUIRegistrationController guiRegistrationController;
    public Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        guiRegistrationController = new GUIRegistrationController(this);
    }

}
