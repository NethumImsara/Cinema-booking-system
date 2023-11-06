import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Theatre {
    public static Scanner scanner = new Scanner(System.in);
    // Initialize the global scanner for user input
    public static void main(String[] args) {
        System.out.println("\nWelcome to the New Theatre");
        // Initialize three arrays 0 s.
        int[] row_1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
        int[] row_2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row_3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
        // Initialize Array list to store tickets.
        ArrayList<Ticket> ticketList = new ArrayList<>();

        // Display the menu
        while (true) {
            System.out.println("-------------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save");
            System.out.println("6) Load");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by surname");
            System.out.println("0) Quit");
            System.out.println("-------------------------------------------------");
            System.out.print("Enter your Option      : ");

            // Get user input for the selected option
            int option;
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer."); // handle the error when user input in integer or double
                scanner.nextLine();
                continue;
            }

            // Process the selected option
            switch (option) {
                case 0:
                    System.out.println("Thank you for using the New Theatre program!");
                    System.exit(0);
                case 1:
                    // Buy a ticket
                    buy_ticket(row_1, row_2, row_3,ticketList);
                    break;
                case 2:
                    // Print seating area
                    print_seating_area(row_1, row_2, row_3);
                    break;
                case 3:
                    // Cancel ticket
                    cancel_ticket(row_1, row_2, row_3,ticketList);
                    break;
                case 4:
                    // List available seats
                    show_available(row_1, row_2, row_3);
                    break;
                case 5:
                    // Save
                    save(row_1, row_2, row_3);
                    break;
                case 6:
                    // Load
                    load(row_1, row_2, row_3);
                    break;
                case 7:
                    //Show ticket
                    show_tickets_info(ticketList);
                    break;
                case 8:
                    //Sort ticket
                    sort_tickets(ticketList);
                    break;
                default:
                    System.out.println("Invalid option. Please select again."); // handle the invalid option error
                    break;
            }
        }
    }

    public static void buy_ticket(int[] row1, int[] row2, int[] row3, ArrayList<Ticket> ticketList) {
        scanner.nextLine();
        String name;
        while(true) {
            System.out.print("Enter your name        : "); // Get user's name
            name = scanner.nextLine();
            if (name.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("Enter valid string"); // handle the error when user input an invalid string type
            }
        }

        String surname;
        while(true) {
            System.out.print("Enter your surname     : "); // Get user's surname
            surname = scanner.nextLine();
            if (surname.matches("[a-zA-Z]+")){
                break;
            } else {
                System.out.println("Enter valid string");  // handle the error when user input an invalid string type
            }
        }

        String email;
        while (true) {
            System.out.print("Enter your Email       : "); // Get user's Email
            email = scanner.nextLine();
            if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                break;
            } else {
                System.out.println("Invalid email format. Please enter a valid email address."); // handle the invalid email format error
            }
        }
        int row;
        while(true) {
            System.out.println("\n---------------------Theatre rows and seats details---------------------\n"+
                                  "\n"+
                                  "                          Theatre has 3 rows\n"
                                + "\n"+
                                  "                           Row 1 : 12 seats\n"
                                + "                           Row 2 : 16 seats\n"
                                + "                           Row 3 : 20 seats\n");
            System.out.println("------------------------------------------------------------------------");

            System.out.print("Enter your row number  : ");  //Getting the user's preferred row number for input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input, enter an integer"); // handle the string error
                scanner.next();
                continue;
            }
            row = scanner.nextInt();
            if (row < 1 || row > 3) {
                System.out.println("Invalid row number."); // handle the invalid row number error
                continue;
            }
            break;
        }
        int seat;
        while (true) {
            System.out.print("Enter your seat number : ");  // Getting the user's preferred seat number for input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input, enter an integer"); //handle the string error
                scanner.next();
                continue;
            }
            seat = scanner.nextInt();
            if (seat <= 0 || seat > 20) {
                System.out.println("Invalid seat number."); // handle the error when the user enters an invalid data type.
            }
            if (row == 1 && seat > 12){
                System.out.println("Enter number between 1 - 12");
                continue;
            }
            else if (row == 2 && seat > 16){
                System.out.println("Enter number between 1 - 16");
                continue;
            }
            break;
        }
        double price;
        while (true) {
            System.out.print("Enter your price       : £"); //Get the price
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input, enter a numeric value"); // handle the error when the user enters an invalid data type
                scanner.next();
                continue;
            }
            price = scanner.nextDouble();
            break;
        }
        seat--;
        Person person = new Person(name,surname,email);
        Ticket ticket = new Ticket(row,seat+1,price,person);
        if (row == 1) {
            if (row1[seat] == 0) {
                row1[seat] = 1;
                ticket.print();
                ticketList.add(ticket);
                System.out.println("Seat reserved successfully.");
            } else {
                System.out.println("This seat is reserved"); // handle the error when seat already booked
            }
        } else if (row == 2) {
            if (row2[seat] == 0) {
                row2[seat] = 1;
                ticket.print();
                ticketList.add(ticket);
                System.out.println("Seat reserved successfully.");
            } else {
                System.out.println("This seat is reserved"); // handle the error when seat already booked
            }
        } else {
            if (row3[seat] == 0) {
                row3[seat] = 1;
                ticket.print();
                ticketList.add(ticket);
                System.out.println("Seat reserved successfully.");
            } else {
                System.out.println("This seat is reserved"); // handle the error when seat already booked
            }
        }
    }


    public static void print_seating_area(int[] row1, int[] row2, int[] row3) {
        String[] row_1 = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};       // Create a new string array
        String[] row_2 = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};
        String[] row_3 = {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"};

        System.out.println("\n\t ***********");
        System.out.println("\t *  STAGE  *");
        System.out.println("\t ***********");

        for (int i = 0; i < row_1.length; i++) {
            if (i == 0) {
                System.out.print("    ");
            }
            if (i == 6) {
                System.out.print(" ");
            }
            if (row1[i] == 1) {
                row_1[i] = "X";
            }
            System.out.print(row_1[i]);
        }
        System.out.println(" ");
        for (int i = 0; i < row_2.length; i++) {
            if (i == 0) {
                System.out.print("  ");
            }
            if (i == 8) {
                System.out.print(" ");
            }
            if (row2[i] == 1) {
                row_2[i] = "X";
            }
            System.out.print(row_2[i]);
        }
        System.out.println(" ");
        for (int i = 0; i < row_3.length; i++) {
            if (i == 10) {
                System.out.print(" ");
            }
            if (row3[i] == 1) {
                row_3[i] = "X";
            }
            System.out.print(row_3[i]);
        }
        System.out.println(" ");

    }

    private static void cancel_ticket(int[] row1, int[] row2, int[] row3,ArrayList<Ticket> ticketList) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the row number: ");
            int row = sc.nextInt();
            System.out.print("Enter the seat number: ");
            int seat = sc.nextInt();
            seat--;
            try {
                if (row == 1) {
                    if (row1[seat] == 1) {
                        row1[seat] = 0;
                        System.out.println("Seat canceled successfully.");
                    } else {
                        System.out.println("This seat is not reserved."); // handle the error when seat not booked
                    }
                } else if (row == 2) {
                    if (row2[seat] == 1) {
                        row2[seat] = 0;
                        System.out.println("Seat canceled successfully.");
                    } else {
                        System.out.println("This seat is not reserved."); // handle the error when seat not booked
                    }
                } else if (row == 3) {
                    if (row3[seat] == 1) {
                        row3[seat] = 0;
                        System.out.println("Seat canceled successfully.");
                    } else {
                        System.out.println("This seat is not reserved."); // handle the error when seat not booked
                    }
                }
                else {
                    System.out.println("Invalid row number. Please try again."); // handle the invalid row number error
                }
                for (Ticket ticket : ticketList) {
                    if (ticket.getRow() == row && ticket.getSeat() == seat + 1) {
                        ticketList.remove(ticket);
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid seat number. Please try again."); // handle the invalid seat number error

            }
        } catch (Exception e) {
            System.out.println("Enter a valid integer"); // handle the error when the user enters an invalid data type
        }
    }

    private static void show_available(int[] row1, int[] row2, int[] row3) {

        for (int i = 0; i < row1.length; i++) {

            if (row1[i] == 0) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println(" ");

        for (int i = 0; i < row2.length; i++) {

            if (row2[i] == 0) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println(" ");
        for (int i = 0; i < row3.length; i++) {

            if (row3[i] == 0) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println(" ");
    }

    private static void save(int[] row1, int[] row2, int[] row3) {
        try {
            File file = new File("Array.txt");
            boolean file_created = file.createNewFile();
            if (file_created) {
                System.out.println("File successfully created");     // create the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("Array.txt");
            for (int i = 0; i < row1.length; i++) {
                myWriter.write(row1[i] + " ");
            }
            myWriter.write("\n");
            for (int i = 0; i < row2.length; i++) {
                myWriter.write(row2[i] + " ");
            }
            myWriter.write("\n");
            for (int i = 0; i < row3.length; i++) {
                myWriter.write(row3[i] + " ");
            }
            myWriter.close();                                         // write the file
            System.out.println("File successfully saved");
        } catch (Exception e) {
            System.out.println("An error occurred.");                 // handle an error when occurred
        }
    }

    private static void load(int[] row1, int[] row2, int[] row3) {
        try {
            File file = new File("Array.txt");
            Scanner reader = new Scanner(file);
            for (int i = 0; i < row1.length; i++) {
                int num = reader.nextInt();
                row1[i] = num;
            }
            for (int i = 0; i < row2.length; i++) {
                int num = reader.nextInt();
                row2[i] = num;
            }
            for (int i = 0; i < row3.length; i++) {
                int num = reader.nextInt();
                row3[i] = num;
            }
            reader.close();                                        // read the file
            print_seating_area( row1, row2, row3);
            System.out.println("\n Successfully loaded");

        } catch (IOException e) {
            System.out.println("Error while reading a file.");     // handle an error when occurred
            e.printStackTrace();
        }
    }
    private static void show_tickets_info(ArrayList<Ticket> ticketList) {
        double total = 0.0;
        for (Ticket ticket : ticketList) {
            System.out.println("\nName  : " + ticket.getPerson().getName() + " " + ticket.getPerson().getSurname());
            System.out.println("Email : " + ticket.getPerson().getEmail());
            System.out.println("Row   : " + ticket.getRow() + "\nSeat  : " + ticket.getSeat());
            System.out.println("Price : £" + ticket.getPrice());
            total += ticket.getPrice();
        }
        System.out.println("\nTotal price of all tickets: £" + total);
    }
    private static void sort_tickets(ArrayList<Ticket> ticketList){       //Bubble sort method
        ArrayList<Ticket> sorted_list = new ArrayList<>(ticketList);
        int n = sorted_list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted_list.get(j).getPrice() > sorted_list.get(j + 1).getPrice()) {
                    Ticket temp = sorted_list.get(j);
                    sorted_list.set(j, sorted_list.get(j + 1));
                    sorted_list.set(j + 1, temp);
                }
            }
        }
        double total = 0.0;
        for (Ticket ticket : sorted_list) {
            System.out.println("\nName  : " + ticket.getPerson().getName() + " " + ticket.getPerson().getSurname());
            System.out.println("Email : " + ticket.getPerson().getEmail());
            System.out.println("Row   : " + ticket.getRow() + "\nSeat  : " + ticket.getSeat());
            System.out.println("Price : £" + ticket.getPrice());
            total += ticket.getPrice();
        }
        System.out.println("\nTotal price of all tickets: £" + total);
    }
}