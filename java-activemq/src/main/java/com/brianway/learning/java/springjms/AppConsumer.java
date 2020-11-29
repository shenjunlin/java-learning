package com.brianway.learning.java.springjms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shenjunlin on 2020/11/29 21:51
 */
public class AppConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");

    }

}
