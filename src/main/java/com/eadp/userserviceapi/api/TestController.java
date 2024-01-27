package com.eadp.userserviceapi.api;

import com.eadp.userserviceapi.util.StandardResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/test")
@RestController
public class TestController {

    @GetMapping
    public ResponseEntity<StandardResponseDto> test(){
        return new ResponseEntity<>(
                new StandardResponseDto("Hello User (user Service API)",
                        200,null), HttpStatus.OK
        );
    }
}
