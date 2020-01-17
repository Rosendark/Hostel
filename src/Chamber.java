public class Chamber {

    protected int numero;
    protected int capacite;
    protected  CATEGORIE categorie;

    public Chamber(int numero, int capacite, CATEGORIE categorie) {
        this.numero = numero;
        this.capacite = capacite;
        this.categorie = categorie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public CATEGORIE getCategorie() {
        return categorie;
    }

    public void setCategorie(CATEGORIE categorie) {
        this.categorie = categorie;
    }
}
