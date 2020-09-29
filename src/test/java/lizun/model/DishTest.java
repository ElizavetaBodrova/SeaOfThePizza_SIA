package lizun.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class DishTest {
    @Test
    public void testGetDishID(){
        Dish dish=new Dish();
        System.out.println(dish.getId());
    }

}