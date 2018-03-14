package com.mxn.service.impl;

import com.mxn.dao.UsersDao;
import com.mxn.dao.impl.UsersDaoImpl;
import com.mxn.domain.Users;
import com.mxn.service.UsersService;
import com.mxn.utils.MailUtils;

/**
 * @author Geenk-MXN
 * @create 2018-03-12 16:48
 */

public class UsersServiceImpl implements UsersService {
    @Override
    public void regist(Users users) throws Exception {
        //将数据存到数据库
        UsersDao usersDao = new UsersDaoImpl();
        usersDao.regist(users);
        //发送激活邮件
        MailUtils.sendMail(users.getEmail(), users.getCode());
    }


    @Override
    public Users findByCode(String code) throws Exception {
        UsersDao usersDao = new UsersDaoImpl();
        Users user = usersDao.findByCode(code);
        return user;
    }


    @Override
    public void updateUsers(Users users) throws Exception {
        UsersDao usersDao = new UsersDaoImpl();
        usersDao.updateUsers(users);

    }
}
