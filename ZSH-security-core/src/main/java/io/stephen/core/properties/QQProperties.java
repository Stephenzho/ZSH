package io.stephen.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author 10447
 * @since 2017/11/20
 */
public class QQProperties extends SocialProperties {

    private String providerId = "qq";




    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
