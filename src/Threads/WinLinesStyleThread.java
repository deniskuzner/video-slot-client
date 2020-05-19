/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import GUIVideoSlot.GUIVideoSlotController;
import Server_client.LinePayout;
import Server_client.SpinLinePayout;
import java.util.List;
import javafx.application.Platform;

/**
 *
 * @author User
 */
public class WinLinesStyleThread extends Thread {

    private GUIVideoSlotController guiVideoSlotController;
    private List<SpinLinePayout> spinLinePayouts;
    private List<LinePayout> linePayouts;

    public WinLinesStyleThread(GUIVideoSlotController guiVideoSlotController, List<SpinLinePayout> spinLinePayouts, List<LinePayout> linePayouts) {
        this.guiVideoSlotController = guiVideoSlotController;
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
        Platform.runLater(() -> guiVideoSlotController.setButtonStyleClass(x, y, "line-one"));
    }

    void clearPanel() {
        Platform.runLater(() -> guiVideoSlotController.clearPanel());
    }

}
