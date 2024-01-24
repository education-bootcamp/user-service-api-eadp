package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.common.BillingAddressDto;

import com.eadp.userserviceapi.service.BillingAddressService;
import org.springframework.stereotype.Service;

@Service
public class BillingAddressServiceImpl implements BillingAddressService {

    @Override
    public void saveAddress(BillingAddressDto dto, String userId) {

    }

    @Override
    public void updateAddress(BillingAddressDto dto, String userId) {

    }

    @Override
    public BillingAddressDto findAddress(String userId) {
        return null;
    }

    @Override
    public void deleteAddress(String userId) {

    }
}
