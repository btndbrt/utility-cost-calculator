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

    public int usageSince(MeterReading previous) {
        if (previous == null) {
            throw new IllegalArgumentException("period must not be null");
        }
        if (this.utilityType != previous.utilityType) {
            throw new IllegalArgumentException("The two readings must be the same utility type");
        }
        if (!this.period.isAfter(previous.period)) {
            throw new IllegalArgumentException("The previous reading's period must be before the current one's");
        }
        if (this.value < previous.value) {
            throw new IllegalArgumentException("The previous reading's value must not be higher than the current value");
        }
        
        return this.value - previous.value;
    }
}
