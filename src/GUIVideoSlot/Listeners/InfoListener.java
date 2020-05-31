/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlot.Listeners;

import GUIVideoSlot.GUIVideoSlotController;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author User
 */
public class InfoListener implements EventHandler {

    GUIVideoSlotController guiVideoSlotController;

    public InfoListener(GUIVideoSlotController guiVideoSlotController) {
        this.guiVideoSlotController = guiVideoSlotController;
    }

    @Override
    public void handle(Event event) {
        guiVideoSlotController.info();
    }

}
