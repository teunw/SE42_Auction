package auction.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * Created by Wouter on 20-6-2016.
 */
@Entity
//@XmlRootElement
@Embeddable
public class Doekoes implements  Comparable {

    public static final String EURO = "\u20AC";
    private static final long serialVersionUID = 1L;
    private String currency;
    private long cents;
    
    private Doekoes() {
        currency = "undefined";
    }

    public Doekoes(long cents, String currency) {
        if (currency.equals(""))
            throw new RuntimeException("currency may not be the empty string");

        this.cents = cents;
        this.currency = currency;
    }

    public static Doekoes difference(Doekoes m1, Doekoes m2) {
        return new Doekoes(m1.cents - m2.cents, m1.currency);
    }

    public static Doekoes sum(Doekoes m1, Doekoes m2) {
        return new Doekoes(m1.cents + m2.cents, m1.currency);
    }

    public static Doekoes negativeValueOf(Doekoes m) {
        return new Doekoes(-m.cents, m.currency);
    }

  
    public boolean equals(Object o) {
        if (!(o instanceof Doekoes))
            return false;
        Doekoes m = (Doekoes) o;
        return this.currency.equals(m.currency) && this.cents == m.cents;
    }

    public int compareTo(Object o) {
        Doekoes m = (Doekoes) o;
        if (!this.currency.equals(m.currency))
            throw new RuntimeException("vergelijken van twee money-objecten met " +
                    "verschillende munteenheid is nog niet geimplementeerd");
        if (this.cents == m.cents) return 0;
        else if (this.cents < m.cents) return -1;
        else return +1;
    }

    public String toString() {

        return currency + " " + getValue();
    }
    
    public boolean isPositive() {
        return cents > 0;
    }

    public String getCurrency() {
        return currency;
    }

    public String getValue() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(((double) cents) / 100);
    }

    public long getCents() {
        return cents;
    }


    public static String getEURO() {
        return EURO;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCents(long cents) {
        this.cents = cents;
    }
}
