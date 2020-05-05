/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlot;

import GUIVideoSlot.Listeners.MinusListener;
import GUIVideoSlot.Listeners.PlusListener;
import GUIVideoSlot.Listeners.SpinListener;
import Server_client.Position;
import Server_client.SPosition;
import Server_client.ServerController;
import Server_client.ServerController_Service;
import Server_client.Symbol;
import Server_client.WebServerTransferObject;
import Session.Session;
import java.lang.reflect.Field;
import java.util.ArrayList;
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
    WebServerTransferObject transferObject;
    ServerController_Service service;
    ServerController serverController;
    List<Integer> betValues;
    int betValuesIndex;
    int win;
    int mat[][];
    List<Symbol> symbols;
    List<Position> positions;
    //List<SPosition> sPositions = new ArrayList(); nece biti ovde nego u metodi spin() !!!

    public GUIVideoSlotController(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        this.fxmlDocumentController.btnPlus.setOnAction(new PlusListener(this));
        this.fxmlDocumentController.btnMinus.setOnAction(new MinusListener(this));
        this.fxmlDocumentController.btnSpin.setOnAction(new SpinListener(this));

        transferObject = new WebServerTransferObject();
        service = new ServerController_Service();
        serverController = service.getServerControllerPort();

        betValues = Arrays.asList(1, 2, 3, 5, 10, 25, 50, 100, 250, 500, 1000);
        betValuesIndex = 0;
        win = 0;
        mat = new int[3][5];
        getSymbols();
        getPositions();

        populateForm();
    }

    void getSymbols() {
        executeSO("getSymbols");
        symbols = transferObject.getSymbols();
    }

    void getPositions() {
        executeSO("getPositions");
        positions = transferObject.getPositions();
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

    void initializePanel() {
        randomizeMatValues();
        setImages();
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
    
    private void disableButtons() {
        this.fxmlDocumentController.btnMinus.setDisable(true);
        this.fxmlDocumentController.btnPlus.setDisable(true);
        this.fxmlDocumentController.btnSpin.setDisable(true);
    }
    
    private void enableButtons() {
        this.fxmlDocumentController.btnMinus.setDisable(false);
        this.fxmlDocumentController.btnPlus.setDisable(false);
        this.fxmlDocumentController.btnSpin.setDisable(false);
    }

    boolean saveSPositions() {
        List<SPosition> sPositions = new ArrayList<>();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                SPosition sp = new SPosition();
                sp.setSymbolId(symbols.get(mat[x][y]).getId());
                for (Position p : positions) {
                    if (p.getX() == x && p.getY() == y) {
                        sp.setPositionId(p.getId());
                    }
                }
                //ispraviti ovo za spin id
                //mozda treba i game id da se postavi
                sp.setSpinId(1);
                sPositions.add(sp);
            }
        }

        transferObject.getSPositions().clear();
        transferObject.getSPositions().addAll(sPositions);
        executeSO("saveSPositions");
        return transferObject.isSignal();
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
        disableButtons();
        //1.update user - skinuti mu bet sa balansa
        //if(!reduceUserBalance())
        //  return;
        //2.popuniti matricu random vrednostima
        initializePanel();
        //3.napraviti sPosition(id, symbol, position) objekat za svako polje u matrici i sacuvati ih sve u bazi
        if(!saveSPositions()){
            //prikazati error message
            return;
        }
        
        
        
        
        //na kraju
        enableButtons();
            
    }

    public void executeSO(String operation) {
        if (operation.equals("getSymbols")) {
            transferObject = serverController.getSymbols(transferObject);
        }
        if (operation.equals("getPositions")) {
            transferObject = serverController.getPositions(transferObject);
        }
        if (operation.equals("saveSPositions")) {
            transferObject = serverController.saveSPositions(transferObject);
        }
    }

}
