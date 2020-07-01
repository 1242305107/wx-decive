package com.tckj.wx.application.config.security;

import com.tckj.wx.application.common.constants.PermitAllUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WCH
 * @date 2020/6/28 14:40
 */
@Configuration
@EnableResourceServer
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {


    public static final String RESOURCE_ID = "res1";

    @Autowired
    TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID)//资源 id
                .tokenStore(tokenStore)
                //.tokenServices(tokenService())//验证令牌的服务
                .stateless(true);
    }

    /*@Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
               // .antMatchers(PermitAllUrl.permitAllUrl()).permitAll() // 放开权限的url
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }*/
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().exceptionHandling()
                .authenticationEntryPoint(new AuthExceptionEntryPoint())
                .accessDeniedHandler(new MyAccessDeniedHandler())
                .and().requestMatcher(new OAuth2RequestedMatcher()).authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(PermitAllUrl.permitAllUrl("/swaggerList","/oauth/token","/oauth/user/token","/users-anon/**")).permitAll() // 放开权限的url
                .anyRequest().authenticated().and().httpBasic();
    }


    /**
     * 判断来源请求是否包含oauth2授权信息<br>
     * url参数中含有access_token,或者header里有Authorization
     */
    private static class OAuth2RequestedMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
                return true;
            }
            // 请求参数中包含access_token参数
            if (request.getParameter(OAuth2AccessToken.ACCESS_TOKEN) != null) {
                return true;
            }
            // 头部的Authorization值以Bearer开头
            String auth = request.getHeader("Authorization");
            if (auth != null) {
                return auth.startsWith(OAuth2AccessToken.BEARER_TYPE);
            }

            return false;
        }
    }

    //资源服务令牌解析服务
    /*@Bean
    public ResourceServerTokenServices tokenService() {
        //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret

        *//*DefaultTokenServices service1 = new DefaultTokenServices();
        service1.setTokenStore(tokenStore);
        return service1;*//*

        RemoteTokenServices service=new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://localhost:8888/oauth/check_token");
        service.setClientId("c1");
        service.setClientSecret("secret");
        return service;
    }*/


    public static void main(String[] args) {
        String tcapp = BCrypt.hashpw("tcapp", BCrypt.gensalt());
        System.out.println(tcapp);
    }

}
