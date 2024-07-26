package com.scaffolding.initialize.Interfaces;

import java.util.List;

import com.scaffolding.initialize.Entities.Response.UserResponse;

public interface IUserService {
    List<UserResponse> findAll();
}
