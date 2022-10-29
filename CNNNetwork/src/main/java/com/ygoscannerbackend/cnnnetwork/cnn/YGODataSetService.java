package com.ygoscannerbackend.cnnnetwork.cnn;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.image.recordreader.ImageRecordReader;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.datasets.iterator.impl.CifarDataSetIterator;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

import java.io.File;
import java.util.List;

public class YGODataSetService implements IDataSetService {

    private final InputType inputType = InputType.convolutional(32, 32, 3);
    private final int trainImagesNum = 512;
    private final int testImagesNum = 128;
    private final int trainBatch = 16;
    private final int testBatch = 8;

    private final DataSetIterator trainIterator;

    private final CifarDataSetIterator testIterator;

    public YGODataSetService() {
        // TODO read in data
        RecordReader imageRecordReader = new ImageRecordReader();
        imageRecordReader.initialize(new FileSplit(new File()));
        trainIterator = new RecordReaderDataSetIterator();
        testIterator = new RecordReaderDataSetIterator();
    }

    @Override
    public DataSetIterator trainIterator() {
        return trainIterator;
    }

    @Override
    public DataSetIterator testIterator() {
        return testIterator;
    }

    @Override
    public InputType inputType() {
        return inputType;
    }

    @Override
    public List<String> labels() {
        return trainIterator.getLabels();
    }
}
