package lizun.controller;

import lizun.dto.FeedbackDto;
import lizun.service.FeedbackService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FeedbackController {
    private FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @ResponseBody
    @RequestMapping(value = "/newF", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer addNewFeedback(@RequestBody FeedbackDto feedbackDto) {
        return feedbackService.addNewFeedback(feedbackDto);
    }

    @ResponseBody
    @RequestMapping(value = "/feedbacks", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FeedbackDto> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }
}
