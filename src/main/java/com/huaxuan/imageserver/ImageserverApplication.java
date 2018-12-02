package com.huaxuan.imageserver;

import okhttp3.OkHttpClient;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImageserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImageserverApplication.class, args);

    }
}
