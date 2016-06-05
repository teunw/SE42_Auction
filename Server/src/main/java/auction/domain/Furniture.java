package auction.domain;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Created by Teun on 29/05/2016.
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Furniture extends Item {

    private String material;

    public Furniture(String material, User seller, Category category, String description) {
        super(seller, category, description);
        this.material = material;
    }

    public Furniture() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
