package bibliotheque;

import java.sql.Date;
import java.util.ArrayList;

public class Adherent {
	private long _num;
	private String _prenom, _nom;
	private Date _dateNaissance;
	private int _nombreEmprunt;
	private Bibliotheque _bibliotheque;
	private ArrayList<Emprunt> _emprunts = new ArrayList<Emprunt>();
	private static int _nombreAdherent = 0;
	
	
	//Constructeurs
	public Adherent() {}
	
	public Adherent(long num, String nom, String prenom, Date dateNaissance, Bibliotheque bibliotheque) {
		_num = num;
		_nom = nom;
		_prenom = prenom;
		_dateNaissance = dateNaissance;
		_bibliotheque = bibliotheque;
		bibliotheque.ajoutAdherent(this);
		_nombreAdherent++;
	}
	
	public Adherent(Adherent adherent) {
		_num = adherent._num;
		_nom = adherent._nom;
		_prenom = adherent._prenom;
		_dateNaissance = adherent._dateNaissance;
		_bibliotheque = adherent._bibliotheque;
		_nombreAdherent++;
	}
	
	//Getters
	public long getNum() {
		return _num;
	}
	
	public String getNom() {
		return _nom;
	}
	
	public String getPrenom() {
		return _prenom;
	}
	
	public Date getDateNaissance() {
		return _dateNaissance;
	}
	
	public Bibliotheque getBibliotheque() {
		return _bibliotheque;
	}
	
	//Setters
	public void setNom(String nom) {
		_nom = nom;
	}
	
	public void setPrenom(String prenom) {
		_prenom = prenom;
	}

	public void setNum(long num) {
		_num = num;	
	}

	public void setDateNaissance(Date dateNaissance) {
		_dateNaissance = dateNaissance;
	}
	
	public void ajoutEmprunt(Emprunt emprunt) {
		_emprunts.add(emprunt);
		_nombreEmprunt++;
	}
	
	public void supprimerEmprunt(Emprunt emprunt) {
		_emprunts.remove(emprunt);
		_nombreEmprunt--;
	}
	
	public int nbrEmprunt() {
		return _emprunts.size();
	}
	
	public static int getNombreAdherent() {
		return _nombreAdherent;
	}
	
	public void afficher() {
		System.out.println("Num : " + _num);
		System.out.println("Nom : " + _nom);
		System.out.println("Prenom : " + _prenom);
		System.out.println("Date de naissance  : " + _dateNaissance);
		System.out.println("Nombre d'emprunt en cours  : " + _nombreEmprunt);
		System.out.println("Bibliothèque : " + _bibliotheque);
	}
	
	public String toString() {
		return _num + " | " + _nom + " | " + _prenom + " | " + _dateNaissance;
	}
	
	public boolean equals(Adherent obj) {
		return (_num == obj._num);
	}
}