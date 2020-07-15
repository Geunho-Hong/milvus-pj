package controller;

import domain.UserDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserServiceImpl;

@Log4j
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(){
        log.info("getRegister");
        return "/user/register";
    }

    @PostMapping("/register")
    public void registerMember(UserDTO userDTO){
        log.info("info User :" + userDTO);
        userService.insert(userDTO);
    }

}
