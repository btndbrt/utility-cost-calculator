package btndbrt.utility;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.YearMonth;

import org.junit.jupiter.api.Test;

public class ReadingBookTest {

    @Test
    void addWorking() {
        ReadingBook r0 = new ReadingBook();
        MeterReading m0 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 1000);
        r0.add(m0);
        assertEquals(m0, r0.getAll().get(0));
    }

    @Test
    void duplicateThrows() {
        ReadingBook r0 = new ReadingBook();
        MeterReading m0 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 1000);
        MeterReading m1 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 1500);

        r0.add(m0);
        assertThrows(IllegalArgumentException.class, () -> r0.add(m1));
    }

    @Test
    void nullThrows() {
        ReadingBook r0 = new ReadingBook();
        assertThrows(IllegalArgumentException.class, () -> r0.add(null));
    }

    @Test
    void diffUtilSamePeriodFine() {
        ReadingBook r0 = new ReadingBook();
        MeterReading m0 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 1000);
        MeterReading m1 = new MeterReading(UtilityType.WATER, YearMonth.of(2026, 9), 1500);
        r0.add(m0);
        assertDoesNotThrow(() -> r0.add(m1));
    }

    @Test
    void invalidIdThrows() {
        ReadingBook r0 = new ReadingBook();
        MeterReading m0 = new MeterReading(UtilityType.GAS, YearMonth.of(2026, 9), 1000);
        r0.add(m0);
        assertThrows(IllegalArgumentException.class, () -> r0.delete(1));
    }
}
