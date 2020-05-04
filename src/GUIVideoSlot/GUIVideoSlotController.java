/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlot;

import Domain.Symbol;
import GUIVideoSlot.Listeners.MinusListener;
import GUIVideoSlot.Listeners.PlusListener;
import GUIVideoSlot.Listeners.SpinListener;
import Session.Session;
import Transfer.TransferObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    List<Symbol> symbols;
    //List<Position> positions;
    //List<SPosition> sPositions = new ArrayList(); nece biti ovde nego u metodi spin() !!!

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
        getSymbols();
        //getPositions();

        populateForm();
    }

    void getSymbols() {
        Symbol s1 = new Symbol(1, "lemon");
        Symbol s2 = new Symbol(2, "orange");
        Symbol s3 = new Symbol(3, "cherry");
        Symbol s4 = new Symbol(4, "grapes");
        Symbol s5 = new Symbol(5, "melon");
        Symbol s6 = new Symbol(6, "bell");
        Symbol s7 = new Symbol(7, "seven");
        symbols = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
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
        
        initializePanel();
        
        
        
        //TODO: LOGIKA CELE IGRE

        //postaviti na disabled spin, plus i minus btn dok se ne zavrsi spin, pa onda vratiti
        //1.update user - skinuti mu bet sa balansa
        //2.popuniti matricu random vrednostima
        //3.napraviti sPosition(id, symbol, position) objekat za svako polje u matrici i sacuvati ih sve u bazi
    }

    //ovo ce ici u poslovnu logiku? pa odatle uraditi setMat() za ovu klasu
    void randomizeMatValues() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                mat[x][y] = new Random().nextInt(symbols.size());
                System.out.println("MAT[" + x + "][" + y + "]: " + mat[x][y]);
            }
        }
    }

    //TODO
    void setImages() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                setImage(getImage(symbols.get(mat[x][y]).getName()), x, y);
            }
        }
    }

    void setImage(Image image, int x, int y) {
        Button button = null;
        String buttonName = "p" + x + y;
        Class fxmlDocumentControllerClass = this.fxmlDocumentController.getClass();
        try {
            Field field = fxmlDocumentControllerClass.getDeclaredField(buttonName);
            button = (Button) field.get(this.fxmlDocumentController);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(GUIVideoSlotController.class.getName()).log(Level.SEVERE, null, ex);
        }

        button.setGraphic(new ImageView(image));
    }

    Image getImage(String name) {
        String location = "assets/images/";
        String fileName = name + ".png";
        return new Image(location + fileName, 140, 140, false, true);
    }

}
