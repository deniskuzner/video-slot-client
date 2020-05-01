/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRankList.Listeners;

import GUIRankList.GUIRankListController;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author User
 */
public class SortListener implements EventHandler {
    
    GUIRankListController guiRankListController;

    public SortListener(GUIRankListController guiRankListController) {
        this.guiRankListController = guiRankListController;
    }
    
    @Override
    public void handle(Event event) {
        guiRankListController.sort();
    }
    
}
