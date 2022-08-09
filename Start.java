package bibliotheque;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
	private static ArrayList<Adherent> _adherents = new ArrayList<Adherent>();
	private static ArrayList<Document> _documents = new ArrayList<Document>();
	private static ArrayList<Emprunt> _emprunts = new ArrayList<Emprunt>();
	private static Bibliotheque _bibliotheque = new Bibliotheque();
	
	public static int menuPrincipal() {
		Scanner s = new Scanner(System.in);
		System.out.println("");
		System.out.println("1- Gérer les adhérents");
		System.out.println("2- Gérer la bibliothèque");
		System.out.println("3- Gérer les documents");
		System.out.println("4- Gérer les emprunts");
		System.out.println("5- Quitter");
		System.out.println("Votre choix ?");
		return s.nextInt();
	}
	public static int menuAdherent() {
		Scanner s = new Scanner(System.in);
		System.out.println("");
		System.out.println("1- Liste des adhérents");
		System.out.println("2- Ajout d'un adhérent");
		System.out.println("3- Chercher un adhérent");
		System.out.println("4- Supprimer un adhérent");
		System.out.println("5- Afficher le nombre des adhérents");
		System.out.println("6- Revenir au menu principal");
		System.out.println("7- Quitter");
		System.out.println("Votre choix ?");
		return s.nextInt();
	}
	public static int menuDocument() {
		Scanner s = new Scanner(System.in);
		System.out.println("");
		System.out.println("1- Liste des documents");
		System.out.println("2- Ajout d'un document");
		System.out.println("3- Chercher un document");
		System.out.println("4- Supprimer un document");
		System.out.println("5- Afficher le nombre des documents");
		System.out.println("6- Revenir au menu principal");
		System.out.println("7- Quitter");
		System.out.println("Votre choix ?");
		return s.nextInt();
	}
	public static int menuEmprunt() {
		Scanner s = new Scanner(System.in);
		System.out.println("");
		System.out.println("1- Liste des emprunts");
		System.out.println("2- Afficher le nombre des emprunts");
		System.out.println("3- Revenir au menu principal");
		System.out.println("4- Quitter");
		System.out.println("Votre choix ?");
		return s.nextInt();
	}
	public static int menuBibliotheque() {
		Scanner s = new Scanner(System.in);
		System.out.println("");
		System.out.println("1- Afficher les informations de la bibliothèque");
		System.out.println("2- Mettre à jour les information de la bibliothèque");
		System.out.println("3- Revenir au menu principal");
		System.out.println("4- Quitter");
		System.out.println("Votre choix ?");
		return s.nextInt();
	}
	
	public static void switchMenuAdherent() {
		int reponseAdherent;
		Adherent adherent;
		do {
			reponseAdherent = menuAdherent();
			switch (reponseAdherent) {
			case 1 : 
				afficherListeAdherents();
				break;
			case 2 :
				ajouterAdherent();
				break;
			case 3 :
				adherent = chercherAdherent();
				if(adherent == null) System.out.println("L'adhérent n'existe pas");
				else System.out.println(adherent);
				break;
			case 4 :
				adherent = chercherAdherent();
				if(adherent == null) System.out.println("L'adhérent n'existe pas");
				else {
					supprimerAdherent();
					System.out.println("L'adhérent a été supprimer");
				}
				break;
			case 5 : 
				afficherNombreAdherents();
				break;
			case 6 : 
				demarrer();
				break;
			case 7 :
				quitterApplication();
			default:
				break;
			}
			reponseAdherent = menuAdherent();
		} while (reponseAdherent != 7);
	}
	public static void switchMenuDocument() {
		int reponseDocument;
		do {
			reponseDocument = menuDocument();
			switch (reponseDocument) {
			case 1 : 
				afficherListeDocuments();
				break;
			case 2 :
				ajouterDocument();
				break;
			case 3 :
				supprimerDocument();
				break;
			case 5 : 
				afficherNombreDocuments();
				break;
			case 6 : 
				demarrer();
				break;
			case 7 :
				quitterApplication();
			default:
				break;
			}
			reponseDocument = menuDocument();
		} while (reponseDocument != 7);
	}
	
	// Méthode pour gérer le menu des emprunts ---> (demarrer)
	public static void switchMenuEmprunt() {
		int reponseEmprunt;
		do {
			reponseEmprunt = menuEmprunt();
			switch (reponseEmprunt) {
			case 1 : 
				afficherListeEmpruntsParLivre();
				break;
			case 2 : 
				afficherNombreEmprunts();
				break;
			case 3 : 
				demarrer();
				break;
			case 4 :
				quitterApplication();
			default:
				break;
			}
			reponseEmprunt = menuEmprunt();
		} while (reponseEmprunt != 4);
	}
	public static void switchMenuBibliothèque() {
		int reponseBibliothequet;
		do {
			reponseBibliothequet = menuBibliotheque();
			switch (reponseBibliothequet) {
			case 1 : 
				afficherInformationsBibliotheque();
				break;
			case 2 :
				modifierInformationsBibliothèque();
			case 3 : 
				demarrer();
				break;
			case 4 :
				quitterApplication();
			default:
				break;
			}
			reponseBibliothequet = menuBibliotheque();
		} while (reponseBibliothequet != 4);
	}
	
	// ------------------------------------
	
	// Méthode principale de  lancement de l'application
	
	public static void demarrer() {
		if(_bibliotheque.getNum() == 0) modifierInformationsBibliothèque();
		int reponse;
		do {
			reponse = menuPrincipal();
			switch(reponse) {
			case 1 : 
				switchMenuAdherent();
				break;
			case 2 :
				switchMenuBibliothèque();
				break;
			case 3 :
				switchMenuDocument();
				break;
			case 4 :
				switchMenuEmprunt();
				break;
			case 5 :
				quitterApplication();
			default :
				System.out.println("La fonctionnalité demandée n'existe pas");
				break;
			}
		} while(reponse != 5);
	}
	
	// Méthode pour quitter l'application --- > (demarrer, switchMenuAdherent)
	public static void quitterApplication() {
		System.out.println("Merci d'avoir utiliser notre application");
		System.exit(0);
	}
	
	// -----------ADHERENTS----------------
	
	// Méthode pour afficher la liste des adhérents ---> (switchMenuAdherent)
	
	public static void afficherListeAdherents() {
		System.out.println("");
		System.out.println("La liste des adhérents : ");
		for(Adherent adherent : _adherents) {
			adherent.afficher();
			System.out.println("---------------------");
		}
		if(_adherents.size() == 0) System.out.println("Pas d'adhérent à afficher");
	}
	
	// Méthode pour afficher le nombre des adhérents ---> (switchMenuAdherent)
	
	// Méthode d'affichage du nombre de tout les adhérents ---> (switchMenuAdhérent)
	public static void afficherNombreAdherents() {
		System.out.println("Le nombre actuel des adhérents est " + Adherent.getNombreAdherent());
	}
	
	
	// Méthode d'ajout d'un adhérent ---> (switchMenuAdherent)
	public static void ajouterAdherent() {
		int num;
		String nom;
		String prenom;
		Date dateNaissance;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Veuillez donner les information de l'adhérent : ");
		
		
		System.out.println("Numéro : ");
		num = Integer.parseInt(s.nextLine());
		
		System.out.println("Nom : ");
		nom = s.nextLine();
		
		System.out.println("Prénom : ");
		prenom = s.nextLine();
		
		System.out.println("Date de naissance : ");
		dateNaissance = Date.valueOf(s.nextLine());
		
		_adherents.add(new Adherent(num, nom, prenom, dateNaissance, _bibliotheque));
	}
	public static Adherent chercherAdherent() {
		int num;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Donner le numéro de l'adhérent :");
		num = s.nextInt();
		
		for(Adherent adherent : _adherents) {
			if(num == adherent.getNum()) {
				return adherent;
			}
		}
		return null;
	}
	public static void supprimerAdherent() {
		_adherents.remove(chercherAdherent());
	}	
	// -----------DOCUMENTS----------------
	
	// Méthode pour afficher la liste des documents ---> (switchMenuDocument)

	public static void afficherInformationsBibliotheque() {
		_bibliotheque.afficher();
	}
	public static void modifierInformationsBibliothèque() {
		int num;
		String adresse;
		String tel;
		String mail;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Numéro de la bibliothèque : ");
		num = Integer.parseInt(s.nextLine());
		_bibliotheque.setNum(num);
		
		System.out.println("Adresse de la bibliothèque : ");
		adresse = s.nextLine();
		_bibliotheque.setAdresse(adresse);
		
		System.out.println("Téléphone de la bibliothèque : ");
		tel = s.nextLine();
		_bibliotheque.setTel(tel);
		
		System.out.println("Mail de la bibliothèque : ");
		mail = s.nextLine();
		_bibliotheque.setMail(mail);
		
		System.out.println("Vos informations ont été modifiés : ");
		afficherInformationsBibliotheque();
	}

	public static void afficherListeDocuments() {
		System.out.println("");
		System.out.println("La liste des documents : ");
		for(Document document : _documents) {
			document.afficher();
			System.out.println("---------------------");
		}
		if(_documents.size() == 0) System.out.println("Pas de document à afficher");
	}
	
	// Méthode pour afficher le nombre des documents ---> (switchMenuDocument)
	public static void afficherNombreDocuments() {
		System.out.println("Le nombre actuel des documents est " + Document.getNombreDocument());
	}
	
	
	// Méthode d'ajout d'un document ---> (switchMenuDocument)
	public static void ajouterDocument() {
		int num;
		String titre;
		Date dateAcquisition;
		int nombreCopie;
		String auteur;
		String type;
		Date dateParution;
		Boolean etat;
		int nombrePage;
		String nomDestinataire;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Veuillez donner les information de le document : ");
		
		
		System.out.println("Numéro : ");
		num = Integer.parseInt(s.nextLine());
		
		System.out.println("Titre : ");
		titre = s.nextLine();
		
		System.out.println("Date d'acquisition : ");
		dateAcquisition = Date.valueOf(s.nextLine());
		
		System.out.println("Nombre de copie.s : ");
		nombreCopie = Integer.parseInt(s.nextLine());
		
		System.out.println("Quel est le type du document : (Livre, Journal, BD, Dictionnaire");
		type = s.nextLine().toLowerCase();
		
		switch (type) {
		case "journal" :
			System.out.println("Date de parution :");
			dateParution=Date.valueOf(s.nextLine());
			_documents.add(new Journal(num, titre, dateAcquisition, nombreCopie,_bibliotheque, dateParution));
			break;
		case "livre" :
			System.out.println("L'auteur : ");
			auteur = s.nextLine();
			_documents.add(new Livre(num, titre, dateAcquisition, nombreCopie, _bibliotheque, auteur, true));
			break;
		case "bd" :
			System.out.println("L'auteur : ");
			auteur = s.nextLine();
			System.out.println("Nom destinataire : ");
			nomDestinataire=s.nextLine();
			_documents.add(new Bd(num, titre, dateAcquisition, nombreCopie, _bibliotheque, auteur, nomDestinataire));
			break;
		case "dictionnaire" :
			System.out.println("L'auteur : ");
			auteur = s.nextLine();
			System.out.println("Nombre de pages :");
			nombrePage=Integer.parseInt(s.nextLine());
			_documents.add(new Dictionnaire(num, titre, dateAcquisition, nombreCopie, _bibliotheque, auteur, nombrePage));
			break;
		default :
			System.out.println("Le type n'est pas reconnu");
			break;
		}
	}
	public static Document chercherDocument() {
		int num;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Donner le numéro du document :");
		num = s.nextInt();
		
		for(Document document : _documents) {
			if(num == document.getNum()) {
				return document;
			}
		}
		return null;
	}
	
	// Méthode pour supprimer un adhérent ---> (switchMenuAdherent)
	public static void supprimerDocument() {
		_documents.remove(chercherDocument());
	}
	
	
	// -----------BIBLIOTHEQUE--------------
	
	// -----------EMPRUNTS------------------
	
	// Méthode pour afficher la liste des emprunts ---> (switchMenuDocument)
	
	public static void afficherListeEmpruntsParLivre() {
		int numeroLivre;
		
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Veuillez donner le numéro du livre : ");
		numeroLivre = s.nextInt();
		
		System.out.println("");
		System.out.println("La liste des emprunts : ");
			for(Emprunt emprunt : _emprunts) {
				if(emprunt.getLivre().getNum() == numeroLivre) emprunt.afficher();
				System.out.println("---------------------");
			}
			if(_emprunts.size() == 0) System.out.println("Pas d'emprunt à afficher");
	}
	
	// Méthode pour afficher le nombre des emprunts ---> (switchMenuDocument)
	public static void afficherNombreEmprunts() {
		System.out.println("Le nombre actuel des documents est " + Emprunt.getNombreEmprunt());
	}
	
	// --------------------------------------
	
	public static void main(String[] args) {
		_adherents.add(new Adherent(1, "a", "a", Date.valueOf("2001-01-01"), _bibliotheque));
		
		_documents.add(new Document(1, "a", Date.valueOf("2001-01-01"), 1, _bibliotheque));
		_documents.add(new Document(2, "b", Date.valueOf("2001-01-01"), 20, _bibliotheque));
		
		demarrer();
	}
}
