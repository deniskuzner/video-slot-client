
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

    private final static QName _ExecuteSpinResponse_QNAME = new QName("http://Server/", "executeSpinResponse");
    private final static QName _GetSymbols_QNAME = new QName("http://Server/", "getSymbols");
    private final static QName _GetSymbolsResponse_QNAME = new QName("http://Server/", "getSymbolsResponse");
    private final static QName _CreateGameResponse_QNAME = new QName("http://Server/", "createGameResponse");
    private final static QName _RandomizeMathValuesResponse_QNAME = new QName("http://Server/", "randomizeMathValuesResponse");
    private final static QName _ExecuteSpin_QNAME = new QName("http://Server/", "executeSpin");
    private final static QName _RandomizeMathValues_QNAME = new QName("http://Server/", "randomizeMathValues");
    private final static QName _CreateGame_QNAME = new QName("http://Server/", "createGame");

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
     * Create an instance of {@link ExecuteSpinResponse }
     * 
     */
    public ExecuteSpinResponse createExecuteSpinResponse() {
        return new ExecuteSpinResponse();
    }

    /**
     * Create an instance of {@link GetSymbols }
     * 
     */
    public GetSymbols createGetSymbols() {
        return new GetSymbols();
    }

    /**
     * Create an instance of {@link CreateGame }
     * 
     */
    public CreateGame createCreateGame() {
        return new CreateGame();
    }

    /**
     * Create an instance of {@link ExecuteSpin }
     * 
     */
    public ExecuteSpin createExecuteSpin() {
        return new ExecuteSpin();
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
     * Create an instance of {@link CreateGameResponse }
     * 
     */
    public CreateGameResponse createCreateGameResponse() {
        return new CreateGameResponse();
    }

    /**
     * Create an instance of {@link Symbol }
     * 
     */
    public Symbol createSymbol() {
        return new Symbol();
    }

    /**
     * Create an instance of {@link Game }
     * 
     */
    public Game createGame() {
        return new Game();
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
     * Create an instance of {@link Win }
     * 
     */
    public Win createWin() {
        return new Win();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteSpinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "executeSpinResponse")
    public JAXBElement<ExecuteSpinResponse> createExecuteSpinResponse(ExecuteSpinResponse value) {
        return new JAXBElement<ExecuteSpinResponse>(_ExecuteSpinResponse_QNAME, ExecuteSpinResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSymbolsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "getSymbolsResponse")
    public JAXBElement<GetSymbolsResponse> createGetSymbolsResponse(GetSymbolsResponse value) {
        return new JAXBElement<GetSymbolsResponse>(_GetSymbolsResponse_QNAME, GetSymbolsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "createGameResponse")
    public JAXBElement<CreateGameResponse> createCreateGameResponse(CreateGameResponse value) {
        return new JAXBElement<CreateGameResponse>(_CreateGameResponse_QNAME, CreateGameResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecuteSpin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "executeSpin")
    public JAXBElement<ExecuteSpin> createExecuteSpin(ExecuteSpin value) {
        return new JAXBElement<ExecuteSpin>(_ExecuteSpin_QNAME, ExecuteSpin.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateGame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "createGame")
    public JAXBElement<CreateGame> createCreateGame(CreateGame value) {
        return new JAXBElement<CreateGame>(_CreateGame_QNAME, CreateGame.class, null, value);
    }

}
