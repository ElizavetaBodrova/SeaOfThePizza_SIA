package lizun.service;

import lizun.dto.FeedbackDto;
import lizun.mappers.CustomerMapper;
import lizun.mappers.FeedbackMapper;
import lizun.mappers.OrderMapper;
import lizun.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private FeedbackMapper feedbackMapper;
    private OrderMapper orderMapper;
    private CustomerService customerService;

    public FeedbackService(FeedbackMapper feedbackMapper, OrderMapper orderMapper,CustomerService customerService) {
        this.feedbackMapper = feedbackMapper;
        this.orderMapper = orderMapper;
        this.customerService = customerService;

    }


    public Integer addNewFeedback(FeedbackDto feedbackDto) {
        Integer id = 0;
        Customer customer = customerService.getCustomerByPhone(feedbackDto.getPhone());
        if (orderMapper.isOrderExist(feedbackDto.getOrder(), customer.getId()) != null) {
            id = feedbackMapper.insertNew(feedbackDto);
            System.out.println(id);
        }
        return id;
    }

    public List<FeedbackDto> getAllFeedbacks() {
        return feedbackMapper.getFeedbacks();
    }

}
