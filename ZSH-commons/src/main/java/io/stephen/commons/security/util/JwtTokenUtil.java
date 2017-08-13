package io.stephen.commons.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.stephen.commons.domain.entity.User;
import io.stephen.commons.security.dto.TokenUserAuthentication;
import io.stephen.commons.security.dto.TokenUserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by zhouShuYi
 *
 * @author zhouShuYi
 * @since 2017/7/16
 */
@Component
public class JwtTokenUtil {
    /**
     * token过期时间
     */
    @Value("${jwt.expiration}")
    private String validity_time ; // 24 hours  validity
    /**
     * header中标识
     */
    private static final String AUTH_HEADER_NAME = "x-authorization";

    /**
     * 签名密钥
     */
    @Value("${jwt.secret}")
    private String secret;

    /**
     * 验签
     */
    public Optional<Authentication> verifyToken(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null && !token.isEmpty()){
            final TokenUserDTO user = parse(token.trim());
            if (user != null) {
                return Optional.of(new TokenUserAuthentication(user, true));
            }
        }
        return Optional.empty();
    }


    /**
     * 从用户中创建一个jwt Token
     *
     * @param user 用户
     * @return token
     */
    public String create(User user) {

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secret)
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(validity_time)))

                .setId(String.valueOf(user.getUserID()))
                .claim("userName", user.getUserName())
                .claim("avatar", user.getAvatar())
                .claim("email", user.getEmail())
                .claim("sex", user.getSex())
                .claim("registerTime", user.getRegisterTime())
                .claim("roles", user.getRoles())
                .compact();
    }

    /**
     * 从token中取出用户
     */
    public TokenUserDTO parse(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        TokenUserDTO userDTO = new TokenUserDTO();
        userDTO.setUserID(claims.getId());
        userDTO.setUserName(claims.get("userName",String.class));
        userDTO.setAvatar(claims.get("avatar", String.class));
        userDTO.setEmail(claims.get("email",String.class));
        userDTO.setSex(claims.get("sex", String.class));
        userDTO.setRegisterTime(claims.get("registerTime", String.class));
        userDTO.setRoles((List<String>) claims.get("roles"));

        return userDTO;
    }

}
