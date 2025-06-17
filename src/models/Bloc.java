package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Bloc {
    public int NBRE_DEMI_JOURS_SEMAINE = 10;
    private final String nom;
    private ModuleInfo[] modules;

    public Bloc(String nom) {
        this.nom = nom;
        this.modules = new ModuleInfo[NBRE_DEMI_JOURS_SEMAINE];

        ModuleInfo matu = new ModuleInfo("Matu");
        modules[0] = matu;
        modules[1] = matu;
        modules[2] = matu;
        modules[3] = matu;
    }

    public boolean planifierModule(ModuleInfo module) {
        boolean estPlanifier = false;
        int nbrePlace = 0;

        for (int i = 0; i < modules.length; i++) {
            if (modules[i] != null) {
                if (nbrePlace < 3) {
                    modules[i] = module;
                    nbrePlace++;
                }
            }
            estPlanifier = true;
        }

        if (nbrePlace < 3) {
            for (int i = 0; i < modules.length; i++) {
                if (modules[i] != null) {
                    if (modules[i] == module) {
                        modules[i] = null;
                    }
                }
            }
            estPlanifier = false;
        }

        return estPlanifier;
    }

    public void afficherHoraire() {
        for (int i = 0; i < modules.length; i++) {
            DayOfWeek.values()[i / 2].getDisplayName(TextStyle.FULL, Locale.FRANCE);
        }
    }

    public boolean estTotalementPlanifier() {
        boolean estTotalementPlanifier = true;

        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                estTotalementPlanifier = false;
            }
        }
        return estTotalementPlanifier;
    }

    public boolean contientModule(ModuleInfo module) {
        boolean contientModule = false;

        for (int i = 0; i < modules.length; i++) {
            if (modules[i].getNom().equals(module.getNom())) {
                contientModule = true;
            }

        }
        return contientModule;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }

}
