package io.stephen.commons.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

        GsonHttpMessageConverter gson = new GsonHttpMessageConverter();
        List<MediaType> gsonSupportedMediaTypes  = gson.getSupportedMediaTypes();

        gsonSupportedMediaTypes.add(MediaType.APPLICATION_JSON);
        gsonSupportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

        converters.add(gson);
    }


}
