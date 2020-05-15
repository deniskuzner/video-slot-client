/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlot;

import GUIMain.GUIMainController;
import java.net.URL;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author User
 */
public class SSFX1 extends Application {

    FXMLDocumentController fxmlDocumentController;
    GUIMainController guiMainController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        fxmlDocumentController = (FXMLDocumentController) fxmlLoader.getController();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("assets/stylesheet.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Video Slot");
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                guiMainController.setUser();
            }
        });
    }

    public void setGuiMainController(GUIMainController guiMainController) {
        this.guiMainController = guiMainController;
    }

}
