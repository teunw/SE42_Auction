package auction.service;

import auction.domain.Bid;
import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
//import nl.fontys.util.Doekoes;
import auction.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AuctionManagerTest {

    private AuctionManager auctionManager;
    private RegistrationManager registrationManager;
    private SellerManager sellerManager;

    @Before
    public void setUp() throws Exception {
        new DatabaseCleaner().clean();
        registrationManager = new RegistrationManager();
        auctionManager = new AuctionManager();
        sellerManager = new SellerManager();
    }

    @Test
    public void getItem() {

        String email = "xx2@nl";
        String omsch = "omsch";

        User seller1 = registrationManager.registerUser(email);
        Category cat = new Category("cat2");
        Item item1 = sellerManager.offerItem(seller1, cat, omsch);
        Item item2 = auctionManager.getItem(item1.getId());
        assertEquals(omsch, item2.getDescription());
        assertEquals(email, item2.getSeller().getEmail());
    }

    @Test
    public void findItemByDescription() {
        String email3 = "xx3@nl";
        String omsch = "omsch";
        String email4 = "xx4@nl";
        String omsch2 = "omsch2";

        User seller3 = registrationManager.registerUser(email3);
        User seller4 = registrationManager.registerUser(email4);
        Category cat = new Category("cat3");
        Item item1 = sellerManager.offerItem(seller3, cat, omsch);
        Item item2 = sellerManager.offerItem(seller4, cat, omsch);

        List<Item> res = auctionManager.findItemByDescription(omsch2);
        assertEquals(0, res.size());

        res = auctionManager.findItemByDescription(omsch);
        assertEquals(2, res.size());

    }

    @Test
    public void newBid() {

        String email = "ss2@nl";
        String emailb = "bb@nl";
        String emailb2 = "bb2@nl";
        String omsch = "omsch_bb6";

        User seller = registrationManager.registerUser(email);
        User buyer = registrationManager.registerUser(emailb);
        User buyer2 = registrationManager.registerUser(emailb2);
        // eerste bod
        Category cat = new Category("cat9");

        Item item1 = sellerManager.offerItem(seller, cat, omsch);
        Bid new1 = auctionManager.newBid(item1, buyer, new Doekoes(10, "eur"));
        assertEquals(emailb, new1.getBuyer().getEmail());

        // lager bod
        Bid new2 = auctionManager.newBid(item1, buyer2, new Doekoes(9, "eur"));
        assertNull(new2);

        // hoger bod
        Bid new3 = auctionManager.newBid(item1, buyer2, new Doekoes(11, "eur"));
        assertEquals(emailb2, buyer2.getEmail());
    }
}
