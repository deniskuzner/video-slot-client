
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sPosition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sPosition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="positionId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="spinId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="symbolId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sPosition", propOrder = {
    "id",
    "positionId",
    "spinId",
    "symbolId"
})
public class SPosition {

    protected int id;
    protected int positionId;
    protected int spinId;
    protected int symbolId;

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
     * Gets the value of the positionId property.
     * 
     */
    public int getPositionId() {
        return positionId;
    }

    /**
     * Sets the value of the positionId property.
     * 
     */
    public void setPositionId(int value) {
        this.positionId = value;
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

    /**
     * Gets the value of the symbolId property.
     * 
     */
    public int getSymbolId() {
        return symbolId;
    }

    /**
     * Sets the value of the symbolId property.
     * 
     */
    public void setSymbolId(int value) {
        this.symbolId = value;
    }

}
