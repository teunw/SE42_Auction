package auction.service;

import auction.domain.Category;
import auction.domain.Item;
import auction.domain.User;
import nl.fontys.util.Money;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellerManagerTest {

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

    /**
     * Test of offerItem method, of class SellerManager.
     */
    @Test
    public void testOfferItem() {
        String omsch = "omsch";

        User user1 = registrationManager.registerUser("xx@nl");
        Category cat = new Category("cat1");
        Item item1 = sellerManager.offerItem(user1, cat, omsch);
        assertEquals(omsch, item1.getDescription());
        assertNotNull(item1.getId());
    }

    /**
     * Test of revokeItem method, of class SellerManager.
     */
    @Test
    public void testRevokeItem() {
        String omsch = "omsch";
        String omsch2 = "omsch2";


        User seller = registrationManager.registerUser("sel@nl");
        User buyer = registrationManager.registerUser("buy@nl");
        Category cat = new Category("cat1");

        // revoke before bidding
        Item item1 = sellerManager.offerItem(seller, cat, omsch);
        boolean res = sellerManager.revokeItem(item1);
        assertTrue(res);
        int count = auctionManager.findItemByDescription(omsch).size();
        assertEquals(0, count);

        // revoke after bid has been made
        Item item2 = sellerManager.offerItem(seller, cat, omsch2);
        auctionManager.newBid(item2, buyer, new Money(100, "Euro"));
        boolean res2 = sellerManager.revokeItem(item2);
        assertFalse(res2);
        int count2 = auctionManager.findItemByDescription(omsch2).size();
        assertEquals(1, count2);


    }

}
