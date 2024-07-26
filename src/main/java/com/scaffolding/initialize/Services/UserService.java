package com.scaffolding.initialize.Services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scaffolding.initialize.AutoMapper.UserMapper;
import com.scaffolding.initialize.Entities.User;
import com.scaffolding.initialize.Entities.Response.UserResponse;
import com.scaffolding.initialize.Interfaces.IUserService;
import com.scaffolding.initialize.Repository.UserRepository;

import com.scaffolding.initialize.Security.UserDetailsImpl;;

@Service
public class UserService implements UserDetailsService, IUserService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userEntity = userRepository.findByEmail(email);

        if (userEntity == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserDetailsImpl(userEntity);
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream().map(userMapper::mapUserToUserResponse).toList();
    }
}
