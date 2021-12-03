package ua.edu.ucu.tempseries;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] temp = {0.7, 8.12, -0.2, 0.02, 0.2};
        TemperatureSeriesAnalysis s = new TemperatureSeriesAnalysis(temp);
        System.out.println(s.findTempClosestToValue(7));
        System.out.println(s.findTempClosestToZero());
        System.out.println(s.max());
        System.out.println(s.min());
        System.out.println(s.average());
        System.out.println(s.deviation());
        System.out.println(Arrays.toString(s.findTempsLessThen(2)));
        System.out.println(Arrays.toString(s.findTempsGreaterThen(2)));
        System.out.println(s.summaryStatistics().toString());
        s.addTemps(0.89, 8.2);
        //System.out.println(Arrays.toString(s.temperatureSeries));
        s.addTemps(1, 5, 9, 0.95, 4);
        //System.out.println(Arrays.toString(s.temperatureSeries));
        System.out.println(s.average());
        System.out.println(Arrays.toString(s.findTempsLessThen(2)));
        System.out.println(s.max());
        s.addTemps(16);
        System.out.println(s.max());
        System.out.println(s.summaryStatistics().toString());
    }
}
