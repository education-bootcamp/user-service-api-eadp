package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.common.ShippingAddressDto;
import com.eadp.userserviceapi.service.ShippingAddressService;
import org.springframework.stereotype.Service;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {
    @Override
    public void saveAddress(ShippingAddressDto dto, String userId) {

    }

    @Override
    public void updateAddress(ShippingAddressDto dto, String userId) {

    }

    @Override
    public ShippingAddressDto findAddress(String userId) {
        return null;
    }

    @Override
    public void deleteAddress(String userId) {

    }
}
