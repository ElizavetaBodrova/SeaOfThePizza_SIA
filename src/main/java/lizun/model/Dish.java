package lizun.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DISH")
public class Dish {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "Name")
    String name;
    @Column(name = "Price")
    Integer price;
    @ManyToOne
    @JoinColumn(name = "ID_group")
    TypeOfDish group;

}
