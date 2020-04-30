/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRankList;

import Domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class GUIRankListController {

    FXMLDocumentController fxmlDocumentController;

    public GUIRankListController(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        
        //napraviti i postaviti listener za dugme Sort
    }

    ObservableList<User> getAllUsers() {
        ObservableList users = FXCollections.observableArrayList();
        
        //poslati transfer objekat za getAll users
        //postaviti rezultat u ovo users i vratiti
        
        return null;
    }

}
