
package bo.gob.rree.ent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntidadInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EntidadInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Activo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="CODCONTACTO" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CONTACTO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntidadInfo", namespace = "http://schemas.datacontract.org/2004/07/", propOrder = {
    "activo",
    "codcontacto",
    "contacto"
})
public class EntidadInfo {

    @XmlElement(name = "Activo")
    protected Boolean activo;
    @XmlElement(name = "CODCONTACTO")
    protected Integer codcontacto;
    @XmlElementRef(name = "CONTACTO", namespace = "http://schemas.datacontract.org/2004/07/", type = JAXBElement.class)
    protected JAXBElement<String> contacto;

    /**
     * Gets the value of the activo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActivo() {
        return activo;
    }

    /**
     * Sets the value of the activo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActivo(Boolean value) {
        this.activo = value;
    }

    /**
     * Gets the value of the codcontacto property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCODCONTACTO() {
        return codcontacto;
    }

    /**
     * Sets the value of the codcontacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCODCONTACTO(Integer value) {
        this.codcontacto = value;
    }

    /**
     * Gets the value of the contacto property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCONTACTO() {
        return contacto;
    }

    /**
     * Sets the value of the contacto property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCONTACTO(JAXBElement<String> value) {
        this.contacto = ((JAXBElement<String> ) value);
    }

}
