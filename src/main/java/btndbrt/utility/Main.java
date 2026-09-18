package btndbrt.utility;
import java.time.YearMonth;
import java.util.Scanner;
import java.time.DateTimeException;

public class Main {

    public static void main(String args[]) {

        ReadingBook book = new ReadingBook();
        Scanner sc = new Scanner(System.in);

        boolean run = true;

        while (run) {
            System.out.println("***UTILITY COST CALCULATOR CLI***\n");
            System.out.println("1) Add reading\n" + "2) List readings\n" + "0) Exit\n");
            
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    System.out.println("\n1) ELECTRICITY\n" + "2) GAS\n" + "3) WATER\n");
                    line = sc.nextLine();
                    UtilityType utilityType;
                    switch (line) {
                        case "1":
                            utilityType = UtilityType.ELECTRICITY;
                            break;

                        case "2":
                            utilityType = UtilityType.GAS;
                            break;

                        case "3":
                            utilityType = UtilityType.WATER;
                            break;
                    
                        default:
                            System.out.println("Try again.\n");
                            continue;
                    }

                    YearMonth period;

                    System.out.println("Year?\n");
                    line = sc.nextLine();

                    int year;
                    try {
                        year = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    System.out.println("Month?\n");
                    line = sc.nextLine();

                    int month;
                    try {
                        month = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    try {
                        period = YearMonth.of(year, month);
                    } catch (DateTimeException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    System.out.println("Value?\n");
                    line = sc.nextLine();

                    int value;
                    try {
                        value = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    try {
                        MeterReading newReading = new MeterReading(utilityType, period, value);
                        book.add(newReading);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    break;
                
                case "2":

                    break;

                case "0":
                    sc.close();
                    run = false;
                    continue;
            
                default:
                    System.out.println("Try again.\n");
                    break;
            }
        }
    }
}