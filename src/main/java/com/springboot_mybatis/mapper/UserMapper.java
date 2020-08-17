package com.springboot_mybatis.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.springboot_mybatis.entity.User;
@Mapper
public interface UserMapper {
    List<User> findUserByName(String name);
    public List<User> ListUser();
    public List<User> insertUser(User user);
    public int delete(int id);
    public List<User> Update(String password1, String name);
    List<User> findUserByPassword(String name, String password);
    List<User> findNameByJurisdiction(String name, String jurisdiction);
}