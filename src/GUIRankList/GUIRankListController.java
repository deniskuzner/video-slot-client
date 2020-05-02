/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRankList;

import Communication.Communication;
import CompareOperator.CompareOperator;
import CompareOperator.GreaterThan;
import CompareOperator.LessThan;
import Domain.User;
import GUIRankList.Listeners.SortListener;
import Transfer.TransferObject;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author User
 */
public class GUIRankListController {

    FXMLDocumentController fxmlDocumentController;
    TransferObject transferObject;
    ObservableList<User> users;

    public GUIRankListController(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        this.fxmlDocumentController.btnSort.setOnAction(new SortListener(this));
        this.transferObject = new TransferObject();
        this.users = FXCollections.observableArrayList();
    }

    public void message(String message) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Message");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(message);
        infoAlert.showAndWait();
    }

    ObservableList<User> getAllUsers() {
        transferObject.operation = "getUsers";
        transferObject = Communication.getInstance().executeSO(transferObject);
        users.setAll(transferObject.castGeneralList(User.class));
        sort();
        return users;
    }

    public void sort() {
        CompareOperator compareOperator = null;
        Method fieldReadMethod = null;
        String sortBy = (String) fxmlDocumentController.cmbSortBy.getValue();
        String orderBy = (String) fxmlDocumentController.cmbOrderBy.getValue();

        switch (orderBy) {
            case "ASC":
                compareOperator = new GreaterThan();
                break;
            case "DESC":
                compareOperator = new LessThan();
                break;
        }

        for (Field field : User.class.getDeclaredFields()) {
            if (field.getName().toLowerCase().equals(sortBy.toLowerCase())) {
                try {
                    fieldReadMethod = new PropertyDescriptor(field.getName(), User.class).getReadMethod();
                } catch (IntrospectionException ex) {
                    Logger.getLogger(GUIRankListController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        try {
            executeSort(fieldReadMethod, compareOperator);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException  ex) {
            Logger.getLogger(GUIRankListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void executeSort(Method fieldReadMethod, CompareOperator compareOperator) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        User pom;
        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (compareOperator.compare((Comparable) fieldReadMethod.invoke(users.get(i)), (Comparable) fieldReadMethod.invoke(users.get(j)))) {
                    pom = users.get(i);
                    users.set(i, users.get(j));
                    users.set(j, pom);
                }
            }
        }
        fxmlDocumentController.tblRankList.setItems(users);
    }

}