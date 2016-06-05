package auction.webservice;


import auction.domain.Bid;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
import auction.service.AuctionManager;
import auction.service.SellerManager;
import nl.fontys.util.Money;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class AuctionService {

    private AuctionManager auctionManager;
    private SellerManager sellerManager;

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

    @WebMethod(operationName = "revokeItem")
    public boolean revokeItem(Item item) {
        return sellerManager.revokeItem(item);
    }

    @WebMethod(operationName = "getItem")
    public Item getItem(Long id) {
        return auctionManager.getItem(id);
    }
}