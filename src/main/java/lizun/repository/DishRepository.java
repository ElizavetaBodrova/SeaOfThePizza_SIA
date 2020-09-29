package lizun.repository;

import lizun.model.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {
}
