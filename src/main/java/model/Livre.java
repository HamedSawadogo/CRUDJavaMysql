package model;

public class Livre {
    private String nomLivre;
    private String auteur;
    private  float prix;
    private String anneeFilm;

    public Livre(String nomLivre, String auteur, float prix, String anneeFilm) {
        this.nomLivre = nomLivre;
        this.auteur = auteur;
        this.prix = prix;
        this.anneeFilm = anneeFilm;
    }
    public String getNomLivre() {
        return nomLivre;
    }
    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public String getAnneeFilm() {
        return anneeFilm;
    }
    public void setAnneeFilm(String anneeFilm) {
        this.anneeFilm = anneeFilm;
    }
}
