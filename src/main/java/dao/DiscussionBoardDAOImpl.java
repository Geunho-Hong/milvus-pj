package dao;

import domain.DiscussionBoardDTO;
import domain.DiscussionReplyDTO;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import service.Criteria;
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
        return sqlSession.update(namespace + ".update",discussionBoardDTO);
    }

    public int delete(int bno) {
        return sqlSession.delete(namespace + ".delete",bno);
    }

    public int hit(int bno) {
        return sqlSession.update(namespace + ".boardHit",bno);
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

    public void insertReply(DiscussionReplyDTO discussionReplyBoardDTO) {
        log.info("DAO insertReply "  + discussionReplyBoardDTO.toString());
        sqlSession.insert(namespace + ".insertReply",discussionReplyBoardDTO);
    }

    public List<DiscussionReplyDTO> getReplyList(int bno){
        List<DiscussionReplyDTO> getReplyList = sqlSession.selectList(namespace + ".getReplyList",bno);
        log.info("조회 댓글 리스트 " + getReplyList);
        return getReplyList;
    }

    public void deleteReply(int rno) {
        log.info ("삭제할 댓글 번호 " + rno);
        sqlSession.delete(namespace + ".deleteReply",rno);
    }

}
