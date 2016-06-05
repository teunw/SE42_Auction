package auction.webservice;


import auction.dao.UserDAOJPA;
import auction.domain.Bid;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
import auction.service.AuctionManager;
import auction.service.SellerManager;
import nl.fontys.util.Money;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.IteratorUtils;

@WebService
public class AuctionService {

    private AuctionManager auctionManager;
    private SellerManager sellerManager;
    UserDAOJPA userDAOJPA = new UserDAOJPA();

    public AuctionService() {
        auctionManager = new AuctionManager();
        sellerManager = new SellerManager();
    }

    @WebMethod(operationName = "findItemByDescription")
    public List<Item> findItemByDescription(String description) {
        return auctionManager.findItemByDescription(description);
    }

    @WebMethod(operationName = "newBid")
    public Bid newBid(Item item, User buyer, Money amount) {
        return auctionManager.newBid(item, buyer, amount);
    }

    @WebMethod(operationName = "offerItem")
    public Item offerItem(User seller, Category cat, String description) {
        return sellerManager.offerItem(seller, cat, description);
    }
    @WebMethod(operationName = "offerItemWithPainter")
    public Item offerItemWithPainter(User seller,String painter, Category cat, String description) {
        return sellerManager.offerItem(seller, painter,cat, description);
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
    public Money getMoneyObject(long cents , String currency) {
        return new Money(cents,currency);
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
    public Bid getHighestBid(Item item ) {
        Item dbItem = auctionManager.getItem(item.getId());
        return dbItem.getHighestBid();
    }
    @WebMethod(operationName = "getAmountOfferedItemsForUser")
    public int getAmountOfferedItems(User user) {
        User dbUser = userDAOJPA.findByEmail(user.getEmail());
        return dbUser.getAmountOfferedItems();
    }
}
