package com.tuanbaol.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

@Component
public final class BootClientDetailsService implements ClientDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        Client client = userService.selectClientByClientId(clientId);

        if (client == null) {
            throw new ClientRegistrationException("客户端不存在");
        }

        return new BootClientDetails(client);
    }
}
 
