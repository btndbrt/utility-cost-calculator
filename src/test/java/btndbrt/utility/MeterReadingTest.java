package btndbrt.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import java.time.YearMonth;

public class MeterReadingTest {

    @Test
    void usageIsDiff() {
        MeterReading mr0 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 8), 2000);
        MeterReading mr1 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 2350);
        int usage = mr1.usageSince(mr0);
        assertEquals(350, usage);
    }
    
    @Test
    void diffUtilitiesThrows() {
        MeterReading mr0 = new MeterReading(UtilityType.ELECTRICITY, YearMonth.of(2026, 8), 2000);
        MeterReading mr1 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 2350);
        assertThrows(IllegalArgumentException.class, () -> mr1.usageSince(mr0));
    }

    @Test
    void prevReadingLaterOrEqualThrows() {
        MeterReading mr0 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 2000);
        MeterReading mr1 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 2350);
        assertThrows(IllegalArgumentException.class, () -> mr1.usageSince(mr0));
    }

    @Test
    void prevReadingHigherThrows() {
        MeterReading mr0 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 8), 2350);
        MeterReading mr1 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 2000);
        assertThrows(IllegalArgumentException.class, () -> mr1.usageSince(mr0));
    }

    @Test
    void prevReadingNullThrows() {
        MeterReading mr0 = null;
        MeterReading mr1 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 2350);
        assertThrows(IllegalArgumentException.class, () -> mr1.usageSince(mr0));
    }

    @Test
    void constructorRejectsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), -2000));
    }
}
