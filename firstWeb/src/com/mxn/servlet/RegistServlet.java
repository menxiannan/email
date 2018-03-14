package com.mxn.servlet;

import com.mxn.domain.Users;
import com.mxn.service.UsersService;
import com.mxn.service.impl.UsersServiceImpl;
import com.mxn.utils.UUIDUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Geenk-MXN
 * @create 2018-03-12 16:49
 */
public class RegistServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            //提交
            //接受数据
            //中文乱码
            request.setCharacterEncoding("UTF-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nickname = request.getParameter("nickname");
            String email = request.getParameter("email");
            //封装数据
            Users users = new Users();
            users.setUsername(username);
            users.setPassword(password);
            users.setNickname(nickname);
            users.setEmail(email);
            users.setState(0); //0未激活 1已激活
            users.setCode(UUIDUtils.getUUID() + UUIDUtils.getUUID());

            //调用业务层处理数据
            UsersService usersService = new UsersServiceImpl();
            usersService.regist(users);
            //页面跳转
            request.setAttribute("msg","注册成功，请去邮箱激活!");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


}
