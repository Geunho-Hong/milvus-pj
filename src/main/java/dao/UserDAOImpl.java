package dao;

import domain.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl {

    private String namespace = "mapper.UserMapper";

    @Autowired
    private SqlSession sqlSession;

    public void insertMember(UserDTO userDTO){
        System.out.println("inserMember Start " + userDTO);
        sqlSession.insert(namespace + ".insertMember",userDTO);
        System.out.println("insert Member Finish");
    }
}
