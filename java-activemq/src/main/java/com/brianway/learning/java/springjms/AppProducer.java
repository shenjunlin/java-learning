package com.brianway.learning.java.springjms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shenjunlin on 2020/11/29 21:51
 */
public class AppProducer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        Producer producer = context.getBean(Producer.class);

        producer.sendMessage("test1");

        context.close();
    }

}
