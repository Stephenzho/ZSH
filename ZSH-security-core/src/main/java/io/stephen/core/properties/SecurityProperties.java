package io.stephen.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 读取ZSH.security开头的配置，在properties文件中
 * @author 10447
 * @since 2017/11/7
 */
@ConfigurationProperties(prefix = "ZSH.security")
public class SecurityProperties {

    private String loginPath = "/login.html";


    private LoginType loginType = LoginType.JSON;

    private SocialProperties socialProperties = new SocialProperties();


    public SocialProperties getSocialProperties() {
        return socialProperties;
    }

    public void setSocialProperties(SocialProperties socialProperties) {
        this.socialProperties = socialProperties;
    }

    public String getLoginPath() {
        return loginPath;
    }

    public void setLoginPath(String loginPath) {
        this.loginPath = loginPath;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
