package auction.service;

import auction.dao.ItemDAO;
import auction.dao.ItemDAOJPA;
import auction.domain.*;

public class SellerManager {

    private ItemDAO itemDAO;

    public SellerManager() {
        itemDAO = new ItemDAOJPA();
    }

    /**
     * @param seller
     * @param cat
     * @param description
     * @return het item aangeboden door seller, behorende tot de categorie cat
     * en met de beschrijving description
     */
    public Item offerItem(User seller, Category cat, String description) {
        Item item = new Item(seller, cat, description);
        itemDAO.create(item);
        seller.addItem(item);
        return item;
    }

    public Painting offerItem(User seller, String painter, String title, Category cat, String description) {
        Painting painting = new Painting(title, painter, seller, cat, description);
        itemDAO.create(painting);
        seller.addItem(painting);
        return painting;
    }

    public Furniture offerItem(User seller, String material, Category cat, String description) {
        Furniture furniture = new Furniture(material, seller, cat, description);
        itemDAO.create(furniture);
        seller.addItem(furniture);
        return furniture;
    }

    /**
     * @param item
     * @return true als er nog niet geboden is op het item. Het item word verwijderd.
     * false als er al geboden was op het item.
     */
    public boolean revokeItem(Item item) {
        if (item.getHighestBid() == null) {
            itemDAO.remove(item);
            return true;
        }
        return false;
    }
}
