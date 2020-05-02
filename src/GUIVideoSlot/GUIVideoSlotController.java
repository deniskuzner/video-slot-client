/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlot;

import Transfer.TransferObject;

/**
 *
 * @author User
 */
public class GUIVideoSlotController {
    
    FXMLDocumentController fxmlDocumentController;
    TransferObject transferObject;

    public GUIVideoSlotController(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        this.transferObject = new TransferObject();
    }
    
}
