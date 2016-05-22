package auction.dao;

import auction.domain.User;

import javax.persistence.*;
import java.util.List;

public class UserDAOJPA implements UserDAO {

    private EntityManager em;
    public UserDAOJPA() {
        em = Persistence.createEntityManagerFactory("auctionPU").createEntityManager();
    }

    @Override
    public int count() {
        Query q = em.createQuery("select u.id from User u");
        Object count = q.getSingleResult();
        return (int)count;
    }

    @Override
    public void create(User user) {
        if (findByEmail(user.getEmail()) != null) {
            throw new EntityExistsException();
        }
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void edit(User user) {
        User dbUser = findByEmail(user.getEmail());
        if (dbUser == null) {
            throw new IllegalArgumentException();
        }
        em.getTransaction().begin();
        dbUser.setEmail(user.getEmail());
//        dbUser = user;//might work, no idea so i;m trying this for now
        em.persist(dbUser);
        em.getTransaction().commit();
    }


    @Override
    public List<User> findAll() {
        Query q = em.createQuery("select u from User u");
        List<User> userList = q.getResultList();
        return userList;
    }

    @Override
    public User findByEmail(String email) {
        Query q = em.createQuery("select u from User u where u.email = :email ");
        q.setParameter("email",email);
        User user;
        try {
            user = (User) q.getSingleResult();
        }catch (NoResultException nr){
            return null;
        }
        return user;
    }

    @Override
    public void remove(User user) {
        em.getTransaction().begin();
        User dbUser = findByEmail(user.getEmail());
        em.remove(dbUser);
        em.getTransaction().commit();
    }

    @Override
    public void removeAll() {
        em.getTransaction().begin();
        for (User u : findAll()) {
            em.remove(u);
        }
        em.getTransaction().commit();
    }
}
