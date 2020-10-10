package lizun.controller;

import lizun.dto.OrderDto;
import lizun.model.Customer;
import lizun.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addOrder(@RequestBody OrderDto orderDto){
        return orderService.addOrder(orderDto);
    }
}
