
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for spinLinePayout complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="spinLinePayout">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gameId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="linePayoutId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="spinId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "spinLinePayout", propOrder = {
    "gameId",
    "linePayoutId",
    "spinId"
})
public class SpinLinePayout {

    protected int gameId;
    protected int linePayoutId;
    protected int spinId;

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
     * Gets the value of the linePayoutId property.
     * 
     */
    public int getLinePayoutId() {
        return linePayoutId;
    }

    /**
     * Sets the value of the linePayoutId property.
     * 
     */
    public void setLinePayoutId(int value) {
        this.linePayoutId = value;
    }

    /**
     * Gets the value of the spinId property.
     * 
     */
    public int getSpinId() {
        return spinId;
    }

    /**
     * Sets the value of the spinId property.
     * 
     */
    public void setSpinId(int value) {
        this.spinId = value;
    }

}
