package dao;

import domain.Criteria;
import domain.LoginDTO;
import domain.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserDAO {

    public UserDTO login(LoginDTO loginDTO);

    public int insertMember(UserDTO userDTO);

    public UserDTO getUserId(UserDTO userDTO);

    public boolean getUserPw(UserDTO userDTO);

    public int deleteAllMember(String userId);

    public int changeUserPw(UserDTO userDTO);

    public List<UserDTO> getUserList(Criteria cri);

    public int totalCount(Criteria cri);
}
