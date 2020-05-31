/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIVideoSlot;

import Domain.User;
import GUIVideoSlot.Listeners.InfoListener;
import GUIVideoSlot.Listeners.MinusListener;
import GUIVideoSlot.Listeners.PlusListener;
import GUIVideoSlot.Listeners.SpinListener;
import Server_client.Game;
import Server_client.SPosition;
import Server_client.ServerController;
import Server_client.ServerController_Service;
import Server_client.Spin;
import Server_client.Symbol;
import Server_client.WebServerTransferObject;
import Session.Session;
import Threads.WinLinesStyleThread;
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
import javafx.stage.Stage;

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
    List<SPosition> sPositions;
    Game game;
    User sessionUser;
    WinLinesStyleThread winLinesStyleThread;

    public GUIVideoSlotController(FXMLDocumentController fxmlDocumentController) {
        this.fxmlDocumentController = fxmlDocumentController;
        this.fxmlDocumentController.btnInfo.setOnAction(new InfoListener(this));
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
        sessionUser = Session.getInstance().getUser();

        createGame();
        getSymbols();

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

    void populateForm() {
        setBalanceLabel();
        setBetLabel();
        setWinLabel();
        initializePanel();
    }

    void setBalanceLabel() {
        fxmlDocumentController.lblBalance.setText(sessionUser.getBalance() + " RSD");
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
        convertSPositionsToMat();
        setImages();
    }

    void randomizeMatValues() {
        transferObject.setGame(game);
        executeSO("randomizeMatValues");
        sPositions = transferObject.getSPositions();
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

    boolean hasBalance() {
        return sessionUser.getBalance() >= betValues.get(betValuesIndex);
    }

    void updatePanel() {
        this.sPositions = transferObject.getSPositions();
        convertSPositionsToMat();
        setImages();

        this.win = transferObject.getWin().getAmount();
        setWinLabel();

        sessionUser.setBalance(transferObject.getUser().getBalance());
        setBalanceLabel();

        winLinesStyleThread = new WinLinesStyleThread(this, transferObject.getSpinLinePayouts(), transferObject.getLinePayouts());
        winLinesStyleThread.start();
    }

    public void clearPanel() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                try {
                    String buttonName = "p" + x + y;
                    Class cls = this.fxmlDocumentController.getClass();
                    Field field = cls.getDeclaredField(buttonName);
                    Button b = (Button) field.get(this.fxmlDocumentController);
                    b.getStyleClass().removeAll("line-one", "line-two", "line-three", "line-four", "line-five");
                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(GUIVideoSlotController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void setButtonStyleClass(int x, int y, String styleClass) {
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
    
    public void info() {
        try {
            GUIVideoSlotInfo.SSFX1 ssfx1 = new GUIVideoSlotInfo.SSFX1();
            ssfx1.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(GUIVideoSlotController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void spin() {
        disableButtons();
        if (winLinesStyleThread != null) {
            winLinesStyleThread.interrupt();
        }
        clearPanel();
        if (!hasBalance()) {
            message("You don't have enough funds on your balance!");
            enableButtons();
            return;
        }

        Server_client.User serverUser = new Server_client.User();
        serverUser.setId(sessionUser.getId());
        serverUser.setBalance(sessionUser.getBalance());
        transferObject.setUser(serverUser);

        Spin spin = new Spin();
        spin.setGameId(game.getId());
        spin.setBet(betValues.get(betValuesIndex));
        transferObject.setSpinObject(spin);

        executeSO("executeSpin");
        if (!transferObject.isSignal()) {
            message("An error occured!");
            enableButtons();
            return;
        }
        updatePanel();

        enableButtons();
    }

    public void executeSO(String operation) {
        if (operation.equals("createGame")) {
            transferObject = serverController.createGame(transferObject);
        }
        if (operation.equals("executeSpin")) {
            transferObject = serverController.executeSpin(transferObject);
        }
        if (operation.equals("getSymbols")) {
            transferObject = serverController.getSymbols(transferObject);
        }
        if (operation.equals("randomizeMatValues")) {
            transferObject = serverController.randomizeMathValues(transferObject);
        }
    }

}
