package models;

public class Horaire {
    public final static int NBRE_DE_BLOC = 6;
    //MR blocs pourrait être final
    private Bloc[] blocs;

    public Horaire() {
        this.blocs = new Bloc[NBRE_DE_BLOC];

        blocs[0] = new Bloc("B1S1");
        blocs[1] = new Bloc("B2S1");
        blocs[2] = new Bloc("B3S1");
        blocs[3] = new Bloc("B4S2");
        blocs[4] = new Bloc("B5S2");
        blocs[5] = new Bloc("B6S2");
    }

    public boolean planifier(ModuleInfo[] modules, Professeur[] profs) {
        boolean estPlanifier = false;

        for (int i = 0; i < modules.length; i++) {
            for (int j = 0; j < profs.length; j++) {
                //MR Il faut utiliser uniquement la méthode getModulesEnseignes()
                if (modules[i].getNom().equals(profs[j].getModulesEnseignes())) {
                    //MR Ici il faut dire au module quel prof fera ce module
                    profs[j].ajouteModuleEnseigne(modules[i]);
                    break;
                }

                for (int u = 0; u < blocs.length; j++) {
                    if (blocs[u] == null) {
                        blocs[u].planifierModule(modules[i]);
                    }
                    estPlanifier = true;
                }
            }
        }
        //MR Le est planifier n'utilise que celui de la planification, mais il faut rajouter le boolean si l'enseignant n'a 'as été affecté'
        return estPlanifier;
    }

    public void afficherHoraire() {
        for (int i = 0; i < blocs.length; i++) {
            blocs[i].afficherHoraire();
        }
    }

    public Bloc moduleDansQuelBloc(ModuleInfo module) {
        Bloc blocQuiContientLeModule = null;

        for (int i = 0; i < blocs.length; i++) {
            if (blocs[i].contientModule(module)) {
                blocQuiContientLeModule = blocs[i];
                break;
            }
        }
        return blocQuiContientLeModule;
    }
}
