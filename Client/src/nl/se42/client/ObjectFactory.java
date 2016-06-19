
package nl.se42.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.se42.client package. 
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

    private final static QName _FindItemByDescription_QNAME = new QName("http://webservice.auction/", "findItemByDescription");
    private final static QName _GetAllUsersResponse_QNAME = new QName("http://webservice.auction/", "getAllUsersResponse");
    private final static QName _OfferItemResponse_QNAME = new QName("http://webservice.auction/", "offerItemResponse");
    private final static QName _GetItemResponse_QNAME = new QName("http://webservice.auction/", "getItemResponse");
    private final static QName _RegisterResponse_QNAME = new QName("http://webservice.auction/", "registerResponse");
    private final static QName _OfferItemWithPainterResponse_QNAME = new QName("http://webservice.auction/", "offerItemWithPainterResponse");
    private final static QName _Bid_QNAME = new QName("http://webservice.auction/", "bid");
    private final static QName _Category_QNAME = new QName("http://webservice.auction/", "category");
    private final static QName _User_QNAME = new QName("http://webservice.auction/", "user");
    private final static QName _Register_QNAME = new QName("http://webservice.auction/", "register");
    private final static QName _FindItemByDescriptionResponse_QNAME = new QName("http://webservice.auction/", "findItemByDescriptionResponse");
    private final static QName _GetHighestBidForItemResponse_QNAME = new QName("http://webservice.auction/", "getHighestBidForItemResponse");
    private final static QName _GetAllUsers_QNAME = new QName("http://webservice.auction/", "getAllUsers");
    private final static QName _GetCategoryObject_QNAME = new QName("http://webservice.auction/", "getCategoryObject");
    private final static QName _Item_QNAME = new QName("http://webservice.auction/", "item");
    private final static QName _RevokeItem_QNAME = new QName("http://webservice.auction/", "revokeItem");
    private final static QName _LoginResponse_QNAME = new QName("http://webservice.auction/", "loginResponse");
    private final static QName _NewBidResponse_QNAME = new QName("http://webservice.auction/", "newBidResponse");
    private final static QName _RevokeItemResponse_QNAME = new QName("http://webservice.auction/", "revokeItemResponse");
    private final static QName _GetMoneyObject_QNAME = new QName("http://webservice.auction/", "getMoneyObject");
    private final static QName _OfferItem_QNAME = new QName("http://webservice.auction/", "offerItem");
    private final static QName _GetOfferedItemsForUser_QNAME = new QName("http://webservice.auction/", "getOfferedItemsForUser");
    private final static QName _GetMoneyObjectResponse_QNAME = new QName("http://webservice.auction/", "getMoneyObjectResponse");
    private final static QName _ClearDatabaseResponse_QNAME = new QName("http://webservice.auction/", "clearDatabaseResponse");
    private final static QName _GetAmountOfferedItemsForUser_QNAME = new QName("http://webservice.auction/", "getAmountOfferedItemsForUser");
    private final static QName _GetCategoryObjectResponse_QNAME = new QName("http://webservice.auction/", "getCategoryObjectResponse");
    private final static QName _GetOfferedItemsForUserResponse_QNAME = new QName("http://webservice.auction/", "getOfferedItemsForUserResponse");
    private final static QName _ClearDatabase_QNAME = new QName("http://webservice.auction/", "clearDatabase");
    private final static QName _OfferItemWithPainter_QNAME = new QName("http://webservice.auction/", "offerItemWithPainter");
    private final static QName _GetAmountOfferedItemsForUserResponse_QNAME = new QName("http://webservice.auction/", "getAmountOfferedItemsForUserResponse");
    private final static QName _GetHighestBidForItem_QNAME = new QName("http://webservice.auction/", "getHighestBidForItem");
    private final static QName _NewBid_QNAME = new QName("http://webservice.auction/", "newBid");
    private final static QName _GetItem_QNAME = new QName("http://webservice.auction/", "getItem");
    private final static QName _Login_QNAME = new QName("http://webservice.auction/", "login");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.se42.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClearDatabase }
     * 
     */
    public ClearDatabase createClearDatabase() {
        return new ClearDatabase();
    }

    /**
     * Create an instance of {@link OfferItemWithPainter }
     * 
     */
    public OfferItemWithPainter createOfferItemWithPainter() {
        return new OfferItemWithPainter();
    }

    /**
     * Create an instance of {@link GetAmountOfferedItemsForUserResponse }
     * 
     */
    public GetAmountOfferedItemsForUserResponse createGetAmountOfferedItemsForUserResponse() {
        return new GetAmountOfferedItemsForUserResponse();
    }

    /**
     * Create an instance of {@link GetHighestBidForItem }
     * 
     */
    public GetHighestBidForItem createGetHighestBidForItem() {
        return new GetHighestBidForItem();
    }

    /**
     * Create an instance of {@link NewBid }
     * 
     */
    public NewBid createNewBid() {
        return new NewBid();
    }

    /**
     * Create an instance of {@link GetItem }
     * 
     */
    public GetItem createGetItem() {
        return new GetItem();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link GetOfferedItemsForUser }
     * 
     */
    public GetOfferedItemsForUser createGetOfferedItemsForUser() {
        return new GetOfferedItemsForUser();
    }

    /**
     * Create an instance of {@link GetMoneyObjectResponse }
     * 
     */
    public GetMoneyObjectResponse createGetMoneyObjectResponse() {
        return new GetMoneyObjectResponse();
    }

    /**
     * Create an instance of {@link ClearDatabaseResponse }
     * 
     */
    public ClearDatabaseResponse createClearDatabaseResponse() {
        return new ClearDatabaseResponse();
    }

    /**
     * Create an instance of {@link GetAmountOfferedItemsForUser }
     * 
     */
    public GetAmountOfferedItemsForUser createGetAmountOfferedItemsForUser() {
        return new GetAmountOfferedItemsForUser();
    }

    /**
     * Create an instance of {@link GetCategoryObjectResponse }
     * 
     */
    public GetCategoryObjectResponse createGetCategoryObjectResponse() {
        return new GetCategoryObjectResponse();
    }

    /**
     * Create an instance of {@link GetOfferedItemsForUserResponse }
     * 
     */
    public GetOfferedItemsForUserResponse createGetOfferedItemsForUserResponse() {
        return new GetOfferedItemsForUserResponse();
    }

    /**
     * Create an instance of {@link FindItemByDescriptionResponse }
     * 
     */
    public FindItemByDescriptionResponse createFindItemByDescriptionResponse() {
        return new FindItemByDescriptionResponse();
    }

    /**
     * Create an instance of {@link GetHighestBidForItemResponse }
     * 
     */
    public GetHighestBidForItemResponse createGetHighestBidForItemResponse() {
        return new GetHighestBidForItemResponse();
    }

    /**
     * Create an instance of {@link GetAllUsers }
     * 
     */
    public GetAllUsers createGetAllUsers() {
        return new GetAllUsers();
    }

    /**
     * Create an instance of {@link GetCategoryObject }
     * 
     */
    public GetCategoryObject createGetCategoryObject() {
        return new GetCategoryObject();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link RevokeItem }
     * 
     */
    public RevokeItem createRevokeItem() {
        return new RevokeItem();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link NewBidResponse }
     * 
     */
    public NewBidResponse createNewBidResponse() {
        return new NewBidResponse();
    }

    /**
     * Create an instance of {@link RevokeItemResponse }
     * 
     */
    public RevokeItemResponse createRevokeItemResponse() {
        return new RevokeItemResponse();
    }

    /**
     * Create an instance of {@link GetMoneyObject }
     * 
     */
    public GetMoneyObject createGetMoneyObject() {
        return new GetMoneyObject();
    }

    /**
     * Create an instance of {@link OfferItem }
     * 
     */
    public OfferItem createOfferItem() {
        return new OfferItem();
    }

    /**
     * Create an instance of {@link FindItemByDescription }
     * 
     */
    public FindItemByDescription createFindItemByDescription() {
        return new FindItemByDescription();
    }

    /**
     * Create an instance of {@link GetAllUsersResponse }
     * 
     */
    public GetAllUsersResponse createGetAllUsersResponse() {
        return new GetAllUsersResponse();
    }

    /**
     * Create an instance of {@link OfferItemResponse }
     * 
     */
    public OfferItemResponse createOfferItemResponse() {
        return new OfferItemResponse();
    }

    /**
     * Create an instance of {@link GetItemResponse }
     * 
     */
    public GetItemResponse createGetItemResponse() {
        return new GetItemResponse();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link OfferItemWithPainterResponse }
     * 
     */
    public OfferItemWithPainterResponse createOfferItemWithPainterResponse() {
        return new OfferItemWithPainterResponse();
    }

    /**
     * Create an instance of {@link Bid }
     * 
     */
    public Bid createBid() {
        return new Bid();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link FontysTime }
     * 
     */
    public FontysTime createFontysTime() {
        return new FontysTime();
    }

    /**
     * Create an instance of {@link Money }
     * 
     */
    public Money createMoney() {
        return new Money();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindItemByDescription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "findItemByDescription")
    public JAXBElement<FindItemByDescription> createFindItemByDescription(FindItemByDescription value) {
        return new JAXBElement<FindItemByDescription>(_FindItemByDescription_QNAME, FindItemByDescription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getAllUsersResponse")
    public JAXBElement<GetAllUsersResponse> createGetAllUsersResponse(GetAllUsersResponse value) {
        return new JAXBElement<GetAllUsersResponse>(_GetAllUsersResponse_QNAME, GetAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfferItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "offerItemResponse")
    public JAXBElement<OfferItemResponse> createOfferItemResponse(OfferItemResponse value) {
        return new JAXBElement<OfferItemResponse>(_OfferItemResponse_QNAME, OfferItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getItemResponse")
    public JAXBElement<GetItemResponse> createGetItemResponse(GetItemResponse value) {
        return new JAXBElement<GetItemResponse>(_GetItemResponse_QNAME, GetItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfferItemWithPainterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "offerItemWithPainterResponse")
    public JAXBElement<OfferItemWithPainterResponse> createOfferItemWithPainterResponse(OfferItemWithPainterResponse value) {
        return new JAXBElement<OfferItemWithPainterResponse>(_OfferItemWithPainterResponse_QNAME, OfferItemWithPainterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "bid")
    public JAXBElement<Bid> createBid(Bid value) {
        return new JAXBElement<Bid>(_Bid_QNAME, Bid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Category }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "category")
    public JAXBElement<Category> createCategory(Category value) {
        return new JAXBElement<Category>(_Category_QNAME, Category.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindItemByDescriptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "findItemByDescriptionResponse")
    public JAXBElement<FindItemByDescriptionResponse> createFindItemByDescriptionResponse(FindItemByDescriptionResponse value) {
        return new JAXBElement<FindItemByDescriptionResponse>(_FindItemByDescriptionResponse_QNAME, FindItemByDescriptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHighestBidForItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getHighestBidForItemResponse")
    public JAXBElement<GetHighestBidForItemResponse> createGetHighestBidForItemResponse(GetHighestBidForItemResponse value) {
        return new JAXBElement<GetHighestBidForItemResponse>(_GetHighestBidForItemResponse_QNAME, GetHighestBidForItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getAllUsers")
    public JAXBElement<GetAllUsers> createGetAllUsers(GetAllUsers value) {
        return new JAXBElement<GetAllUsers>(_GetAllUsers_QNAME, GetAllUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoryObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getCategoryObject")
    public JAXBElement<GetCategoryObject> createGetCategoryObject(GetCategoryObject value) {
        return new JAXBElement<GetCategoryObject>(_GetCategoryObject_QNAME, GetCategoryObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "item")
    public JAXBElement<Item> createItem(Item value) {
        return new JAXBElement<Item>(_Item_QNAME, Item.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RevokeItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "revokeItem")
    public JAXBElement<RevokeItem> createRevokeItem(RevokeItem value) {
        return new JAXBElement<RevokeItem>(_RevokeItem_QNAME, RevokeItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewBidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "newBidResponse")
    public JAXBElement<NewBidResponse> createNewBidResponse(NewBidResponse value) {
        return new JAXBElement<NewBidResponse>(_NewBidResponse_QNAME, NewBidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RevokeItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "revokeItemResponse")
    public JAXBElement<RevokeItemResponse> createRevokeItemResponse(RevokeItemResponse value) {
        return new JAXBElement<RevokeItemResponse>(_RevokeItemResponse_QNAME, RevokeItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoneyObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getMoneyObject")
    public JAXBElement<GetMoneyObject> createGetMoneyObject(GetMoneyObject value) {
        return new JAXBElement<GetMoneyObject>(_GetMoneyObject_QNAME, GetMoneyObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfferItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "offerItem")
    public JAXBElement<OfferItem> createOfferItem(OfferItem value) {
        return new JAXBElement<OfferItem>(_OfferItem_QNAME, OfferItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOfferedItemsForUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getOfferedItemsForUser")
    public JAXBElement<GetOfferedItemsForUser> createGetOfferedItemsForUser(GetOfferedItemsForUser value) {
        return new JAXBElement<GetOfferedItemsForUser>(_GetOfferedItemsForUser_QNAME, GetOfferedItemsForUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoneyObjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getMoneyObjectResponse")
    public JAXBElement<GetMoneyObjectResponse> createGetMoneyObjectResponse(GetMoneyObjectResponse value) {
        return new JAXBElement<GetMoneyObjectResponse>(_GetMoneyObjectResponse_QNAME, GetMoneyObjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearDatabaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "clearDatabaseResponse")
    public JAXBElement<ClearDatabaseResponse> createClearDatabaseResponse(ClearDatabaseResponse value) {
        return new JAXBElement<ClearDatabaseResponse>(_ClearDatabaseResponse_QNAME, ClearDatabaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAmountOfferedItemsForUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getAmountOfferedItemsForUser")
    public JAXBElement<GetAmountOfferedItemsForUser> createGetAmountOfferedItemsForUser(GetAmountOfferedItemsForUser value) {
        return new JAXBElement<GetAmountOfferedItemsForUser>(_GetAmountOfferedItemsForUser_QNAME, GetAmountOfferedItemsForUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoryObjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getCategoryObjectResponse")
    public JAXBElement<GetCategoryObjectResponse> createGetCategoryObjectResponse(GetCategoryObjectResponse value) {
        return new JAXBElement<GetCategoryObjectResponse>(_GetCategoryObjectResponse_QNAME, GetCategoryObjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOfferedItemsForUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getOfferedItemsForUserResponse")
    public JAXBElement<GetOfferedItemsForUserResponse> createGetOfferedItemsForUserResponse(GetOfferedItemsForUserResponse value) {
        return new JAXBElement<GetOfferedItemsForUserResponse>(_GetOfferedItemsForUserResponse_QNAME, GetOfferedItemsForUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearDatabase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "clearDatabase")
    public JAXBElement<ClearDatabase> createClearDatabase(ClearDatabase value) {
        return new JAXBElement<ClearDatabase>(_ClearDatabase_QNAME, ClearDatabase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfferItemWithPainter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "offerItemWithPainter")
    public JAXBElement<OfferItemWithPainter> createOfferItemWithPainter(OfferItemWithPainter value) {
        return new JAXBElement<OfferItemWithPainter>(_OfferItemWithPainter_QNAME, OfferItemWithPainter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAmountOfferedItemsForUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getAmountOfferedItemsForUserResponse")
    public JAXBElement<GetAmountOfferedItemsForUserResponse> createGetAmountOfferedItemsForUserResponse(GetAmountOfferedItemsForUserResponse value) {
        return new JAXBElement<GetAmountOfferedItemsForUserResponse>(_GetAmountOfferedItemsForUserResponse_QNAME, GetAmountOfferedItemsForUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHighestBidForItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getHighestBidForItem")
    public JAXBElement<GetHighestBidForItem> createGetHighestBidForItem(GetHighestBidForItem value) {
        return new JAXBElement<GetHighestBidForItem>(_GetHighestBidForItem_QNAME, GetHighestBidForItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewBid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "newBid")
    public JAXBElement<NewBid> createNewBid(NewBid value) {
        return new JAXBElement<NewBid>(_NewBid_QNAME, NewBid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "getItem")
    public JAXBElement<GetItem> createGetItem(GetItem value) {
        return new JAXBElement<GetItem>(_GetItem_QNAME, GetItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.auction/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

}
