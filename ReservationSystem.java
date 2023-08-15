import java.util.*;

public class ReservationSystem {
    private HashMap<String, String> users = new HashMap<>();
    private HashMap<String, Boolean> reservations = new HashMap<>();

    public ReservationSystem() {
        
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("Shivamg9198", "Shivamg@321");

        reservations.put("user1", false);
        reservations.put("user2", false);
        reservations.put("Shivamg9198", false);
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public void makeReservation(String username) {
        if (reservations.containsKey(username) && !reservations.get(username)) {
            reservations.put(username, true);
            System.out.println("Reservation made successfully.");
        } else {
            System.out.println("You already have a reservation or the username is invalid.");
        }
    }

    public void cancelReservation(String username) {
        if (reservations.containsKey(username) && reservations.get(username)) {
            reservations.put(username, false);
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("You don't have a reservation to cancel or the username is invalid.");
        }
    }

    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (system.login(username, password)) {
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.makeReservation(username);
                    break;
                case 2:
                    system.cancelReservation(username);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}