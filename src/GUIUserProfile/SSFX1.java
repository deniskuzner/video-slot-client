/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIUserProfile;

import Domain.User;
import GUIMain.GUIMainController;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
    public void start(Stage primaryStage) throws IOException {

        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        fxmlDocumentController = (FXMLDocumentController) fxmlLoader.getController();
        fxmlDocumentController.gender.getItems().addAll("MALE", "FEMALE");
        fxmlDocumentController.gender.setPromptText("Please select one");

        Scene scene = new Scene(root);
        //scene.getStylesheets().add("CSS/stylesheet.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("User profile");
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                guiMainController.setUser();
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setGuiMainController(GUIMainController guiMainController) {
        this.guiMainController = guiMainController;
    }
    
}
