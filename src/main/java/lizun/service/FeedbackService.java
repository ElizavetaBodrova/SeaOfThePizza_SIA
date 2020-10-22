package lizun.service;

import lizun.dto.FeedbackDto;
import lizun.mappers.FeedbackMapper;
import lizun.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private FeedbackMapper feedbackMapper;
    private OrderMapper orderMapper;

    public FeedbackService(FeedbackMapper feedbackMapper, OrderMapper orderMapper) {
        this.feedbackMapper = feedbackMapper;
        this.orderMapper = orderMapper;

    }


    public Integer addNewFeedback(FeedbackDto feedbackDto) {
        Integer id = 0;
        if (orderMapper.isOrderExist(feedbackDto.getOrder(), feedbackDto.getPhone()) != null) {
            id = feedbackMapper.insertNew(feedbackDto);
            System.out.println(id);
        }
        return id;
    }

    public List<FeedbackDto> getAllFeedbacks() {
        return feedbackMapper.getFeedbacks();
    }
}
