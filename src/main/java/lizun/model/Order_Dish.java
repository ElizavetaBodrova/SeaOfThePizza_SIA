package lizun.model;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "ORDER_DISH")
public class Order_Dish {
    @ManyToMany
    @Column(name = "ID_ORDER")
    private Order order;
    @ManyToMany
    @Column(name = "ID_DISH")
    private Dish dish;
    @Column(name = "Count")
    private int count;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
