package hostel;

public enum CATEGORIE {
    ECO("Salle de bain commune", (float) 2.82, 1),
    CONFORT("Salle de bain privative et télévision", (float) 7.20, 2),
    CONFORT_PLUS("Salle de bain avec baignoire et climatisation", (float) 23.45, 3);

    private String description;
    private float prix;
    private int poids; //Permet de savoir quelle catégorie est supérieure à une autre
    CATEGORIE(String description, float prix, int poids) {
        this.description = description;
        this.prix = prix;
        this.poids = poids;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }

    public int getPoids() {
        return poids;
    }
}
