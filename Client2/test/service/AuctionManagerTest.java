package service;


import mypackage.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AuctionManagerTest {

    mypackage.RegistrationService registrationServices = new RegistrationServiceService().getPort(RegistrationService.class);
    mypackage.AuctionService auctionServices = new AuctionServiceService().getPort(AuctionService.class);

    @Before
    public void setUp() throws Exception {
        registrationServices.clearDatabase();

    }

    @Test
    public void getItem() {

        String email = "xx2@nl";
        String omsch = "omsch";

        User seller1 = registrationServices.register(email);
        Category cat = auctionServices.getCategoryObject("cat2");
        Item item1 = auctionServices.offerItem(seller1, cat, omsch);
        Item item2 = auctionServices.getItem(item1.getId());
        assertEquals(omsch, item2.getDescription());
        assertEquals(email, item2.getSeller().getEmail());
    }

    @Test
    public void findItemByDescription() {
        String email3 = "xx3@nl";
        String omsch = "omsch";
        String email4 = "xx4@nl";
        String omsch2 = "omsch2";

        User seller3 = registrationServices.register(email3);
        User seller4 = registrationServices.register(email4);
        Category cat = auctionServices.getCategoryObject("cat3");
//        String cat = "cat3";
        Item item1 = auctionServices.offerItem(seller3, cat, omsch);
        Item item2 = auctionServices.offerItem(seller4, cat, omsch);

        List<Item> res = auctionServices.findItemByDescription(omsch2);
        assertEquals(0, res.size());

        res = auctionServices.findItemByDescription(omsch);
        assertEquals(2, res.size());

    }

    @Test
    public void newBid() {

        String email = "ss2@nl";
        String emailb = "bb@nl";
        String emailb2 = "bb2@nl";
        String omsch = "omsch_bb6";

        User seller = registrationServices.register(email);
        User buyer = registrationServices.register(emailb);
        User buyer2 = registrationServices.register(emailb2);
        // eerste bod
        Category cat = auctionServices.getCategoryObject("cat9");
//        String cat = "cat9";

        Item item1 = auctionServices.offerItem(seller, cat, omsch);

        Bid new1 = auctionServices.newBid(item1, buyer, auctionServices.getMoneyObject(10, "€"));
        assertEquals(emailb, new1.getBuyer().getEmail());

        // lager bod
        Bid new2 = auctionServices.newBid(item1, buyer2, auctionServices.getMoneyObject(9, "€"));
        assertNull(new2);

        // hoger bod
        Bid new3 = auctionServices.newBid(item1, buyer2, auctionServices.getMoneyObject(11, "€"));
        assertEquals(emailb2, buyer2.getEmail());
    }
}
