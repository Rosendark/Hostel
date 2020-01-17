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

    public Reservation(int numero, int jourArrivee, int moisArrivee, int anneeArrivee,
                       int jourDepart, int moisDepart, int anneeDepart, int nbPersonnes,
                       boolean aEnfant, CATEGORIE categorie) {
        this.numero = numero;
        this.dateArrivee = dateCreation.createDate(jourArrivee, moisArrivee, anneeArrivee);
        this.dateDepart = dateCreation.createDate(jourDepart, moisDepart, anneeDepart);
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

    public void affecteChambre(Chamber chamber) {
        if(chamber == null) {
            System.out.println("Impossible d'affecter une chambre null à la chambre " + numero + "...");
            return;
        }

        if(chamber.getCategorie().comparePoids(categorie) < 0) {
            System.out.println("La chambre donnée ne répond pas aux besoins de la réservation " + numero + ".");
            return;
        }
        this.chamber = chamber;
        statut = STATUT_RESERVE.ACCEPTEE;
    }

    public void dessafecteChambre() {
        chamber = null;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public void setaEnfant(boolean aEnfant) {
        this.aEnfant = aEnfant;
    }
}
