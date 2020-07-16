package domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.sql.Date;

@Getter
@Setter
@ToString
public class DiscussionBoardDTO {

    private Integer bno;
    private String userId;
    private String title;
    private String content;
    private Date regdate;
    private Integer pw;

    public DiscussionBoardDTO(Integer bno, String userId, String title, String content, Date regdate, Integer pw){
        this.bno = bno;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.regdate = regdate;
        this.pw = pw;
    }

}
