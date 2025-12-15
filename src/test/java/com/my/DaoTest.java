package com.my;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
    public static void main(String[] args) {
        try {
            // 只加载DAO层配置
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
            System.out.println("DAO层配置加载成功！");
            context.close();
        } catch (Exception e) {
            System.out.println("DAO层配置加载失败：");
            e.printStackTrace();
        }
    }
}