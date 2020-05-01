/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRankList;

import Domain.User;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        cmbSortBy.getSelectionModel().selectFirst();
    }

    private void populateCmbOrderBy() {
        cmbOrderBy.getItems().addAll("DESC", "ASC");
        cmbOrderBy.getSelectionModel().selectFirst();
    }

    private void populateTblRankList() {
        ObservableList<User> users = guiRankListController.getAllUsers();

        TableColumn<User, Integer> rankColumn = new TableColumn<>("Rank");
        rankColumn.setCellValueFactory(column -> new ReadOnlyObjectWrapper<>(tblRankList.getItems().indexOf(column.getValue()) + 1));
        rankColumn.setSortable(false);

        TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setMinWidth(125);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        usernameColumn.setSortable(false);

        TableColumn<User, String> firsNameColumn = new TableColumn<>("First name");
        firsNameColumn.setMinWidth(125);
        firsNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firsNameColumn.setSortable(false);

        TableColumn<User, String> lastNameColumn = new TableColumn<>("Last name");
        lastNameColumn.setMinWidth(125);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setSortable(false);

        TableColumn<User, String> balanceColumn = new TableColumn<>("Balance");
        balanceColumn.setMinWidth(113);
        balanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));
        balanceColumn.setSortable(false);

        tblRankList.setItems(users);
        tblRankList.getColumns().addAll(rankColumn, usernameColumn, firsNameColumn, lastNameColumn, balanceColumn);
    }
    
    public void refreshTable() {
        ObservableList users = FXCollections.observableArrayList();
        users.setAll(guiRankListController.users);
        tblRankList.setItems(users);
    }

}
