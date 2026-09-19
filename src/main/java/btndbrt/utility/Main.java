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
            System.out.println("\n***UTILITY COST CALCULATOR CLI***\n");
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
                            System.out.println("Try again");
                            continue;
                    }

                    YearMonth period;

                    System.out.println("Year?");
                    line = sc.nextLine();

                    int year;
                    try {
                        year = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number");
                        continue;
                    }

                    System.out.println("Month?");
                    line = sc.nextLine();

                    int month;
                    try {
                        month = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number");
                        continue;
                    }
                    try {
                        period = YearMonth.of(year, month);
                    } catch (DateTimeException e) {
                        System.out.println("Invalid date");
                        continue;
                    }

                    System.out.println("Value?");
                    line = sc.nextLine();

                    int value;
                    try {
                        value = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number");
                        continue;
                    }

                    try {
                        MeterReading newReading = new MeterReading(utilityType, period, value);
                        book.add(newReading);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                        continue;
                    }

                    break;
                
                case "2":
                    for (int i = 0; i < book.getAll().size(); ++i) {
                        System.out.println(book.getAll().get(i));
                    }

                    break;

                case "0":
                    sc.close();
                    run = false;
                    continue;
            
                default:
                    System.out.println("Try again");
                    break;
            }
        }
    }
}