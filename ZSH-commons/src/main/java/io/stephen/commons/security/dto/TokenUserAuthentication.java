package io.stephen.commons.security.dto;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 表示身份验证请求已通过的用户主体，存储在securityContext中
 * <pre>
 *  SecurityContextHolder.getContext().setAuthentication(anAuthentication);
 * </pre>
 *
 * Spring Security中存放的认证用户
 *
 * @author zhouShuYi
 * @since  2017/7/16
 */
public class TokenUserAuthentication implements Authentication {

    private static final long serialVersionUID = 3730332217518791533L;

    private TokenUserDTO userDTO;

    private Boolean authentication = false;

    public TokenUserAuthentication(TokenUserDTO userDTO, Boolean authentication) {
        this.userDTO = userDTO;
        this.authentication = authentication;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getDetails() {
        return userDTO;
    }

    @Override
    public Object getPrincipal() {
        return userDTO.getUserName();
    }

    @Override
    public boolean isAuthenticated() {
        return authentication;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authentication = isAuthenticated;
    }

    @Override
    public String getName() {
        return userDTO.getUserName();
    }
}
