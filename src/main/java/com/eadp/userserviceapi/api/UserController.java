package com.eadp.userserviceapi.api;

import com.eadp.userserviceapi.dto.request.RequestUserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @PostMapping
    public String createUser(@RequestBody RequestUserDto dto){
        return dto.toString();
    }
    @PutMapping("/{userId}")
    public String updateUser(@RequestBody RequestUserDto dto, @PathVariable String userId){
        return "updateUser";
    }
    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return "findUser";
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "deleteUser";
    }
    @GetMapping(value = "/list", params = {"page","size","searchText"})
    public String findAllUsers(
            @RequestParam int page, @RequestParam int size, @RequestParam String searchText
    ){
        return "findAllUsers";
    }
}
