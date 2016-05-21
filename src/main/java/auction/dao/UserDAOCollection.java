package auction.dao;

import auction.domain.User;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAOCollection implements UserDAO {

    private HashMap<String, User> users;

    public UserDAOCollection() {
        users = new HashMap<>();
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public void create(User user) {
        if (findByEmail(user.getEmail()) != null) {
            throw new EntityExistsException();
        }
        users.put(user.getEmail(), user);
    }

    @Override
    public void edit(User user) {
        if (findByEmail(user.getEmail()) == null) {
            throw new IllegalArgumentException();
        }
        users.put(user.getEmail(), user);
    }


    @Override
    public List<User> findAll() {
        return new ArrayList<User>(users.values());
    }

    @Override
    public User findByEmail(String email) {
        return users.get(email);
    }

    @Override
    public void remove(User user) {
        users.remove(user.getEmail());
    }
}
