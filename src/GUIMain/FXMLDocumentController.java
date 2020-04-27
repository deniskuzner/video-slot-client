/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMain;

import Domain.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLDocumentController {

    GUIMainController guiMainController;
    User user;
    
    @FXML
    public Label lblFirstNameLastName;
    
    @FXML
    public Label lblBalance;

    @FXML
    public void play() {

    }

    @FXML
    public void showSpinHistory() {

    }

    @FXML
    public void showRankList() {

    }

    @FXML
    public void showUserProfile() {

    }

    @FXML
    public void exitProgram() {

    }

    @FXML
    public void initialize() {
        guiMainController = new GUIMainController(this);
    }
    
    public void setUser(User user) {
        this.user = user;
        this.lblFirstNameLastName.setText(user.getFirstName()+ " " + user.getLastName());
        this.lblBalance.setText(String.valueOf(user.getBalance()));
    }

}