package io.stephen.commons.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10447
 * @since 2017/8/6
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {


    /**
     *  添加相应转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 默认UTF-8
        FastJsonHttpMessageConverter jsonMessageConverter = new FastJsonHttpMessageConverter();
        // 格式化日期
        jsonMessageConverter.getFastJsonConfig().setDateFormat(JSON.DEFFAULT_DATE_FORMAT);

        // 设置相应头
        List<MediaType> jsonMediaTypes = new ArrayList<MediaType>();
        jsonMediaTypes.add(MediaType.APPLICATION_JSON);
        jsonMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

        jsonMessageConverter.setSupportedMediaTypes(jsonMediaTypes);

        converters.add(jsonMessageConverter);
    }


  /*  *//**
     *  获取自定义转换器bean
     * @return 自定义fastJson转换器
     *//*
    @Bean
    public FastJsonHttpMessageConverter messageConverters(){
        return jsonMessageConverter;
    }*/


}
