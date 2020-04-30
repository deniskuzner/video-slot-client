/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRankList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FXMLDocumentController {
    
    @FXML
    public ComboBox cmbSortBy;
    
    @FXML
    public ComboBox cmbOrderBy;
    
    @FXML
    public Button btnSort;
    
    @FXML
    public TableView tblRankList;
    
    GUIRankListController guiRankListController;

    @FXML
    public void initialize() {
        guiRankListController = new GUIRankListController(this);
        populateForm();
    }    

    private void populateForm() {
        populateCmbSortBy();
        populateCmbOrderBy();
        populateTblRankList();
    }

    private void populateCmbSortBy() {
        cmbSortBy.getItems().addAll("Balance", "Username");
    }

    private void populateCmbOrderBy() {
        cmbOrderBy.getItems().addAll("ASC", "DESC");
    }

    private void populateTblRankList() {
        guiRankListController.getAllUsers();
        
        // mozda i napraviti novi table model zbog rednog broja koji ne postoji u klasi user
        // razmisliti kako bi se postavljao taj redni broj
    }
    
}
