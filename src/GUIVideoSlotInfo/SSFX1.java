/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlotInfo;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class SSFX1 extends Application {
    
    FXMLDocumentController fxmlDocumentController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        fxmlDocumentController = (FXMLDocumentController) fxmlLoader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Video Slot Info");
        primaryStage.show();
    }
    
}
