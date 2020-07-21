package controller;

import domain.LoginDTO;
import domain.PageDTO;
import domain.UserDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.Criteria;
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
        return "/user/register";
    }

    @GetMapping("/modify")
    public String modify(){
        return "/user/modify";
    }

    @PostMapping("/changePw")
    public String changePw(@RequestParam String currentPw, @RequestParam String pw, HttpSession session,
                           Model model) {
        UserDTO currentUser = (UserDTO)session.getAttribute("login");
        log.info("CurrentUser " + currentUser);
        if(userService.checkPw(currentUser, currentPw)) {
            log.info("비밀번호 변경");
            userService.changePw(currentUser,pw);
        }else {
            model.addAttribute("msg","비밀번호가 일치하지 않습니다");
            return "/user/modify";
        }
        return "/index";
    }

    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }

    @GetMapping("/adminLogin")
    public String adminLogin(String error, String logout, Model model){
        log.info("Error " + error);
        log.info("Logout " + logout);

        if(error != null){
            model.addAttribute("error", "관리자 계정을 확인해주세요");
        }
        if(logout != null){
            model.addAttribute("logout","로그아웃");
        }

        return "/user/adminLogin";
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
            //return "/user/login-post";
            return "/discussion/list";
        }
    }

    @GetMapping("/profile")
    public String profile(){
        return "/user/profile";
    }

    @PostMapping("/register")
    public String registerMember(UserDTO userDTO){
        log.info("info User :" + userDTO.toString());
        userService.insertMember(userDTO);
        return "/user/login";
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
