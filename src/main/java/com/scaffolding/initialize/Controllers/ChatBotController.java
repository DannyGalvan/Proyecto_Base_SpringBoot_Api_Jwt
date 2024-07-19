package com.scaffolding.initialize.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaffolding.initialize.Entities.LoginBot;
import com.scaffolding.initialize.Entities.Response.ResponseApi;
import com.scaffolding.initialize.Interfaces.ILoginBotService;
import com.scaffolding.initialize.Swagger.Shemas.AuthenticationFailed;
import com.scaffolding.initialize.Swagger.Shemas.ListLoginBot;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "ChatBot", description = "API de chatbot")
public class ChatBotController {

    private ILoginBotService loginBotService;

    public ChatBotController(ILoginBotService loginBotService) {
        this.loginBotService = loginBotService;
    }

    @GetMapping("/chatbot")
    @Operation(summary = "Obtiene los chatbot", description = "Este endpoint devuelve los chatbot disponibles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ChatBot Response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ListLoginBot.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthenticationFailed.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AuthenticationFailed.class))),
    })
    public ResponseEntity<?> getChatBotResponse() {
        List<LoginBot> loginBotData = loginBotService.getLoginBotData();

        ResponseApi<List<LoginBot>> apiResponse = new ResponseApi<>(true, "ChatBot Response",
                loginBotData);

        return ResponseEntity.ok(apiResponse);
    }
}
