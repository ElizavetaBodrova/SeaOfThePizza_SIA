package lizun.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="POINT")
public class Point {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="Adress")
    private String address;
    @Column(name="Phone")
    private String phone;

}

