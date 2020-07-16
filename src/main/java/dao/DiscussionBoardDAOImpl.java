package dao;

import domain.Criteria;
import domain.DiscussionBoardDTO;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import java.util.List;

@Log4j
@Repository
public class DiscussionBoardDAOImpl implements DiscussionBoardDAO {

    private String namespace = "mapper.DiscussionBoardMapper";
    private final SqlSession sqlSession;

    public DiscussionBoardDAOImpl(SqlSession sqlsession){
        this.sqlSession = sqlsession;
    }

    public void write(DiscussionBoardDTO discussionBoardDTO) {
        log.info("DAO Write " + discussionBoardDTO.toString());
        sqlSession.insert(namespace + ".insert",discussionBoardDTO);
    }

    public DiscussionBoardDTO read(int bno) {
        return sqlSession.selectOne(namespace + ".select",bno);
    }

    public int modify(DiscussionBoardDTO discussionBoardDTO) {
        sqlSession.update(namespace + ".update",discussionBoardDTO);
        return 1;
    }

    public int delete(int bno) {
        sqlSession.delete(namespace + ".delete",bno);
        return 1;
    }

    public int hit(DiscussionBoardDTO discussionBoardDTO) {
        return 0;
    }

    public int countBoard(Criteria cri) {
        int totalCount = sqlSession.selectOne(namespace + ".totalCount");
        log.info("Total Count " + totalCount);
        return sqlSession.selectOne(namespace + ".totalCount",cri);
    }

    public List<DiscussionBoardDTO> list() {
        List<DiscussionBoardDTO> boardList = sqlSession.selectList(namespace+".list");
        log.info("Board List" + boardList);
        return boardList;
    }

    public List<DiscussionBoardDTO> getListWithPaging(Criteria cri) {
        log.info(sqlSession.selectList(namespace + ".getListWithPaging",cri));
        return sqlSession.selectList(namespace + ".getListWithPaging",cri);
    }
}
