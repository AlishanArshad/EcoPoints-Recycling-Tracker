import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Enter your Id :");
            String id = scanner.nextLine();
            System.out.println("Enter your Name :");
            String name = scanner.nextLine();
            System.out.println("Enter your Address :");
            String address = scanner.nextLine();
            System.out.println("Enter your materialType :");
            String materialType = scanner.nextLine();
            System.out.println("Enter your weight in kg :");
            double weight = scanner.nextDouble();
            scanner.nextLine();


            Household household = new Household(id, name, address);
            RecyclingEvent recyclingEvent = new RecyclingEvent(materialType, weight);
            household.addEvent(recyclingEvent);

            System.out.println("Press 'ENTER' to continue or 'No' to Stop : ");
            String choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("no")) {
                System.out.println("BYEE....");
                break;
            }

            try {
                FileWriter writer = new FileWriter("EcoPoints.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(String.valueOf(household));
                bufferedWriter.newLine();
                bufferedWriter.write(String.valueOf(recyclingEvent));
                bufferedWriter.newLine();
                bufferedWriter.write("---------------------------------------------");
                bufferedWriter.close();
                System.out.println("File written for "+ name);
                System.out.println("---------------------------------------------------");


            }catch (IOException e){
                System.out.println("Unable to Write " + e.getMessage());

            }
        }
        scanner.close();
    }
}

