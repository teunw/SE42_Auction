package auction.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    public Long id;

    private String email;

    public User() {
        this.email = null;
    }

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
