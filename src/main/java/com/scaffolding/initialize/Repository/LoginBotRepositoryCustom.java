package com.scaffolding.initialize.Repository;

import java.util.List;

import com.scaffolding.initialize.Entities.LoginBot;


public interface LoginBotRepositoryCustom {
  List<LoginBot> BuscarPorCriteria(Integer userId, String name);
}
