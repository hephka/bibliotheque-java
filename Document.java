package bibliotheque;

import java.sql.Date;

public class Document {
	protected int _num;
	protected String _titre;
	protected Date _dateAcquisition;
	protected int _nombreCopie;
	private Bibliotheque _bibliotheque;
	private static int _nombreDocument = 0;
	
	public Document() {}
	
	public Document(int num, String titre, Date dateAcquisition, int nombreCopie, Bibliotheque bibliotheque) {
		_num = num;
		_titre = titre;
		_dateAcquisition = dateAcquisition;
		_nombreCopie = nombreCopie;
		_bibliotheque = bibliotheque;
		bibliotheque.ajoutDocument(this);
		_nombreDocument++;
	}
	
	public Document(Document document) {
		_num = document._num;
		_titre = document._titre;
		_dateAcquisition = document._dateAcquisition;
		_nombreCopie = document._nombreCopie;
		_bibliotheque = document._bibliotheque;
		_nombreDocument++;
	}
	
	public int getNum() {
		return _num;
	}
	
	public String getTitre() {
		return _titre;
	}
	
	public Date getDateAcquisition() {
		return _dateAcquisition;
	}
	
	public int getNombreCopie() {
		return _nombreCopie;
	}
	
	public Bibliotheque getBibliotheque() {
		return _bibliotheque;
	}
	
	public void setNum(int num) {
		_num = num;
	}
	
	public void setTitre(String titre) {
		_titre = titre;
	}
	
	public void setDateAcquisition(Date dateAcquisition) {
		_dateAcquisition = dateAcquisition;
	}
	
	public void setNombreCopie(int nombreCopie) {
		_nombreCopie = nombreCopie;
	}
	
	public static int getNombreDocument() {
		return _nombreDocument;
	}
	
	protected void afficher() {
		System.out.println("Num : " + _num);
		System.out.println("Titre : " + _titre);
		System.out.println("Date d'acquisition : " + _dateAcquisition);
		System.out.println("Nombre de copie.s : " + _nombreCopie);
		System.out.println("Bibliothèque : " + _bibliotheque);
	}
	
	public String toString() {
		return _num + " | " + _titre + " | " + _dateAcquisition + " | " + _nombreCopie;
	}
}
