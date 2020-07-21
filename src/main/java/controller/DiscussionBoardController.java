package controller;

import domain.DiscussionBoardDTO;
import domain.DiscussionReplyDTO;
import domain.PageDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.Criteria;
import service.DiscussionBoardService;
import java.util.List;

@Log4j
@Controller
@RequestMapping("/discussion")
public class DiscussionBoardController {

    private final DiscussionBoardService discussionBoardService;

    public DiscussionBoardController(DiscussionBoardService discussionBoardService){
        this.discussionBoardService = discussionBoardService;
    }

    @GetMapping("/register")
    public String getWrite(){
        return "/discussion/write";
    }

    @PostMapping("/register")
    public String insertBoard(DiscussionBoardDTO boardDTO){
        log.info("Controller " + boardDTO.toString());
        discussionBoardService.write(boardDTO);
        return "redirect:/discussion/list";
    }

    @GetMapping("/board/{bno}")
    public String detailBoard(@PathVariable String bno, Model model){
        log.info ("조회할 게시판 번호 : " + bno);
        int bnoNum = Integer.parseInt(bno);
        discussionBoardService.hit(bnoNum);
        model.addAttribute("board",discussionBoardService.read(bnoNum));
        return "/discussion/read";
    }

    @GetMapping("/list")
    public String boardList(Criteria cri, Model model){
        model.addAttribute("pageMaker",new PageDTO(cri,discussionBoardService.countBoard(cri)));
        model.addAttribute("list", discussionBoardService.getListWithPaging(cri));
        return "/discussion/list";
    }

    @GetMapping("/board/update/{bno}")
    public String getUpdateBoard(@PathVariable String bno, Model model){
        model.addAttribute("board",discussionBoardService.read(Integer.parseInt(bno)));
        log.info("글이 수정되었습니다");
        return "/discussion/modify";
    }

    @PostMapping("/board/update")
    public String updateBoard(DiscussionBoardDTO discussionBoardDTO){
        log.info("수정할 게시글 번호 " + discussionBoardDTO.getBno());
        discussionBoardService.modify(discussionBoardDTO);
        return "redirect:/discussion/list";
    }

    @GetMapping("/board/delete/{bno}")
    public String deleteBoard(@PathVariable String bno){
        log.info("삭제할 게시글 번호: " + bno);
        int result = discussionBoardService.delete(Integer.parseInt(bno));


        if(result == 1 ){
            log.info("삭제 성공");
        }else{
            log.info("삭제 실패");
        }
        return "redirect:/discussion/list";
    }

    @PostMapping("/board/delete")
    public String deleteBoard2(DiscussionBoardDTO boardDTO){
        log.info("Discussion board delete " + boardDTO.toString());

        return "1";
    }


    @ResponseBody
    @PostMapping("/board/checked/delete")
    public int deleteAllBoard(@RequestParam(value = "checkArr[]") List<String> checkArr){
        log.info("delete Checked Board " + checkArr);

        for(String index : checkArr){
            int bno = Integer.parseInt(index);
            discussionBoardService.delete(bno);
        }
        return 1;
    }

    @ResponseBody
    @PostMapping("/reply/register")
    public void insertReply(@RequestBody DiscussionReplyDTO discussionReplyDTO){
        log.info("insertReply " + discussionReplyDTO.toString());
        discussionBoardService.insertReply(discussionReplyDTO);
    }

    @ResponseBody
    @GetMapping("/reply/{bno}")
    public List<DiscussionReplyDTO> replyList(@PathVariable("bno")int bno){
        log.info("조회할 댓글 게시판 " +  bno);
        return discussionBoardService.getReplyList(bno);
    }

    @ResponseBody
    @PostMapping("/delete/reply/{rno}")
    public ResponseEntity<String> deleteReply(@PathVariable("rno") int rno){
        log.info("Delete Reply" + rno);
        discussionBoardService.deleteReply(rno);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

}
