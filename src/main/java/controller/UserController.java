package controller;

import domain.LoginDTO;
import domain.UserDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

}
