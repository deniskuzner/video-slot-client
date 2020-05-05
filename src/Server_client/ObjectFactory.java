
package Server_client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Server_client package. 
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

    private final static QName _GetSymbols_QNAME = new QName("http://Server/", "getSymbols");
    private final static QName _GetPositionsResponse_QNAME = new QName("http://Server/", "getPositionsResponse");
    private final static QName _SaveSPositions_QNAME = new QName("http://Server/", "saveSPositions");
    private final static QName _GetSymbolsResponse_QNAME = new QName("http://Server/", "getSymbolsResponse");
    private final static QName _SaveSPositionsResponse_QNAME = new QName("http://Server/", "saveSPositionsResponse");
    private final static QName _GetPositions_QNAME = new QName("http://Server/", "getPositions");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Server_client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSymbolsResponse }
     * 
     */
    public GetSymbolsResponse createGetSymbolsResponse() {
        return new GetSymbolsResponse();
    }

    /**
     * Create an instance of {@link SaveSPositionsResponse }
     * 
     */
    public SaveSPositionsResponse createSaveSPositionsResponse() {
        return new SaveSPositionsResponse();
    }

    /**
     * Create an instance of {@link SaveSPositions }
     * 
     */
    public SaveSPositions createSaveSPositions() {
        return new SaveSPositions();
    }

    /**
     * Create an instance of {@link GetPositionsResponse }
     * 
     */
    public GetPositionsResponse createGetPositionsResponse() {
        return new GetPositionsResponse();
    }

    /**
     * Create an instance of {@link GetSymbols }
     * 
     */
    public GetSymbols createGetSymbols() {
        return new GetSymbols();
    }

    /**
     * Create an instance of {@link GetPositions }
     * 
     */
    public GetPositions createGetPositions() {
        return new GetPositions();
    }

    /**
     * Create an instance of {@link Symbol }
     * 
     */
    public Symbol createSymbol() {
        return new Symbol();
    }

    /**
     * Create an instance of {@link SPosition }
     * 
     */
    public SPosition createSPosition() {
        return new SPosition();
    }

    /**
     * Create an instance of {@link Position }
     * 
     */
    public Position createPosition() {
        return new Position();
    }

    /**
     * Create an instance of {@link WebServerTransferObject }
     * 
     */
    public WebServerTransferObject createWebServerTransferObject() {
        return new WebServerTransferObject();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSymbols }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "getSymbols")
    public JAXBElement<GetSymbols> createGetSymbols(GetSymbols value) {
        return new JAXBElement<GetSymbols>(_GetSymbols_QNAME, GetSymbols.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPositionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "getPositionsResponse")
    public JAXBElement<GetPositionsResponse> createGetPositionsResponse(GetPositionsResponse value) {
        return new JAXBElement<GetPositionsResponse>(_GetPositionsResponse_QNAME, GetPositionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveSPositions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "saveSPositions")
    public JAXBElement<SaveSPositions> createSaveSPositions(SaveSPositions value) {
        return new JAXBElement<SaveSPositions>(_SaveSPositions_QNAME, SaveSPositions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSymbolsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "getSymbolsResponse")
    public JAXBElement<GetSymbolsResponse> createGetSymbolsResponse(GetSymbolsResponse value) {
        return new JAXBElement<GetSymbolsResponse>(_GetSymbolsResponse_QNAME, GetSymbolsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveSPositionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "saveSPositionsResponse")
    public JAXBElement<SaveSPositionsResponse> createSaveSPositionsResponse(SaveSPositionsResponse value) {
        return new JAXBElement<SaveSPositionsResponse>(_SaveSPositionsResponse_QNAME, SaveSPositionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPositions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "getPositions")
    public JAXBElement<GetPositions> createGetPositions(GetPositions value) {
        return new JAXBElement<GetPositions>(_GetPositions_QNAME, GetPositions.class, null, value);
    }

}
