package models;

public class ModuleInfo {
    private final String nom;
    private Professeur professeur;

    public ModuleInfo(String nom) {
        this.nom = nom;
        this.professeur = null;
    }

    public String getNom() {
        return nom;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        //MR Que se passe t'il si professeur est null ?
        return nom + " avec " + professeur.getNom();
    }

}
