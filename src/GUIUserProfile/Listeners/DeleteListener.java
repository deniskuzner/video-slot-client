/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIUserProfile.Listeners;

import GUIUserProfile.GUIUserProfileController;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author User
 */
public class DeleteListener implements EventHandler {

    GUIUserProfileController guiUserProfileController;

    public DeleteListener(GUIUserProfileController guiUserProfileController) {
        this.guiUserProfileController = guiUserProfileController;
    }

    @Override
    public void handle(Event event) {
        guiUserProfileController.delete();
    }

}
