package org.example.dao;

import org.example.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookImpl implements BookDao{
    //注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //新增
    @Override
    public void add(Book book) {
        String strSql = "insert into bookinfo values(?,?)";
        //会返回一个数字，数字代表有几条数据受到影响
       int update = jdbcTemplate.update(strSql,book.getBookName(),book.getAuther());
       if (update >0){
           System.out.println("新增成功");
       }else{
           System.out.println("新增失败");
       }
    }
}
