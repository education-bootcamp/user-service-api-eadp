package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.paginate.PaginateUsersResponseDto;
import com.eadp.userserviceapi.dto.request.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;
import com.eadp.userserviceapi.entity.User;
import com.eadp.userserviceapi.repo.UserRepo;
import com.eadp.userserviceapi.service.UserService;
import com.eadp.userserviceapi.util.KeyManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final KeyManager keyManager;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, KeyManager keyManager) {
        this.userRepo = userRepo;
        this.keyManager = keyManager;
    }

    @Override
    public void createUser(RequestUserDto dto) {
        User user = new User();
        user.setUserId(keyManager.generateKey(new Random().nextInt(15)));
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setStatus(true);
        user.setAvatarUrl(dto.getAvatarUrl().getBytes());
        userRepo.save(user);
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
