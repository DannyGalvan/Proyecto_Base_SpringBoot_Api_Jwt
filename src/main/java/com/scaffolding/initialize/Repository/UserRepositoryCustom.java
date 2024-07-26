package com.scaffolding.initialize.Repository;

import com.scaffolding.initialize.Entities.User;

public interface UserRepositoryCustom {
    User findByRole(int role_id);
}
