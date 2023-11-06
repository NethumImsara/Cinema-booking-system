public class Person {
    private String name;
    public String surname;
    private String email;

    public Person(String name, String surname, String email){       //creating constructor for person.
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public String getName(){        //getter method to get first name
        return this.name;
    }
    public String getSurname(){      //getter method to get surname
        return this.surname;
    }
    public String getEmail(){           //getter method to get email
        return this.email;
    }
}

