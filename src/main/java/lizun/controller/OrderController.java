package lizun.controller;

import lizun.dto.OrderDto;
import lizun.dto.OrdersDto;
import lizun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer addOrder(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }
    @ResponseBody
    @RequestMapping(value = "/lastOrder", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrdersDto> addLastOrder(@RequestBody String phone) {
        return orderService.getLastOrderByIDCustomer(phone);
    }
}
