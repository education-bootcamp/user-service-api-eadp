package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.common.BillingAddressDto;

import com.eadp.userserviceapi.entity.BillingAddress;
import com.eadp.userserviceapi.entity.User;
import com.eadp.userserviceapi.repo.BillingRepo;
import com.eadp.userserviceapi.repo.UserRepo;
import com.eadp.userserviceapi.service.BillingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingAddressServiceImpl implements BillingAddressService {

    private final BillingRepo billingRepo;
    private final UserRepo userRepo;

    @Autowired
    public BillingAddressServiceImpl(BillingRepo billingRepo, UserRepo userRepo) {
        this.billingRepo = billingRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void saveAddress(BillingAddressDto dto, String userId) {

        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCountry(dto.getCountry());
        billingAddress.setCity(dto.getCity());
        billingAddress.setZip(dto.getZip());
        billingAddress.setUser(selectedUser.get());
        billingRepo.save(billingAddress);
    }

    @Override
    public void updateAddress(BillingAddressDto dto, String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<BillingAddress> selectedBillingAddress = billingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();

        selectedBillingAddress.get().setCountry(dto.getCountry());
        selectedBillingAddress.get().setCity(dto.getCity());
        selectedBillingAddress.get().setZip(dto.getZip());
        billingRepo.save(selectedBillingAddress.get());
    }

    @Override
    public BillingAddressDto findAddress(String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<BillingAddress> selectedBillingAddress = billingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();
        return new BillingAddressDto(
                selectedBillingAddress.get().getCountry(),selectedBillingAddress.get().getCity(),
                selectedBillingAddress.get().getZip()
        );
    }

    @Override
    public void deleteAddress(String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<BillingAddress> selectedBillingAddress = billingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();

        billingRepo.delete(selectedBillingAddress.get());
    }
}
