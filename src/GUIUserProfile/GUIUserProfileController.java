/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIUserProfile;

import Communication.Communication;
import Converter.ConverterGUIDC;
import Domain.User;
import GUIUserProfile.Listeners.DeleteListener;
import GUIUserProfile.Listeners.UpdateListener;
import Session.Session;
import Transfer.TransferObject;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author User
 */
public class GUIUserProfileController {

    FXMLDocumentController fxmlDocumentController;
    TransferObject transferObject;

    public GUIUserProfileController(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        transferObject = new TransferObject();
        this.fxmlDocumentController.btnUpdate.setOnAction(new UpdateListener(this));
        this.fxmlDocumentController.btnDelete.setOnAction(new DeleteListener(this));
    }

    public void message(String message) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Message");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(message);
        infoAlert.showAndWait();
    }

    public void update() {
        User user = Session.getInstance().getUser();
        try {
            ConverterGUIDC.convertGUIToDC(fxmlDocumentController, user);
        } catch (NullPointerException e) {
            message("All fields are required!");
        }

        if (user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getFirstName().isEmpty()
                || user.getLastName().isEmpty() || user.getGender() == null || user.getBirthDate() == null) {
            message("All fields are required!");
            return;
        }

        transferObject.generalEntity = user;
        transferObject.operation = "updateUser";
        transferObject = Communication.getInstance().executeSO(transferObject);

        message(transferObject.message);
    }

    public void delete() {
        Alert alert = new Alert(AlertType.WARNING, "Are you sure you want to delete user profile and exit application?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            transferObject.generalEntity = Session.getInstance().getUser();
            transferObject.operation = "deleteUser";
            transferObject = Communication.getInstance().executeSO(transferObject);
            message(transferObject.message);

            if (transferObject.signal) {
                exitProgram();
            }
        }
    }

    public void exitProgram() {
        Platform.exit();
        System.exit(0);
    }

}
