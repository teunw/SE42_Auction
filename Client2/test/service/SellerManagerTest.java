package service;

import mypackage.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellerManagerTest {

    mypackage.RegistrationService registrationManager = new RegistrationServiceService().getPort(RegistrationService.class);
    mypackage.AuctionService auctionManager = new AuctionServiceService().getPort(AuctionService.class);

    @Before
    public void setUp() throws Exception {
        registrationManager.clearDatabase();
    }

    /**
     * Test of offerItem method, of class SellerManager.
     */
    @Test
    public void testOfferItem() {
        String omsch = "omsch";

        User user1 = registrationManager.register("xx@nl");
        Category cat = auctionManager.getCategoryObject("cat1");
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


        User seller = registrationManager.register("sel@nl");
        User buyer = registrationManager.register("buy@nl");
        Category cat = auctionManager.getCategoryObject("cat1");

        // revoke before bidding
        Item item1 = auctionManager.offerItem(seller, cat, omsch);
        boolean res = auctionManager.revokeItem(item1);
        assertTrue(res);
        int count = auctionManager.findItemByDescription(omsch).size();
        assertEquals(0, count);

        // revoke after bid has been made
        Item item2 = auctionManager.offerItem(seller, cat, omsch2);
        Doekoes money = auctionManager.getMoneyObject(100, "€");
//        auctionManager.newBid2(item2, buyer, money); //Todo fix this
        Bid b = auctionManager.newBid(item2, buyer, money); //Todo fix this
        auctionManager.newBid2(item2, buyer); //Todo fix this
        boolean res2 = auctionManager.revokeItem(item2);
        assertFalse(res2);
        int count2 = auctionManager.findItemByDescription(omsch2).size();
        assertEquals(1, count2);


    }

}
