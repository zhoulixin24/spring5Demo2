package org.example.testdemo;

import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//动态代理底层原理代码实现，spring中会封装
public class ProxyTest {
    public static void main(String[] args) {
        //创建接口实现代理类
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        //获取代理类对象
        UserDao userDao1 = (UserDao)Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        userDao1.add();
        userDao1.delete(2,1);
    }
}

//创建代理对象
class UserDaoProxy implements InvocationHandler {

    private Object obj;
    //将需要增强的类传进来
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //方法之前
        System.out.println("方法执行之前"+method.getName()+"传递参数"+ Arrays.toString(objects));
        //被增强的方法
        Object res = method.invoke(obj,objects);
        //方法之后
        System.out.println("方法执行之后"+obj);
        return res;
    }
}
