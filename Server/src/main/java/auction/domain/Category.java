package auction.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @Id
    @GeneratedValue
    public Long Id;

    private String description;

    public Category() {

    }

    public Category(String description) {
        this.description = description;
    }

    public String getDiscription() {
        return description;
    }
}
