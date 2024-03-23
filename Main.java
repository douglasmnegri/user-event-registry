import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String name;
        int age;
        String cpf;
        String email;
        String cellPhone;

        System.out.println("Name:");
        while (true) {
            name = myObj.nextLine();
            int length = name.length();

            if (length <= 1) {
                System.out.println("Please enter a valid name.");
            } else {
                break;
            }
        }

        System.out.println("Age:");
        while (true) {
            age = myObj.nextInt();
            myObj.nextLine();

            if(age < 0) {
                System.out.println("Please enter a valid age.");
            }
            else {
                break;
            }
        }

        System.out.println("CPF:");
        cpf = myObj.nextLine();

        System.out.println("Email:");
        email = myObj.nextLine();

        System.out.println("Cellphone Number:");
        cellPhone = myObj.nextLine();

        // Create a User object with the input values
        User newUser = new User(name, age, cpf, email, cellPhone);

        // Call the printUserInfo() method to print the user's information
        newUser.printUserInfo();
    }
}

class User {
    private String name;
    private int age;
    private String cpf;
    private String email;
    private String cellPhone;

    public User(String name, int age, String cpf, String email, String cellPhone) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
        this.cellPhone = cellPhone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void printUserInfo() {
        System.out.println("\nUser Information:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("CPF: " + getCpf());
        System.out.println("Email: " + getEmail());
        System.out.println("Cellphone Number: " + getCellPhone());
    }
}

// class Event {
// private String eventName;
// private String eventAddress;
// private String eventCategory;
// private LocalDate eventDate;
// private String eventDescription;

// public Event(String eventName, String eventAddress, String eventCategory,
// LocalDate eventDate,
// String eventDescription) {
// this.eventName = eventName;
// this.eventAddress = eventAddress;
// this.eventCategory = eventCategory;
// this.eventDate = eventDate;
// this.eventDescription = eventDescription;
// }

// public String getEventName() {
// return eventName;
// }

// public String getEventAddress() {
// return eventAddress;
// }

// public String getEventCategory() {
// return eventCategory;
// }

// public LocalDate getEventDate() {
// return eventDate;
// }

// public String getEventDescription() {
// return eventDescription;
// }

// public void printEventInfo() {
// System.out.println("Name: " + getEventName());
// System.out.println("Address: " + getEventAddress());
// System.out.println("Category: " + getEventCategory());
// System.out.println("Date: " + getEventDate());
// System.out.println("Description: " + getEventDescription());
// }
// }

// // User newUser01 = new User("Douglas", 28, "099.999.999-89",
// // "random-email@gmail.com", "(0XX)9 9999-8888");
// // User newUser02 = new User("Daniel", 21, "088.888.8888-99",
// // "daniel-mail@hotmail.com", "(0XX)9 7777-7779");
// // System.out.println("\n - User Registration Form - ");
// // newUser01.printUserInfo();
// // newUser02.printUserInfo();

// // Event newEvent01 = new Event("Music Festival", "Central Park", "Music",
// // LocalDate.of(2024, 10, 25),
// // "Experience the best bands of the world in one place!");
// // System.out.println("\n - List of Events -");
// // newEvent01.printEventInfo();