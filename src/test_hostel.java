import hostel.CATEGORIE;
import hostel.Hostel;

public class test_hostel {

    public final static void main(String[] args) {
        Hostel hostel = new Hostel();

        String email1 = "j@gmail.com";
        String email2 = "miles@sfr.fr";
        String email3 = "note_nuk_db@orange.fr";

        hostel.addChamber(3, CATEGORIE.CONFORT_PLUS);
        hostel.addChamber(1, CATEGORIE.ECO);
        hostel.addChamber(9, CATEGORIE.CONFORT);

        /*
        Actuellement:
           email 1 à les réservations 1, 2, 5
           email 2 à les réservations 3, 4, 7
           email 3 à les réservations 6
         */

        hostel.addReservation(22, 12, 1997, 23, 12, 1997,
                3, false, CATEGORIE.CONFORT, email1, "Mister J");
        //Devra être annulé ou modifié car la date de d'arrivée est après celle de départ
        hostel.addReservation(13, 5, 2011, 12, 5, 2011,
                3, false, CATEGORIE.CONFORT, email1, "Mister L");

        hostel.addReservation(12, 2, 2013, 9, 6, 2014,
                5, true, CATEGORIE.ECO, email2, "Miles Prower");
        hostel.addReservation(12, 2, 2013, 9, 6, 2014,
                5, false, CATEGORIE.CONFORT_PLUS, email2, "Tails");

        hostel.addReservation(13, 5, 2011, 14, 5, 2011,
                3, false, CATEGORIE.CONFORT, email1, "LJ");

        hostel.addReservation(2, 5, 2019, 5, 5, 2019,
                2, false, CATEGORIE.CONFORT, email3, "Noto");

        hostel.addReservation(26, 2, 2020, 29, 7, 2020,
                1, false, CATEGORIE.CONFORT_PLUS, email2, "Miles Prower");

        hostel.printListeClient();
    }
}
