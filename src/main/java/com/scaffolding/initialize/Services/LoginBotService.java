package com.scaffolding.initialize.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scaffolding.initialize.Entities.LoginBot;
import com.scaffolding.initialize.Interfaces.ILoginBotService;
import com.scaffolding.initialize.Repository.LoginBotRepository;

@Service
public class LoginBotService implements ILoginBotService {

  private final LoginBotRepository loginBotRepository;

  public LoginBotService(LoginBotRepository loginBotRepository) {
    this.loginBotRepository = loginBotRepository;
  }

  public List<LoginBot> getLoginBotData() {
    return loginBotRepository.BuscarPorCriteria(1, "string");
  }

  public List<LoginBot> getAllBots() {
    return loginBotRepository.findAll();
  }
}
