package tn.uma.isamm;

import java.util.List;

public interface GestionEtudiant {
	Etudiant chercherParCIN(String cin);
	  boolean verifierLoginMotDePasse(String cin, String motDePasse);
	 boolean ajouterEtudiant(Etudiant etudiant);
	  boolean supprimerEtudiant(String cin);
	  boolean modifierEtudiant(Etudiant etudiantModifie);
	  List<Etudiant> getEtudiants();

}
