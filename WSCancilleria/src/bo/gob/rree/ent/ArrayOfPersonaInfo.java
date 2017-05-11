
package bo.gob.rree.ent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPersonaInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPersonaInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonaInfo" type="{http://schemas.datacontract.org/2004/07/}PersonaInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPersonaInfo", namespace = "http://schemas.datacontract.org/2004/07/", propOrder = {
    "personaInfo"
})
public class ArrayOfPersonaInfo {

    @XmlElement(name = "PersonaInfo", nillable = true)
    protected List<PersonaInfo> personaInfo;

    /**
     * Gets the value of the personaInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personaInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonaInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonaInfo }
     * 
     * 
     */
    public List<PersonaInfo> getPersonaInfo() {
        if (personaInfo == null) {
            personaInfo = new ArrayList<PersonaInfo>();
        }
        return this.personaInfo;
    }

}
