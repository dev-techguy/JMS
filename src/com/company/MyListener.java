package com.company;

import javax.jms.*;

public class MyListener {
    void listen(String text) {
        ConnectionFactory connectionFactory = new ConnectionFactory() {
            @Override
            public Connection createConnection() {
                return null;
            }

            @Override
            public Connection createConnection(String s, String s1) {
                return null;
            }

            @Override
            public JMSContext createContext() {
                return null;
            }

            @Override
            public JMSContext createContext(String s, String s1) {
                return null;
            }

            @Override
            public JMSContext createContext(String s, String s1, int i) {
                return null;
            }

            @Override
            public JMSContext createContext(int i) {
                return null;
            }
        };

        Queue queue = () -> null;

        final int NUM_MSGS = 10;

        try {
            JMSContext context = (JMSContext) connectionFactory.createConnection();
            System.out.println("\nPassing To Queue\n\n " + text);
            if (context != null) {
                context.createProducer().send(queue, text);
            }
//            for (int i = 0; i < NUM_MSGS; i++) {
//                text = "This is message " + (i + 1);
//                System.out.println("Sending message: " + text);
//                if (context != null) {
//                    context.createProducer().send(queue, text);
//                }
//            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
