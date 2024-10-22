package tn.uma.isamm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GestionEtudiantImpl implements GestionEtudiant {
	
	// <Etudiant> : généralicité
	private List<Etudiant> etudiants = new ArrayList<>();

    @Override
    public Etudiant chercherParCIN(String cin) {
        for (Etudiant e : etudiants) {
            if (e.getCin().equals(cin)) {
                return e;
            }
        }
        return null; 
    }

    @Override
    public boolean verifierLoginMotDePasse(String cin, String motDePasse) {
       Etudiant e = chercherParCIN(cin);
       if(e != null) {
    	   return e.getMotDePasse().equals(motDePasse);
       }
       
    	   return false;
       
    }

    @Override
    public boolean ajouterEtudiant(Etudiant etudiant) {
        if (chercherParCIN(etudiant.getCin()) != null) { 
            return false;
        }
        etudiants.add(etudiant);
        return true;
    }

    @Override
    public boolean supprimerEtudiant(String cin) {
    	Etudiant e = chercherParCIN(cin);
    	if(e != null) {
    	return etudiants.remove(e);
    	}
    	
    	return false;
    	
    	
    }

    @Override
    public boolean modifierEtudiant(Etudiant etudiantModifie) {
        Etudiant etudiantExistant = chercherParCIN(etudiantModifie.getCin());
        if (etudiantExistant != null) {
            etudiantExistant.setNom(etudiantModifie.getNom());
            etudiantExistant.setMoyenne(etudiantModifie.getMoyenne());
            etudiantExistant.setMotDePasse(etudiantModifie.getMotDePasse());
            return true;
        }
        return false;
    }
    
    @Override
    public List<Etudiant> getEtudiants() {
        return etudiants;  
    }

}
