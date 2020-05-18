/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import GUIVideoSlot.FXMLDocumentController;
import GUIVideoSlot.GUIVideoSlotController;
import Server_client.LinePayout;
import Server_client.SpinLinePayout;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;

/**
 *
 * @author User
 */
public class WinLinesStyleThread extends Thread {

    private FXMLDocumentController fxmlDocumentController;
    private List<SpinLinePayout> spinLinePayouts;
    private List<LinePayout> linePayouts;

    public WinLinesStyleThread(FXMLDocumentController fxmlDocumentController, List<SpinLinePayout> spinLinePayouts, List<LinePayout> linePayouts) {
        this.fxmlDocumentController = fxmlDocumentController;
        this.spinLinePayouts = spinLinePayouts;
        this.linePayouts = linePayouts;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                for (SpinLinePayout spinLinePayout : spinLinePayouts) {
                    int arrayLength = linePayouts.stream().filter(lp -> lp.getId() == spinLinePayout.getLinePayoutId()).findFirst().get().getArrayLength();
                    int x = 0;
                    switch (spinLinePayout.getLineNumber()) {
                        case 1:
                            for (int y = 0; y < arrayLength; y++) {
                                setButtonStyleClass(0, y, "line-one");
                            }
                            break;
                        case 2:
                            for (int y = 0; y < arrayLength; y++) {
                                setButtonStyleClass(1, y, "line-two");
                            }
                            break;
                        case 3:
                            for (int y = 0; y < arrayLength; y++) {
                                setButtonStyleClass(2, y, "line-three");
                            }
                            break;
                        case 4:
                            x = 0;
                            for (int y = 0; y < arrayLength; y++) {
                                setButtonStyleClass(x, y, "line-four");
                                if (y < 2) {
                                    x++;
                                } else {
                                    x--;
                                }
                            }
                            break;
                        case 5:
                            x = 2;
                            for (int y = 0; y < arrayLength; y++) {
                                setButtonStyleClass(x, y, "line-five");
                                if (y < 2) {
                                    x--;
                                } else {
                                    x++;
                                }
                            }
                            break;
                    }

                    sleep(1000);
                    clearPanel();
                    sleep(700);
                }
            }
        } catch (InterruptedException e) {
        }

    }

    void setButtonStyleClass(int x, int y, String styleClass) {
        try {
            String buttonName = "p" + x + y;
            Class cls = this.fxmlDocumentController.getClass();
            Field field = cls.getDeclaredField(buttonName);
            Button b = (Button) field.get(this.fxmlDocumentController);
            b.getStyleClass().add(styleClass);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(WinLinesStyleThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void clearPanel() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                try {
                    String buttonName = "p" + x + y;
                    Class cls = this.fxmlDocumentController.getClass();
                    Field field = cls.getDeclaredField(buttonName);
                    Button b = (Button) field.get(this.fxmlDocumentController);
//                    b.getStyleClass().removeAll("line-one", "line-two", "line-three", "line-four", "line-five");
                    b.getStyleClass().clear();
                    b.getStyleClass().add("button");
                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(GUIVideoSlotController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
