package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.paginate.PaginateUsersResponseDto;
import com.eadp.userserviceapi.dto.request.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;
import com.eadp.userserviceapi.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public void createUser(RequestUserDto dto) {

    }

    @Override
    public void updateUser(RequestUserDto dto, String userId) {

    }

    @Override
    public ResponseUserDto findUser(String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public PaginateUsersResponseDto findAllUsers(int page, int size, String searchText) {
        return null;
    }
}
