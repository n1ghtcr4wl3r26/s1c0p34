
package bo.gob.rree.ent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetDirectorioResult" type="{http://schemas.datacontract.org/2004/07/}ArrayOfEntidadInfo" minOccurs="0"/>
 *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getDirectorioResult",
    "total"
})
@XmlRootElement(name = "GetDirectorioResponse")
public class GetDirectorioResponse {

    @XmlElementRef(name = "GetDirectorioResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<ArrayOfEntidadInfo> getDirectorioResult;
    @XmlElement(name = "Total")
    protected Integer total;

    /**
     * Gets the value of the getDirectorioResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfEntidadInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfEntidadInfo> getGetDirectorioResult() {
        return getDirectorioResult;
    }

    /**
     * Sets the value of the getDirectorioResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfEntidadInfo }{@code >}
     *     
     */
    public void setGetDirectorioResult(JAXBElement<ArrayOfEntidadInfo> value) {
        this.getDirectorioResult = ((JAXBElement<ArrayOfEntidadInfo> ) value);
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotal(Integer value) {
        this.total = value;
    }

}
