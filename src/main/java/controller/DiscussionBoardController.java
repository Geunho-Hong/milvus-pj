package controller;

import domain.DiscussionBoardDTO;
import domain.DiscussionReplyDTO;
import domain.PageDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.Criteria;
import service.DiscussionBoardService;

import java.security.Principal;
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
    public String detailBoard(@PathVariable String bno, Model model,
                              Principal principal){
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

    /*@GetMapping("/board/update/{bno}")
    public String getUpdateBoard(@PathVariable String bno, Model model,Principal principal,
                                 Authentication auth){
        log.info("조회 게시판 번호 " + bno);

        model.addAttribute("board",discussionBoardService.read(Integer.parseInt(bno)));
        log.info("글이 수정되었습니다");
        return "/discussion/modify";
    }*/

    @GetMapping("/board/update")
    public String getUpdateBoard(DiscussionBoardDTO boardDTO,Principal principal,
                                 Authentication auth,Model model){
        String authUser = auth.getAuthorities().toString();

        log.info("게시글 작성자 게시글 번호 " + boardDTO.getUserId());
        log.info("현재 접속 유저 " + principal.getName());
        log.info("사용자 권한 " + authUser);

        if(boardDTO.getUserId().equals(principal.getName())
                || authUser.equals("[ROLE_ADMIN]")){
            /*
             현재 접속한 사용자와 게시글의 작성자가 같거나 ADMIN 일
             경우만 수정페이지에 조회한다.
             */
            model.addAttribute("board",discussionBoardService.read(boardDTO.getBno()));
            log.info("수정 페이지 접속");
            return "/discussion/modify";

        }else{
            return "redirect:/accessError";
        }
    }

    @PostMapping("/board/update")
    public String updateBoard(DiscussionBoardDTO boardDTO,Principal principal,
                              Authentication auth){
        String authUser = auth.getAuthorities().toString();

        log.info("게시글 작성자 게시글 번호 " + boardDTO.getUserId());
        log.info("현재 접속 유저 " + principal.getName());
        log.info("사용자 권한 " + authUser);

        if(boardDTO.getUserId().equals(principal.getName())
                || authUser.equals("[ROLE_ADMIN]")){
            // 현재 접속한 사용자와 게시글의 작성자가 같거나 ADMIN 일 경우만 수정한다.
            log.info("Success Modify");
            discussionBoardService.modify(boardDTO);
            return "redirect:/discussion/list";
        }else{
            return "redirect:/accessError";
        }
    }

    @PostMapping("/board/delete")
    public String deleteBoard(DiscussionBoardDTO boardDTO, Principal principal,
                               Authentication auth){

        String authUser = auth.getAuthorities().toString();

        log.info("게시글 작성자 " + boardDTO.getUserId());
        log.info("현재 접속 유저 " + principal.getName());
        log.info("사용자 권한 " + authUser);

        if(boardDTO.getUserId().equals(principal.getName())
            || authUser.equals("[ROLE_ADMIN]")){
            // 현재 접속한 사용자와 게시글의 작성자가 같거나 ADMIN 일 경우만 삭제한다.
            discussionBoardService.delete(boardDTO.getBno());
            log.info("Success Delete");
            return "redirect:/discussion/list";
        }else{
            return "redirect:/accessError";
        }
    }

  /*  @GetMapping("/board/delete/{bno}")
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
*/

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
