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
import Server_client.Game;
import Server_client.LinePayout;
import Server_client.Position;
import Server_client.SPosition;
import Server_client.ServerController;
import Server_client.ServerController_Service;
import Server_client.Spin;
import Server_client.Symbol;
import Server_client.WebServerTransferObject;
import Session.Session;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    List<SPosition> sPositions;
    List<LinePayout> linePayouts;
    Game game;
    int spinId;

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
        sPositions = new ArrayList<>();
        
        
        createGame();
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
    
    void createGame() {
        game = new Game();
        game.setUserId(Session.getInstance().getUser().getId());
        transferObject.setGame(game);
        executeSO("createGame");
        game = transferObject.getGame();
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
        win = 0;
    }

    void initializePanel() {
        randomizeMatValues();
        setImages();
    }
    
    void randomizeMatValues(){
        transferObject.getSymbols().clear();
        transferObject.getSymbols().addAll(symbols);
        transferObject.getPositions().clear();
        transferObject.getPositions().addAll(positions);
        transferObject.setGame(game);
        executeSO("randomizeMatValues");
        sPositions = transferObject.getSPositions();
        convertSPositionsToMat();
    }
    
    void convertSPositionsToMat() {
        for (SPosition sPosition : sPositions) {
            mat[sPosition.getPosition().getX()][sPosition.getPosition().getY()] = sPosition.getSymbol().getId();
        }
    }
   
    void setImages() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                setImage(getImage(getSymbolNameById(mat[x][y])), x, y);
            }
        }
    }
    
    String getSymbolNameById(int id) {
        return symbols.stream().filter(s -> s.getId() == id).findFirst().get().getName();
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

    boolean createSpin() {
        Spin spin = new Spin();
        spin.setGameId(game.getId());
        spin.setBet(betValues.get(betValuesIndex));
        spin.getSPositions().addAll(sPositions);
        transferObject.setSpin(spin);
        executeSO("createSpin");
        spinId = transferObject.getSpin().getId();
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

        transferObject.setUser(serverUser);
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
    
    boolean createSpinLinePayouts() {
        transferObject.getSPositions().clear();
        transferObject.getSPositions().addAll(sPositions);
        transferObject.getLinePayouts().clear();
        transferObject.getLinePayouts().addAll(linePayouts);
        
        executeSO("createSpinLinePayouts");
        win = transferObject.getWin();
        return transferObject.isSignal();
    }
    
    boolean increaseUserBalance() {
        //izvojiti sessionUser kao atribut klase
        User sessionUser = Session.getInstance().getUser();
        int newBalance = sessionUser.getBalance() + win;

        Server_client.User serverUser = new Server_client.User();
        serverUser.setId(sessionUser.getId());
        serverUser.setBalance(newBalance);

        transferObject.setUser(serverUser);
        executeSO("updateUser");
        if (transferObject.isSignal()) {
            sessionUser.setBalance(newBalance);
            setBalanceLabel();
        } else {
            message(transferObject.getMessage());
        }
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
    //iz ove metode se poziva VideoSlotLogic
    public void spin() {

        //videoSlotLogic.spin();
        //TODO: LOGIKA CELE IGRE
        //postaviti na disabled spin, plus i minus btn dok se ne zavrsi spin, pa onda vratiti
        disableButtons();
        //1.RESENO: provera da li ima dovoljno sredstava tj. bet > balance ? ako nema -> poruka i return;
        //2.RESENO: update user - skinuti mu bet sa balansa
        if (!reduceUserBalance()) {
            return;
        }
        //3.RESENO: popuniti matricu random vrednostima i postaviti slike, mozda initializePanel() pozvati vise puta
        //u okviru neke metode koja ce da ulepsa spin
        initializePanel();
        //4.RESENO: sacuvati SPIN zajedno sa svim SPosition objektima
        if(!createSpin()) {
            message("An error occurred!");
            return;
        }
        
        //6.RESENO: prolaz kroz matricu kako bi se proverile vrednosti na 5 linija koje se gledaju
        //ako postoje dobitne linije, izvlaci se iz baze LinePayout za svaku (preko WHERE arrayLength = ? AND symbolId = ?)
        //i na osnovu toga se cuva SpinLinePayout za svaku dobitnu liniju
        //postavljanje css klasa za obojeni border na svako polje u dobitnoj liniji
//        checkLines();
        if(!createSpinLinePayouts()){
            message("An error occurred!");
            return;
        }

        //7.RESENO: racuna se win
        //prolaz kroz SpinLinePayout listu, sabiranje dobitaka i cuvanje u bazi objekta Win
        //postavljanje win labele na taj iznos
        
        
        //8.ponovo update usera sa dodavanjem win-a na balance
        //ako je win > 0
        //8.1. pitanje da li zeli da pogadja boju? da -> otvara novu formu, ne -> radi update usera
        increaseUserBalance();
        setWinLabel();
        //na kraju
        enableButtons();

    }

    public void executeSO(String operation) {
        if (operation.equals("createGame")) {
            transferObject = serverController.createGame(transferObject);
        }
        if (operation.equals("getSymbols")) {
            transferObject = serverController.getSymbols(transferObject);
        }
        if (operation.equals("getPositions")) {
            transferObject = serverController.getPositions(transferObject);
        }
        if (operation.equals("getLinePayouts")) {
            transferObject = serverController.getLinePayouts(transferObject);
        }
        if (operation.equals("randomizeMatValues")) {
            transferObject = serverController.randomizeMathValues(transferObject);
        }
        if (operation.equals("updateUser")) {
            transferObject = serverController.updateUser(transferObject);
        }
        if (operation.equals("createSpin")) {
            transferObject = serverController.createSpin(transferObject);
        }
        if (operation.equals("createSpinLinePayouts")) {
            transferObject = serverController.createSpinLinePayouts(transferObject);
        }
    }

}
