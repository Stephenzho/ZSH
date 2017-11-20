package io.stephen.core.social.qq.config;

import io.stephen.core.properties.SecurityProperties;
import io.stephen.core.social.qq.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 *
 * @ConditionalOnProperty 当前缀prefix名称为name的属性配置时，该配置类@Configuration才生效
 *
 * @author 10447
 * @since 2017/11/20
 */
@Configuration
@ConditionalOnProperty(prefix = "security.social.qq", name = "appId")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        String providerId = securityProperties.getSocialProperties().getQqProperties().getProviderId();
        String appId = securityProperties.getSocialProperties().getQqProperties().getAppId();
        String appSecret = securityProperties.getSocialProperties().getQqProperties().getAppSecret();


        return new QQConnectionFactory(providerId,appId,appSecret);
    }


}
