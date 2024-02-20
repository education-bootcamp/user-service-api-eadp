package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.common.BillingAddressDto;


public interface BillingAddressService {
    public void saveAddress(BillingAddressDto dto, int userId);
    public void updateAddress(BillingAddressDto dto, int userId);
    public BillingAddressDto findAddress(int userId);
    public void deleteAddress(int userId);
}
