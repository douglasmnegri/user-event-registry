import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeParseException;

public class Main {
    private static final String[] SHOW_OPTIONS = { "Register User", "Register Event", "List Users", "List Events" };
    private static final List<User> userList = new ArrayList<>();
    private static final List<Event> eventList = new ArrayList<>();

    private static void printUsers() {
        // Hardcoded users meant for testing it out
        if (userList.isEmpty()) {
            System.out.println("The list of users is empty");

            User user01 = new User("Alice", 35, "12345678901", "alice@example.com", "1234567890");
            User user02 = new User("Bob", 42, "98765432109", "bob@example.com", "0987654321");
            userList.add(user01);
            userList.add(user02);

        }

        else {
            System.out.println("\n- LIST OF USERS -\n");
            for (User user : userList) {
                user.printUserInfo();
                System.out.println("");
            }
        }
    }

    private static void printEvents() {
        
        // Also hardcoded meant for testing it out
        if (eventList.isEmpty()) {
            System.out.println("The list of events is empty");
            Event event01 = new Event("Birthday Party", "123 Main Street", "Celebration", LocalDate.of(2024, 4, 15),
                    "Join us for a fun-filled birthday celebration!");
            Event event02 = new Event("Tech Conference", "456 Elm Street", "Conference", LocalDate.of(2024, 5, 20),
                    "Explore the latest trends in technology at our annual conference.");
            eventList.add(event01);
            eventList.add(event02);

        } else {
            System.out.println("\n- LIST OF EVENTS -\n");
            for (Event event : eventList) {
                event.printEventInfo();
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        System.out.println("Choose an option below:");
        displayOptions(Obj);
    }

    private static void displayOptions(Scanner scanner) {
        while (true) {
            for (int i = 0; i < SHOW_OPTIONS.length; i++) {
                System.out.println((i + 1) + ". " + SHOW_OPTIONS[i]);
            }

            int categoryIndex = scanner.nextInt();
            scanner.nextLine();

            switch (categoryIndex) {
                case 1:
                    User newUser = User.createUserFromInput();
                    userList.add(newUser);
                    System.out.println("\nUser Information:");
                    newUser.printUserInfo();
                    break;
                case 2:
                    Event newEvent = Event.createEventFromInput();
                    eventList.add(newEvent);
                    newEvent.printEventInfo();
                    break;
                case 3:
                    printUsers();
                    break;
                case 4:
                    printEvents();
                    break;
                default:
                    System.out.println("Invalid input. Type 1 for User and 2 for Event.");
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