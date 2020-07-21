package domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {

    private String userId;
    private String pw;
    private String name;
    private Date join_date;
    private Integer auth;
    private String profileImg;

    @Builder
    public UserDTO(String userId, String pw, String name ,Date join_date ,Integer auth
            ,String profileImg){
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.join_date = join_date;
        this.auth = auth;
        this.profileImg = profileImg;
    }

}
