package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.common.ShippingAddressDto;

public interface ShippingAddressService {
    public void saveAddress(ShippingAddressDto dto, String userId);
    public void updateAddress(ShippingAddressDto dto, String userId);
    public ShippingAddressDto findAddress(String userId);
    public void deleteAddress(String userId);
}
