package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private int numOfElements = 0;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[]{};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        final int ILLEGAL = -273;
        for (double value: temperatureSeries) {
            if (value < ILLEGAL) {
                throw  new InputMismatchException("Value lower "
                        +
                        "than -237 is found");
            }
        }
        this.temperatureSeries = Arrays.copyOf(temperatureSeries,
                temperatureSeries.length);
        this.numOfElements = temperatureSeries.length;
    }

    public double average() {
        this.checkEmpty();
        double sum = 0;
        for (int i = 0; i < this.numOfElements; i++) {
            sum += this.temperatureSeries[i];
        }
        return sum/this.numOfElements;
    }

    public double deviation() {
        this.checkEmpty();
        double sum = 0;
        double average = this.average();
        for (int i = 0; i < this.numOfElements; i++) {
            sum = (this.temperatureSeries[i] - average)
                    *(this.temperatureSeries[i] - average);
        }
        return Math.sqrt(sum/this.numOfElements);
    }

    public double min() {
        this.checkEmpty();
        double minValue = temperatureSeries[0];
        for (int i = 1; i < this.numOfElements; i++) {
            if (this.temperatureSeries[i] < minValue) {
                minValue = this.temperatureSeries[i];
            }
        }
        return minValue;
    }

    public double max() {
        this.checkEmpty();
        double maxValue = temperatureSeries[0];
        for (int i = 1; i < this.numOfElements; i++) {
            if (this.temperatureSeries[i] > maxValue) {
                maxValue = this.temperatureSeries[i];
            }
        }
        return maxValue;
    }

    public double findTempClosestToZero() {
        return this.findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        this.checkEmpty();
        double dist = Math.abs(temperatureSeries[0] - tempValue);
        int idx = 0;
        for (int i = 1; i < this.numOfElements; i++) {
            double newDist = Math.abs(temperatureSeries[i] - tempValue);
            if (newDist < dist) {
                idx = i;
                dist = newDist;
            } else if (Math.abs(newDist - dist) < 0.00000001) {
                if (temperatureSeries[i] > temperatureSeries[idx]) {
                    idx = i;
                }
            }
        }
        return temperatureSeries[idx];
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] lessThanValue = new double[this.numOfElements];
        int idx = 0;
        for (int i = 0; i < this.numOfElements; i++) {
            if (this.temperatureSeries[i] < tempValue) {
                lessThanValue[idx] = this.temperatureSeries[i];
                idx++;
            }
        }
        return Arrays.copyOfRange(lessThanValue, 0, idx);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] greaterThanValue = new double[this.numOfElements];
        int idx = 0;
        for (int i = 0; i < this.numOfElements; i++) {
            if (this.temperatureSeries[i] > tempValue) {
                greaterThanValue[idx] = this.temperatureSeries[i];
                idx++;
            }
        }
        return Arrays.copyOfRange(greaterThanValue, 0, idx);
    }

    public TempSummaryStatistics summaryStatistics() {
        this.checkEmpty();
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps) {
        if (this.temperatureSeries.length
                <
                this.temperatureSeries.length + temps.length) {
            double[] newArr = new double[this.temperatureSeries.length * 2];
            for (int i = 0; i < this.numOfElements; i++) {
                newArr[i] = this.temperatureSeries[i];
            }
            this.temperatureSeries = Arrays.copyOf(newArr, newArr.length);
        }
        int idx = 0;
        for (int i = this.numOfElements; i
                <
                this.numOfElements + temps.length; i++) {
            this.temperatureSeries[i] = temps[idx];
            idx++;
        }
        this.numOfElements = this.numOfElements + temps.length;
        return this.numOfElements;
    }

    private void checkEmpty() {
        if (this.numOfElements == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
    }

}
