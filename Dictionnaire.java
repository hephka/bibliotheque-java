package bibliotheque;

import java.sql.Date;

public final class Dictionnaire extends Volume {
	private int _nombrePage;
	
	public int getNombrePage() {
		return _nombrePage;
	}
	
	public void setNombrePage(int nombrePage) {
		_nombrePage = nombrePage;
	}

	public Dictionnaire() {}
	
	public Dictionnaire(int num, String titre, Date dateAcquisition, int nombreCopie, Bibliotheque bibliotheque, String auteur, int nombrePage) {
		super(num, titre, dateAcquisition, nombreCopie, bibliotheque, auteur);
	}
	
	@Override
	protected void afficher() {
		System.out.println("-----Dictionnaire-----");
		super.afficher();
		System.out.println("Nombre de page : " + _nombrePage);
	}
	
	public String toString() {
		return _num + " | " + _titre + " | " + _dateAcquisition + " | " + _nombreCopie +  " | " + _nombrePage;
	}
	
}
