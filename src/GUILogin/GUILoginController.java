/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILogin;

import Domain.User;
import GUILogin.Listeners.LoginListener;
import GUILogin.Listeners.RegistrationListener;
import Transfer.TransferObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    public GUILoginController(FXMLDocumentController fxmlDocumentController) throws IOException {
        this.fxmlDocumentController = fxmlDocumentController;
        this.fxmlDocumentController.btnLogin.setOnAction(new LoginListener(this));
        this.fxmlDocumentController.btnRegister.setOnAction(new RegistrationListener(this));

        socket = new Socket("127.0.0.1", 8189);
    }

    public void poruka(String poruka) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Poruka:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(poruka);
        infoAlert.showAndWait();
    }

    public void login() {
        User user = new User();
        user.setUsername(fxmlDocumentController.txtUsername.getText());
        user.setPassword(fxmlDocumentController.txtPassword.getText());
        transferObject.generalEntity = user;
        executeSO("login");
        poruka(transferObject.message);
        if (transferObject.signal) {
//            GUI.SSFX1 ssfx1;
//            Stage s;
//            ssfx1 = new GUI.SSFX1();
//            s = new Stage();
//            String idKorisnika = String.valueOf(p.idKorisnika);
//            try {
//                ssfx1.postaviKorisnika(idKorisnika);
//                ssfx1.start(s);
//
//                fxmlDocumentController.closeForm();
//            } catch (Exception ex) {
//                Logger.getLogger(ControllerGUILogin.class.getName()).log(Level.SEVERE, null, ex);
//            }
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

    public void executeSO(String opertaion) {
        transferObject.operation = opertaion;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(GUILoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            out.writeObject(transferObject);
        } catch (IOException ex) {
            Logger.getLogger(GUILoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            transferObject = (TransferObject) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GUILoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
