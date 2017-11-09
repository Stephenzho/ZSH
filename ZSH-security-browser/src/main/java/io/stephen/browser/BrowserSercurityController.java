package io.stephen.browser;

import io.stephen.core.exceptionHandle.CommonException;
import io.stephen.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理需要权限但未认证的请求
 * @author 10447
 * @since 2017/11/7
 */
@RestController
public class BrowserSercurityController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 记录请求的缓存，实则是在session上设置个参数
     */
    private RequestCache requestCache = new HttpSessionRequestCache();

    /**
     * 重定向工具
     */
    private RedirectStrategy redireStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当身份认证时跳转到这里
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public void requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取请求缓存
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (null != savedRequest) {
            String redirectUrl = savedRequest.getRedirectUrl(); // 获取跳转到这的url

            logger.debug(redirectUrl+"跳转到此，");

        }

        String useragent = request.getHeader("User-Agent");
        System.out.println(useragent);

        if (useragent.startsWith("Mozilla/5.0"))
            redireStrategy.sendRedirect(request, response, securityProperties.getLoginPath());
        else
            throw new CommonException("401","请引导用户进行授权");

    }

}
