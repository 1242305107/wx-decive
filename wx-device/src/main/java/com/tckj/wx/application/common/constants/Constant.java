package com.tckj.wx.application.common.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WCH
 * @date 2020/6/28 14:40
 */
public class Constant {

    public static final int BYTE_BUFFER = 1024;
    public static final int BUFFER_MULTIPLE = 10;

    public static final String PASSWORD = "123456";

    public static final Integer PERMISSION_PARENT_ID = 0;

    //存储用户登录前的位置
    public static Map<String, String> RETURN_URL = new HashMap<>();

    //验证码过期时间(90秒)
    public static final Long PASS_TIME = 90 *1000L;




    /**
     * 用户注册默认角色
     */
    public static final int DEFAULT_REGISTER_ROLE = 5;


    //根菜单节点
    public static final String ROOT_MENU = "0";

    //菜单类型，1：菜单  2：按钮操作
    public static final int TYPE_MENU = 1;

    //菜单类型，1：菜单  2：按钮操作
    public static final int TYPE_BUTTON = 2;

    public static boolean isMethodPass =false;

    //启用
    public static final int ENABLE = 1;
    //禁用
    public static final int DISABLE = 0;

    //通过
    public static final int PASS = 1;
    //驳回
    public static final int NOT_PASS =0;


    public static final  String QingHaiProvinceID = "630000";



    public static class FilePostFix {
        public static final String ZIP_FILE = ".zip";
        public static final String [] RASTER={".img",".tif"};

        public static final String[] IMAGES = {"jpg", "jpeg", "JPG", "JPEG", "gif", "GIF", "bmp", "BMP", "png","PNG","svg","SVG"};
        public static final String[] ZIP = {"ZIP", "zip", "rar", "RAR"};
        public static final String[] VIDEO = {"mp4", "MP4", "mpg", "mpe", "mpa", "m15", "m1v", "mp2", "rmvb"};
        public static final String[] APK = {"apk", "exe"};
        public static final String[] OFFICE = {"xls", "xlsx", "docx", "doc", "ppt", "pptx"};
        public static final String STYLEFILE=".sld";

    }

    public static class FileType {
        public static final String FILE_IMG = "image";
        public static final String FILE_ZIP = "zip";
        public static final String FILE_VEDIO = "video";
        public static final String FILE_APK = "apk";
        public static final String FILE_OFFICE = "office";
        public static final String FILE_OTHER = "other";
        public static final String FILE_IMG_DIR = "/img/";
        public static final String FILE_ZIP_DIR = "/zip/";
        public static final String FILE_VEDIO_DIR = "/video/";
        public static final String FILE_APK_DIR = "/apk/";
        public static final String FILE_OFFICE_DIR = "/office/";
        public static final String FILE_OTHER_DIR = "/other/";
    }


    public class RoleType{
        //超级管理员
        public static final String SYS_ASMIN_ROLE= "sysadmin";
        //省级管理员
        public static final String PROVINCE_ADMIN= "provinceAdmin";
        //市级管理员
        public static final String CITY_ADMIN= "cityAdmin";
        //县级管理员
        public static final String AREA_ADMIN= "areaAdmin";
        //县级用户
        public static final String AREA_USER= "areaUser";
        //普通用户
        public static final String USER= "user";
    }

    /**
     * 草类型
     */
    public static class GrassType{
        //人工饲草
        public static final int ARTIFICIAL = 1;
        //牧草
        public static final int PASTURE = 2;
        //任务申请
        public static final int APPLY = 0;

    }

    /**
     * 任务的状态
     */
    public static class Status{
        //待提交
        public static final String WAIT_SUBMIT = "waitSubmit";
        //待市级审核
        public static final String WAIT_CITY_HANDLE = "waitCityHandle";
        //待省级审核
        public static final String WAIT_Province_HANDLE = "waitProvinceHandle";
        //已完成
        public static final String FINISHED = "finished";
        //待省级下达
        public static final String WAIT_Province_AGREE = "waitProvinceAgree";
    }

    /**
     * 角色对应的任务所有状态
     */
    public static class RoleStatus{
        //超级管理员
        public static final String[] SYS_ADMIN_STATUS= {"waitSubmit", "waitCityHandle", "waitProvinceHandle", "waitProvinceAgree", "finished"};
        //省级管理员
        public static final String[] PROVINCE_STATUS= {"waitProvinceHandle", "waitProvinceAgree", "finished"};
        //市级管理员
        public static final String[] CITY_STATUS= {"waitCityHandle", "waitProvinceHandle", "waitProvinceAgree", "finished"};
        //县级管理员
        public static final String[] AREA_STATUS= {"waitSubmit", "waitCityHandle", "waitProvinceHandle", "waitProvinceAgree", "finished"};

    }

    /**
     * 系统编号
     */
    public static class SystemCode{
        public static int year;
        public static int code0;//任务申请
        public static int code1;//人工饲草
        public static int code2;//牧草良种
    }

    /**
     * 附件类型
     */
    public static class AttachmentType{
        //上报
        public static final int REPORT = 1;
        //下达
        public static final int RELEASE = 2;
    }


    /**
     * 按钮类型
     */
    public static class MenuType{
        //大屏
        public static final int config = 1;
        //配置
        public static final int screen = 2;
        //业务
        public static final int business = 0;

    }



}
