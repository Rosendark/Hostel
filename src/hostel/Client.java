package hostel;

import java.util.ArrayList;

public class Client {

    protected String nom;
    protected String email;
    protected ArrayList<Reservation> reservations;

    @Override
    public String toString() {
        return "Client: " +
                "\n  nom='" + nom + '\'' +
                "\n  email='" + email + '\'' +
                "\n  listeReservation: \n" + getListeReservation();
    }

    public String getListeReservation() {
        String texteListeReservation = "";
        for(Reservation r: reservations) {
            texteListeReservation += r + "\n";
        }
        return texteListeReservation;
    }

    public Client(String nom, String email) {
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

    /**
     * Permet d'ajouter une nouvelle réservation à la liste
     * @param nouvelleReservation Reservation oà ajouter (créée dans l'objet Hostel)
     */
    public void addReservation(Reservation nouvelleReservation) {
        reservations.add(nouvelleReservation);
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}
