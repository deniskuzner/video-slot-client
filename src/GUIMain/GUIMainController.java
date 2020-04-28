/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMain;

import GUIMain.Listeners.ExitProgramListener;
import GUIMain.Listeners.PlayListener;
import GUIMain.Listeners.ProfileListener;
import GUIMain.Listeners.RankListListener;
import GUIMain.Listeners.SpinHistoryListener;
import javafx.application.Platform;

/**
 *
 * @author User
 */
public class GUIMainController {

    FXMLDocumentController fxmlDocumentController;

    public GUIMainController(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        this.fxmlDocumentController.play.setOnAction(new PlayListener(this));
        this.fxmlDocumentController.spinHistory.setOnAction(new SpinHistoryListener(this));
        this.fxmlDocumentController.rankList.setOnAction(new RankListListener(this));
        this.fxmlDocumentController.profile.setOnAction(new ProfileListener(this));
        this.fxmlDocumentController.exitProgram.setOnAction(new ExitProgramListener(this));
    }

    public void play() {
    }

    public void showSpinHistory() {
    }

    public void showRankList() {
    }

    public void showUserProfile() {
    }

    public void exitProgram() {
        Platform.exit();
        System.exit(0);
    }

}
