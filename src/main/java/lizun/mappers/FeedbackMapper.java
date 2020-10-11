package lizun.mappers;

import lizun.dto.FeedbackDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {

    Integer insertNew(@Param("feedback") FeedbackDto feedback);

    List<FeedbackDto> getFeedbacks();
}
