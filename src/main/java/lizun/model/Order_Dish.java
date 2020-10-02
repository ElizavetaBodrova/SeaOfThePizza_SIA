package lizun.model;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "ORDER_DISH")
public class Order_Dish {
    @ManyToMany
    @Column(name = "id_order")
   private Order order;
    @Column(name = "id_dish")
    private Dish dish;
    @Column(name = "count")
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
