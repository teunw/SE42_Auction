package auction.domain;

import nl.fontys.util.Money;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements Comparable {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(targetEntity = User.class)
    private User seller;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Category category;
    private String description;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Bid highest;

    public Item() {

    }

    public Item(User seller, Category category, String description) {
        this.seller = seller;
        this.category = category;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public User getSeller() {
        return seller;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highest;
    }

    public Bid newBid(User buyer, Money amount) {
        if (highest != null && highest.getAmount().compareTo(amount) >= 0) {
            return null;
        }
        highest = new Bid(buyer, amount);
        highest.setItem(this);
        return highest;
    }

    @Override
    public int compareTo(Object o) {
        Item item;
        try {
            item = (Item) o;
        } catch (ClassCastException e) {
            return 0;
        }
        if (getHighestBid() == null)
            return 0;
        return item.getHighestBid().getAmount().compareTo(this.getHighestBid().getAmount());
    }

    public boolean equals(Object o) {
        Item item;
        try {
            item = (Item) o;
        } catch (ClassCastException e) {
            return false;
        }
        return item.compareTo(this) == 0;
    }

    @Override
    public int hashCode() {
        Long id = (getId() != null) ? getId() : -1;
        int result = id.hashCode();
        result = 31 * result + getSeller().hashCode();
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + getDescription().hashCode();
        if (highest != null)
            result = 31 * result + highest.hashCode();
        return result;
    }
}
