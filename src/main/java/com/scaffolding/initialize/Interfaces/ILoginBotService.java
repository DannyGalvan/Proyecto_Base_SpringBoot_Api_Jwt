package com.scaffolding.initialize.Interfaces;

import java.util.List;

import com.scaffolding.initialize.Entities.LoginBot;

public interface ILoginBotService {

  public List<LoginBot> getLoginBotData();

  public List<LoginBot> getAllBots();

}
