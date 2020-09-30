package lizun.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Table(name="ORDER")
public class Order {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="Phone_client")
    private String phone;
    @ManyToOne
    @Column(name="ID_point")
    private TypeOfDelivery type;
    @ManyToOne
    @Column(name="ID_type")
    private Point point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TypeOfDelivery getType() {
        return type;
    }

    public void setType(TypeOfDelivery type) {
        this.type = type;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
