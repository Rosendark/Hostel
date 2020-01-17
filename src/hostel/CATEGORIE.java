package hostel;

public enum CATEGORIE {
    ECO("Salle de bain commune", 2.82),
    CONFORT("Salle de bain privative et télévision", 7.20),
    CONFORT_PLUS("Salle de bain avec baignoire et climatisation", 23.45);

    private String description;
    private double prix;
    CATEGORIE(String description, double prix) {
        this.description = description;
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }
}
