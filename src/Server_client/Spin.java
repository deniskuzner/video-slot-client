
package Server_client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for spin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="spin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gameId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="spinLinePayouts" type="{http://Server/}spinLinePayout" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="win" type="{http://Server/}win" minOccurs="0"/>
 *         &lt;element name="sPositions" type="{http://Server/}sPosition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "spin", propOrder = {
    "bet",
    "gameId",
    "id",
    "spinLinePayouts",
    "win",
    "sPositions"
})
public class Spin {

    protected int bet;
    protected int gameId;
    protected int id;
    @XmlElement(nillable = true)
    protected List<SpinLinePayout> spinLinePayouts;
    protected Win win;
    @XmlElement(nillable = true)
    protected List<SPosition> sPositions;

    /**
     * Gets the value of the bet property.
     * 
     */
    public int getBet() {
        return bet;
    }

    /**
     * Sets the value of the bet property.
     * 
     */
    public void setBet(int value) {
        this.bet = value;
    }

    /**
     * Gets the value of the gameId property.
     * 
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * Sets the value of the gameId property.
     * 
     */
    public void setGameId(int value) {
        this.gameId = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
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

}
