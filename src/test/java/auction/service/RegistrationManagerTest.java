package auction.service;

import auction.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RegistrationManagerTest {

    private RegistrationManager registrationManager;

    @Before
    public void setUp() throws Exception {
        registrationManager = new RegistrationManager();
    }

    @Test
    public void registerUser() {
        User user1 = registrationManager.registerUser("xxx1@yyy");
        assertTrue(user1.getEmail().equals("xxx1@yyy"));
        User user2 = registrationManager.registerUser("xxx2@yyy2");
        assertTrue(user2.getEmail().equals("xxx2@yyy2"));
        User user2bis = registrationManager.registerUser("xxx2@yyy2");
        assertSame(user2bis, user2);
        //geen @ in het adres
        assertNull(registrationManager.registerUser("abc"));
    }

    @Test
    public void getUser() {
        User user1 = registrationManager.registerUser("xxx5@yyy5");
        User userGet = registrationManager.getUser("xxx5@yyy5");
        assertSame(userGet, user1);
        assertNull(registrationManager.getUser("aaa4@bb5"));
        registrationManager.registerUser("abc");
        assertNull(registrationManager.getUser("abc"));
    }

    @Test
    public void getUsers() {
        List<User> users = registrationManager.getUsers();
        assertEquals(0, users.size());

        User user1 = registrationManager.registerUser("xxx8@yyy");
        users = registrationManager.getUsers();
        assertEquals(1, users.size());
        assertSame(users.get(0), user1);


        User user2 = registrationManager.registerUser("xxx9@yyy");
        users = registrationManager.getUsers();
        assertEquals(2, users.size());

        registrationManager.registerUser("abc");
        //geen nieuwe user toegevoegd, dus gedrag hetzelfde als hiervoor
        users = registrationManager.getUsers();
        assertEquals(2, users.size());
    }
}
