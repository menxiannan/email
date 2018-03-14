package com.mxn.dao;

import com.mxn.domain.Users;

/**
 * @author Geenk-MXN
 * @create 2018-03-12 16:47
 */
public interface UsersDao {
    void regist(Users users) throws Exception;

    Users findByCode(String code) throws Exception;

    void updateUsers(Users users) throws Exception;
}
