package auction.service;

import auction.dao.ItemDAO;
import auction.dao.ItemDAOJPA;
import auction.dao.UserDAO;
import auction.dao.UserDAOJPA;

/**
 * Created by Teun on 22/05/2016.
 */
public class DatabaseCleaner {

    private ItemDAO itemDAO;
    private UserDAO userDAO;

    public DatabaseCleaner() {
        itemDAO = new ItemDAOJPA();
        userDAO = new UserDAOJPA();
    }

    public void clean() {
        itemDAO.removeAll();
        userDAO.removeAll();
    }
}
