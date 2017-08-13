package io.stephen.commons.security.filter;

import io.jsonwebtoken.JwtException;
import io.stephen.commons.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * jwt token验证类,验证成功后设置进去SecurityContext中
 *
 * @author zhouShuYi
 * @since 2017/7/16
 */
public class ValidateTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            // 验签
            Optional<Authentication> authentication = jwtTokenUtil.verifyToken(httpServletRequest);


            SecurityContextHolder.getContext().setAuthentication(authentication.orElse(null));

            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (JwtException e) {
            System.err.println(e.getMessage());
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            //可以在这里指定重定向还是返回错误接口示例
        } catch (Exception e) {
            System.err.println(e.getMessage());
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }


}
