package com.tuanbaol.auth.config;

import io.swagger.annotations.ApiOperation;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;

@RestController
public class ClientController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    @ApiOperation("register")
    public String clientRegistered(@RequestBody @Valid Client client) {
        client.setId(UUID.randomUUID().toString());
        client.setClientSecret(passwordEncoder.encode(client.getClientSecret()));
        boolean i = userService.addClient(client);
        return "200";
    }

    @GetMapping("/getRegister")
    @ApiOperation("getRegister")
    public String clientRegistered() throws IOException {
        Client client = userService.selectClientByClientId("client1");
        return new ObjectMapper().writeValueAsString(client);
    }
}
