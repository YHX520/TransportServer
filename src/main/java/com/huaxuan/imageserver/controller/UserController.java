package com.huaxuan.imageserver.controller;

import com.huaxuan.imageserver.dao.UserMapper;
import com.huaxuan.imageserver.dataMode.User;
import com.huaxuan.imageserver.logtool.L;
import com.huaxuan.imageserver.unit.MyNameString;
import com.huaxuan.imageserver.unit.NetStatust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    User user;


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestBody Map<String,Object> map){
        L.i("输入userID:"+map.get("userId"));

        user.setUserid(map.get("userId").toString());
        user.setPhonenumber(map.get("phoneNumber").toString());
        if(userMapper.selectByPrimaryKey(user.getUserid())!=null){

        }
        user.setUserpassword(map.get("password").toString());
        user.setHeadimage(MyNameString.getImage());
        user.setUsername(MyNameString.getName());
        user.setPrice(200);
        try {
            userMapper.insert(user);
        }catch (Exception e){
            return NetStatust.ERROR;
        }

        return NetStatust.SUCCESS;
    }
}
