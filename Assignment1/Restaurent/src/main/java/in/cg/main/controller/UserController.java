package in.cg.main.controller;

import org.springframework.web.bind.annotation.*;

import in.cg.main.dto.UserDto;
import in.cg.main.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto dto){
        userService.registerUser(dto);
        return "User Registered Successfully";
    }
}