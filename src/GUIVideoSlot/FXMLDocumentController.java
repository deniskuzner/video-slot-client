/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlot;

import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLDocumentController {

    GUIVideoSlotController guiVideoSlotController;

    @FXML
    public void initialize() {
        guiVideoSlotController = new GUIVideoSlotController(this);
    }    
    
}
