package hostel;

import java.util.Date;

public class Reservation {
    private int numero;
    private Date dateArrivee;
    private Date dateDepart;
    private int nbPersonnes;
    private boolean aEnfant;
    private Chamber chamber;

    public Reservation(int numero, int jourArrivee, int moisArrivee, int anneeArrivee,
                       int jourDepart, int moisDepart, int anneeDepart, int nbPersonnes, boolean aEnfant) {
        this.numero = numero;
        this.dateArrivee = dateCreation.createDate(jourArrivee, moisArrivee, anneeArrivee);
        this.dateDepart = dateCreation.createDate(jourDepart, moisDepart, anneeDepart);
        this.nbPersonnes = nbPersonnes;
        chamber = null;
    }

}
