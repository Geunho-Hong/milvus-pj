package dao;

import domain.Criteria;
import domain.DiscussionBoardDTO;
import java.util.List;

public interface DiscussionBoardDAO {

    public void write(DiscussionBoardDTO discussionBoardDTO);

    public DiscussionBoardDTO read(int bno);

    public int modify(DiscussionBoardDTO discussionBoardDTO);

    public int delete(int bno);

    public int hit(DiscussionBoardDTO discussionBoardDTO);

    public int countBoard(Criteria cri);

    public List<DiscussionBoardDTO> list();

    public List<DiscussionBoardDTO> getListWithPaging(Criteria cri);

}
