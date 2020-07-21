package service;

import dao.UserDAO;
import domain.LoginDTO;
import domain.UserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.Criteria;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDAO userDAO,BCryptPasswordEncoder passwordEncoder){
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO login(LoginDTO loginDTO) {
        log.info("LoginDTO " + loginDTO);
        UserDTO loginUser = userDAO.login(loginDTO);
        String rawPw = loginUser.getPw();
        log.info("RawPw " + rawPw);
        log.info("Login Data " + loginUser);
        if(passwordEncoder.matches(loginDTO.getPw(),loginUser.getPw())){
            log.info("계정 정보 일치");
            return userDAO.login(loginDTO);
        }else{
            log.info("계정 정보 불일치");
            return null;
        }
    }

    public int insertMember(UserDTO userDTO) {
        int answer = 0;
        String encyptPassword = passwordEncoder.encode(userDTO.getPw());
        log.info("암호화 비밀번호 " + encyptPassword);
        UserDTO registerUser = userDTO.builder()
                .userId(userDTO.getUserId())
                .pw(encyptPassword)
                .name(userDTO.getName())
                .build();
        userDAO.insertMember(registerUser);
        userDAO.insertAuth(userDTO);
        log.info("InsertUser ");
        return answer = 1;
    }

    public UserDTO getUserId(UserDTO userDTO) {
        return userDAO.getUserId(userDTO);
    }

    public int deleteAllMember(String string) {
        userDAO.deleteAllMember(string);
        return 1;
    }

    public boolean checkPw(UserDTO currentUser, String currentPw) {
        String getPassword = userDAO.getUserPassword(currentUser);
        log.info("CurrentPw " + currentPw); // currentPw는 input창에 입력한 비밀번호.
        log.info("Service checkPw " + getPassword);
        return getPassword.equals(currentPw);
    }

    public int changePw(UserDTO currentUser, String changePw) {
        Map<String,Object> userMap = new HashMap<String, Object>();
        userMap.put("userId",currentUser.getUserId());
        userMap.put("pw",changePw);
        return userDAO.changePw(userMap);
    }

    public List<UserDTO> getUserList(Criteria cri) {
        return userDAO.getUserList(cri);
    }

    public int totalCount(Criteria cri) {
        return userDAO.totalCount(cri);
    }
}
