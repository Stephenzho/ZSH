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


    public String getLoginPath() {
        return loginPath;
    }

    public void setLoginPath(String loginPath) {
        this.loginPath = loginPath;
    }
}
