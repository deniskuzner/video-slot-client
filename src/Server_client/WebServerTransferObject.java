
package Server_client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for webServerTransferObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="webServerTransferObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://Server/}user" minOccurs="0"/>
 *         &lt;element name="symbols" type="{http://Server/}symbol" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="positions" type="{http://Server/}position" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="linePayouts" type="{http://Server/}linePayout" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sPositions" type="{http://Server/}sPosition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="spinLinePayouts" type="{http://Server/}spinLinePayout" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="spin" type="{http://Server/}spin" minOccurs="0"/>
 *         &lt;element name="game" type="{http://Server/}game" minOccurs="0"/>
 *         &lt;element name="win" type="{http://Server/}win" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="gameObject" type="{http://Server/}game" minOccurs="0"/>
 *         &lt;element name="positionsList" type="{http://Server/}position" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="spinObject" type="{http://Server/}spin" minOccurs="0"/>
 *         &lt;element name="symbolsList" type="{http://Server/}symbol" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userObject" type="{http://Server/}user" minOccurs="0"/>
 *         &lt;element name="winObject" type="{http://Server/}win" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "webServerTransferObject", propOrder = {
    "user",
    "symbols",
    "positions",
    "linePayouts",
    "sPositions",
    "spinLinePayouts",
    "spin",
    "game",
    "win",
    "message",
    "signal",
    "gameObject",
    "positionsList",
    "spinObject",
    "symbolsList",
    "userObject",
    "winObject"
})
public class WebServerTransferObject {

    protected User user;
    @XmlElement(nillable = true)
    protected List<Symbol> symbols;
    @XmlElement(nillable = true)
    protected List<Position> positions;
    @XmlElement(nillable = true)
    protected List<LinePayout> linePayouts;
    @XmlElement(nillable = true)
    protected List<SPosition> sPositions;
    @XmlElement(nillable = true)
    protected List<SpinLinePayout> spinLinePayouts;
    protected Spin spin;
    protected Game game;
    protected Win win;
    protected String message;
    protected boolean signal;
    protected Game gameObject;
    @XmlElement(nillable = true)
    protected List<Position> positionsList;
    protected Spin spinObject;
    @XmlElement(nillable = true)
    protected List<Symbol> symbolsList;
    protected User userObject;
    protected Win winObject;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the symbols property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the symbols property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSymbols().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Symbol }
     * 
     * 
     */
    public List<Symbol> getSymbols() {
        if (symbols == null) {
            symbols = new ArrayList<Symbol>();
        }
        return this.symbols;
    }

    /**
     * Gets the value of the positions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the positions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPositions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Position }
     * 
     * 
     */
    public List<Position> getPositions() {
        if (positions == null) {
            positions = new ArrayList<Position>();
        }
        return this.positions;
    }

    /**
     * Gets the value of the linePayouts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linePayouts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinePayouts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinePayout }
     * 
     * 
     */
    public List<LinePayout> getLinePayouts() {
        if (linePayouts == null) {
            linePayouts = new ArrayList<LinePayout>();
        }
        return this.linePayouts;
    }

    /**
     * Gets the value of the sPositions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sPositions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSPositions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SPosition }
     * 
     * 
     */
    public List<SPosition> getSPositions() {
        if (sPositions == null) {
            sPositions = new ArrayList<SPosition>();
        }
        return this.sPositions;
    }

    /**
     * Gets the value of the spinLinePayouts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spinLinePayouts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpinLinePayouts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SpinLinePayout }
     * 
     * 
     */
    public List<SpinLinePayout> getSpinLinePayouts() {
        if (spinLinePayouts == null) {
            spinLinePayouts = new ArrayList<SpinLinePayout>();
        }
        return this.spinLinePayouts;
    }

    /**
     * Gets the value of the spin property.
     * 
     * @return
     *     possible object is
     *     {@link Spin }
     *     
     */
    public Spin getSpin() {
        return spin;
    }

    /**
     * Sets the value of the spin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Spin }
     *     
     */
    public void setSpin(Spin value) {
        this.spin = value;
    }

    /**
     * Gets the value of the game property.
     * 
     * @return
     *     possible object is
     *     {@link Game }
     *     
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets the value of the game property.
     * 
     * @param value
     *     allowed object is
     *     {@link Game }
     *     
     */
    public void setGame(Game value) {
        this.game = value;
    }

    /**
     * Gets the value of the win property.
     * 
     * @return
     *     possible object is
     *     {@link Win }
     *     
     */
    public Win getWin() {
        return win;
    }

    /**
     * Sets the value of the win property.
     * 
     * @param value
     *     allowed object is
     *     {@link Win }
     *     
     */
    public void setWin(Win value) {
        this.win = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the signal property.
     * 
     */
    public boolean isSignal() {
        return signal;
    }

    /**
     * Sets the value of the signal property.
     * 
     */
    public void setSignal(boolean value) {
        this.signal = value;
    }

    /**
     * Gets the value of the gameObject property.
     * 
     * @return
     *     possible object is
     *     {@link Game }
     *     
     */
    public Game getGameObject() {
        return gameObject;
    }

    /**
     * Sets the value of the gameObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link Game }
     *     
     */
    public void setGameObject(Game value) {
        this.gameObject = value;
    }

    /**
     * Gets the value of the positionsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the positionsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPositionsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Position }
     * 
     * 
     */
    public List<Position> getPositionsList() {
        if (positionsList == null) {
            positionsList = new ArrayList<Position>();
        }
        return this.positionsList;
    }

    /**
     * Gets the value of the spinObject property.
     * 
     * @return
     *     possible object is
     *     {@link Spin }
     *     
     */
    public Spin getSpinObject() {
        return spinObject;
    }

    /**
     * Sets the value of the spinObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link Spin }
     *     
     */
    public void setSpinObject(Spin value) {
        this.spinObject = value;
    }

    /**
     * Gets the value of the symbolsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the symbolsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSymbolsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Symbol }
     * 
     * 
     */
    public List<Symbol> getSymbolsList() {
        if (symbolsList == null) {
            symbolsList = new ArrayList<Symbol>();
        }
        return this.symbolsList;
    }

    /**
     * Gets the value of the userObject property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUserObject() {
        return userObject;
    }

    /**
     * Sets the value of the userObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUserObject(User value) {
        this.userObject = value;
    }

    /**
     * Gets the value of the winObject property.
     * 
     * @return
     *     possible object is
     *     {@link Win }
     *     
     */
    public Win getWinObject() {
        return winObject;
    }

    /**
     * Sets the value of the winObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link Win }
     *     
     */
    public void setWinObject(Win value) {
        this.winObject = value;
    }

}
