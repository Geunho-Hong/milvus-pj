package service;

import dao.UserDAO;
import domain.LoginDTO;
import domain.UserDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

/*
 *  Constructor Based Injection 장점
 *  1. 의존관계 설정이 되지 않으면 객체 생성 불가능 -> 컴파일 타임에 인지 가능
 *  (ex) A라는 객체 생성시 , B라는 객체에 오류가 있으면, 아예 생성되지 않는다.
 *  2. 의존성 주입이 필요한 필드를 final로 선언하여 객체를 immutable 하게 만든다.
 *
 */

@Log4j
@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public UserDTO login(LoginDTO loginDTO) {
        log.info("Login Data " + userDAO.login(loginDTO));
        return userDAO.login(loginDTO);
    }

    public int insertMember(UserDTO userDTO) {
        int answer = 0;
        userDAO.insertMember(userDTO);
        return answer = 1;
    }

    public UserDTO getUserId(UserDTO userDTO) {
        return userDTO;
    }

    public boolean getUserPw(UserDTO userDTO) {
        return false;
    }

    public int deleteMember(UserDTO userDTO) {
        return 0;
    }

    public int changeUserPw(UserDTO userDTO) {
        return 0;
    }
}
