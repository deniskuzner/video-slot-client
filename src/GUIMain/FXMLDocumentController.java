/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMain;

import Domain.User;
import Session.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLDocumentController {

    GUIMainController guiMainController;
    
    @FXML
    public Label lblFirstNameLastName;
    
    @FXML
    public Label lblBalance;
    
    @FXML
    public MenuItem play;
    
    @FXML
    public MenuItem spinHistory;
    
    @FXML
    public MenuItem rankList;
    
    @FXML
    public MenuItem profile;
    
    @FXML
    public MenuItem exitProgram;

    @FXML
    public void initialize() {
        guiMainController = new GUIMainController(this);
        guiMainController.setUser();
    }
    
}
