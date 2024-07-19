package com.scaffolding.initialize.Swagger.Shemas;

import com.scaffolding.initialize.Entities.Response.ResponseApi;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Authentication Failed or Unauthorized")
public class AuthenticationFailed extends ResponseApi<String> {
    
    public AuthenticationFailed() {
        super(false, "Authentication failed", null);
    }
}
