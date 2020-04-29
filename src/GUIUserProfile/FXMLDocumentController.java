/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIUserProfile;

import Converter.ConverterGUIDC;
import Converter.GeneralFXMLDocumentController;
import Session.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLDocumentController implements GeneralFXMLDocumentController {

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
    public TextField balance;

    @FXML
    public DatePicker birthDate;

    @FXML
    public Button btnUpdate;

    @FXML
    public Button btnDelete;

    GUIUserProfileController guiUserProfileController;

    @FXML
    public void initialize() {
        guiUserProfileController = new GUIUserProfileController(this);
        populateForm();
    }

    private void populateForm() {
        ConverterGUIDC.convertDCToGUI(Session.getInstance().getUser(), this);
    }

}
