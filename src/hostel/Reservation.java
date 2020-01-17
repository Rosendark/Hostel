package hostel;

import java.util.Date;

public class Reservation {
    private int numero;
    private Date dateArrivee;
    private Date dateDepart;
    private int nbPersonnes;
    private boolean aEnfant;

    private CATEGORIE categorie;
    private STATUT_RESERVE statut;
    private Chamber chamber;

    @Override
    public String toString() {
        String numeroChamber = "Aucune";
        if(chamber != null)
            numeroChamber = "" + chamber.numero;
        return "    Reservation: " +
                "\n       numero=" + numero +
                "\n       dateArrivee=" + dateArrivee +
                "\n       dateDepart=" + dateDepart +
                "\n       nbPersonnes=" + nbPersonnes +
                "\n       aEnfant=" + aEnfant +
                "\n       categorie=" + categorie +
                "\n       statut=" + statut +
                "\n       chamber=" + numeroChamber +
                "\n       prix=" + getPrix();
    }

    public Reservation(int numero, int jourArrivee, int moisArrivee, int anneeArrivee,
                       int jourDepart, int moisDepart, int anneeDepart, int nbPersonnes,
                       boolean aEnfant, CATEGORIE categorie) {
        this.numero = numero;
        this.dateArrivee = DateCreation.createDate(jourArrivee, moisArrivee, anneeArrivee);
        this.dateDepart = DateCreation.createDate(jourDepart, moisDepart, anneeDepart);
        this.nbPersonnes = nbPersonnes;
        this.aEnfant = aEnfant;
        this.categorie = categorie;

        //Une réservation est toujours en attente et sans chambre
        statut = STATUT_RESERVE.EN_ATTENTE;
        chamber = null;
    }

    /**
     * Permet de savoir si la réservation est surclassée ou pas
     * @return Vrai si la catégorie de la réservation à un poids inférieur à celle de la chambre ou faux si elle
     * est au moins égale (ou si la réservation n'a pas de chambre).
     */
    public boolean estSurclassee() {
        if(chamber == null) {
            System.out.println("Impossible de savoir si la réservation " + numero + " est surclassée.");
            return false;
        }
        return (categorie.comparePoids(chamber.getCategorie()) < 0);
    }

    /**
     * Permet d'obtenir le prix de la chambre associé à la réservation
     * @return Le prix de la chambre (ou -1 si la réservation n'a pas de chambre)
     */
    public float getPrix() {
        if(chamber == null) {
            System.out.println("Impossible d'obtenir le prix de la réservation " + numero + ".");
            return -1;
        }
        return chamber.getPrix();
    }

    public boolean affecteChambre(Chamber chamber) {
        if(chamber == null) {
            System.out.println("Impossible d'affecter une chambre null à la chambre " + numero + "...");
            return false;
        }

        if(chamber.getCategorie().comparePoids(categorie) < 0) {
            System.out.println("La chambre donnée ne répond pas aux besoins de la réservation " + numero + ".");
            return false;
        }
        this.chamber = chamber;
        statut = STATUT_RESERVE.ACCEPTEE;
        return true;
    }

    public void dessafecteChambre() {
        chamber = null;
    }

    public int getNumero() {
        return numero;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public boolean isaEnfant() {
        return aEnfant;
    }

    public CATEGORIE getCategorie() {
        return categorie;
    }

    public STATUT_RESERVE getStatut() {
        return statut;
    }

    public Chamber getChamber() {
        return chamber;
    }
}
