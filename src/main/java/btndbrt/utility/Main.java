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
            System.out.println("1) Add reading");
            System.out.println("2) List readings");
            System.out.println("3) Delete reading");
            System.out.println("4) Calculate costs");
            System.out.println("0) Exit");
            
            String line = sc.nextLine();
            switch (line) {

                // ADD READING
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
                
                // LIST READINGS
                case "2":
                    if (book.getAll().size() == 0) {
                        System.out.println("No readings to show :(");
                        continue;
                    }
                    for (int i = 0; i < book.getAll().size(); ++i) {
                        System.out.println("\nID: " + i + " " + book.getAll().get(i));
                    }

                    break;

                // DELETE READING
                case "3":
                    System.out.println("ID?");
                    line = sc.nextLine();
                    int id;
                    try {
                        id = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number");
                        continue;
                    }
                    if (id >= book.getAll().size() || id < 0) {
                        System.out.println("Invalid ID");
                        continue;
                    }
                    book.delete(id);
                    System.out.println("Successfully deleted id: " + id);

                    break;

                // CALCULATE COST
                case "4":

                    break;

                // EXIT
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