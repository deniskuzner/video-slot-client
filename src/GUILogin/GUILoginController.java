/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILogin;

import Communication.Communication;
import Converter.ConverterGUIDC;
import Domain.User;
import GUILogin.Listeners.LoginListener;
import GUILogin.Listeners.RegistrationListener;
import Session.Session;
import Transfer.TransferObject;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class GUILoginController {

    FXMLDocumentController fxmlDocumentController;
    TransferObject transferObject = new TransferObject();

    public GUILoginController(FXMLDocumentController fxmlDocumentController) throws IOException {
        this.fxmlDocumentController = fxmlDocumentController;
        this.fxmlDocumentController.btnLogin.setOnAction(new LoginListener(this));
        this.fxmlDocumentController.btnRegister.setOnAction(new RegistrationListener(this));
    }

    public void message(String message) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Message");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(message);
        infoAlert.showAndWait();
    }

    public void login() {
        User user = new User();
        ConverterGUIDC.convertGUIToDC(fxmlDocumentController, user);
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            message("All fields are required!");
            return;
        }

        transferObject.generalEntity = user;
        transferObject.operation = "login";
        transferObject = Communication.getInstance().executeSO(transferObject);

        message(transferObject.message);
        if (transferObject.signal) {
            GUIMain.SSFX1 ssfx1 = new GUIMain.SSFX1();
            Stage s = new Stage();
            try {
                Session.getInstance().setUser((User) transferObject.generalEntity);
                ssfx1.start(s);
                fxmlDocumentController.closeForm();
            } catch (Exception ex) {
                Logger.getLogger(GUILoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void register() {
        try {
            GUIRegistration.SSFX1 ssfx1 = new GUIRegistration.SSFX1();
            ssfx1.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(GUILoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
