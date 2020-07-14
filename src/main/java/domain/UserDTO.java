package domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.sql.Date;

@Getter
@Setter
@ToString
public class UserDTO {

    private String userId;
    private String pw;
    private String name;
    //private Date joinDate;

    public UserDTO(String userId, String pw , String name){
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        //this.joinDate = joinDate;
    }


}
