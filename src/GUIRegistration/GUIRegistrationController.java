/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRegistration;

import Communication.Communication;
import Converter.ConverterGUIDC;
import Domain.User;
import GUIRegistration.Listeners.RegistrationListener;
import Transfer.TransferObject;
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

    public void message(String message) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Message");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(message);
        infoAlert.showAndWait();
    }

    public void register() {
        User user = new User();
        user.setBalance(5000);
        ConverterGUIDC.convertGUIToDC(fxmlDocumentController, user);
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getFirstName().isEmpty()
                || user.getLastName().isEmpty() || user.getGender() == null || user.getBirthDate() == null) {
            message("All fields are required!");
            return;
        }

        transferObject.generalEntity = user;
        transferObject.operation = "createUser";
        transferObject = Communication.getInstance().executeSO(transferObject);

        message(transferObject.message);
        if (transferObject.signal) {
            fxmlDocumentController.closeForm();
        }
    }

}
