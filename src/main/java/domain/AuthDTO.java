package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AuthDTO {

    private String userId;
    private String auth;

    public AuthDTO(String userId, String auth){
        this.userId = userId;
        this.auth = auth;
    }
}
