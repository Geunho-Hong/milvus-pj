package controller;

import domain.Criteria;
import domain.LoginDTO;
import domain.PageDTO;
import domain.UserDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Log4j
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(){
        log.info("getRegister");
        return "/index";
    }

    @GetMapping("/modify")
    public String modify(){
        return "/user/modify";
    }

    @PostMapping("/modify")
    public String modifyUser(UserDTO userDTO){
        int result = userService.changeUserPw(userDTO);
        if(result == 1){
            log.info("비밀번호 변경 성공");
        }else{
            log.info("비밀번호 변경 실패");
        }
        return "/index";
    }

    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }

    @PostMapping("/login-post")
    public String loginPost(LoginDTO loginDTO, HttpSession session, Model model){
        UserDTO currentUser = userService.login(loginDTO);
        log.info("loginPost");

        if(currentUser == null){
            log.info("User is Empty");
            model.addAttribute("msg", "아이디, 패스워드가 틀리거나 없는 회원 입니다.");
            return "/user/login";
        }else{
            log.info("Login Success " + currentUser.toString());
            model.addAttribute("userDTO", currentUser);
            return "/user/login-post";
        }
    }

    @PostMapping("/register")
    public void registerMember(UserDTO userDTO){
        log.info("info User :" + userDTO.toString());
        userService.insertMember(userDTO);
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Object currentUser = session.getAttribute("login");
        if (currentUser != null) {
            session.removeAttribute("login");
            session.invalidate();
        }
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/checkId")
    public String checkId(@RequestBody UserDTO userDTO){
        log.info (" checkId Controller");
        UserDTO user = userService.getUserId(userDTO);
        if(user == null){
            return "0";
        }else{
            return "1";
        }
    }

    @GetMapping("/list")
    public String boardList(Criteria cri, Model model){
        model.addAttribute("pageMaker",new PageDTO(cri,userService.totalCount(cri)));
        model.addAttribute("list", userService.getUserList(cri));
        return "/user/adminPage";
    }

    @ResponseBody
    @PostMapping("/checked/delete")
    public int deleteAllBoard(@RequestParam(value = "checkArr[]") List<String> checkArr){
        log.info("delete Checked Board " + checkArr);

        for(String userId : checkArr){
            log.info("userId "  + userId);
            userService.deleteAllMember(userId);
        }
        return 1;
    }

}
