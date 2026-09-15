package btndbrt.utility;
import java.time.YearMonth;

public class Main {
    public static void main(String args[]) {
        UtilityType utilityType = UtilityType.GAS;
        YearMonth period = YearMonth.of(2026, 2);
        int value = 2000;
        MeterReading reading1 = new MeterReading(utilityType, period, value);
        System.out.print(reading1 + "\n");
    }
}