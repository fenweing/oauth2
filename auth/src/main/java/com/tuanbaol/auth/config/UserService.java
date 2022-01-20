package com.tuanbaol.auth.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements InitializingBean {

    private Map<String, User> userMap = new HashMap<>();
    private Map<String, Client> clientMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        Client client = new Client();
        client.setClientId("client1");
        client.setAuthorizedGrantTypes("password,refresh_token,authorization_code,implicit,client_credentials");
        client.setRegisteredRedirectUri("https://www.esensoft.com");
        client.setClientSecret("$2a$10$BMoF1ymHaqkmZdSIsNvieOR3RAw/fKjXAPy8lumaJdo1bhCL0xp7S");
        client.setAuthorities("admin");
        client.setScope("user");
        addClient(client);
        User user = new User();
        user.setUsername("admin");
        user.setPassword("$2a$10$yy1OWGdnpO4sq1xIffejqeue8OvivhmWRVFzmpWC/PivKBuAZA5Ti");
        user.setIsLocked(false);
        user.setIsEnable(true);
        userMap.put(user.getUsername(), user);
    }

    public Map selectUser() {
        Map data = new HashMap();
        List<User> userList = new ArrayList<>(userMap.values());
        data.put("recordList", userList);
        data.put("total", userList.size());
        return data;
    }


    public User selectUserByUsername(String username) {
        return userMap.get(username);
    }


    public Client selectClientByClientId(String clientId) {
        return clientMap.get(clientId);
    }

    public boolean addClient(Client client) {
        clientMap.put(client.getClientId(), client);
        return true;
    }


}
 
