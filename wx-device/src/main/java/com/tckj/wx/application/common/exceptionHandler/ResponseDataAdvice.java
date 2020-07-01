package com.tckj.wx.application.common.exceptionHandler;

import com.alibaba.fastjson.JSONObject;
import com.tckj.wx.application.common.util.ComUtil;
import com.tckj.wx.application.common.util.ResultHelper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 统一响应
 * @author WCH
 * @date 2020/6/15 9:47
 */
@ControllerAdvice
@ResponseBody
public class ResponseDataAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
         if(o.toString().endsWith("}")){
             JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(o));
             if(!ComUtil.isEmpty(jsonObject.get("error"))){
                 return ResultHelper.failed(o,"Unauthorized");
             }
         }
        return o;
    }
}
