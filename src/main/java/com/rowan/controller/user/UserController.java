package com.rowan.controller.user;


import com.rowan.core.common.BaseController;
import com.rowan.core.model.PageInfo;
import com.rowan.core.model.ResultApi;
import com.rowan.po.User;
import com.rowan.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户
 * @author zhangHao
 * @date 2019/7/15 23:14
*/
@Api(tags = "用户")
@RestController
@RequestMapping("/technology")
@CommonsLog
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("获取用户登陆列表")
    @GetMapping("/getUserInfoList")
    public ResultApi<PageInfo<User>> getUserInfoList(){
        startPage();
        List<User> result =userService.getUserInfoList();
        PageInfo<User> pageInfo = pageInfo();
        pageInfo.setResultList(result);
        return respond500(pageInfo);
    }

    @ApiOperation("获取用户登陆列表")
    @GetMapping("/saveUserInfo")
    public ResultApi<String> saveUserInfo(){
        int i = userService.saveUserInfo();
        return respond500(i);
    }


}