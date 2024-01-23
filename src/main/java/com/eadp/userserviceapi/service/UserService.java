package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.paginate.PaginateUsersResponseDto;
import com.eadp.userserviceapi.dto.request.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;

public interface UserService {
    public void createUser(RequestUserDto dto);
    public void updateUser(RequestUserDto dto, String userId);
    public ResponseUserDto findUser(String userId);
    public void deleteUser(String userId);
    public PaginateUsersResponseDto findAllUsers(int page, int size, String searchText);
}
