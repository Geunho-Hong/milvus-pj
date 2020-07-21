package service;

import dao.DiscussionBoardDAO;
import domain.DiscussionBoardDTO;
import domain.DiscussionReplyDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Log4j
@Service
public class DiscussionBoardServiceImpl implements DiscussionBoardService {

    private final DiscussionBoardDAO discussionBoardDAO;

    public DiscussionBoardServiceImpl(DiscussionBoardDAO discussionBoardDAO){
        this.discussionBoardDAO = discussionBoardDAO;
    }

    public void write(DiscussionBoardDTO discussionBoardDTO) {
        log.info("Service Write " + discussionBoardDTO.toString());
        discussionBoardDAO.write(discussionBoardDTO);
    }

    public DiscussionBoardDTO read(int bno) {
        DiscussionBoardDTO detailBoard = discussionBoardDAO.read(bno);
        log.info("Service read " + detailBoard);
        return detailBoard;
    }

    public int modify(DiscussionBoardDTO discussionBoardDTO) {
        return discussionBoardDAO.modify(discussionBoardDTO);
    }

    public int delete(int bno) {
       return discussionBoardDAO.delete(bno);
    }

    public int hit(int bno) {
        return discussionBoardDAO.hit(bno);
    }

    public int countBoard(Criteria cri){
        return discussionBoardDAO.countBoard(cri);
    }

    public List<DiscussionBoardDTO> list() {
        log.info("Service List ");
        return discussionBoardDAO.list();
    }

    public List<DiscussionBoardDTO> getListWithPaging(Criteria cri) {
        return discussionBoardDAO.getListWithPaging(cri);
    }

    public void insertReply(DiscussionReplyDTO discussionReplyBoardDTO) {
        log.info("disCuss " + discussionReplyBoardDTO.toString());
        discussionBoardDAO.insertReply(discussionReplyBoardDTO);
    }

    public void deleteReply(int rno) {
        discussionBoardDAO.deleteReply(rno);
    }

    public List<DiscussionReplyDTO> getReplyList(int bno) {
       return discussionBoardDAO.getReplyList(bno);
    }
}
