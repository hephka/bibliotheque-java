package bibliotheque;

import java.sql.Date;
import java.util.ArrayList;

public final class Livre extends Volume {
	private boolean _etat = true;
	private ArrayList<Emprunt> _emprunts = new ArrayList<Emprunt>();
	

	public Livre() {}
	
	public Livre(int num, String titre, Date dateAcquisition, int nombreCopie, Bibliotheque bibliotheque, String auteur, boolean etat) {
		super(num, titre, dateAcquisition, nombreCopie, bibliotheque, auteur);
	}
	
	public void ajoutEmprunt(Emprunt emprunt) {
		_emprunts.add(emprunt);
		_nombreCopie--;
	}
	
	public void supprimerEmprunt(Emprunt emprunt) {
		_emprunts.remove(emprunt);
		_nombreCopie++;
	}
	
	public int nbrEmprunt() {
		return _emprunts.size();
	}
	
	public void controlerEtat() {
		if(_nombreCopie > 0) _etat = true;
		else _etat = false;
	}
	
	@Override
	protected void afficher() {
		controlerEtat();
		System.out.println("-----Livre-----");
		super.afficher();
		System.out.println("Etat : " + (_etat == true ? "Disponible" : "Indisponible"));
	}
	
	public String toString() {
		return _num + " | " + _titre + " | " + _dateAcquisition + " | " + _nombreCopie +  " | " + _auteur +  " | " + _etat;
	}
	
}
