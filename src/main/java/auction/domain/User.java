package auction.domain;


import javax.persistence.*;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    public Long id;

    private String email;
    @OneToMany
    private Set<Item> offeredItems;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Iterator<Item> getOfferedItems() {
        return offeredItems.iterator();
    }

    public int getAmountOfferedItems() {
        return offeredItems.size();
    }

    private void addItem(Item item) {
        offeredItems.add(item);
    }
}
