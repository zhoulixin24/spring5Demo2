package org.example.testdemo;

import org.example.aoptest.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aspectJTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
