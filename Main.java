import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        String content;
        System.out.println("What do you want to register? Type 1 for User and 2 for Event.");
        while (true) {
            content = Obj.nextLine();
            if (content.equals("1")) {
                User newUser = User.createUserFromInput();
                System.out.println("\nUser Information:");
                newUser.printUserInfo();
            } else if (content.equals("2")) {
                Event newEvent = Event.createEventFromInput();
                newEvent.printEventInfo();
            }
            else {
                System.out.println("Invalid input.  Type 1 for User and 2 for Event.");
            }
        }
    }
}

class User {
    private String name;
    private int age;
    private String cpf;
    private String email;
    private String cellPhone;

    public static User createUserFromInput() {
        Scanner userObj = new Scanner(System.in);
        String name;
        int age;
        String cpf;
        String email;
        String cellPhone;

        System.out.println("Name:");
        while (true) {
            name = userObj.nextLine();
            int length = name.length();

            if (length <= 1) {
                System.out.println("Please enter a valid name.");
            } else {
                break;
            }
        }

        System.out.println("Age:");
        while (true) {
            age = userObj.nextInt();
            userObj.nextLine();

            if (age < 0) {
                System.out.println("Please enter a valid age.");
            } else {
                break;
            }
        }

        System.out.println("CPF:");
        cpf = userObj.nextLine();

        System.out.println("Email:");
        email = userObj.nextLine();

        System.out.println("Cellphone Number:");
        cellPhone = userObj.nextLine();

        return new User(name, age, cpf, email, cellPhone);
    }

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
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("CPF: " + getCpf());
        System.out.println("Email: " + getEmail());
        System.out.println("Cellphone Number: " + getCellPhone());
    }
}

class Event {
    private String eventName;
    private String eventAddress;
    private String eventCategory;
    private LocalDate eventDate;
    private String eventDescription;

    // Predefined array of event categories
    private static final String[] EVENT_CATEGORIES = { "Concert", "Conference", "Seminar", "Workshop", "Exhibition",
            "Festival", "Charity Event", "Sports Event", "Networking Event",
            "Product Launch" };

    public static Event createEventFromInput() {
        Scanner eventObj = new Scanner(System.in);

        System.out.println("Event Name:");
        String eventName = eventObj.nextLine();

        System.out.println("Event Address:");
        String eventAddress = eventObj.nextLine();

        // Prompt for date input
        LocalDate eventDate;
        while (true) {
            System.out.println("Event Date (YYYY-MM-DD):");
            String dateInput = eventObj.nextLine();

            try {
                eventDate = LocalDate.parse(dateInput);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }

        System.out.println("Event Description:");
        String eventDescription = eventObj.nextLine();

        // Prompt user to select event category
        System.out.println("Event Category:");
        String selectedCategory;
        while (true) {
            // Display available categories
            for (int i = 0; i < EVENT_CATEGORIES.length; i++) {
                System.out.println((i + 1) + ". " + EVENT_CATEGORIES[i]);
            }
            int categoryIndex = eventObj.nextInt();
            eventObj.nextLine();

            if (categoryIndex >= 1 && categoryIndex <= EVENT_CATEGORIES.length) {
                selectedCategory = EVENT_CATEGORIES[categoryIndex - 1];
                break;
            } else {
                System.out.println("Invalid category selection. Please try again.");
            }
        }

        return new Event(eventName, eventAddress, selectedCategory, eventDate, eventDescription);
    }

    public Event(String eventName, String eventAddress, String eventCategory, LocalDate eventDate,
            String eventDescription) {
        this.eventName = eventName;
        this.eventAddress = eventAddress;
        this.eventCategory = eventCategory;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
    }

    public String getEventName() {
        return eventName;
    }

    public String geteventAddress() {
        return eventAddress;
    }

    public String geteventCategory() {
        return eventCategory;
    }

    public LocalDate geteventDate() {
        return eventDate;
    }

    public String geteventDescription() {
        return eventDescription;
    }

    public void printEventInfo() {
        System.out.println("Name: " + getEventName());
        System.out.println("Address: " + geteventAddress());
        System.out.println("Category: " + geteventCategory());
        System.out.println("Date: " + geteventDate());
        System.out.println("Description: " + geteventDescription());
    }
}