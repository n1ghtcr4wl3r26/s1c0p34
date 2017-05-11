
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
 *         &lt;element name="Dni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NombreCompleto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Inicio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Cantidad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "dni",
    "nombreCompleto",
    "inicio",
    "cantidad",
    "total",
    "usuario",
    "pass"
})
@XmlRootElement(name = "GetAcreditados")
public class GetAcreditados {

    @XmlElementRef(name = "Dni", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> dni;
    @XmlElementRef(name = "NombreCompleto", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> nombreCompleto;
    @XmlElement(name = "Inicio")
    protected Integer inicio;
    @XmlElement(name = "Cantidad")
    protected Integer cantidad;
    @XmlElement(name = "Total")
    protected Integer total;
    @XmlElementRef(name = "Usuario", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> usuario;
    @XmlElementRef(name = "Pass", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<String> pass;

    /**
     * Gets the value of the dni property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDni() {
        return dni;
    }

    /**
     * Sets the value of the dni property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDni(JAXBElement<String> value) {
        this.dni = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the nombreCompleto property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Sets the value of the nombreCompleto property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNombreCompleto(JAXBElement<String> value) {
        this.nombreCompleto = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the inicio property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInicio() {
        return inicio;
    }

    /**
     * Sets the value of the inicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInicio(Integer value) {
        this.inicio = value;
    }

    /**
     * Gets the value of the cantidad property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidad(Integer value) {
        this.cantidad = value;
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

    /**
     * Gets the value of the usuario property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUsuario(JAXBElement<String> value) {
        this.usuario = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the pass property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPass() {
        return pass;
    }

    /**
     * Sets the value of the pass property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPass(JAXBElement<String> value) {
        this.pass = ((JAXBElement<String> ) value);
    }

}
