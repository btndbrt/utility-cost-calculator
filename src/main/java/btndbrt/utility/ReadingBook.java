package btndbrt.utility;

import java.util.ArrayList;
import java.util.List;

public class ReadingBook {
    private final List<MeterReading> readings = new ArrayList<>();

    public void add(MeterReading newReading) {
        if (newReading == null) {
            throw new IllegalArgumentException("reading must not be null");
        }
        for (int i = 0; i < readings.size(); ++i) {
            if (readings.get(i).getPeriod().equals(newReading.getPeriod()) && readings.get(i).getUtilityType() == newReading.getUtilityType()) {
                throw new IllegalArgumentException("Reading with this period and UtilityType already exists");
            }
        }
        readings.add(newReading);
    }

    public List<MeterReading> getAll() {
        return List.copyOf(this.readings);
    }
}
