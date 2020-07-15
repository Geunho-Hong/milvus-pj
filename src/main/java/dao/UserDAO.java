package dao;

import domain.LoginDTO;
import domain.UserDTO;

public interface UserDAO {

    public UserDTO login(LoginDTO loginDTO);

    public int insertMember(UserDTO userDTO);

    public UserDTO getUserId(UserDTO userDTO);

    public boolean getUserPw(UserDTO userDTO);

    public int deleteMember(UserDTO userDTO);

    public int changeUserPw(UserDTO userDTO);

}
