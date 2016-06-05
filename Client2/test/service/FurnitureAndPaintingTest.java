package service;

import auction.domain.*;
import mypackage.*;
import nl.fontys.util.Money;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;

import static org.junit.Assert.*;

public class FurnitureAndPaintingTest {

    //    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("auctionPU");
//    final EntityManager em = emf.createEntityManager();
//    private AuctionManager auctionMgr;
//    private RegistrationManager registrationMgr;
//    private SellerManager sellerMgr;
    mypackage.RegistrationService registrationServices = new RegistrationServiceService().getPort(RegistrationService.class);
    mypackage.AuctionService auctionServices = new AuctionServiceService().getPort(AuctionService.class);

    public FurnitureAndPaintingTest() {
    }

    @Before
    public void setUp() throws Exception {
//        registrationMgr = new RegistrationManager();
//        auctionMgr = new AuctionManager();
//        sellerMgr = new SellerManager();
//        new DatabaseCleaner().clean();
    }

    @Test
    public void newFurniture() {
        String omsch = "omsch1";
        String iemand1 = "iemand1@def";
        User u1 = registrationServices.register(iemand1);
        User u2 = registrationServices.register("iemand2@def");
        Category cat = new Category("cat2");

        Item furniture1 = auctionServices.offerItem(u1, "ijzer", cat, "broodkast");
        assertEquals("seller of item correct", furniture1.getSeller(), u1);

        User foundUser = registrationServices.login(iemand1);
        Iterator<Item> it = foundUser.getOfferedItems();
        Item firstItem = it.next();
        //        int xxx = 22;
        assertEquals("item added in offeredItems", furniture1, firstItem);
        Item item2 = auctionServices.offerItem(u1, "Rembrandt", cat, "Nachtwacht");
        it = registrationServices.login(iemand1).getOfferedItems();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());

        //de volgende code verwijderen als Item abstract is
        Item item3 = auctionServices.offerItem(u1, new Category("boek"), "The science of Discworld");
        it = registrationServices.login(iemand1).getOfferedItems();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());

        assertNull(furniture1.getHighestBid());
        Bid bid = auctionServices.newBid(furniture1, u2, new Money(150000, Money.EURO));
        assertNotNull(furniture1.getHighestBid());

        Item foundFurniture = auctionServices.getItem(furniture1.getId());
        int i = 3;
        assertTrue(foundFurniture.getClass() == Furniture.class);
    }
}
