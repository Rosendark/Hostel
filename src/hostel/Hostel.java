package hostel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Hostel {

    protected ArrayList<Chamber> chambers;
    protected ArrayList<Client> clients;
    protected ArrayList<Reservation> reservations;

    public Hostel() {
        chambers = new ArrayList<Chamber>();
        clients = new ArrayList<Client>();
        reservations = new ArrayList<Reservation>();
    }

    public Hostel(ArrayList<Chamber> chambers, ArrayList<Client> clients, ArrayList<Reservation> reservations) {
        this.chambers = chambers;
        this.clients = clients;
        this.reservations = reservations;
    }

    public void addChamber(int capacite, CATEGORIE categorie) {
        int indexNouvelleChambre = chambers.size() + 1;
        chambers.add(new Chamber(indexNouvelleChambre, capacite, categorie));
    }

    public ArrayList<Chamber> getChambers() {
        return chambers;
    }

    public void setChambers(ArrayList<Chamber> chambers) {
        this.chambers = chambers;
    }

    public void printListeClient() {
        System.out.println("Liste des clients de l'hostel: ");
        for(Client c: clients) {
            System.out.println(c);
        }
    }

    /**
     * Permet d'ajouter un client (possible uniquement à l'intérieur de cette classe lors de l'ajout d'une
     * réservation par un email inconnu
     * @param nom Le nom du client
     * @param email L'adresse email (qui sert d'identifiant)
     * @return Le client créé
     */
    private Client addClient(String nom, String email) {
        Client nouveauClient = new Client(nom, email);
        clients.add(nouveauClient);
        return nouveauClient;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void addReservation(int jourArrivee, int moisArrivee, int anneeArrivee,
                               int jourDepart, int moisDepart, int anneeDepart, int nbPersonnes,
                               boolean aEnfant, CATEGORIE categorie, String emailReserveur, String nomReserveur) {
        //Todo: Vérifier les dates d'arrivée et de départ et annuler la création de la réservation si besoin


        //Première étape, créer la réservation et l'ajouter à l'Hôtel
        int indexNouvelHotel = reservations.size() + 1;
        Reservation nouvelleReservation = new Reservation(indexNouvelHotel, jourArrivee, moisArrivee, anneeArrivee,
                jourDepart, moisDepart, anneeDepart, nbPersonnes, aEnfant, categorie);
        reservations.add(nouvelleReservation);

        /*Deuxième étape, chercher le client avec l'adresse mail donnée, le créer si on ne le trouve pas,
        dans les deux cas: lui affecter la réservation */
        Client clientReserveur = getClientSelonMail(emailReserveur);
        if(clientReserveur == null)
            clientReserveur = addClient(nomReserveur, emailReserveur);
        clientReserveur.addReservation(nouvelleReservation);
    }

    /**
     * Permet d'obtenir un client selon son adresse email
     * @param emailRecherche Le mail recherché
     * @return Le client obtenu ou null si il n'existe pas de client avec l'adresse donnée
     */
    private Client getClientSelonMail(String emailRecherche) {
        for(Client c: clients) {
            if(c.getEmail().equals(emailRecherche))
                return c;
        }
        return null;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void traiteToutesReservations() {
        //On se base sur le moment de l'exécution de cette méthode
        Date dateDebutTraitement = new Date();
        for(Reservation r: reservations) {
            traiteUneReservation(r, dateDebutTraitement);
        }
    }

    public void traiteUneReservation(Reservation reservation, Date dateLimite) {
        //On ne traite qu'une seule fois chaque réservation (le déclassement sera géré dans une autre méthode)
        //Et tant pis si on essaie de la traiter après la date de départ
        if(reservation.getStatut() != STATUT_RESERVE.EN_ATTENTE) {
            System.out.println("La réservation " + reservation.getNumero() + " n'est pas en attente.");
            return;
        }
        if(reservation.getDateDepart().before(dateLimite)) {
            System.out.println("La fin de la réservation est avant la date limite.");
            return;
        }

        ArrayList<Chamber> chambresDisponibles = getChambresNonReservees(dateLimite);
        //On parcourt les chambres pour savoir laquelle utiliser
        Chamber chamberReservation = getChambrePourReservation(chambresDisponibles);
        if(!reservation.affecteChambre(chamberReservation))
            System.out.println("Erreur réservation avec la chambre " + chamberReservation);
    }

    private Chamber getChambrePourReservation(ArrayList<Chamber> chambresDisponibles) {
        //Todo: à faire
        Chamber chambreObtenue = null;
        for(Chamber ch: chambresDisponibles) {

        }

        return chambreObtenue;
    }

    public ArrayList<Chamber> getChambresNonReservees(Date dateLimite) {
        //On récupère la liste des chambres réservées et on clone celle de l'Hostel
        ArrayList<Chamber> chambresReservees = getChambresReservees(dateLimite);
        ArrayList<Chamber> chambresNonReservee = new ArrayList<Chamber>();
        chambresNonReservee.addAll(chambers);

        //On retire ensuite toutes les chambres réservées au clone
        chambresNonReservee.removeAll(chambresReservees);
        return chambresNonReservee;
    }

    /**
     * Permet de récupérer la liste des chambres qui sont déjà en cours de réservation
     * @param dateLimite Date limite de récupération de chambres (on ne fait pas de récupération sur les
     * réservations qui sont APRES cette date)
     * @return La liste des chambres reservees
     */
    private ArrayList<Chamber> getChambresReservees(Date dateLimite) {
        ArrayList<Chamber> chambresReservees = new ArrayList<Chamber>();
        Chamber chambreActu = null;
        for(Reservation r: reservations) {
            chambreActu = r.getChamber();
            if(r.getDateDepart().before(dateLimite) && chambreActu != null)
                chambresReservees.add(r.getChamber());
        }
        return chambresReservees;
    }
}
