package org.example.service;


import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 在注解里面 value属性值可以省略不写
 * 默认值是类名称 首字母小写
 */

//@Component(value = "userService")
//@Component
    @Service
public class UserService {

        @Autowired
        @Qualifier(value = "userDaoImpl")
    public UserDao userDao;
    public void add(){
        System.out.println("UserService add..........");
        userDao.add();
    }
}
