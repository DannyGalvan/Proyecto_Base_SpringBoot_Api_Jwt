package com.scaffolding.initialize.AutoMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.scaffolding.initialize.Entities.User;
import com.scaffolding.initialize.Entities.Response.UserResponse;


@Mapper(componentModel = "spring")
public interface UserMapper {

  UserResponse mapUserToUserResponse(User user);
  
  @Mapping(target = "password", ignore = true)
  User mapUserResponseToUser(UserResponse userResponse);
}
