import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;


class Passenger {
    private String name;
    private String phoneNumber;
    private String idNumber;
    private String accountCreatedDate;

    public Passenger(String name, String phoneNumber, String idNumber, String accountCreatedDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
        this.accountCreatedDate = accountCreatedDate;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getAccountCreatedDate() {
        return accountCreatedDate;
    }
}


class BusTicketSystem {
    private LinkedList<Passenger> passengers;
    private Queue<String> history;

    public BusTicketSystem() {
        passengers = new LinkedList<>();
        history = new LinkedList<>();
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Rajata Bus Ticket System ===");
        System.out.println("Please enter your details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("ID Number: ");
        String idNumber = scanner.nextLine();

        // Get current date and format it as a string
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String accountCreatedDate = dateFormat.format(currentDate);

        Passenger passenger = new Passenger(name, phoneNumber, idNumber, accountCreatedDate);

        passengers.add(passenger);

        System.out.println("Login successful. Welcome, " + name + "!");
    }

    public void displayMenu() {
        System.out.println("=== Rajata Bus ===");
        System.out.println("1. Raya - Siantar");
        System.out.println("2. Siantar - Raya");
        System.out.println("3. Raya - Seribudolog");
        System.out.println("4. Seribudolog - Raya");
        System.out.println("5. Siantar - Seribudolog");
        System.out.println("6. Seribudolog - Siantar");
        System.out.println("7. Seribudolog - Bosi Sinombah");
        System.out.println("8. Bosi Sinombah - Seribudolog");
        System.out.println("9. Seridolog - Sipiso-piso");
        System.out.println("10. Sipiso-piso - Seribudolog");
        System.out.println("11. Raya Bayu - Siantar");
        System.out.println("12. Siantar - Raya Bayu");
        System.out.println("13. Raya Bayu - Seribudolog");
        System.out.println("14. Seribudolog - Raya Bayu");
        System.out.println("15. Seribudolog - Kabanjahe");
        System.out.println("16. Kabanjahe - Seribudolog");
        System.out.println("0. Exit Application");
    }

    public void bookTicket(int route) {
        Scanner scanner = new Scanner(System.in);
        String[] destinations = {
                "Raya - Siantar", "Siantar - Raya", "Raya - Seribudolog", "Seribudolog - Raya",
                "Siantar - Seribudolog", "Seribudolog - Siantar", "Seribudolog - Bosi Sinombah",
                "Bosi Sinombah - Seribudolog", "Seridolog - Sipiso-piso", "Sipiso-piso - Seribudolog",
                "Raya Bayu - Siantar", "Siantar - Raya Bayu", "Raya Bayu - Seribudolog",
                "Seribudolog - Raya Bayu", "Seribudolog - Kabanjahe", "Kabanjahe - Seribudolog"
        };
        int departureNumber;

        switch (route) {
            case 1:
            case 2:
                System.out.print("Enter the bus departure number: ");
                departureNumber = scanner.nextInt();
                System.out.print("Enter the number of seats to book: ");
                int bookedSeats = scanner.nextInt();
                int ticketPrice1 = (route == 1) ? 7000 : 7000;
                int totalBill1 = bookedSeats * ticketPrice1;

                if (totalBill1 <= 0) {
                    System.out.println("Invalid number of seats!");
                    return;
                }

                if (bookedSeats > 0 && bookedSeats <= 27) {
                    System.out.println("Seats booked successfully!");
                    System.out.println("Total bill: " + totalBill1);
                } else {
                    System.out.println("Sorry! All the seats have been booked.");
                    System.out.println("Proceed to stand for some time.");
                    System.out.println("Life is Cruel and Beautiful at the same time, isn't it?");
                }

                break;
            case 3:
            case 4:
                // ... Similar logic for other routes
                break;
            default:
                System.out.println("Invalid route!");
        }
    }

    public void makePayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of seats booked: ");
        int seats = scanner.nextInt();
        System.out.print("Enter the destination route: ");
        int route = scanner.nextInt();
        System.out.print("Enter the time of departure: ");
        String timeDeparture = scanner.next();

        String[] destinations = {
                "Raya - Siantar", "Siantar - Raya", "Raya - Seribudolog", "Seribudolog - Raya",
                "Siantar - Seribudolog", "Seribudolog - Siantar", "Seribudolog - Bosi Sinombah",
                "Bosi Sinombah - Seribudolog", "Seridolog - Sipiso-piso", "Sipiso-piso - Seribudolog",
                "Raya Bayu - Siantar", "Siantar - Raya Bayu", "Raya Bayu - Seribudolog",
                "Seribudolog - Raya Bayu", "Seribudolog - Kabanjahe", "Kabanjahe - Seribudolog"
        };

        int[] ticketPrices = {7000, 7000, 12000, 12000, 18000, 18000, 10000, 10000, 20000, 20000, 10000, 10000, 10000, 10000, 15000, 15000};

        if (route >= 1 && route <= destinations.length) {
            System.out.println("YOUR TOTAL BILL");
            System.out.println("Total booked seat is " + seats);
            System.out.println("Destination is " + destinations[route - 1]);
            System.out.println("Time departure " + timeDeparture);
            System.out.println("Your total bill " + (seats * ticketPrices[route - 1]));
        } else {
            System.out.println("Invalid route!");
        }
    }

    public void displayHistory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose search criteria:");
        System.out.println("1. Name");
        System.out.println("2. Phone number");
        System.out.println("3. ID number");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                System.out.print("Enter the name to search: ");
                String name = scanner.nextLine();
                searchByName(name);
                break;
            case 2:
                System.out.print("Enter the phone number to search: ");
                String phoneNumber = scanner.nextLine();
                searchByPhoneNumber(phoneNumber);
                break;
            case 3:
                System.out.print("Enter the ID number to search: ");
                String idNumber = scanner.nextLine();
                searchByIdNumber(idNumber);
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    private void searchByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equalsIgnoreCase(name)) {
                System.out.println("Name: " + passenger.getName());
                System.out.println("Phone Number: " + passenger.getPhoneNumber());
                System.out.println("ID Number: " + passenger.getIdNumber());
                System.out.println("Account Created Date: " + passenger.getAccountCreatedDate());
                return;
            }
        }
        System.out.println("No passenger found with the given name.");
    }

    private void searchByPhoneNumber(String phoneNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Name: " + passenger.getName());
                System.out.println("Phone Number: " + passenger.getPhoneNumber());
                System.out.println("ID Number: " + passenger.getIdNumber());
                System.out.println("Account Created Date: " + passenger.getAccountCreatedDate());
                return;
            }
        }
        System.out.println("No passenger found with the given phone number.");
    }

    private void searchByIdNumber(String idNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getIdNumber().equals(idNumber)) {
                System.out.println("Name: " + passenger.getName());
                System.out.println("Phone Number: " + passenger.getPhoneNumber());
                System.out.println("ID Number: " + passenger.getIdNumber());
                System.out.println("Account Created Date: " + passenger.getAccountCreatedDate());
                return;
            }
        }
        System.out.println("No passenger found with the given ID number.");
    }
}

public class App {
    public static void main(String[] args) {
        BusTicketSystem ticketSystem = new BusTicketSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rajata Bus Ticket System!");

        // Login System
        ticketSystem.login();

        // Display Menu
        ticketSystem.displayMenu();

        int route;
        do {
            System.out.print("Enter the route number (0 to exit): ");
            route = scanner.nextInt();

            if (route >= 1 && route <= 16) {
                ticketSystem.bookTicket(route);
            } else if (route != 0) {
                System.out.println("Invalid route!");
            }
        } while (route != 0);

        // Payment
        ticketSystem.makePayment();

        // History
        ticketSystem.displayHistory();
    }
}
