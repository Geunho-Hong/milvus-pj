package dao;

import domain.AuthDTO;
import domain.LoginDTO;
import domain.UserDTO;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import service.Criteria;
import java.util.List;
import java.util.Map;

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
        return sqlSession.insert(namespace + ".insertMember",userDTO);
    }

    @Override
    public int insertAuth(UserDTO userDTO) {
        AuthDTO authUser = new AuthDTO(userDTO.getUserId(),"ROLE_MEMBER");
        return sqlSession.insert(namespace + ".insertAuth",authUser);
    }

    public UserDTO getUserId(UserDTO userDTO) {
        log.info("DAO "  + userDTO.toString());
        return sqlSession.selectOne(namespace + ".getUserId",userDTO);
    }

    public String getUserPassword(UserDTO userDTO) {
        log.info("DAO GetUserPW " + sqlSession.selectOne(namespace+".checkPw",userDTO));
        return sqlSession.selectOne(namespace+".checkPw",userDTO);
    }

    public int deleteAllMember(String userId) {
        return sqlSession.delete(namespace +".deleteAllMember",userId);
    }

    public int changePw(Map<String, Object> userMap) {
        int result = 0;
        log.info("DAO changePw " + userMap);
        return sqlSession.update(namespace + ".changePw",userMap);
    }

    public List<UserDTO> getUserList(Criteria cri) {
        return sqlSession.selectList(namespace + ".getUserList",cri);
    }

    public int totalCount(Criteria cri) {
        log.info("총 유저의 수");
        return sqlSession.selectOne(namespace +".totalCount",cri);
    }
}
