package hostel;

import java.util.ArrayList;

public class Hostel {

    protected ArrayList<Chamber> chambers;
    protected ArrayList<Client> clients;
    protected ArrayList<Reservation> reservations;

    public Hostel(ArrayList<Chamber> chambers, ArrayList<Client> clients, ArrayList<Reservation> reservations) {
        this.chambers = chambers;
        this.clients = clients;
        this.reservations = reservations;
    }

    public ArrayList<Chamber> getChambers() {
        return chambers;
    }

    public void setChambers(ArrayList<Chamber> chambers) {
        this.chambers = chambers;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}
