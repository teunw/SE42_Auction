package auction.service;

import auction.domain.*;
//import nl.fontys.util.Doekoes;
import auction.domain.*;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;

import static org.junit.Assert.*;

public class FurnitureAndPaintingTest {

    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("auctionPU");
    final EntityManager em = emf.createEntityManager();
    private AuctionManager auctionMgr;
    private RegistrationManager registrationMgr;
    private SellerManager sellerMgr;

    public FurnitureAndPaintingTest() {
    }

    @Before
    public void setUp() throws Exception {
        registrationMgr = new RegistrationManager();
        auctionMgr = new AuctionManager();
        sellerMgr = new SellerManager();
        new DatabaseCleaner().clean();
    }

    @Test
    public void newFurniture() {
        String omsch = "omsch1";
        String iemand1 = "iemand1@def";
        User u1 = registrationMgr.registerUser(iemand1);
        User u2 = registrationMgr.registerUser("iemand2@def");
        Category cat = new Category("cat2");

        Item furniture1 = sellerMgr.offerItem(u1, "ijzer", cat, "broodkast");
        assertEquals("seller of item correct", furniture1.getSeller(), u1);

        User foundUser = registrationMgr.getUser(iemand1);
        Iterator<Item> it = foundUser.getOfferedItems();
        Item firstItem = it.next();
        //        int xxx = 22;
        assertEquals("item added in offeredItems", furniture1, firstItem);
        Item item2 = sellerMgr.offerItem(u1, "Rembrandt", cat, "Nachtwacht");
        it = registrationMgr.getUser(iemand1).getOfferedItems();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());

        //de volgende code verwijderen als Item abstract is
        Item item3 = sellerMgr.offerItem(u1, new Category("boek"), "The science of Discworld");
        it = registrationMgr.getUser(iemand1).getOfferedItems();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());

        assertNull(furniture1.getHighestBid());
        Bid bid = auctionMgr.newBid(furniture1, u2, new Doekoes(150000, Doekoes.EURO));
        assertNotNull(furniture1.getHighestBid());

        Item foundFurniture = auctionMgr.getItem(furniture1.getId());
        int i = 3;
        assertTrue(foundFurniture.getClass() == Furniture.class);
    }
}
