
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

    private final static QName _SaveSPositions_QNAME = new QName("http://Server/", "saveSPositions");
    private final static QName _CreateSpinResponse_QNAME = new QName("http://Server/", "createSpinResponse");
    private final static QName _SaveSPositionsResponse_QNAME = new QName("http://Server/", "saveSPositionsResponse");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://Server/", "updateUserResponse");
    private final static QName _GetPositions_QNAME = new QName("http://Server/", "getPositions");
    private final static QName _GetLinePayoutsResponse_QNAME = new QName("http://Server/", "getLinePayoutsResponse");
    private final static QName _GetSymbols_QNAME = new QName("http://Server/", "getSymbols");
    private final static QName _GetLinePayouts_QNAME = new QName("http://Server/", "getLinePayouts");
    private final static QName _GetPositionsResponse_QNAME = new QName("http://Server/", "getPositionsResponse");
    private final static QName _CreateSpin_QNAME = new QName("http://Server/", "createSpin");
    private final static QName _GetSymbolsResponse_QNAME = new QName("http://Server/", "getSymbolsResponse");
    private final static QName _RandomizeMathValuesResponse_QNAME = new QName("http://Server/", "randomizeMathValuesResponse");
    private final static QName _RandomizeMathValues_QNAME = new QName("http://Server/", "randomizeMathValues");
    private final static QName _UpdateUser_QNAME = new QName("http://Server/", "updateUser");

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
     * Create an instance of {@link CreateSpin }
     * 
     */
    public CreateSpin createCreateSpin() {
        return new CreateSpin();
    }

    /**
     * Create an instance of {@link GetPositionsResponse }
     * 
     */
    public GetPositionsResponse createGetPositionsResponse() {
        return new GetPositionsResponse();
    }

    /**
     * Create an instance of {@link GetLinePayouts }
     * 
     */
    public GetLinePayouts createGetLinePayouts() {
        return new GetLinePayouts();
    }

    /**
     * Create an instance of {@link GetSymbols }
     * 
     */
    public GetSymbols createGetSymbols() {
        return new GetSymbols();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link RandomizeMathValues }
     * 
     */
    public RandomizeMathValues createRandomizeMathValues() {
        return new RandomizeMathValues();
    }

    /**
     * Create an instance of {@link RandomizeMathValuesResponse }
     * 
     */
    public RandomizeMathValuesResponse createRandomizeMathValuesResponse() {
        return new RandomizeMathValuesResponse();
    }

    /**
     * Create an instance of {@link CreateSpinResponse }
     * 
     */
    public CreateSpinResponse createCreateSpinResponse() {
        return new CreateSpinResponse();
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
     * Create an instance of {@link GetLinePayoutsResponse }
     * 
     */
    public GetLinePayoutsResponse createGetLinePayoutsResponse() {
        return new GetLinePayoutsResponse();
    }

    /**
     * Create an instance of {@link GetPositions }
     * 
     */
    public GetPositions createGetPositions() {
        return new GetPositions();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link Symbol }
     * 
     */
    public Symbol createSymbol() {
        return new Symbol();
    }

    /**
     * Create an instance of {@link SpinLinePayout }
     * 
     */
    public SpinLinePayout createSpinLinePayout() {
        return new SpinLinePayout();
    }

    /**
     * Create an instance of {@link WebServerTransferObject }
     * 
     */
    public WebServerTransferObject createWebServerTransferObject() {
        return new WebServerTransferObject();
    }

    /**
     * Create an instance of {@link LinePayout }
     * 
     */
    public LinePayout createLinePayout() {
        return new LinePayout();
    }

    /**
     * Create an instance of {@link SPosition }
     * 
     */
    public SPosition createSPosition() {
        return new SPosition();
    }

    /**
     * Create an instance of {@link Spin }
     * 
     */
    public Spin createSpin() {
        return new Spin();
    }

    /**
     * Create an instance of {@link Position }
     * 
     */
    public Position createPosition() {
        return new Position();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSpinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "createSpinResponse")
    public JAXBElement<CreateSpinResponse> createCreateSpinResponse(CreateSpinResponse value) {
        return new JAXBElement<CreateSpinResponse>(_CreateSpinResponse_QNAME, CreateSpinResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPositions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "getPositions")
    public JAXBElement<GetPositions> createGetPositions(GetPositions value) {
        return new JAXBElement<GetPositions>(_GetPositions_QNAME, GetPositions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLinePayoutsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "getLinePayoutsResponse")
    public JAXBElement<GetLinePayoutsResponse> createGetLinePayoutsResponse(GetLinePayoutsResponse value) {
        return new JAXBElement<GetLinePayoutsResponse>(_GetLinePayoutsResponse_QNAME, GetLinePayoutsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLinePayouts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "getLinePayouts")
    public JAXBElement<GetLinePayouts> createGetLinePayouts(GetLinePayouts value) {
        return new JAXBElement<GetLinePayouts>(_GetLinePayouts_QNAME, GetLinePayouts.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSpin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "createSpin")
    public JAXBElement<CreateSpin> createCreateSpin(CreateSpin value) {
        return new JAXBElement<CreateSpin>(_CreateSpin_QNAME, CreateSpin.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RandomizeMathValuesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "randomizeMathValuesResponse")
    public JAXBElement<RandomizeMathValuesResponse> createRandomizeMathValuesResponse(RandomizeMathValuesResponse value) {
        return new JAXBElement<RandomizeMathValuesResponse>(_RandomizeMathValuesResponse_QNAME, RandomizeMathValuesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RandomizeMathValues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "randomizeMathValues")
    public JAXBElement<RandomizeMathValues> createRandomizeMathValues(RandomizeMathValues value) {
        return new JAXBElement<RandomizeMathValues>(_RandomizeMathValues_QNAME, RandomizeMathValues.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

}
