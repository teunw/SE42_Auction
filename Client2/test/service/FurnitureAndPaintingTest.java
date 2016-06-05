package service;

import mypackage.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class FurnitureAndPaintingTest {

    mypackage.RegistrationService registrationServices = new RegistrationServiceService().getPort(RegistrationService.class);
    mypackage.AuctionService auctionServices = new AuctionServiceService().getPort(AuctionService.class);

    public FurnitureAndPaintingTest() {
    }

    @Before
    public void setUp() throws Exception {
        registrationServices.clearDatabase();
    }

    @Test
    public void newFurniture() {
        String omsch = "omsch1";
        String iemand1 = "iemand1@def";
        User u1 = registrationServices.register(iemand1);
        User u2 = registrationServices.register("iemand2@def");
        Category cat = auctionServices.getCategoryObject("cat2");

        Item furniture1 = auctionServices.offerItemWithPainter(u1, "ijzer", cat, "broodkast");
        assertEquals("seller of item correct", furniture1.getSeller(), u1);

        User foundUser = registrationServices.login(iemand1);
//        Iterator<Item> it = foundUser.getOfferedItems();
        Iterator<Item> it = auctionServices.getOfferedItemsForUser(foundUser).iterator();
        Item firstItem = it.next();
        //        int xxx = 22;
        assertEquals("item added in offeredItems", furniture1, firstItem);
        Item item2 = auctionServices.offerItemWithPainter(u1, "Rembrandt", cat, "Nachtwacht");
        it = auctionServices.getOfferedItemsForUser(registrationServices.login(iemand1)).iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());

        //de volgende code verwijderen als Item abstract is
        Item item3 = auctionServices.offerItem(u1, auctionServices.getCategoryObject("boek"), "The science of Discworld");
        it = auctionServices.getOfferedItemsForUser(registrationServices.login(iemand1)).iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());

//        assertNull(furniture1.getHighestBid());
        assertNull(auctionServices.getHighestBidForItem(furniture1));
        Bid bid = auctionServices.newBid(furniture1, u2, auctionServices.getMoneyObject(150000, "eur"));
        assertNotNull(auctionServices.getHighestBidForItem(furniture1));

        Item foundFurniture = auctionServices.getItem(furniture1.getId());
        int i = 3;
//        assertTrue(foundFurniture.getClass() == Furniture.class);
    }
}
