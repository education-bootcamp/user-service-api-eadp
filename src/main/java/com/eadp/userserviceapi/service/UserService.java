package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.paginate.PaginateUsersResponseDto;
import com.eadp.userserviceapi.dto.request.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;

public interface UserService {
    public void createUser(RequestUserDto dto);
    public void updateUser(RequestUserDto dto, int userId);
    public ResponseUserDto findUser(int userId);
    public void deleteUser(int userId);
    public PaginateUsersResponseDto findAllUsers(int page, int size, String searchText);
}
