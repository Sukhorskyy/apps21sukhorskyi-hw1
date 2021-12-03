package ua.edu.ucu.tempseries;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public final class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics(TemperatureSeriesAnalysis tempAnalysis) {
        this.avgTemp = tempAnalysis.average();
        this.devTemp = tempAnalysis.deviation();
        this.minTemp = tempAnalysis.min();
        this.maxTemp = tempAnalysis.max();
    }
}
