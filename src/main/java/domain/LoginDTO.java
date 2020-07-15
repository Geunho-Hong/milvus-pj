package domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {

    private String userId;
    private String pw;

    public LoginDTO(String userId, String pw){
        this.userId = userId;
        this.pw = pw;
    }
}
