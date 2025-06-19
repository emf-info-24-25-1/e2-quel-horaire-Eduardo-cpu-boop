package models;

public class Professeur {
    private final String nom;
    private final String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String prenom, String nom) {
        this.nom = nom;
        this.prenom = prenom;
        //MR Il faut créer un tableau tout de même de ModuleInfo mais de grandeur 0 (tableau dynamique)
        this.modulesEnseignes = null;
    }

    public boolean enseigneCeModule(String nomDuModule) {
        boolean enseigneCeModule = false;

        for (int i = 0; i < modulesEnseignes.length; i++) {
            if (modulesEnseignes[i].getNom() == nomDuModule) {
                enseigneCeModule = true;
                //MR Ici un petit break
            }
        }
        return enseigneCeModule;
    }

    public void ajouteModuleEnseigne(ModuleInfo module) {
        int nbre = 0;
        ModuleInfo[] tabtemporaire = new ModuleInfo[modulesEnseignes.length + 1];

        for (int i = 0; i < modulesEnseignes.length; i++) {
            if (modulesEnseignes[i] != null) {
                tabtemporaire[nbre] = modulesEnseignes[i];
                nbre++;
            }
        }
        tabtemporaire[tabtemporaire.length - 1] = module;
        modulesEnseignes = tabtemporaire;
    }

    public void viderModules() {
        //MR Il faut obtenir un tableau de taille 0
        for (int i = 0; i < modulesEnseignes.length; i++) {
            if (modulesEnseignes[i] != null) {
                modulesEnseignes[i] = null;
            }
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ModuleInfo[] getModulesEnseignes() {
        return modulesEnseignes;
    }

    @Override
    public String toString() {
        return prenom + " " + nom.toUpperCase();
    }

}
