package com.tuanbaol.auth.config;


import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author wangle
 * @date 2018/10/16  9:23
 **/
@Data
public class Client {

    private String id;
    @NotNull
    private String clientId;
    private String resourceIds;
    private Boolean isSecretRequired;
    @NotNull
    private String clientSecret;
    private Boolean isScoped;
    private String scope;
    @NotNull
    private String authorizedGrantTypes;
    @NotNull
    private String registeredRedirectUri;
    private String authorities;
    private Boolean isAutoApprove;
    @NotNull
    private Integer accessTokenValiditySeconds;
    @NotNull
    private Integer refreshTokenValiditySeconds;
    @NotNull
    private String createTime;
    @NotNull
    private String modifyTime;
}
 
 
 
