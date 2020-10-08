package lizun.mappers;

import lizun.dto.FeedbackDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {

    FeedbackDto insertNew(@Param("feedback") FeedbackDto feedback);

    List<FeedbackDto> getFeedbacks();
}
