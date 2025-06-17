package service;

import models.ModuleInfo;
import models.Professeur;

public class ServiceFormationMaitres {

    public static void attribuerModules(Professeur[] professeurs, ModuleInfo[] modules) {

        for (int i = 0; i < professeurs.length; i++) {
            int nbre = ((int) (Math.random() * (12 - 1 + 1)) + 1)-1;
            if (professeurs[i].getModulesEnseignes().equals(modules[nbre])) {
                nbre = 0;
            } else {
                professeurs[i].ajouteModuleEnseigne(modules[nbre]);
            }
        }
    }

    public static boolean tousModulesCouverts(Professeur[] profs, ModuleInfo[] modules) {
        boolean tousModuleCouverts = false;

        for (int i = 0; i < profs.length; i++) {
            profs[i].getModulesEnseignes();
            if (profs[i].getModulesEnseignes() == null) {

            }
        }
        return tousModuleCouverts;
    }
}
