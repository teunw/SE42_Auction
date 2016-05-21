package auction.service;

import auction.domain.Bid;
import auction.domain.Item;
import auction.domain.User;
import nl.fontys.util.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AuctionManager {

    private List<Item> items;

    public AuctionManager() {
        items = new ArrayList<>();
    }

    /**
     * @param id
     * @return het item met deze id; als dit item niet bekend is wordt er null
     * geretourneerd
     */
    public Item getItem(Long id) {
        for (Item i : items) {
            if (Objects.equals(i.getId(), id)) {
                return i;
            }
        }
        return null;
    }


    /**
     * @param description
     * @return een lijst met items met @desciption. Eventueel lege lijst.
     */
    public List<Item> findItemByDescription(String description) {
        List<Item> items = new ArrayList<>();
        for (Item i : items) {
            if (Objects.equals(i.getDescription(), description)) {
                items.add(i);
            }
        }
        return items;
    }

    /**
     * @param item
     * @param buyer
     * @param amount
     * @return het nieuwe bod ter hoogte van amount op item door buyer, tenzij
     * amount niet hoger was dan het laatste bod, dan null
     */
    public Bid newBid(Item item, User buyer, Money amount) {
        if (item.getHighestBid().getAmount().compareTo(amount) > 0) {
            return item.newBid(buyer, amount);
        }
        return null;
    }
}
