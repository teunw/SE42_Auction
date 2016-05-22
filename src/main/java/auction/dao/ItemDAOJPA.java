package auction.dao;

import auction.domain.Item;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Teun on 22/05/2016.
 */
public class ItemDAOJPA implements ItemDAO {

    private EntityManager em;

    public ItemDAOJPA() {
        em = Persistence.createEntityManagerFactory("auctionPU").createEntityManager();
    }

    @Override
    public int count() {
        Query q = em.createQuery("select count(i.id) from Item i");
        return (int) q.getSingleResult();
    }

    @Override
    public void create(Item item) {
        if (item.getId() != null) {
            throw new EntityExistsException();
        }
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    @Override
    public void edit(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    @Override
    public Item find(Long id) {
        Query q = em.createQuery("select i from Item i where i.id = :id");
        q.setParameter("id", id);
        Item item;
        try {
            item = (Item) q.getSingleResult();
        } catch (NoResultException nr) {
            return null;
        }
        return item;
    }

    @Override
    public List<Item> findAll() {
        Query q = em.createQuery("select i from Item i");
        List<Item> itemList = q.getResultList();
        return itemList;
    }

    @Override
    public List<Item> findByDescription(String description) {
        Query q = em.createQuery("select i from Item i");
        List<Item> items = q.getResultList();
        return items;
    }

    @Override
    public void remove(Item item) {
        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
    }

    @Override
    public void removeAll() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Item i").executeUpdate();
        em.getTransaction().commit();
    }
}
