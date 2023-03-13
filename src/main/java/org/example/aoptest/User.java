package org.example.aoptest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 第一步 创建类
 */
@Component
public class User {
    public void add(){
        System.out.println("新增");
    }
}
