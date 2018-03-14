package com.mxn.servlet;

import com.mxn.domain.Users;
import com.mxn.service.UsersService;
import com.mxn.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户激活servlet
 *
 * @author Geenk-MXN
 * @create 2018-03-14 10:31
 */
//@WebServlet(name = "ActiveServlet")
public class ActiveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //接受激活码
            String code = request.getParameter("code");
            //根据激活码查询用户
            UsersService usersService = new UsersServiceImpl();
            Users users = usersService.findByCode(code);
            //查到用户，修改账户状态
            if (null != users) {
                users.setState(1);
                users.setCode(null);
                usersService.updateUsers(users);
                request.setAttribute("msg","激活成功！");
            }else{
                //没找到
                request.setAttribute("msg","激活码有误请重新激活！");
            }
            request.getRequestDispatcher("/msg.jsp").forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
