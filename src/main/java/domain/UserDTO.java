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
    private Date join_date;
    private int auth;

    public UserDTO(String userId, String pw , String name,Date join_date,int auth){
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.join_date = join_date;
        this.auth = auth;
    }

}
