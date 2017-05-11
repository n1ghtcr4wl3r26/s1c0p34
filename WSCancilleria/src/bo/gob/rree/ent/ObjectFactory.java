
package bo.gob.rree.ent;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bo.gob.rree.ent package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _EntidadInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "EntidadInfo");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _PersonaInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "PersonaInfo");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _ArrayOfEntidadInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "ArrayOfEntidadInfo");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _ArrayOfPersonaInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "ArrayOfPersonaInfo");
    private final static QName _GetDirectorioResponseGetDirectorioResult_QNAME = new QName("http://tempuri.org/", "GetDirectorioResult");
    private final static QName _GetAcreditadosResponseGetAcreditadosResult_QNAME = new QName("http://tempuri.org/", "GetAcreditadosResult");
    private final static QName _GetDirectorioUsuario_QNAME = new QName("http://tempuri.org/", "Usuario");
    private final static QName _GetDirectorioPass_QNAME = new QName("http://tempuri.org/", "Pass");
    private final static QName _GetDirectorioNombre_QNAME = new QName("http://tempuri.org/", "Nombre");
    private final static QName _EntidadInfoCONTACTO_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "CONTACTO");
    private final static QName _GetAcreditadosNombreCompleto_QNAME = new QName("http://tempuri.org/", "NombreCompleto");
    private final static QName _GetAcreditadosDni_QNAME = new QName("http://tempuri.org/", "Dni");
    private final static QName _PersonaInfoNroIdentificacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "NroIdentificacion");
    private final static QName _PersonaInfoMaterno_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "Materno");
    private final static QName _PersonaInfoCiteSolAcreditacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "citeSolAcreditacion");
    private final static QName _PersonaInfoPaterno_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "Paterno");
    private final static QName _PersonaInfoNombres_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "nombres");
    private final static QName _PersonaInfoNombreCompleto_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "NombreCompleto");
    private final static QName _PersonaInfoCargoPersona_QNAME = new QName("http://schemas.datacontract.org/2004/07/", "CargoPersona");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bo.gob.rree.ent
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAcreditados }
     * 
     */
    public GetAcreditados createGetAcreditados() {
        return new GetAcreditados();
    }

    /**
     * Create an instance of {@link GetDirectorio }
     * 
     */
    public GetDirectorio createGetDirectorio() {
        return new GetDirectorio();
    }

    /**
     * Create an instance of {@link GetDirectorioResponse }
     * 
     */
    public GetDirectorioResponse createGetDirectorioResponse() {
        return new GetDirectorioResponse();
    }

    /**
     * Create an instance of {@link ArrayOfEntidadInfo }
     * 
     */
    public ArrayOfEntidadInfo createArrayOfEntidadInfo() {
        return new ArrayOfEntidadInfo();
    }

    /**
     * Create an instance of {@link GetAcreditadosResponse }
     * 
     */
    public GetAcreditadosResponse createGetAcreditadosResponse() {
        return new GetAcreditadosResponse();
    }

    /**
     * Create an instance of {@link ArrayOfPersonaInfo }
     * 
     */
    public ArrayOfPersonaInfo createArrayOfPersonaInfo() {
        return new ArrayOfPersonaInfo();
    }

    /**
     * Create an instance of {@link PersonaInfo }
     * 
     */
    public PersonaInfo createPersonaInfo() {
        return new PersonaInfo();
    }

    /**
     * Create an instance of {@link EntidadInfo }
     * 
     */
    public EntidadInfo createEntidadInfo() {
        return new EntidadInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntidadInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "EntidadInfo")
    public JAXBElement<EntidadInfo> createEntidadInfo(EntidadInfo value) {
        return new JAXBElement<EntidadInfo>(_EntidadInfo_QNAME, EntidadInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonaInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "PersonaInfo")
    public JAXBElement<PersonaInfo> createPersonaInfo(PersonaInfo value) {
        return new JAXBElement<PersonaInfo>(_PersonaInfo_QNAME, PersonaInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfEntidadInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "ArrayOfEntidadInfo")
    public JAXBElement<ArrayOfEntidadInfo> createArrayOfEntidadInfo(ArrayOfEntidadInfo value) {
        return new JAXBElement<ArrayOfEntidadInfo>(_ArrayOfEntidadInfo_QNAME, ArrayOfEntidadInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPersonaInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "ArrayOfPersonaInfo")
    public JAXBElement<ArrayOfPersonaInfo> createArrayOfPersonaInfo(ArrayOfPersonaInfo value) {
        return new JAXBElement<ArrayOfPersonaInfo>(_ArrayOfPersonaInfo_QNAME, ArrayOfPersonaInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfEntidadInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetDirectorioResult", scope = GetDirectorioResponse.class)
    public JAXBElement<ArrayOfEntidadInfo> createGetDirectorioResponseGetDirectorioResult(ArrayOfEntidadInfo value) {
        return new JAXBElement<ArrayOfEntidadInfo>(_GetDirectorioResponseGetDirectorioResult_QNAME, ArrayOfEntidadInfo.class, GetDirectorioResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPersonaInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAcreditadosResult", scope = GetAcreditadosResponse.class)
    public JAXBElement<ArrayOfPersonaInfo> createGetAcreditadosResponseGetAcreditadosResult(ArrayOfPersonaInfo value) {
        return new JAXBElement<ArrayOfPersonaInfo>(_GetAcreditadosResponseGetAcreditadosResult_QNAME, ArrayOfPersonaInfo.class, GetAcreditadosResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Usuario", scope = GetDirectorio.class)
    public JAXBElement<String> createGetDirectorioUsuario(String value) {
        return new JAXBElement<String>(_GetDirectorioUsuario_QNAME, String.class, GetDirectorio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Pass", scope = GetDirectorio.class)
    public JAXBElement<String> createGetDirectorioPass(String value) {
        return new JAXBElement<String>(_GetDirectorioPass_QNAME, String.class, GetDirectorio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Nombre", scope = GetDirectorio.class)
    public JAXBElement<String> createGetDirectorioNombre(String value) {
        return new JAXBElement<String>(_GetDirectorioNombre_QNAME, String.class, GetDirectorio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "CONTACTO", scope = EntidadInfo.class)
    public JAXBElement<String> createEntidadInfoCONTACTO(String value) {
        return new JAXBElement<String>(_EntidadInfoCONTACTO_QNAME, String.class, EntidadInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "NombreCompleto", scope = GetAcreditados.class)
    public JAXBElement<String> createGetAcreditadosNombreCompleto(String value) {
        return new JAXBElement<String>(_GetAcreditadosNombreCompleto_QNAME, String.class, GetAcreditados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Usuario", scope = GetAcreditados.class)
    public JAXBElement<String> createGetAcreditadosUsuario(String value) {
        return new JAXBElement<String>(_GetDirectorioUsuario_QNAME, String.class, GetAcreditados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Pass", scope = GetAcreditados.class)
    public JAXBElement<String> createGetAcreditadosPass(String value) {
        return new JAXBElement<String>(_GetDirectorioPass_QNAME, String.class, GetAcreditados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Dni", scope = GetAcreditados.class)
    public JAXBElement<String> createGetAcreditadosDni(String value) {
        return new JAXBElement<String>(_GetAcreditadosDni_QNAME, String.class, GetAcreditados.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "NroIdentificacion", scope = PersonaInfo.class)
    public JAXBElement<String> createPersonaInfoNroIdentificacion(String value) {
        return new JAXBElement<String>(_PersonaInfoNroIdentificacion_QNAME, String.class, PersonaInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "Materno", scope = PersonaInfo.class)
    public JAXBElement<String> createPersonaInfoMaterno(String value) {
        return new JAXBElement<String>(_PersonaInfoMaterno_QNAME, String.class, PersonaInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "citeSolAcreditacion", scope = PersonaInfo.class)
    public JAXBElement<String> createPersonaInfoCiteSolAcreditacion(String value) {
        return new JAXBElement<String>(_PersonaInfoCiteSolAcreditacion_QNAME, String.class, PersonaInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "Paterno", scope = PersonaInfo.class)
    public JAXBElement<String> createPersonaInfoPaterno(String value) {
        return new JAXBElement<String>(_PersonaInfoPaterno_QNAME, String.class, PersonaInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "nombres", scope = PersonaInfo.class)
    public JAXBElement<String> createPersonaInfoNombres(String value) {
        return new JAXBElement<String>(_PersonaInfoNombres_QNAME, String.class, PersonaInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "NombreCompleto", scope = PersonaInfo.class)
    public JAXBElement<String> createPersonaInfoNombreCompleto(String value) {
        return new JAXBElement<String>(_PersonaInfoNombreCompleto_QNAME, String.class, PersonaInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/", name = "CargoPersona", scope = PersonaInfo.class)
    public JAXBElement<String> createPersonaInfoCargoPersona(String value) {
        return new JAXBElement<String>(_PersonaInfoCargoPersona_QNAME, String.class, PersonaInfo.class, value);
    }

}
