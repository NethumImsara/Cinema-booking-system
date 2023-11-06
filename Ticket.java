public class Ticket {
    private int row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(int row, int seat, double price, Person person) {      //creating constructor for ticket.
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public void print() {
        System.out.println("\nPerson name    : " + person.getName());
        System.out.println("Person surname : " + person.getSurname());
        System.out.println("Person email   : " + person.getEmail());
        System.out.println("Row            : " + row);
        System.out.println("Seat           : " + seat);
        System.out.println("Price          : £" + price + "\n");
    }
    public Person getPerson(){           //getter method to get person
        return person;
    }
    public int getRow(){             //getter method to get row number
        return row;
    }
    public int getSeat(){            //getter method to get seat number
        return seat;
    }
    public double getPrice() {           //getter method to get price
        return price;
    }
}
