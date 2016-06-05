package service;

import mypackage.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RegistrationManagerTest {

    mypackage.RegistrationService registrationManager = new RegistrationServiceService().getPort(RegistrationService.class);
    mypackage.AuctionService auctionServices = new AuctionServiceService().getPort(AuctionService.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void registerUser() {
        User user1 = registrationManager.register("xxx1@yyy");
        assertTrue(user1.getEmail().equals("xxx1@yyy"));
        User user2 = registrationManager.register("xxx2@yyy2");
        assertTrue(user2.getEmail().equals("xxx2@yyy2"));
        User user2bis = registrationManager.register("xxx2@yyy2");
        assertSame(user2bis, user2);
        //geen @ in het adres
        assertNull(registrationManager.register("abc"));
    }

    @Test
    public void getUser() {
        User user1 = registrationManager.register("xxx5@yyy5");
        User userGet = registrationManager.login("xxx5@yyy5");
        assertSame(userGet, user1);
        assertNull(registrationManager.login("aaa4@bb5"));
        registrationManager.register("abc");
        assertNull(registrationManager.login("abc"));
    }

    @Test
    public void getUsers() {
        List<User> users = auctionServices.getAllUsers();
        assertEquals(0, users.size());

        User user1 = registrationManager.register("xxx8@yyy");
        users = auctionServices.getAllUsers();
        assertEquals(1, users.size());
        assertSame(users.get(0), user1);


        User user2 = registrationManager.register("xxx9@yyy");
        users = auctionServices.getAllUsers();
        assertEquals(2, users.size());

        registrationManager.register("abc");
        //geen nieuwe user toegevoegd, dus gedrag hetzelfde als hiervoor
        users = auctionServices.getAllUsers();
        assertEquals(2, users.size());
    }
}
