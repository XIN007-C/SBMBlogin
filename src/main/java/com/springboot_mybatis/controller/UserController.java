package com.springboot_mybatis.controller;

import com.springboot_mybatis.entity.User;
import com.springboot_mybatis.mapper.UserMapper;
import com.springboot_mybatis.service.UserService;
import com.springboot_mybatis.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Controller
public class UserController {
    @Autowired
    private UserService userservice;

    @Autowired
    private UserMapper userMapper;

    //登录成功后，查询所有数据
    @RequestMapping("/userList")
    public String ListUser(Model model, HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String jurisdiction = request.getParameter("jurisdiction");
        if (userMapper.findUserByPassword(name,password).size() != 0) {  //查询数据库该条数据是否存在
            if (!CodeUtil.checkVerifyCode(request)) {       //判断验证码是否正确
                return "examine";
            } else {
                //通过name和jurisdiction判断账号身份
                if (jurisdiction.equals("管理员")) {
                    if (userMapper.findNameByJurisdiction(name, jurisdiction).size() != 0) {
                        List<User> userList = userservice.ListUser();
                        model.addAttribute("userList", userList);
                        return "listAdministrator";
                    } else {
                        return "jurisdictionerror";
                    }
                } else {
                    if (userMapper.findNameByJurisdiction(name, jurisdiction).size() != 0) {
                        List<User> userList = userservice.ListUser();
                        model.addAttribute("userList", userList);
                        return "listUser";
                    } else {
                        return "jurisdictionerror";
                    }
                }
            }
        } else {
            return "ringup";
        }
    }

    //注册账号
    @RequestMapping(value = "/insert")
    public String insert(User user, HttpServletRequest request)
    {
        if (userMapper.findUserByName(request.getParameter("username")).size() == 0) {  //查询数据库是否有该数据
            user.setName(request.getParameter("username"));     //获取注册的用户账号，存放到数据库
            user.setPassword(request.getParameter("password2"));  //获取注册的用户密码，存放到数据库
            userservice.insertUser(user);
            return "enter";
        } else {
            return "usernameisexist";
        }
    }

    //修改密码
    @RequestMapping(value = "/update")
    public String update(HttpServletRequest request) {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        if (userMapper.findUserByPassword(name,password).size() != 0) {  //查询数据库该条数据是否存在
            String password1 = request.getParameter("password2");
            userMapper.Update(password1, name);
            return "请重新访问登录页面！！！";
        } else {
            return "update";
        }
    }

    //删除用户
    @RequestMapping(value = "/delete")
    public String delete(int id) {
        int result = userservice.delete(id);
        if (result >= 1) {
            return "Refresh";
        } else {
            return "Refresh_the_list";
        }
    }
}
