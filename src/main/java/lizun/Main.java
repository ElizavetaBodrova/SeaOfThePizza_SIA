package lizun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("lizun.mappers")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
