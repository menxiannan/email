package com.mxn.dao.impl;

import com.mxn.dao.UsersDao;
import com.mxn.domain.Users;
import com.mxn.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * @author Geenk-MXN
 * @create 2018-03-12 16:48
 */

public class UsersDaoImpl implements UsersDao {
    /**
     * 添加用户
     *
     * @param users
     * @throws Exception
     */
    @Override
    public void regist(Users users) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into users values (?,?,?,?,?,?,?)";
        Object[] params = {users.getUid(), users.getUsername(), users.getPassword(),
                users.getNickname(), users.getEmail(), users.getState(), users.getCode()};
        queryRunner.update(sql, params);
    }

    /**
     * 根据激活码查询用户
     *
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public Users findByCode(String code) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT * FROM `users` u WHERE  u.`CODE`=?";
        Users users = queryRunner.query(sql, new BeanHandler<Users>(Users.class), code);
        return users;
    }

    @Override
    public void updateUsers(Users users) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "UPDATE users SET username = ?,password = ?," +
                "nickname=?,email=?,state=?,code=? WHERE uid = ?";
        Object[] params = {users.getUsername(), users.getPassword(),
                users.getNickname(), users.getEmail(), users.getState(), users.getCode(),
                users.getUid()};
        queryRunner.update(sql, params);

    }
}
