/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILogin.Listeners;

import GUILogin.GUILoginController;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author User
 */
public class RegistrationListener implements EventHandler {

    GUILoginController guiLoginController;

    public RegistrationListener(GUILoginController guiLoginController) {
        this.guiLoginController = guiLoginController;
    }
    
    @Override
    public void handle(Event event) {
        guiLoginController.register();
    }
    
}
