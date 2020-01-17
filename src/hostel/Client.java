package hostel;

import java.util.ArrayList;

public class Client {

    protected String nom;
    protected String email;
    protected ArrayList<Reservation> reservations;

    public Client(String nom, String email, ArrayList<Reservation> reservations) {
        this.nom = nom;
        this.email = email;
        this.reservations = new ArrayList<Reservation>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}
