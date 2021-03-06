package com.tckj.wx.application.config.mybatisPlus;
import	java.util.Date;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author WCH
 * @date 2020/6/24 11:16
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        /*this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
        this.fillStrategy(metaObject, "createTime", LocalDateTime.now()); // 也可以使用(3.3.0 该方法有bug请升级到之后的版本如`3.3.1.8-SNAPSHOT`)*/
        /* 上面选其一使用,下面的已过时(注意 strictInsertFill 有多个方法,详细查看源码) */
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        //this.setInsertFieldValByName("operator", "Jerry", metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐使用)
//        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now()); // 也可以使用(3.3.0 该方法有bug请升级到之后的版本如`3.3.1.8-SNAPSHOT`)
        /* 上面选其一使用,下面的已过时(注意 strictUpdateFill 有多个方法,详细查看源码) */
        //this.setFieldValByName("operator", "Tom", metaObject);
        //this.setUpdateFieldValByName("operator", "Tom", metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
