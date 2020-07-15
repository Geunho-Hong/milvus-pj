package dao;

import domain.LoginDTO;
import domain.UserDTO;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Log4j
@Repository
public class UserDAOImpl implements UserDAO {

    private String namespace = "mapper.UserMapper";

    private final SqlSession sqlSession;

    public UserDAOImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public UserDTO login(LoginDTO loginDTO) {
        return sqlSession.selectOne(namespace + ".login",loginDTO);
    }

    public int insertMember(UserDTO userDTO){
        log.info("insertMember " + userDTO);
        sqlSession.insert(namespace + ".insertMember",userDTO);
        return 1;
    }

    public UserDTO getUserId(UserDTO userDTO) {
        return null;
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
