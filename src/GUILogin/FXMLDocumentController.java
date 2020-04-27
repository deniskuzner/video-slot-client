/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILogin;

import Converter.GeneralFXMLDocumentController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    public Button btnLogin;
    
    @FXML
    public Button btnRegister;
    
    public GUILoginController guiLoginController;
    public Stage stage;

    @FXML
    public void initialize() throws IOException {
        guiLoginController = new GUILoginController(this);
    }
    
    void setStage(Stage stage) {
        this.stage = stage;
    }
    
    void closeForm() {
        stage.close();
    }
    
}
