/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlot;

import GUIVideoSlot.Listeners.MinusListener;
import GUIVideoSlot.Listeners.PlusListener;
import GUIVideoSlot.Listeners.SpinListener;
import Session.Session;
import Transfer.TransferObject;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author User
 */
public final class GUIVideoSlotController {

    FXMLDocumentController fxmlDocumentController;
    TransferObject transferObject;
    List<Integer> betValues;
    int betValuesIndex;
    int win;
    int mat[][];

    public GUIVideoSlotController(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        this.fxmlDocumentController.btnPlus.setOnAction(new PlusListener(this));
        this.fxmlDocumentController.btnMinus.setOnAction(new MinusListener(this));
        this.fxmlDocumentController.btnSpin.setOnAction(new SpinListener(this));

        transferObject = new TransferObject();
        betValues = Arrays.asList(1, 2, 3, 5, 10, 25, 50, 100, 250, 500, 1000);
        betValuesIndex = 0;
        win = 0;
        mat = new int[3][5];

        populateForm();
    }

    void populateForm() {
        fxmlDocumentController.lblBalance.setText(Session.getInstance().getUser().getBalance() + " RSD");
        setBetLabel();
        setWinLabel();
        initializePanel();
    }

    void setBetLabel() {
        fxmlDocumentController.lblBet.setText(betValues.get(betValuesIndex) + " RSD");
    }

    void setWinLabel() {
        fxmlDocumentController.lblWin.setText(win + " RSD");
    }

    //TODO
    void initializePanel() {
        randomizeMatValues();
        setImages();
    }

    public void plus() {
        if (betValuesIndex + 1 < betValues.size()) {
            betValuesIndex++;
            setBetLabel();
        }
    }

    public void minus() {
        if (betValuesIndex - 1 >= 0) {
            betValuesIndex--;
            setBetLabel();
        }
    }

    //TODO
    public void spin() {
        //TODO: LOGIKA CELE IGRE

        //postaviti na disabled spin, plus i minus btn dok se ne zavrsi spin, pa onda vratiti
    }

    private void randomizeMatValues() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                mat[x][y] = new Random().nextInt(8);
                System.out.println("MAT[" + x + "][" + y + "]: " + mat[x][y]);
            }
        }
    }

    //TODO
    private void setImages() {

    }

}
