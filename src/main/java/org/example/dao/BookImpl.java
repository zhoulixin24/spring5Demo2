package org.example.dao;

import org.example.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookImpl implements BookDao {
    //注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //新增
    @Override
    public void add(Book book) {
        String strSql = "insert into bookinfo(bookName,auther) values(?,?)";
        //会返回一个数字，数字代表有几条数据受到影响
       int update = jdbcTemplate.update(strSql,book.getBookName(),book.getAuther());
       if (update >0){
           System.out.println("新增成功");
       }else{
           System.out.println("新增失败");
       }
    }
    //更新
    @Override
    public void update(Book book) {
        String sql = "update bookinfo set bookName=?,auther=? where id =?";
        Object[] args = {book.getBookName(),book.getBookName(),book.getId()};
        int update = jdbcTemplate.update(sql,args);
        if (update >0){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }
    //删除
    @Override
    public void delete(int id) {
        String sql = "delete from bookinfo  where id =?";
        int update = jdbcTemplate.update(sql,id);
        if (update >0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from bookinfo";
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }


}
