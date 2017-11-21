package io.stephen.core.social.qq.connet;

import io.stephen.core.social.qq.api.QQ;
import io.stephen.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @author 10447
 * @since 2017/11/20
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId ;


    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";


    public QQServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken,appId);
    }
}
