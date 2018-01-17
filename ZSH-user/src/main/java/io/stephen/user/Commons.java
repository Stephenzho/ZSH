package io.stephen.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 10447
 * @since 2018/1/17
 */
@FeignClient("commons-client")
public interface Commons {

    @GetMapping("/dcc")
    String dc();

}

