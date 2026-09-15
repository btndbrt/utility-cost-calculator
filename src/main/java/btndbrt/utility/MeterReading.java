package btndbrt.utility;
import java.time.YearMonth;

public class MeterReading {
    private final UtilityType utilityType;
    private final YearMonth period;
    private final int value;

    public MeterReading(UtilityType utilityType, YearMonth period, int value) {
        if (utilityType == null) {
            throw new IllegalArgumentException("UtilityType must not be null");
        }
        if (period == null) {
            throw new IllegalArgumentException("period must not be null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("value must not be negative: " + value);
        }
        this.utilityType = utilityType;
        this.period = period;
        this.value = value;
    }

    public UtilityType getUtilityType() {
        return utilityType;
    }

    public YearMonth getPeriod() {
        return period;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return utilityType + " " + period + ": " + value;
    }
}
