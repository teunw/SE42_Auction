package auction.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    public Long Id;

    private String description;

    public Category() {
        description = null;
    }

    public Category(String description) {
        this.description = description;
    }

    public String getDiscription() {
        return description;
    }
}
