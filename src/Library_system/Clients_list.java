package Library_system;
import java.util.ArrayList;

public class Clients_list {
    private ArrayList<Client> clients;

    public Clients_list() {
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
        System.out.println("A client has been added to the system: " + client.getName() + " " + client.getSurname());
    }

    public void showAllClients() {
        System.out.println("\n---Customer list---");
        for(Client client : clients) {
            System.out.println(client);
        }
    }

    public Client searchClient(String id){
        for(Client client : clients){
            if(client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }
}
