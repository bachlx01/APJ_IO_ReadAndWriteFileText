import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;

        while (choice !=0) {
            System.out.println("1. Copy file txt.");
            System.out.println("2. Read file csv");
            System.out.println("3. Calculate sum of numbers in file");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1: // Copy file txt
                    cloneFile();
                    break;
                case 2: // Read file csv
                    readFileCSV();
                    break;
                case 3: // Calculate sum of numbers in file
                    sumOfFile(input);
                    break;
                case 0: // Exit current program
                    System.exit(0);
            }
        }

    }

    private static void sumOfFile(Scanner input) {
        try {
            System.out.print("Enter the catch of file(hint: numbers.txt): ");
            String src = input.next();
            File file = new File(src);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            int sum = 0;

            while ((line = reader.readLine()) != null)  {
                sum += Integer.parseInt(line);
            }
            reader.close();
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println("The file does not exist");
        }
    }

    private static void readFileCSV() {
        try {
            File file = new File("file.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("The file does not exist");
        }
    }

    private static void cloneFile() {
        try {
            File file = new File("text.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            File newFile = new File("newText.txt");
            FileWriter fileWriter = new FileWriter(newFile);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("The file does not exist");
        }
        System.out.println("done");
    }
}
