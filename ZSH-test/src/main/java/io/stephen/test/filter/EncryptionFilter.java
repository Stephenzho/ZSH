package io.stephen.test.filter;


import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 10447
 * @since 2018/4/16
 */
public class EncryptionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

       Enumeration<String> attributeNames =  request.getAttributeNames();

        attributeNames.hasMoreElements();

        System.out.println(attributeNames);


        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
