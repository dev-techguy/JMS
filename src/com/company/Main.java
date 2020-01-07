package com.company;

import java.sql.Connection;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    Connection connection;

    void runJMS() {
        try {
            //connect to database
            connection = Database.getConnection();
            if (connection != null) {
                System.out.println("Connection Established\n");
            } else {
                System.out.println("Connection Failed\n");
            }

            int delay = 5000; // delay for 5sec
            int period = 10000; //repeat every 1min
            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    //pass messages to the queue from the rest api
                    new API().api();
                }
            }, delay, period);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().runJMS();
    }
}
