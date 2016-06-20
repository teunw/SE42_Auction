package service;


import mypackage.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemsFromSellerTest {

    mypackage.RegistrationService registrationServices = new RegistrationServiceService().getPort(RegistrationService.class);
    mypackage.AuctionService auctionServices = new AuctionServiceService().getPort(AuctionService.class);

    public ItemsFromSellerTest() {
    }

    @Before
    public void setUp() throws Exception {
        registrationServices.clearDatabase();
    }

    @Test
    //   @Ignore
    public void numberOfOfferdItems() {

        String email = "ifu1@nl";
        String omsch1 = "omsch_ifu1";
        String omsch2 = "omsch_ifu2";

        User user1 = registrationServices.register(email);
        assertEquals(0, auctionServices.getAmountOfferedItemsForUser(user1));

        Category cat = auctionServices.getCategoryObject("cat2");
        Item item1 = auctionServices.offerItem(user1, cat, omsch1);


        // test number of items belonging to user1
        assertEquals(1, auctionServices.getAmountOfferedItemsForUser(user1));

        /*
         *  expected: which one of te above two assertions do you expect to be true?
         *  QUESTION:
         *    Explain the result in terms of entity manager and persistance context.
         */


//        assertEquals(1, auctionServices.getAmountOfferedItemsForUser(item1.getSeller()));


        User user2 = registrationServices.login(email);
        assertEquals(1, auctionServices.getAmountOfferedItemsForUser(user2));
        Item item2 = auctionServices.offerItem(user2, cat, omsch2);
        assertEquals(2, auctionServices.getAmountOfferedItemsForUser(user2));

        User user3 = registrationServices.login(email);
        assertEquals(2, auctionServices.getAmountOfferedItemsForUser(user3));

        User userWithItem = item2.getSeller();
        assertEquals(2, auctionServices.getAmountOfferedItemsForUser(userWithItem));
        /*
         *  expected: which one of te above two assertions do you expect to be true?
         *  QUESTION:
         *    Explain the result in terms of entity manager and persistance context.
         */


    }

    @Test
//    @Ignore
    public void getItemsFromSeller() {
        String email = "ifu1@nl";
        String omsch1 = "omsch_ifu1";
        String omsch2 = "omsch_ifu2";

        Category cat = auctionServices.getCategoryObject("cat2");

        User user10 = registrationServices.register(email);
        Item item10 = auctionServices.offerItem(user10, cat, omsch1);
        Iterator<Item> it = auctionServices.getOfferedItemsForUser(user10).iterator();
        // testing number of items of java object
        assertTrue(it.hasNext());

        // now testing number of items for same user fetched from db.
        User user11 = registrationServices.login(email);
        Iterator<Item> it11 = auctionServices.getOfferedItemsForUser(user11).iterator();
        assertTrue(it11.hasNext());
        it11.next();
        assertFalse(it11.hasNext());

        // Explain difference in above two tests for te iterator of 'same' user


        User user20 = registrationServices.login(email);
        Item item20 = auctionServices.offerItem(user20, cat, omsch2);
        Iterator<Item> it20 = auctionServices.getOfferedItemsForUser(user20).iterator();
        assertTrue(it20.hasNext());
        it20.next();
        assertTrue(it20.hasNext());


        User user30 = item20.getSeller();
        Iterator<Item> it30 = auctionServices.getOfferedItemsForUser(user30).iterator();
        assertTrue(it30.hasNext());
        it30.next();
        assertTrue(it30.hasNext());

    }
}
