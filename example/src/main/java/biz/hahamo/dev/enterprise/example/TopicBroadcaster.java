package biz.hahamo.dev.enterprise.example;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

/**
 * 
 * @author GHajba
 */
public class TopicBroadcaster {

    @Resource(lookup = "ExampleConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "example.topic")
    private Topic topic;

    public void postTestMessage() throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(topic);

        messageProducer.send(session.createTextMessage("Hello JMS example!"));
    }

    public void postTextObjectMessage() throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(topic);

        messageProducer.send(session.createObjectMessage("Hello JMS example!"));
    }

}