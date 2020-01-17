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

    /**
     * Permet de savoir quelle la catégorie à un poids supérieure l'autre
     * @param category La catégorie qui servira de comparaison
     * @return -1 si la catégorie à un poids inférieur à celui de la catégorie donnée en paramètre,
     * 1 si le poids est supérieur et 0 en cas d'égalité
     */
    public int comparePoids(CATEGORIE category) {
        int resultat = 0;
        if(poids < category.poids)
            resultat = -1;
        else if(poids > category.poids)
            resultat = 1;
        else //Egalité
            resultat = 0;
        System.out.println("Comparaison du poids " + this + " et de " + category + ": " + resultat + ".");
        return resultat;
    }
}
