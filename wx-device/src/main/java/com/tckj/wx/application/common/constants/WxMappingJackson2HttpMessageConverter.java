package com.tckj.wx.application.common.constants;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WCH
 * @date 2020/6/15 11:05
 */
@Component
public class WxMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public WxMappingJackson2HttpMessageConverter() {

        List<MediaType> mediaTypes = new ArrayList<>();

        mediaTypes.add(MediaType.TEXT_PLAIN);

        mediaTypes.add(MediaType.TEXT_HTML);  //加入text/html类型的支持

        setSupportedMediaTypes(mediaTypes);// tag6

    }

}