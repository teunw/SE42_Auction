package auction.domain;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name="users")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @Id
    @GeneratedValue
    public Long id;

    private String email;
    @OneToMany
    private Set<Item> offeredItems = new HashSet<>();

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

    public void addItem(Item item) {
        offeredItems.add(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        return getOfferedItems() != null ? getOfferedItems().equals(user.getOfferedItems()) : user.getOfferedItems() == null;

    }

    @Override
    public int hashCode() {
        int result = getEmail() != null ? getEmail().hashCode() : 0;
        result = 31 * result + (getOfferedItems() != null ? getOfferedItems().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", offeredItems=" + offeredItems +
                '}';
    }
}
