package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DiscussionReplyDTO {

    private int rno;
    private int bno;
    private String content;
    private String userId;
    private Date regdate;


    public DiscussionReplyDTO(int rno, int bno, String content, String userId, Date regdate) {
        this.rno = rno;
        this.bno = bno;
        this.content = content;
        this.userId = userId;
        this.regdate = regdate;
    }
}
