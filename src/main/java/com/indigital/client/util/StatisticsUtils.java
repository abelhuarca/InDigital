package com.indigital.client.util;

import java.util.List;

public class StatisticsUtils {

    public static double calculateStandardDeviation(List<Double> doubleList) {
        double sum = 0.0;
        double standardDeviation = 0.0;
        int length = doubleList.size();
        for (double num : doubleList) {
            sum += num;
        }
        double mean = sum / length;
        for (double num : doubleList) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        return Math.sqrt(standardDeviation / length);
    }

}
