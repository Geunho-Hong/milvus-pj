package service;

import domain.Criteria;
import domain.LoginDTO;
import domain.UserDTO;
import java.util.List;


public interface UserService {

    public UserDTO login(LoginDTO loginDTO);

    public int insertMember(UserDTO userDTO);

    public UserDTO getUserId(UserDTO userDTO);

    public boolean getUserPw(UserDTO userDTO);

    public int deleteAllMember(String string);

    public int changeUserPw(UserDTO userDTO);

    public List<UserDTO> getUserList(Criteria cri);

    public int totalCount(Criteria cri);

}
