package com.my;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleTest {
    public static void main(String[] args) {
        try {
            System.out.println("Loading application-dao.xml...");
            ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
            System.out.println("Spring context loaded successfully!");
            System.out.println("Bean count: " + context.getBeanDefinitionCount());
        } catch (Exception e) {
            System.out.println("Error loading Spring context:");
            e.printStackTrace();
        }
    }
}