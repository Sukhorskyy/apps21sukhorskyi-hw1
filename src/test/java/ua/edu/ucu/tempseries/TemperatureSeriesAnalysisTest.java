package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class TemperatureSeriesAnalysisTest {
    TemperatureSeriesAnalysis seriesAnalysis;
    double[] generalTemperatureSeries = {3.0, -5.0, 1.0, 5.0};

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        seriesAnalysis = new TemperatureSeriesAnalysis(generalTemperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviation() {
        seriesAnalysis = new TemperatureSeriesAnalysis(generalTemperatureSeries);
        double expResult = 2.0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() {
        seriesAnalysis = new TemperatureSeriesAnalysis(generalTemperatureSeries);
        double expResult = -5.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMax() {
        seriesAnalysis = new TemperatureSeriesAnalysis(generalTemperatureSeries);
        double expResult = 5.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero() {
        seriesAnalysis = new TemperatureSeriesAnalysis(generalTemperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue() {
        seriesAnalysis = new TemperatureSeriesAnalysis(generalTemperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(1.8);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThen() {
        seriesAnalysis = new TemperatureSeriesAnalysis(generalTemperatureSeries);
        double[] expResult = {-5.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(0);
        assertTrue(Arrays.equals(expResult, actualResult));
    }

    @Test
    public void testFindTempsGreaterThen() {
        seriesAnalysis = new TemperatureSeriesAnalysis(generalTemperatureSeries);
        double[] expResult = {3.0, 5.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1);
        assertTrue(Arrays.equals(expResult, actualResult));
    }

    @Test
    public void testSummaryStatistics() {
        seriesAnalysis = new TemperatureSeriesAnalysis(generalTemperatureSeries);
        String expResult = "TempSummaryStatistics(avgTemp=1.0, devTemp=2.0, minTemp=-5.0, maxTemp=5.0)";
        String actualResult = seriesAnalysis.summaryStatistics().toString();
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testAddTemps() {
        seriesAnalysis = new TemperatureSeriesAnalysis(generalTemperatureSeries);
        seriesAnalysis.addTemps(5.9);
    }

}
