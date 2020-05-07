/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlot;

import Domain.User;
import GUIVideoSlot.Listeners.MinusListener;
import GUIVideoSlot.Listeners.PlusListener;
import GUIVideoSlot.Listeners.SpinListener;
import Server_client.LinePayout;
import Server_client.Position;
import Server_client.SPosition;
import Server_client.ServerController;
import Server_client.ServerController_Service;
import Server_client.SpinLinePayout;
import Server_client.Symbol;
import Server_client.WebServerTransferObject;
import Session.Session;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
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
    List<LinePayout> linePayouts;

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
        getLinePayouts();

        populateForm();
    }

    public void message(String message) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Message");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(message);
        infoAlert.showAndWait();
    }

    void getSymbols() {
        executeSO("getSymbols");
        symbols = transferObject.getSymbols();
    }

    void getPositions() {
        executeSO("getPositions");
        positions = transferObject.getPositions();
    }
    
    void getLinePayouts() {
        executeSO("getLinePayouts");
        linePayouts = transferObject.getLinePayouts();
        System.out.println("LINE PAYOUTS SIZE: " + linePayouts.size());
    }

    void populateForm() {
        setBalanceLabel();
        setBetLabel();
        setWinLabel();
        initializePanel();
    }

    void setBalanceLabel() {
        fxmlDocumentController.lblBalance.setText(Session.getInstance().getUser().getBalance() + " RSD");
    }

    void setBetLabel() {
        fxmlDocumentController.lblBet.setText(betValues.get(betValuesIndex) + " RSD");
    }

    void setWinLabel() {
        fxmlDocumentController.lblWin.setText(win + " RSD");
    }

    void initializePanel() {
        createSpin();
        setImages();
    }

    //ovo ce ici u poslovnu logiku? pa odatle uraditi setMat() za ovu klasu
    void createSpin() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                mat[x][y] = new Random().nextInt(symbols.size());
            }
        }
        
        //ovde ce ici poziv SO npr. createSpin();
        //koji ce da sacuva SPIN zajedno sa SPOSITIONS listom
        //u transfer objektu ce da se prosledi i bet, gameId, mozda cak i symbols i positions
        
        //rezultat: mat = transferObject.getMat();
        //spinId = transferObject.spinId;
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
                sp.setGameId(1);
                sp.setSpinId(1);
                sPositions.add(sp);
            }
        }

        transferObject.getSPositions().clear();
        transferObject.getSPositions().addAll(sPositions);
        executeSO("saveSPositions");
        return transferObject.isSignal();
    }

    boolean reduceUserBalance() {
        if (!hasBalance()) {
            message("You don't have enough funds on your balance!");
            return false;
        }
        User sessionUser = Session.getInstance().getUser();
        int newBalance = sessionUser.getBalance() - betValues.get(betValuesIndex);

        Server_client.User serverUser = new Server_client.User();
        serverUser.setId(sessionUser.getId());
        serverUser.setBalance(newBalance);

        transferObject.setUserObject(serverUser);
        executeSO("updateUser");
        if (transferObject.isSignal()) {
            sessionUser.setBalance(newBalance);
            setBalanceLabel();
        } else {
            message(transferObject.getMessage());
        }
        return transferObject.isSignal();
    }

    boolean hasBalance() {
        return Session.getInstance().getUser().getBalance() >= betValues.get(betValuesIndex);
    }

    //na server
    void checkLines() {
        //ovo staviti u PayoutCalculator na serveru
        //linije 1,2,3
        List<SpinLinePayout> spinLinePayouts = new ArrayList<>();
        for (int x = 0; x < 3; x++) {
            int arrayLength = 1;
            int symbolId = symbols.get(mat[x][0]).getId();
            for (int y = 1; y < 5; y++) {
                if (symbolId == symbols.get(mat[x][y]).getId()) {
                    arrayLength++;
                } else {
                    break;
                }
            }
            
            addSpinLinePayoutToList(spinLinePayouts, arrayLength, symbolId);
            System.out.println("LINIJA: " + (x + 1) + ", SIMBOL: " + symbolId + ", DUZINA NIZA: " + arrayLength);
        }

        //linija 4
        int arrayLength = 0;
        int symbolId = symbols.get(mat[0][0]).getId();
        int x = 0;
        for (int y = 0; y < 5; y++) {
            if (symbolId == symbols.get(mat[x][y]).getId()) {
                arrayLength++;
            } else {
                break;
            }
            if(y < 2)
                x++;
            else
                x--;
        }
        addSpinLinePayoutToList(spinLinePayouts, arrayLength, symbolId);
        System.out.println("LINIJA: " + 4 + ", SIMBOL: " + symbolId + ", DUZINA NIZA: " + arrayLength);

        //linija 5
        arrayLength = 0;
        symbolId = symbols.get(mat[2][0]).getId();
        x = 2;
        for (int y = 0; y < 5; y++) {
            if (symbolId == symbols.get(mat[x][y]).getId()) {
                arrayLength++;
            } else {
                break;
            }
            if(y < 2)
                x--;
            else
                x++;
        }
        addSpinLinePayoutToList(spinLinePayouts, arrayLength, symbolId);
        System.out.println("LINIJA: " + 5 + ", SIMBOL: " + symbolId + ", DUZINA NIZA: " + arrayLength);
        
        
        saveSpinLinePayouts(spinLinePayouts);
    }
    //na server
    void addSpinLinePayoutToList(List<SpinLinePayout> spinLinePayouts, int arrayLength, int symbolId) {
        Optional<LinePayout> result = linePayouts.stream().filter(l -> l.getArrayLength() == arrayLength && l.getSymbolId() == symbolId).findFirst();
        LinePayout lp = result.isPresent() ? result.get() : null;
        
        if(lp != null) {
                SpinLinePayout spinLinePayout = new SpinLinePayout();
                spinLinePayout.setGameId(1);
                spinLinePayout.setSpinId(1);
                spinLinePayout.setLinePayoutId(lp.getId());
                spinLinePayouts.add(spinLinePayout);
                
                win += lp.getAmount() * betValues.get(betValuesIndex);
            }
    }
    //na server
    void saveSpinLinePayouts(List<SpinLinePayout> spinLinePayouts) {
        System.out.println("SAVE SPIN LINE PAYOUTS SIZE: " + spinLinePayouts.size());
        System.out.println("WIN: " + win);
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
    //iz ove metode se poziva VideoSlotLogic
    public void spin() {

        //videoSlotLogic.spin();
        //TODO: LOGIKA CELE IGRE
        //postaviti na disabled spin, plus i minus btn dok se ne zavrsi spin, pa onda vratiti
        disableButtons();
        //1.RESENO: provera da li ima dovoljno sredstava tj. bet > balance ? ako nema -> poruka i return;
        //2.RESENO: update user - skinuti mu bet sa balansa
        if (!reduceUserBalance()) {
            enableButtons();
            return;
        }
        //3.RESENO: popuniti matricu random vrednostima i postaviti slike, mozda initializePanel() pozvati vise puta
        //u okviru neke metode koja ce da ulepsa spin
        initializePanel();
        //4.mozda prvo sacuvati u bazi spin koji ima podesen bet iznos, mozda trenutno vreme
        //ili sacuvati SPIN zajedno sa svim SPosition objektima???

        //5.RESENO: napraviti sPosition(id, symbol, position) objekat za svako polje u matrici i sacuvati ih sve u bazi
        if (!saveSPositions()) {
            message("An error occurred!");
            return;
        }

        //6.prolaz kroz matricu kako bi se proverile vrednosti na 5 linija koje se gledaju
        //ako postoje dobitne linije, izvlaci se iz baze LinePayout za svaku (preko WHERE arrayLength = ? AND symbolId = ?)
        //i na osnovu toga se cuva SpinLinePayout za svaku dobitnu liniju
        //postavljanje css klasa za obojeni border na svako polje u dobitnoj liniji
        checkLines();

        //7.racuna se win
        //prolaz kroz SpinLinePayout listu, sabiranje dobitaka i cuvanje u bazi objekta Win
        //postavljanje win labele na taj iznos
        
        setWinLabel();
        win = 0;
        //8.ponovo update usera sa dodavanjem win-a na balance
        //ako je win > 0
        //8.1. pitanje da li zeli da pogadja boju? da -> otvara novu formu, ne -> radi update usera
        //increaseUserBalance();
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
        if (operation.equals("getLinePayouts")) {
            transferObject = serverController.getLinePayouts(transferObject);
        }
        if (operation.equals("saveSPositions")) {
            transferObject = serverController.saveSPositions(transferObject);
        }
        if (operation.equals("updateUser")) {
            transferObject = serverController.updateUser(transferObject);
        }
    }

}
