package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.common.BillingAddressDto;
import com.eadp.userserviceapi.dto.common.ShippingAddressDto;
import com.eadp.userserviceapi.entity.BillingAddress;
import com.eadp.userserviceapi.entity.ShippingAddress;
import com.eadp.userserviceapi.entity.User;
import com.eadp.userserviceapi.repo.BillingRepo;
import com.eadp.userserviceapi.repo.ShippingRepo;
import com.eadp.userserviceapi.repo.UserRepo;
import com.eadp.userserviceapi.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {
    private final ShippingRepo shippingRepo;
    private final UserRepo userRepo;

    @Autowired
    public ShippingAddressServiceImpl(ShippingRepo shippingRepo, UserRepo userRepo) {
        this.shippingRepo = shippingRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void saveAddress(ShippingAddressDto dto, int userId) {

        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCountry(dto.getCountry());
        shippingAddress.setCity(dto.getCity());
        shippingAddress.setZip(dto.getZip());
        shippingAddress.setUser(selectedUser.get());
        shippingRepo.save(shippingAddress);
    }

    @Override
    public void updateAddress(ShippingAddressDto dto, int userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<ShippingAddress> selectedShippingAddress = shippingRepo.findShippingAddressByUser(selectedUser.get());
        if (selectedShippingAddress.isEmpty()) throw new RuntimeException();

        selectedShippingAddress.get().setCountry(dto.getCountry());
        selectedShippingAddress.get().setCity(dto.getCity());
        selectedShippingAddress.get().setZip(dto.getZip());
        shippingRepo.save(selectedShippingAddress.get());
    }

    @Override
    public ShippingAddressDto findAddress(int userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<ShippingAddress> selectedShippingAddress = shippingRepo.findShippingAddressByUser(selectedUser.get());
        if (selectedShippingAddress.isEmpty()) throw new RuntimeException();
        return new ShippingAddressDto(
                selectedShippingAddress.get().getCountry(),selectedShippingAddress.get().getCity(),
                selectedShippingAddress.get().getZip()
        );
    }

    @Override
    public void deleteAddress(int userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<ShippingAddress> selectedShippingAddress = shippingRepo.findShippingAddressByUser(selectedUser.get());
        if (selectedShippingAddress.isEmpty()) throw new RuntimeException();

        shippingRepo.delete(selectedShippingAddress.get());
    }
}
