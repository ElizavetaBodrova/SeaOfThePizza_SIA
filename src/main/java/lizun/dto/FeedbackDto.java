package lizun.dto;

import javax.persistence.Column;

public class FeedbackDto {
    private Integer mark;
    private String comment;

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
