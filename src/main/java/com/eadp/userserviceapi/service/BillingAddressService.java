package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.common.BillingAddressDto;


public interface BillingAddressService {
    public void saveAddress(BillingAddressDto dto, String userId);
    public void updateAddress(BillingAddressDto dto, String userId);
    public BillingAddressDto findAddress(String userId);
    public void deleteAddress(String userId);
}
