/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlot;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLDocumentController {
    
    @FXML
    public Button btnMinus;
    
    @FXML
    public Button btnPlus;
    
    @FXML
    public Button btnSpin;
    
    @FXML
    public Label lblBet;
    
    @FXML
    public Label lblBalance;
    
    @FXML
    public Label lblWin;
    
    @FXML
    public Button p00;
    
    @FXML
    public Button p01;
    
    @FXML
    public Button p02;
    
    @FXML
    public Button p03;
    
    @FXML
    public Button p04;
    
    @FXML
    public Button p10;
    
    @FXML
    public Button p11;
    
    @FXML
    public Button p12;
    
    @FXML
    public Button p13;
    
    @FXML
    public Button p14;
    
    @FXML
    public Button p20;
    
    @FXML
    public Button p21;
    
    @FXML
    public Button p22;
    
    @FXML
    public Button p23;
    
    @FXML
    public Button p24;
    
    GUIVideoSlotController guiVideoSlotController;

    @FXML
    public void initialize() {
        guiVideoSlotController = new GUIVideoSlotController(this);
    }    

}
