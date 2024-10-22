package tn.uma.isamm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EtudiantController {
	
	
	GestionEtudiant ge;
	
	@Autowired
	public void EtudController (GestionEtudiant ge) {
		this.ge = ge;
	}
	
	@GetMapping("/authentif")
	public String Verif(String login, String mdp, Model model) {
	    if (!ge.verifierLoginMotDePasse(login, mdp)) {
	        model.addAttribute("msg", mdp==null && login==null ?null: "Erreur d'authentification, veuillez réessayer.");
	        return "authentif.html";  
	    } else {  
            return "redirect:/etudiants";
	    }
	}
	
	
	
	@GetMapping("/etudiants")
    public String listEtudiants(Model model) {
        model.addAttribute("etudiants", ge.getEtudiants());
        return "etudiants";
    }
	
	
	@GetMapping("/ajout")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("etudiant", new Etudiant());  
        return "formEtud"; 
    }
	
	@GetMapping("/modifier")
    public String afficherFormulaireModification(@RequestParam String cin, Model model) {
        Etudiant etudiant = ge.chercherParCIN(cin); 
        model.addAttribute("etudiant", etudiant);  
        return "formEtud";  
    }
	
	@PostMapping("/ajout")
    public String ajouterEtudiant(Etudiant etudiant) {
        ge.ajouterEtudiant(etudiant);
        return "redirect:/etudiants"; 
    }
	
	@GetMapping("/supprimer")
    public String supprimerEtudiant(@RequestParam String cin) {
        ge.supprimerEtudiant(cin); 
        return "redirect:/etudiants"; 
    }
	
	@PostMapping("/modifier")
	public String modifierEtudiant(@ModelAttribute Etudiant etudiant) {
	    ge.modifierEtudiant(etudiant); 
	    return "redirect:/etudiants"; 
	}

	
	//@PostMapping("/ajout")
    public String ajouterOuModifierEtudiant(@RequestParam(required = false) String cin, Etudiant etudiant) {
        if (cin == null || cin.isEmpty()) {
            ge.ajouterEtudiant(etudiant);  
        } else {
            ge.modifierEtudiant(etudiant);  
        }
        return "redirect:/etudiants";  
    }
}
