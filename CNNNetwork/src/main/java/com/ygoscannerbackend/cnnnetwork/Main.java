package com.ygoscannerbackend.cnnnetwork;

import com.ygoscannerbackend.cnnnetwork.cnn.Network;
import com.ygoscannerbackend.cnnnetwork.cnn.YGODataSetService;
import org.apache.log4j.BasicConfigurator;

public class Main {
    public static void main(String[] args) {

        BasicConfigurator.configure();

        YGODataSetService ygoDataSetService = new YGODataSetService();
        Network network = new Network(ygoDataSetService);

        network.train();

        network.evaluate();
    }
}