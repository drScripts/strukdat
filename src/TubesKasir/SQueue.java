package TubesKasir;

public class SQueue {
    Client[] clients;
    int head;
    int tail;

    public SQueue(int maxWaiting) {
        clients = new Client[maxWaiting];
        for (int i = 0; i < maxWaiting; i++) {
            clients[i] = new Client();
        }
    }

    public int search(String nama) {
        int index = -1;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].username != null) {
                if (clients[i].username.equals(nama)) {
                    index = i;
                }
            }

        }
        return index;
    }

    public int insert(Client client) {
        int index = -1;
        for (int i = clients.length - 1; i >= 0; i--) {
            if (clients[i] == null) {
                clients[i] = client;
                index = i;
            }
        }
        return index;
    }

    void print() {
        for (Client client : clients) {
            System.out.println("nama : " + client.username);
        }
    }
}
