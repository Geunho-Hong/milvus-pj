package dao;

import domain.LoginDTO;
import domain.UserDTO;
import service.Criteria;
import java.util.List;
import java.util.Map;


public interface UserDAO {

    public UserDTO login(LoginDTO loginDTO);

    public int insertMember(UserDTO userDTO);

    public UserDTO getUserId(UserDTO userDTO);

    public String getUserPassword(UserDTO userDTO);

    public int deleteAllMember(String userId);

    public int changePw(Map<String,Object> userMap);

    public List<UserDTO> getUserList(Criteria cri);

    public int totalCount(Criteria cri);
}
