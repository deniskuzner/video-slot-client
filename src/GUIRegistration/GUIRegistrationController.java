/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRegistration;

import Communication.Communication;
import Domain.User;
import GUIRegistration.Listeners.RegistrationListener;
import Transfer.TransferObject;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javafx.scene.control.Alert;

/**
 *
 * @author User
 */
public class GUIRegistrationController {

    FXMLDocumentController fxmlDocumentController;
    TransferObject transferObject = new TransferObject();

    public GUIRegistrationController(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        this.fxmlDocumentController.btnRegister.setOnAction(new RegistrationListener(this));
    }

    public void poruka(String poruka) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Poruka:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(poruka);
        infoAlert.showAndWait();
    }

    public void register() {
        String username = fxmlDocumentController.txtUsername.getText();
        String password = fxmlDocumentController.txtPassword.getText();
        String firstName = fxmlDocumentController.txtFirstName.getText();
        String lastName = fxmlDocumentController.txtLastName.getText();
        String gender = fxmlDocumentController.cmbGender.getValue() == null ? "" : (String) fxmlDocumentController.cmbGender.getValue();
        LocalDate birthDate = fxmlDocumentController.dpBirthDate.getValue() == null ? null : fxmlDocumentController.dpBirthDate.getValue();
        if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || gender.isEmpty() || birthDate == null) {
            poruka("All fields are required!");
            return;
        }

        User user = new User(0, username, password, firstName, lastName, gender, convertLocalDateToSqlDate(birthDate));
        transferObject.generalEntity = user;
        transferObject.operation = "createUser";
        transferObject = Communication.getInstance().executeSO(transferObject);

        poruka(transferObject.message);
        if (transferObject.signal) {
            fxmlDocumentController.closeForm();
        }
    }

    public static java.sql.Date convertLocalDateToSqlDate(LocalDate input) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = java.sql.Date.valueOf(input);
        return java.sql.Date.valueOf(sdf.format(date));
    }

}
