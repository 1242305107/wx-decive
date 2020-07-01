package com.tckj.wx.application.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tckj.wx.application.common.util.ResultHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;

/**
 * @author WCH
 * @date 2020/6/15 9:47
 */
@Api(tags = "微信登录测试")
@RestController
@RequestMapping("/auth")
public class WXLoginController {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;

    @ApiOperation("登录")
    @PostMapping("/wxLogin")
    @ApiImplicitParam(name = "code",value = "用户凭证",required = true,dataType = "String",paramType = "query")
    public ResultHelper wxLogin(@RequestParam String code) {

        //String url = "https://api.weixin.qq.com/sns/jscode2session";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
       /* Map<String, String> param = new HashMap<>();
        param.put("appid", WxApp.APPID);
        param.put("secret", WxApp.SECRET);
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");*/

//        //headers
//        HttpHeaders requestHeaders = new HttpHeaders();
//        //设置类型
//        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//        requestHeaders.setContentType(type);
//        //设置body
//        JSONObject body=new JSONObject();
//        body.put("appid",appid);
//        body.put("secret",secret);
//        body.put("js_code",code);
//        body.put("grant_type","authorization_code");
//        HttpEntity requestEntity = new HttpEntity(body,requestHeaders);
//
//        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Map.class);

        ResponseEntity<Map> forEntity = restTemplate.getForEntity(url, Map.class);

        return ResultHelper.succeed(forEntity);
    }


}
