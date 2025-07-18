import java.io.*;
import java.util.*;

public class BookingManager {
    private static final String FILE_NAME = "bookings.txt";

    public void addBooking(Booking b) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(b.getName() + "," + b.getDate() + "," + b.getTime());
            writer.newLine();
            System.out.println("Booking Confirmed!");
        } catch (IOException e) {
            System.out.println("Error saving booking.");
        }
    }

    public void viewBookings() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nCurrent Bookings:");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("Name: " + data[0] + ", Date: " + data[1] + ", Time: " + data[2]);
            }
        } catch (IOException e) {
            System.out.println("No bookings found.");
        }
    }

    public void cancelBooking(String name) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(name + ",")) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    found = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error processing cancellation.");
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found) {
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Booking not found.");
        }
    }
}
