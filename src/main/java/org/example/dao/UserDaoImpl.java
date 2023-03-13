package org.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("UserDao..............");
    }

    @Override
    public int delete(int a, int b) {
        System.out.println(a-b);
        return a-b;
    }
}
