package dao;

import domain.DiscussionBoardDTO;
import domain.DiscussionReplyDTO;
import service.Criteria;
import java.util.List;

public interface DiscussionBoardDAO {

    public void write(DiscussionBoardDTO discussionBoardDTO);

    public DiscussionBoardDTO read(int bno);

    public int modify(DiscussionBoardDTO discussionBoardDTO);

    public int delete(int bno);

    public int hit(int bno);

    public int countBoard(Criteria cri);

    public List<DiscussionBoardDTO> list();

    public List<DiscussionBoardDTO> getListWithPaging(Criteria cri);

    public void insertReply(DiscussionReplyDTO discussionReplyBoardDTO);

    public List<DiscussionReplyDTO> getReplyList(int bno);

    public void deleteReply(int rno);


}
