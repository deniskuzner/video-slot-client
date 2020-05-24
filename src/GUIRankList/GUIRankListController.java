/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIRankList;

import Communication.Communication;
import Sort.CompareOperator;
import Sort.GreaterThan;
import Sort.LessThan;
import Domain.User;
import GUIRankList.Listeners.SortListener;
import Sort.Sort;
import Transfer.TransferObject;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
            new Sort<User>().sort(users, compareOperator, fieldReadMethod);
            fxmlDocumentController.tblRankList.setItems(users);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException  ex) {
            Logger.getLogger(GUIRankListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}