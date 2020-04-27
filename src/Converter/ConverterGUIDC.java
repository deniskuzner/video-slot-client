/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Domain.GeneralEntity;
import GUIRegistration.FXMLDocumentController;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ConverterGUIDC {

    public static boolean convertGUIToDC(GeneralFXMLDocumentController fxmlDocumentController, GeneralEntity generalEntity) {
        for (Field f : fxmlDocumentController.getClass().getDeclaredFields()) {
            for (Field dk : generalEntity.getClass().getDeclaredFields()) {
                dk.setAccessible(true);
                if (dk.getName().equals(f.getName())) {
                    if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("int")) {
                        try {
                            Integer broj = Integer.valueOf(((javafx.scene.control.TextField) f.get(fxmlDocumentController)).getText());
                            dk.set(generalEntity, broj);

                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }
                    if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("java.lang.String")) {
                        try {
                            dk.set(generalEntity, ((javafx.scene.control.TextField) f.get(fxmlDocumentController)).getText());
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                    if (f.getType().getName().equals("javafx.scene.control.PasswordField") && dk.getType().getName().equals("java.lang.String")) {
                        try {
                            dk.set(generalEntity, ((javafx.scene.control.PasswordField) f.get(fxmlDocumentController)).getText());
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                    if (f.getType().getName().equals("javafx.scene.control.DatePicker") && dk.getType().getName().equals("java.util.Date")) {
                        try {
                            dk.set(generalEntity, convertLocalDateToSqlDate((LocalDate) ((javafx.scene.control.DatePicker) f.get(fxmlDocumentController)).getValue()));
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                    if (f.getType().getName().equals("javafx.scene.control.ComboBox") && dk.getType().getName().equals("java.lang.String")) {
                        try {
                            dk.set(generalEntity, ((javafx.scene.control.ComboBox) f.get(fxmlDocumentController)).getValue());
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }

    public static boolean convertDCToGUI(GeneralEntity generalEntity, GeneralFXMLDocumentController fxmlDocumentController) {
        for (Field f : fxmlDocumentController.getClass().getDeclaredFields()) {
            for (Field dk : generalEntity.getClass().getDeclaredFields()) {
                dk.setAccessible(true);
                if (dk.getName().equals(f.getName())) {
                    if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("int")) {
                        try {
                            Integer broj = (Integer) dk.get(generalEntity);
                            ((javafx.scene.control.TextField) f.get(fxmlDocumentController)).setText(String.valueOf(broj));
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }
                    if (f.getType().getName().equals("javafx.scene.control.TextField") && dk.getType().getName().equals("java.lang.String")) {
                        try {
                            ((javafx.scene.control.TextField) f.get(fxmlDocumentController)).setText((String) dk.get(generalEntity));
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                    if (f.getType().getName().equals("javafx.scene.control.PasswordField") && dk.getType().getName().equals("java.lang.String")) {
                        try {
                            ((javafx.scene.control.PasswordField) f.get(fxmlDocumentController)).setText((String) dk.get(generalEntity));
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                    if (f.getType().getName().equals("javafx.scene.control.DatePicker") && dk.getType().getName().equals("java.util.Date")) {
                        try {
                            ((javafx.scene.control.DatePicker) f.get(fxmlDocumentController)).setValue(convertSqlDateToLocalDate((Date) dk.get(generalEntity)));
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                    if (f.getType().getName().equals("javafx.scene.control.ComboBox") && dk.getType().getName().equals("java.lang.String")) {
                        try {
                            ((javafx.scene.control.ComboBox) f.get(fxmlDocumentController)).setValue((String) dk.get(generalEntity));
                        } catch (IllegalArgumentException | IllegalAccessException ex) {
                            Logger.getLogger(ConverterGUIDC.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    }

                }
            }
        }
        return true;

    }

    private static LocalDate convertSqlDateToLocalDate(java.util.Date input) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(sm.format(input));
        LocalDate date = sqlDate.toLocalDate();
        return date;
    }

    private static java.sql.Date convertLocalDateToSqlDate(LocalDate input) {
        if (input == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = java.sql.Date.valueOf(input);
        return java.sql.Date.valueOf(sdf.format(date));
    }

}
