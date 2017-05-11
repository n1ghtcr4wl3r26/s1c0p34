
package bo.gob.rree.ent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfEntidadInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfEntidadInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntidadInfo" type="{http://schemas.datacontract.org/2004/07/}EntidadInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfEntidadInfo", namespace = "http://schemas.datacontract.org/2004/07/", propOrder = {
    "entidadInfo"
})
public class ArrayOfEntidadInfo {

    @XmlElement(name = "EntidadInfo", nillable = true)
    protected List<EntidadInfo> entidadInfo;

    /**
     * Gets the value of the entidadInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entidadInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntidadInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntidadInfo }
     * 
     * 
     */
    public List<EntidadInfo> getEntidadInfo() {
        if (entidadInfo == null) {
            entidadInfo = new ArrayList<EntidadInfo>();
        }
        return this.entidadInfo;
    }

}
