/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUILogin;

import java.io.IOException;
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
    public void start(Stage primaryStage) throws IOException {

        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        fxmlDocumentController = (FXMLDocumentController) fxmlLoader.getController();
        fxmlDocumentController.setStage(primaryStage);

        Scene scene = new Scene(root);
        fxmlDocumentController.txtUsername.requestFocus();
        //scene.getStylesheets().add("CSS/stylesheet.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public FXMLDocumentController getController() {
        return fxmlDocumentController;
    }

}
