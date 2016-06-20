package auction.webservice;


import auction.dao.UserDAOJPA;
import auction.domain.Bid;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
import auction.service.AuctionManager;
import auction.service.DatabaseCleaner;
import auction.service.RegistrationManager;
import auction.service.SellerManager;
import auction.domain.*;

//import nl.fontys.util.Doekoes;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;

@WebService
public class AuctionService {

    private AuctionManager auctionManager;
    private RegistrationManager registrationManager;

    private SellerManager sellerManager;
    UserDAOJPA userDAOJPA = new UserDAOJPA();

    public AuctionService() {
        auctionManager = new AuctionManager();
        sellerManager = new SellerManager();
        registrationManager = new RegistrationManager();
    }

    @WebMethod(operationName = "findItemByDescription")
    public List<Item> findItemByDescription(String description) {
        return auctionManager.findItemByDescription(description);
    }

    @WebMethod(operationName = "newBid")
    public Bid newBid(Item item, User buyer, Doekoes amount) {
        return auctionManager.newBid(item, buyer, amount);
    }

    @WebMethod(operationName = "newBid2")
    public void newBid2(Item item, User buyer) {
        auctionManager.newBid(item, buyer, new Doekoes(10,"€"));
    }

    @WebMethod(operationName = "offerItem")
    public Item offerItem(User seller, Category cat, String description) {
        return sellerManager.offerItem(seller, cat, description);
    }

    @WebMethod(operationName = "offerItemWithPainter")
    public Item offerItemWithPainter(User seller, String painter, Category cat, String description) {
        return sellerManager.offerItem(seller, painter, cat, description);
    }

    @WebMethod(operationName = "revokeItem")
    public boolean revokeItem(Item item) {
        return sellerManager.revokeItem(item);
    }

    @WebMethod(operationName = "getItem")
    public Item getItem(Long id) {
        return auctionManager.getItem(id);
    }

    @WebMethod(operationName = "getMoneyObject")
    public Doekoes getMoneyObject(long cents, String currency) {
        return new Doekoes(cents, currency);
    }

    @WebMethod(operationName = "getCategoryObject")
    public Category getCategoryObject(String description) {
        return new Category(description);
    }

    @WebMethod(operationName = "getOfferedItemsForUser")
    public ArrayList<Item> getOfferedItems(User user) {
        User dbUser = userDAOJPA.findByEmail(user.getEmail());
        return (ArrayList<Item>) IteratorUtils.toList(dbUser.getOfferedItems());
    }

    @WebMethod(operationName = "getAllUsers")
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) IteratorUtils.toList(userDAOJPA.findAll().iterator());
    }

    @WebMethod(operationName = "getHighestBidForItem")
    public Bid getHighestBid(Item item) {
        Item dbItem = auctionManager.getItem(item.getId());
        return dbItem.getHighestBid();
    }

    @WebMethod(operationName = "getAmountOfferedItemsForUser")
    public int getAmountOfferedItems(User user) {
        User dbUser = userDAOJPA.findByEmail(user.getEmail());
        return dbUser.getAmountOfferedItems();
    }

    @WebMethod(operationName = "register")
    public User register(String email) {
        return registrationManager.registerUser(email);
    }

    @WebMethod(operationName = "login")
    public User login(String email) {
        return registrationManager.getUser(email);
    }

    @WebMethod(operationName = "clearDatabase")
    public void clearDatabase() {
        new DatabaseCleaner().clean();
    }
}
