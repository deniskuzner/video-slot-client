/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIMain;

import Domain.User;
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
    User user;

    @Override
    public void start(Stage primaryStage) throws Exception {
        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        fxmlDocumentController = (FXMLDocumentController) fxmlLoader.getController();
        fxmlDocumentController.setUser(user);
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("CSS/stylesheet.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Video Slot");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setUser(User user) {
        this.user = user;
    }

}