package lizun.model;


import javax.persistence.*;

@Table(name="FEEDBACK")
public class Feedback {

    @Id
    @Column(name="ID")
    Integer id;
    @Column(name="ID_order")
    Order order;
    @Column(name="Mark")
    Integer mark;
    @Column(name="Comment")
    String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
