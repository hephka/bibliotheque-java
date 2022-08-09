package bibliotheque;

import java.sql.Date;

public final class Bd extends Volume {
	private String _nomDestinataire;
	
	public String getNomDestinataire() {
		return _nomDestinataire;
	}
	
	public void setNomDestinataire(String nomDestinataire) {
		_nomDestinataire = nomDestinataire;
	}
	
	public Bd() {}
	
	public Bd(int num, String titre, Date dateAcquisition, int nombreCopie, Bibliotheque bibliotheque, String auteur, String nomDestinataire) {
		super(num, titre, dateAcquisition, nombreCopie, bibliotheque, auteur);
		_nomDestinataire = nomDestinataire;
	}
	
	@Override
	protected void afficher() {
		System.out.println("-----BD-----");
		super.afficher();
		System.out.println("Nom du destinataire : " + _nomDestinataire);
	}

	public String toString() {
		return _num + " | " + _titre + " | " + _dateAcquisition + " | " + _nombreCopie +  " | " + _auteur +  " | " + _nomDestinataire;
	}
	
}
