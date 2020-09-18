package lizun.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name="GROUPS_DISH")
public class TypeOfDish {

    @javax.persistence.Id
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="Name")
    String name;

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
}
