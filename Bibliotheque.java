package bibliotheque;

import java.util.ArrayList;

public class Bibliotheque {
	private int _num;
	private String _adresse, _tel, _mail;
	private ArrayList<Adherent> _adherents;
	private ArrayList<Document> _documents;
	
	//Constructeurs
	public Bibliotheque() {
		_num = 0;
		_adresse = "";
		_tel = "";
		_mail = "";
		_adherents = new ArrayList<Adherent>();
		_documents = new ArrayList<Document>();
	}
	
	public Bibliotheque(int num, String adresse, String tel, String mail) {
		_num = num;
		_adresse = adresse;
		_tel = tel;
		_mail = mail;
		_adherents = new ArrayList<Adherent>();
		_documents = new ArrayList<Document>();
	}
	
	public Bibliotheque(Bibliotheque bibliotheque) {
		_num = bibliotheque._num;
		_adresse = bibliotheque._adresse;
		_tel = bibliotheque._tel;
		_mail = bibliotheque._mail;
		_adherents = bibliotheque._adherents;
		_documents = bibliotheque._documents;
	}
	
	//Getters
	public int getNum() {
		return _num;
	}
	
	public String getAdresse() {
		return _adresse;
	}
	
	public String getTel() {
		return _tel;
	}
	
	public String getMail() {
		return _mail;
	}
	
	//Setters
	public void setNum(int num) {
		_num = num;
	}
	
	public void setAdresse(String adresse) {
		_adresse = adresse;
	}
	
	public void setTel(String tel) {
		_tel = tel;
	}
	
	public void setMail(String mail) {
		_mail = mail;
	}
	
	public void ajoutAdherent(Adherent adherents) {
		_adherents.add(adherents);
	}
	
	public void supprimerAdherent(Adherent adherents) {
		_adherents.remove(adherents);
	}
	
	private void afficherAdherents() {
		System.out.println("Liste des adhérents (" + nombreAdherents() + "): ");
		for(Adherent adherent : _adherents) {
			System.out.println("      " + adherent);
		}
	}
	
	public void ajoutDocument(Document documents) {
		_documents.add(documents);
	}
	
	public void supprimerDocument(Document documents) {
		_documents.remove(documents);
	}
	
	public int nombreAdherents() {
		return _adherents.size();
	}
	
	public int nombreDocuments() {
		return _documents.size();
	}
	
	private void afficherDocuments() {
		System.out.println("Liste des documents (" + nombreDocuments() + ") : ");
		for(Document document : _documents) {
			System.out.println("      " + document);
		}
	}
	
	public void afficher() {
		System.out.println("Num : " + _num);
		System.out.println("Adresse : " + _adresse);
		System.out.println("Tel : " + _tel);
		System.out.println("Mail  : " + _mail);
		afficherAdherents();
		afficherDocuments();
	}
	
	@Override
	public String toString() {
		return _num + " | " + _adresse + " | " + _tel + " | " + _mail;
	}
}

	
