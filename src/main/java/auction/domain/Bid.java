package auction.domain;

import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bid implements Comparable<Bid> {

    @Id
    @GeneratedValue
    public Long id;

    private FontysTime time;
    @OneToOne
    private User buyer;
    private Money amount;

    public Bid() {
    }

    public Bid(User buyer, Money amount) {
        this.buyer = buyer;
        this.amount = amount;
        this.time = FontysTime.now();
    }

    public FontysTime getTime() {
        return time;
    }

    public User getBuyer() {
        return buyer;
    }

    public Money getAmount() {
        return amount;
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
}
