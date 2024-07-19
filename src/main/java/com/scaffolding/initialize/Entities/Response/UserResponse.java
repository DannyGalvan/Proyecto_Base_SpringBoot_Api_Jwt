package com.scaffolding.initialize.Entities.Response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.scaffolding.initialize.Entities.LoginBot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer id;

    private String email;

    private String name;

    private String lastName;

    private String userName;

    private Boolean active = true;

    private LocalDateTime createdAt;

    private LocalDateTime dateToken;

    private List<LoginBot> loginBots = new ArrayList<>();
}
