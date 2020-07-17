package dao;

import domain.Criteria;
import domain.LoginDTO;
import domain.UserDTO;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        log.info("DAO "  + userDTO.toString());
        return sqlSession.selectOne(namespace + ".getUserId",userDTO);
    }

    public boolean getUserPw(UserDTO userDTO) {
        return false;
    }

    public int deleteAllMember(String userId) {
        sqlSession.delete(namespace +".deleteAllMember",userId);
        return 1;
    }

    public int changeUserPw(UserDTO userDTO) {
        sqlSession.update(namespace + ".changePw",userDTO);
        return 1;
    }

    public List<UserDTO> getUserList(Criteria cri) {
        return sqlSession.selectList(namespace + ".getUserList",cri);
    }

    public int totalCount(Criteria cri) {
        log.info("총 유저의 수");
        return sqlSession.selectOne(namespace +".totalCount",cri);
    }
}
