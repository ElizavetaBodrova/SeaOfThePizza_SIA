package lizun.mappers;

import lizun.Main;
import lizun.PersistenceConfig;
import lizun.model.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class,
        initializers = ConfigFileApplicationContextInitializer.class)
//@SpringBootTest
public class DishMapperTest {

    @Autowired
    private DishMapper dishMapper;

    @Test
    public void testDishMapper() {
        List<Dish> dishes = dishMapper.getDishByGroupName("Пицца");
        for (int i = 0; i < dishes.size(); i++) {
            System.out.println(dishes.get(i).getName() + " " + dishes.get(i).getPrice());
        }
    }
}