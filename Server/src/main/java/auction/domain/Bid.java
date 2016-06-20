package auction.domain;

//import nl.fontys.util.Doekoes;
import nl.fontys.util.FontysTime;
import auction.domain.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Bid implements Comparable<Bid> {

    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private FontysTime time;
    @OneToOne
    private User buyer;
    @Embedded
    private Doekoes amount;
    @OneToOne
    private Item item;
    public Bid() {}

    public Bid(User buyer, Doekoes amount) {
        this.buyer = buyer;
        this.amount = amount;
        this.time = FontysTime.now();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bid)) return false;

        Bid bid = (Bid) o;
        if (getTime() != null ? !getTime().equals(bid.getTime()) : bid.getTime() != null) return false;
        if (getBuyer() != null ? !getBuyer().equals(bid.getBuyer()) : bid.getBuyer() != null) return false;
        return getAmount() != null ? getAmount().equals(bid.getAmount()) : bid.getAmount() == null;

    }

    @Override
    public String toString() {
        return "Bid{" +
                ", time=" + time +
                ", buyer=" + buyer +
                ", amount=" + amount +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 31 * (getTime() != null ? getTime().hashCode() : 0);
        result = 31 * result + (getBuyer() != null ? getBuyer().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Bid o) {
        return this.getAmount().compareTo(o.getAmount());
    }

    public void setId(Long id) { this.id = id; }

    public void setTime(FontysTime time) {
        this.time = time;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setAmount(Doekoes amount) {
        this.amount = amount;
    }

    public Long getId() { return id; }

    public FontysTime getTime() {
        return time;
    }

    public User getBuyer() {
        return buyer;
    }

    public Doekoes getAmount() {
        return amount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }



}
