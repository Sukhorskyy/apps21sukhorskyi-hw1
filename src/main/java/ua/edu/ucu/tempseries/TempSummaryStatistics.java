package ua.edu.ucu.tempseries;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public final class TempSummaryStatistics {
    final private double avgTemp;
    final private double devTemp;
    final private double minTemp;
    final private double maxTemp;

    public TempSummaryStatistics(TemperatureSeriesAnalysis tempAnalysis) {
        this.avgTemp = tempAnalysis.average();
        this.devTemp = tempAnalysis.deviation();
        this.minTemp = tempAnalysis.min();
        this.maxTemp = tempAnalysis.max();
    }
}
