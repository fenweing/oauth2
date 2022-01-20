package com.tuanbaol.auth.config;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author wangle
 * @date 2018/10/16  15:36
 **/
@Data
@SuppressWarnings("unchecked")
public final class BootClientDetails implements ClientDetails {

    private Client client;
    private Set<String> scope;

    public BootClientDetails(Client client) {
        this.client = client;
    }

    public BootClientDetails() {
    }

    @Override
    public String getClientId() {
        return client.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        return client.getResourceIds() != null ?
                transformStringToSet(client.getResourceIds()) :null;
    }

    @Override
    public boolean isSecretRequired() {
        return client.getIsSecretRequired();
    }

    @Override
    public String getClientSecret() {
        return client.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return client.getIsScoped();
    }

    @Override
    public Set<String> getScope() {

        this.scope = client.getScope() != null ?
                transformStringToSet(client.getScope()) : null;

        return client.getScope() != null ?
                transformStringToSet(client.getScope()) : null;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return client.getAuthorizedGrantTypes() != null ?
                transformStringToSet(client.getAuthorizedGrantTypes()) : null;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return client.getRegisteredRedirectUri() != null ?
                transformStringToSet(client.getRegisteredRedirectUri()) : null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return (client.getAuthorities() != null && client.getAuthorities().trim().length() > 0) ?
                AuthorityUtils.commaSeparatedStringToAuthorityList(client.getAuthorities()) : null;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return client.getAccessTokenValiditySeconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return client.getRefreshTokenValiditySeconds();
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return this.client.getIsAutoApprove() == null ? false : this
                .client.getIsAutoApprove();
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }

    public Set<String> transformStringToSet(String src) {
        return  CollectionUtil.ofHashSet(src.split(","));
    }
}
