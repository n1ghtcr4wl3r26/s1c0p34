
package bo.gob.rree.ent;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PersonaInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonaInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CargoPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodEntidad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FechaAcreditacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Materno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NombreCompleto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NroIdentificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Paterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="citeSolAcreditacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codAcreditacion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codcategoria" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codpersona" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fechaAmpliacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaCiteSol" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaLlegadaAlPais" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechacese" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaInfo", namespace = "http://schemas.datacontract.org/2004/07/", propOrder = {
    "cargoPersona",
    "codEntidad",
    "fechaAcreditacion",
    "materno",
    "nombreCompleto",
    "nroIdentificacion",
    "paterno",
    "citeSolAcreditacion",
    "codAcreditacion",
    "codcategoria",
    "codpersona",
    "fechaAmpliacion",
    "fechaCiteSol",
    "fechaLlegadaAlPais",
    "fechacese",
    "nombres"
})
public class PersonaInfo {

    @XmlElementRef(name = "CargoPersona", namespace = "http://schemas.datacontract.org/2004/07/", type = JAXBElement.class)
    protected JAXBElement<String> cargoPersona;
    @XmlElement(name = "CodEntidad")
    protected Integer codEntidad;
    @XmlElement(name = "FechaAcreditacion")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAcreditacion;
    @XmlElementRef(name = "Materno", namespace = "http://schemas.datacontract.org/2004/07/", type = JAXBElement.class)
    protected JAXBElement<String> materno;
    @XmlElementRef(name = "NombreCompleto", namespace = "http://schemas.datacontract.org/2004/07/", type = JAXBElement.class)
    protected JAXBElement<String> nombreCompleto;
    @XmlElementRef(name = "NroIdentificacion", namespace = "http://schemas.datacontract.org/2004/07/", type = JAXBElement.class)
    protected JAXBElement<String> nroIdentificacion;
    @XmlElementRef(name = "Paterno", namespace = "http://schemas.datacontract.org/2004/07/", type = JAXBElement.class)
    protected JAXBElement<String> paterno;
    @XmlElementRef(name = "citeSolAcreditacion", namespace = "http://schemas.datacontract.org/2004/07/", type = JAXBElement.class)
    protected JAXBElement<String> citeSolAcreditacion;
    protected Integer codAcreditacion;
    protected Integer codcategoria;
    protected Integer codpersona;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaAmpliacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaCiteSol;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaLlegadaAlPais;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechacese;
    @XmlElementRef(name = "nombres", namespace = "http://schemas.datacontract.org/2004/07/", type = JAXBElement.class)
    protected JAXBElement<String> nombres;

    /**
     * Gets the value of the cargoPersona property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCargoPersona() {
        return cargoPersona;
    }

    /**
     * Sets the value of the cargoPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCargoPersona(JAXBElement<String> value) {
        this.cargoPersona = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the codEntidad property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodEntidad() {
        return codEntidad;
    }

    /**
     * Sets the value of the codEntidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodEntidad(Integer value) {
        this.codEntidad = value;
    }

    /**
     * Gets the value of the fechaAcreditacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAcreditacion() {
        return fechaAcreditacion;
    }

    /**
     * Sets the value of the fechaAcreditacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAcreditacion(XMLGregorianCalendar value) {
        this.fechaAcreditacion = value;
    }

    /**
     * Gets the value of the materno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMaterno() {
        return materno;
    }

    /**
     * Sets the value of the materno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMaterno(JAXBElement<String> value) {
        this.materno = ((JAXBElement<String> ) value);
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
     * Gets the value of the nroIdentificacion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNroIdentificacion() {
        return nroIdentificacion;
    }

    /**
     * Sets the value of the nroIdentificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNroIdentificacion(JAXBElement<String> value) {
        this.nroIdentificacion = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paterno property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaterno() {
        return paterno;
    }

    /**
     * Sets the value of the paterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaterno(JAXBElement<String> value) {
        this.paterno = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the citeSolAcreditacion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCiteSolAcreditacion() {
        return citeSolAcreditacion;
    }

    /**
     * Sets the value of the citeSolAcreditacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCiteSolAcreditacion(JAXBElement<String> value) {
        this.citeSolAcreditacion = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the codAcreditacion property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodAcreditacion() {
        return codAcreditacion;
    }

    /**
     * Sets the value of the codAcreditacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodAcreditacion(Integer value) {
        this.codAcreditacion = value;
    }

    /**
     * Gets the value of the codcategoria property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodcategoria() {
        return codcategoria;
    }

    /**
     * Sets the value of the codcategoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodcategoria(Integer value) {
        this.codcategoria = value;
    }

    /**
     * Gets the value of the codpersona property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodpersona() {
        return codpersona;
    }

    /**
     * Sets the value of the codpersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodpersona(Integer value) {
        this.codpersona = value;
    }

    /**
     * Gets the value of the fechaAmpliacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAmpliacion() {
        return fechaAmpliacion;
    }

    /**
     * Sets the value of the fechaAmpliacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAmpliacion(XMLGregorianCalendar value) {
        this.fechaAmpliacion = value;
    }

    /**
     * Gets the value of the fechaCiteSol property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaCiteSol() {
        return fechaCiteSol;
    }

    /**
     * Sets the value of the fechaCiteSol property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaCiteSol(XMLGregorianCalendar value) {
        this.fechaCiteSol = value;
    }

    /**
     * Gets the value of the fechaLlegadaAlPais property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaLlegadaAlPais() {
        return fechaLlegadaAlPais;
    }

    /**
     * Sets the value of the fechaLlegadaAlPais property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaLlegadaAlPais(XMLGregorianCalendar value) {
        this.fechaLlegadaAlPais = value;
    }

    /**
     * Gets the value of the fechacese property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechacese() {
        return fechacese;
    }

    /**
     * Sets the value of the fechacese property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechacese(XMLGregorianCalendar value) {
        this.fechacese = value;
    }

    /**
     * Gets the value of the nombres property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNombres() {
        return nombres;
    }

    /**
     * Sets the value of the nombres property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNombres(JAXBElement<String> value) {
        this.nombres = ((JAXBElement<String> ) value);
    }

}
