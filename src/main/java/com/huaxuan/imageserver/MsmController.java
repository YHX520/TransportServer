package com.huaxuan.imageserver;


import com.huaxuan.imageserver.Msm.CHttpPost;
import com.huaxuan.imageserver.Msm.ConfigManager;
import com.huaxuan.imageserver.Msm.Message;
import com.huaxuan.imageserver.logtool.L;
import com.huaxuan.imageserver.unit.SystemParameter;
import okhttp3.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

@RestController
public class MsmController {
    public static final String GET = "GET";
    public static final String POST = "POST";
    private int connectTimeOut = 5;//连接超时 15秒
    private int readTimeOut = 20;
    private int writeTimeOut = 20;
    private String cacheFilePath = SystemParameter.imagePath;//缓存地址
    private long cacheSize = 10 * 1024 * 1024;//缓存10M
    private String url;//请求url
    private String method;//请求方法
    OkHttpClient.Builder oKHttpBuilder;
    OkHttpClient okHttpClient;
    Request.Builder builder;
    FormBody.Builder formBody;
    RequestBody requestBody;
    Request request;
    Call call;
    String userid="E105FJ";
    String pwd="j27WoR";
    boolean isenpwd=false;

    @RequestMapping(value = "/getMsm", method = RequestMethod.GET)
    public String getValidateMsm(String Phone) {
        initOkhttp();


      // singleSend(userid,pwd,isenpwd,Phone);

        return "succes";


    }

    public void initOkhttp() {
        if (okHttpClient == null) {
            synchronized (this) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient.Builder().connectTimeout(connectTimeOut, TimeUnit.SECONDS)
                            .readTimeout(readTimeOut, TimeUnit.SECONDS)
                            .cache(new Cache(new File(cacheFilePath).getAbsoluteFile(), cacheSize)).build();
                }
            }
        }

    }

    public static void singleSend(String userid, String pwd, boolean isEncryptPwd,String PhoneNumber,String validateNumber) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        try {
            // 参数类
            Message message = new Message();
            // 实例化短信处理对象
            CHttpPost cHttpPost = new CHttpPost();

            // 设置账号   将 userid转成大写,以防大小写不一致
            message.setUserid(userid.toUpperCase());

            //判断密码是否加密。
            //密码加密，则对密码进行加密
            if (isEncryptPwd) {
                // 设置时间戳
                String timestamp = sdf.format(Calendar.getInstance().getTime());
                message.setTimestamp(timestamp);

                // 对密码进行加密
                String encryptPwd = cHttpPost.encryptPwd(message.getUserid(), pwd, message.getTimestamp());
                // 设置加密后的密码
                message.setPwd(encryptPwd);

            } else {
                // 设置密码
                message.setPwd(pwd);
            }

            // 设置手机号码 此处只能设置一个手机号码
            message.setMobile("18024367645");
            // 设置内容
            message.setContent("您在帮运APP注册的验证码是2315，在10分钟内有效。如非本人操作请忽略本短信。");
            // 设置扩展号
            message.setExno("11");
            // 用户自定义流水编号
            message.setCustid("2016092919495055");
            // 自定义扩展数据
            //业务类型
            message.setSvrtype("90885");
            message.setApikey("38a1284584c8414fffc0dab5b13d72c0");

            // 返回的平台流水编号等信息
            StringBuffer msgId = new StringBuffer();
            // 返回值
            int result = -310099;
            // 发送短信
            result = cHttpPost.singleSend(message, msgId);
            // result为0:成功;非0:失败
            if (result == 0) {
                System.out.println("单条发送提交成功！");

                System.out.println(msgId.toString());

            } else {
                System.out.println("单条发送提交失败,错误码：" + result);
            }
        } catch (Exception e) {
            //异常处理
            e.printStackTrace();
        }

    }
}
