public class Main {
    public static void main(String[] args) {
        User newUser = new User("Douglas", 28, "099.999.999-89", "random-email@gmail.com", "(0XX)9 9999-8888");
        System.out.println("\nUser data - Registration" + "\n");
        System.out.println("Name: " + newUser.getName());
        System.out.println("Age: " + newUser.getAge());
        System.out.println("CPF: " + newUser.getCpf());
        System.out.println("Email: " + newUser.getEmail());
        System.out.println("Cell Number: " + newUser.getCellPhone());
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
}