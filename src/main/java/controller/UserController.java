package controller;

import domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(){
        return "/user/register";
    }

    @PostMapping("/register")
    public void registerMember(UserDTO userDTO){
        System.out.println(userDTO.toString());
        userService.insert(userDTO);
    }

}
