package com.eadp.userserviceapi.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @PostMapping
    public String createUser(){
        return "createUser";
    }
    @PutMapping
    public String updateUser(){
        return "updateUser";
    }
    @GetMapping
    public String findUser(){
        return "findUser";
    }
    @DeleteMapping
    public String deleteUser(){
        return "deleteUser";
    }
    @GetMapping("/list")
    public String findAllUsers(){
        return "findAllUsers";
    }
}
