package bibliotheque;

import java.sql.Date;

public abstract class Volume extends Document {
	protected String _auteur;
	
	public String getAuteur() {
		return _auteur;
	}
	
	public void setAuteur(String auteur) {
		_auteur = auteur;
	}
	
	public Volume() {}
	
	public Volume(int num, String titre, Date dateAcquisition, int nombreCopie, Bibliotheque bibliotheque, String auteur) {
		super(num, titre, dateAcquisition, nombreCopie, bibliotheque);
		_auteur = auteur;
	}
	
	@Override
	protected void afficher() {
		super.afficher();
		System.out.println("Auteur : " + _auteur);
	}
	
	public String toString() {
		return _num + " | " + _titre + " | " + _dateAcquisition + " | " + _nombreCopie +  " | " + _auteur;
	}
	
}
