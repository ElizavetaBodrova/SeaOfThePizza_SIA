package lizun.model;

import javax.persistence.*;



@Table(name="DISH")
public class Dish {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="Name")
    String name;
    @Column(name="Price")
    Integer price;
    @Column(name = "ID_group")
    TypeOfDish group;

    public TypeOfDish getGroup() {
        return group;
    }

    public void setGroup(TypeOfDish group) {
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
