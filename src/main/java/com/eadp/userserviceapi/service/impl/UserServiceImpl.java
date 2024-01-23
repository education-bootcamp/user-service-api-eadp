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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();
        selectedUser.get().setEmail(dto.getEmail());
        selectedUser.get().setFullName(dto.getFullName());
        selectedUser.get().setAvatarUrl(dto.getAvatarUrl().getBytes());
        selectedUser.get().setStatus(dto.isStatus());
        userRepo.save(selectedUser.get());
    }

    @Override
    public ResponseUserDto findUser(String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

       // String avatar=new String(selectedUser.get().getAvatarUrl(), StandardCharsets.UTF_8);

        return new ResponseUserDto(
                selectedUser.get().getUserId(),
                selectedUser.get().getFullName(),
                selectedUser.get().getEmail(),
                new String(selectedUser.get().getAvatarUrl()),
                selectedUser.get().isStatus()
        );
    }

    @Override
    public void deleteUser(String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();
        userRepo.delete(selectedUser.get());
    }

    @Override
    public PaginateUsersResponseDto findAllUsers(int page, int size, String searchText) {
        List<User> allUsers = userRepo.findAllUsers(searchText, PageRequest.of(page, size));
        Long count = userRepo.findAllUserCount(searchText);
        List<ResponseUserDto> dtos = new ArrayList<>();
        System.out.println(allUsers);
        allUsers.forEach(e->{
            dtos.add(new ResponseUserDto(
                    e.getUserId(),
                    e.getFullName(),
                    e.getEmail(),
                    new String(e.getAvatarUrl()),
                    e.isStatus()
            ));
        });
        return new PaginateUsersResponseDto(count,dtos);
    }
}
