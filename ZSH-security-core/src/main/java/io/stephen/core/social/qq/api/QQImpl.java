package io.stephen.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * QQ 接口实现类
 * @author 10447
 * @since 2017/11/20
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ{

    private Logger logger = LoggerFactory.getLogger(getClass());


    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%S&openid=%s";

    private String appId;
    private String openId;


    private ObjectMapper objectMapper = new ObjectMapper();


    public QQImpl(String accessToken, String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;

        String url = String.format(URL_GET_OPENID, accessToken);

        /*
            获取openid
            result = callback( {"client_id":"YOUR_APPID","openid":"YOUR_OPENID"} );
          */
        String result = getRestTemplate().getForObject(url, String.class);

        this.openId = StringUtils.substringBetween(result, "\"openid\":\"" , "\"}");
    }

    /**
     * 获取用户信息
     * @return
     * @throws IOException
     */
    @Override
    public QQUserInfo getUserInfo()  {

        String url = String.format(URL_GET_USERINFO,appId,openId);

        String result = getRestTemplate().getForObject(url, String.class);

        logger.info(result);

        QQUserInfo userInfo = null;

        try {
            userInfo = objectMapper.readValue(result,QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        } catch (IOException e) {
            throw new RuntimeException("获取用户信息失败");
        }
    }
}
