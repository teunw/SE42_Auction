package auction.service;

import nl.se42.client.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SellerManagerTest {

    private AuctionService auctionManager;

    @Before
    public void setUp() throws Exception {
        auctionManager = new AuctionServiceService().getAuctionServicePort();
    }

    /**
     * Test of offerItem method, of class SellerManager.
     */
    @Test
    public void testOfferItem() {
        String omsch = "omsch";


        User user1 = auctionManager.register("xx@nl");
        Category cat = new Category();
        cat.setDescription("cat1");
        Item item1 = auctionManager.offerItem(user1, cat, omsch);
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


        User seller = auctionManager.register("sel@nl");
        User buyer = auctionManager.register("buy@nl");
        Category cat = new Category();
        cat.setDescription("cat1");

        // revoke before bidding
        Item item1 = auctionManager.offerItem(seller, cat, omsch);
        boolean res = auctionManager.revokeItem(item1);
        assertTrue(res);
        int count = auctionManager.findItemByDescription(omsch).size();
        assertEquals(0, count);

        // revoke after bid has been made
        Item item2 = auctionManager.offerItem(seller, cat, omsch2);
        auctionManager.newBid(item2, buyer, new Money());
        boolean res2 = auctionManager.revokeItem(item2);
        assertFalse(res2);
        int count2 = auctionManager.findItemByDescription(omsch2).size();
        assertEquals(1, count2);


    }

}
