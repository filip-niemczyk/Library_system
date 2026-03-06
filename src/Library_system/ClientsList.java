package Library_system;

import java.util.ArrayList;

public class ClientsList {
    private ArrayList<Client> clients;

    public ClientsList() {
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
        System.out.println("A client has been added to the system: " + client.getName() + " " + client.getSurname());
    }

    public void showAllClients() {
        System.out.println("\n---Customer list---");
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public Client searchClient(int id) {
        for (Client client : clients) {
            if (client.getId() == (id)) {
                return client;
            }
        }
        return null;
    }

    public Client login(String login, String password) {
        for (Client client : clients) {
            if (client.verifyLogin(login, password)) {
                return client;
            }
        }
        return null;
    }

    public boolean isLoginTaken(String login) {
        for (Client client : clients) {
            if (client.getLogin().equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }
}
