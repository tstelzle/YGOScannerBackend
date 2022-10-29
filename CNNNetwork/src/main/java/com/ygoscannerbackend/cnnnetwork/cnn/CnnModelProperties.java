package com.ygoscannerbackend.cnnnetwork.cnn;

import lombok.Value;
import org.deeplearning4j.nn.conf.Updater;

@Value
public class CnnModelProperties {
    int epochsNum = 512;

    double learningRate = 0.001;

    Updater optimizer = Updater.ADAM;
}