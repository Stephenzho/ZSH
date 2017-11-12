package io.stephen.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.stephen.core.properties.LoginType;
import io.stephen.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆成功处理
 * @author 10447
 * @since 2017/11/9
 */
@Component
public class ZSHAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 登陆成功后跳转到此，根据配置返回
     *
     * @param request
     * @param response
     * @param authentication
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        log.info(authentication.getName()+"登陆成功");

        if (securityProperties.getLoginType().equals(LoginType.JSON)) {
            response.setContentType("application/json,charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else{

            super.onAuthenticationSuccess(request, response, authentication);
        }

    }
}
