package service;

import domain.LoginDTO;
import domain.UserDTO;
import service.Criteria;
import java.util.List;


public interface UserService {

    public UserDTO login(LoginDTO loginDTO);

    public int insertMember(UserDTO userDTO);

    public UserDTO getUserId(UserDTO userDTO);

    public int deleteAllMember(String string);

    public List<UserDTO> getUserList(Criteria cri);

    public int totalCount(Criteria cri);

    public boolean checkPw(UserDTO currentUser,String currentPw);

    public int changePw(UserDTO currentUser,String changePw);

}
