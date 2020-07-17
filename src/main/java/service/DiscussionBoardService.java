package service;

import domain.Criteria;
import domain.DiscussionBoardDTO;
import domain.DiscussionReplyDTO;

import java.util.List;

public interface DiscussionBoardService {

    public void write(DiscussionBoardDTO discussionBoardDTO);

    public DiscussionBoardDTO read(int bno);

    public int modify(DiscussionBoardDTO discussionBoardDTO);

    public int delete(int bno);

    public int hit(DiscussionBoardDTO discussionBoardDTO);

    public int countBoard(Criteria cri);

    public List<DiscussionBoardDTO> getListWithPaging(Criteria cri);

    public void insertReply(DiscussionReplyDTO discussionReplyBoardDTO);

    public void deleteReply(int rno);

    public List<DiscussionReplyDTO> getReplyList(int bno);
}
