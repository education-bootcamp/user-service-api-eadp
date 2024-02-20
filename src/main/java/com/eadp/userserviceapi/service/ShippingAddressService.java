package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.common.ShippingAddressDto;

public interface ShippingAddressService {
    public void saveAddress(ShippingAddressDto dto, int userId);
    public void updateAddress(ShippingAddressDto dto, int userId);
    public ShippingAddressDto findAddress(int userId);
    public void deleteAddress(int userId);
}
