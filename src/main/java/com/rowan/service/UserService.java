package com.rowan.service;

import com.alibaba.fastjson.JSONObject;
import com.rowan.constants.RedisConstant;
import com.rowan.core.common.ResultApi;
import com.rowan.core.dao.DataSource;
import com.rowan.core.dao.RedisDao;
import com.rowan.core.util.Md5;
import com.rowan.mapper.UserMapper;
import com.rowan.model.dto.UserDto;
import com.rowan.model.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 用户信息
 *
 * @author zhanghao
 * @date 2019/9/26 18:05
 **/
@Service
@Slf4j
@DataSource("technology")
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisDao redisDao;

    /**
     * 获取用户登陆列表
     *
     * @return
     * @author zhanghao
     * @date 2019/8/23 18:46
     **/
    public List<User> getUserInfoList() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    /**
     * 保存用户信息
     *
     * @param userDto
     * @return
     */
    public User saveUserInfo(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setPassword(Md5.encode(user.getPassword()));
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
        //int a = 5 / 0;
        return user;
    }

    public ResultApi<String> login(String username, String password) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("username", username);
        map.put("password", Md5.encode(password));
        User user = userMapper.selectUserInfoByMap(map);
        if (user == null) {
            return ResultApi.build(600, "用户名或密码不正确");
        }
        //token随机生成，可以换成更安全的生成规则
        String token = UUID.randomUUID().toString();
        user.setPassword(null);
        redisDao.setForHour(RedisConstant.LOGIN + token, JSONObject.toJSONString(user), 3);
        return ResultApi.ok(token);
    }
}
