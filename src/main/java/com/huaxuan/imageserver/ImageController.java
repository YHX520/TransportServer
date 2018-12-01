package com.huaxuan.imageserver;


import com.huaxuan.imageserver.logtool.L;
import com.huaxuan.imageserver.unit.SystemParameter;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;


@RestController
public class ImageController {

    @RequestMapping(value = "/getImage",method = RequestMethod.POST)
    public String getImage(String token, String imageName, HttpServletResponse response) throws FileNotFoundException {
        L.i(imageName);
        File file=new File(SystemParameter.imagePath,imageName);
        FileInputStream fileInputStream=new FileInputStream(file);
        return "hi"+imageName;
    }


}
