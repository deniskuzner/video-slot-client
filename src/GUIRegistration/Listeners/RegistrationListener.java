/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRegistration.Listeners;

import GUIRegistration.GUIRegistrationController;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author User
 */
public class RegistrationListener implements EventHandler {

    GUIRegistrationController guiRegistrationController;

    public RegistrationListener(GUIRegistrationController guiRegistrationController) {
        this.guiRegistrationController = guiRegistrationController;
    }

    @Override
    public void handle(Event event) {
        guiRegistrationController.register();
    }

}
