import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingManager manager = new BookingManager();

        int choice;
        do {
            System.out.println("\n--- ONLINE BOOKING SYSTEM ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. View All Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter date (dd-mm-yyyy): ");
                    String date = sc.nextLine();
                    System.out.print("Enter time (HH:MM): ");
                    String time = sc.nextLine();
                    Booking b = new Booking(name, date, time);
                    manager.addBooking(b);
                    break;
                case 2:
                    manager.viewBookings();
                    break;
                case 3:
                    System.out.print("Enter name to cancel: ");
                    String delName = sc.nextLine();
                    manager.cancelBooking(delName);
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
