package lizun.dto;


import lizun.model.Dish;
import lizun.model.Point;
import lizun.model.TypeOfDelivery;

import java.util.List;

public class OrderDto {
   private List<Dish> order;
   private List<Integer> numberOfDish;
   private TypeOfDelivery typeOfDelivery;
   private Point point;

    public List<Dish> getOrder() {
        return order;
    }

    public void setOrder(List<Dish> order) {
        this.order = order;
    }

    public List<Integer> getNumberOfDish() {
        return numberOfDish;
    }

    public void setNumberOfDish(List<Integer> numberOfDish) {
        this.numberOfDish = numberOfDish;
    }

    public TypeOfDelivery getTypeOfDelivery() {
        return typeOfDelivery;
    }

    public void setTypeOfDelivery(TypeOfDelivery typeOfDelivery) {
        this.typeOfDelivery = typeOfDelivery;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
