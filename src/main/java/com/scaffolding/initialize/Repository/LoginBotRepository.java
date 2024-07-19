package com.scaffolding.initialize.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaffolding.initialize.Entities.LoginBot;

@Repository
public interface LoginBotRepository extends JpaRepository<LoginBot, Integer>, LoginBotRepositoryCustom {

}
