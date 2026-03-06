package Library_system;

public class Client {
    private String id;
    private String name;
    private String surname;


    public Client(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return String.format("Client [ID: %s] | %s %s", id, name, surname);
    }
}