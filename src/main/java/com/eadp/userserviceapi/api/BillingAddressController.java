package com.eadp.userserviceapi.api;

import com.eadp.userserviceapi.dto.common.BillingAddressDto;
import com.eadp.userserviceapi.dto.request.RequestUserDto;
import com.eadp.userserviceapi.service.BillingAddressService;
import com.eadp.userserviceapi.service.UserService;
import com.eadp.userserviceapi.util.StandardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class BillingAddressController {
    private final BillingAddressService billingAddressService;

    @Autowired
    public BillingAddressController(BillingAddressService billingAddressService) {
        this.billingAddressService = billingAddressService;
    }

    @PostMapping(params = "userId")
    public ResponseEntity<StandardResponseDto> createUser(@RequestBody BillingAddressDto dto,
                                                          @RequestParam String userId) {
        billingAddressService.saveAddress(dto, Integer.parseInt(userId));
        return new ResponseEntity<>(
                new StandardResponseDto("Address was Saved!",201,null),
                HttpStatus.CREATED
        );
    }

    @PutMapping(params = "userid")
    public ResponseEntity<StandardResponseDto> updateUser(@RequestBody BillingAddressDto dto,
                                                          @RequestParam String userId) {
        billingAddressService.updateAddress(dto, Integer.parseInt(userId));
        return new ResponseEntity<>(
                new StandardResponseDto("Address was updated!",201,null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<StandardResponseDto> findUser(@PathVariable String userId) {
        return new ResponseEntity<>(
                new StandardResponseDto("Address data",200,billingAddressService.findAddress(Integer.parseInt(userId))),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<StandardResponseDto> deleteUser(@PathVariable String userId) {
        billingAddressService.deleteAddress(Integer.parseInt(userId));
        return new ResponseEntity<>(
                new StandardResponseDto(  "Address was Deleted!",204,null),
                HttpStatus.NO_CONTENT
        );
    }
}
