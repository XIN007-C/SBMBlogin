package com.springboot_mybatis.service;

import com.springboot_mybatis.entity.User;
import com.springboot_mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findByName(String name) {
        return userMapper.findUserByName(name);
    }

    public List<User> findUserByPassword(String name,String password) {
        return userMapper.findUserByPassword(name,password);
    }

    public List<User> findNByJ(String name, String jurisdiction) {
        return userMapper.findNameByJurisdiction(name, jurisdiction);
    }

    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    public List<User> ListUser(){
        return  userMapper.ListUser();
    }
    public List<User> Update(String password1, String name){
        return userMapper.Update(password1, name);
    }

    public int delete(int id){
        return userMapper.delete(id);
    }
}
