/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMain;

import Domain.User;
import GUIMain.Listeners.ExitProgramListener;
import GUIMain.Listeners.PlayListener;
import GUIMain.Listeners.ProfileListener;
import GUIMain.Listeners.RankListListener;
import Session.Session;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class GUIMainController {

    FXMLDocumentController fxmlDocumentController;

    public GUIMainController(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        this.fxmlDocumentController.play.setOnAction(new PlayListener(this));
        this.fxmlDocumentController.rankList.setOnAction(new RankListListener(this));
        this.fxmlDocumentController.profile.setOnAction(new ProfileListener(this));
        this.fxmlDocumentController.exitProgram.setOnAction(new ExitProgramListener(this));
    }

    public void play() {
    }

    public void showRankList() {
        try {
            GUIRankList.SSFX1 ssfx1 = new GUIRankList.SSFX1();
            ssfx1.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(GUIMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showUserProfile() {
        try {
            GUIUserProfile.SSFX1 ssfx1 = new GUIUserProfile.SSFX1();
            ssfx1.setGuiMainController(this);
            ssfx1.start(new Stage());
        } catch (IOException ex) {
            Logger.getLogger(GUIMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exitProgram() {
        Platform.exit();
        System.exit(0);
    }

    public void setUser() {
        User user = Session.getInstance().getUser();
        fxmlDocumentController.lblFirstNameLastName.setText(user.getFirstName() + " " + user.getLastName());
        fxmlDocumentController.lblBalance.setText(String.valueOf(user.getBalance()));
    }

}
