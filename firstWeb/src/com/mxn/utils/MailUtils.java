package com.mxn.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件发送工具类
 *
 * @author Geenk-MXN
 * @create 2018-03-14 10:10
 */

public class MailUtils {
    /**
     * 发送邮件
     *
     * @param toMail 目标邮箱
     * @param code   激活码
     */
    public static void sendMail(String toMail, String code) throws Exception {
        //1.创建链接对象，连接邮箱服务器
        Properties props = new Properties(); //可用来设置主题名，服务器地址等信息
//        props.setProperty("host","www.geenk.com"); // 服务器地址
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("service@mxn.com", "123qwe");
            }
        });
        //2.创建邮件对象
        Message message = new MimeMessage(session);
        //2.1 设置发件人
        message.setFrom(new InternetAddress("service@mxn.com"));
        //2.2 设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
        //2.3 设置主题
        message.setSubject("来自 mxn 激活邮件");
        //2.4 设置邮件正文
        message.setContent("<h1>正文内容,激活点击以下链接：</h1><h3><a href='http://127.0.0.1:8080/firstWeb/ActiveServlet?code=" + code + "'>http://127.0.0.1:8080/firstWeb/ActiveServlet?code=" + code + "</a></h3>", "text/html;charset=UTF-8");

        //3.发送邮件
        Transport.send(message);
    }
}
