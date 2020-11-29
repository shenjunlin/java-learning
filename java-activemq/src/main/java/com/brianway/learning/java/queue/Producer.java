package com.brianway.learning.java.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Created by shenjunlin on 2020/11/29 20:12
 */
public class Producer {

    private static final String url = "tcp://127.0.0.1:61616";
    private static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

        Connection connection = connectionFactory.createConnection();
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目标
        Destination destination = session.createQueue(queueName);
        //创建生产者
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 2; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage("text" + i);
            //发送消息
            producer.send(textMessage);
            System.out.println("发送消息成功" + textMessage.getText());
        }

        connection.close();
    }
}
