package hostel;

import java.util.Date;

public class Reservation {
    private int numero;
    private Date dateArrivee;
    private Date dateDepart;
    private int nbPersonnes;
    private boolean aEnfant;
    private Chamber chamber;

    public Reservation(int numero, Date dateArrivee, Date dateDepart, int nbPersonnes, boolean aEnfant) {
        this.numero = numero;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.nbPersonnes = nbPersonnes;
        chamber = null;
    }

}
