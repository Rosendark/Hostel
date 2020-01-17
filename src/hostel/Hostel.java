package hostel;

import java.util.ArrayList;

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
}
