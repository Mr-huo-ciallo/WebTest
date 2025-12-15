package com.my;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        try {
            // 加载所有Spring配置文件
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "application-dao.xml",
                "application-service.xml",
                "spring-mvc.xml"
            );
            System.out.println("Spring上下文初始化成功！");
            context.close();
        } catch (Exception e) {
            System.out.println("Spring上下文初始化失败：");
            e.printStackTrace();
        }
    }
}