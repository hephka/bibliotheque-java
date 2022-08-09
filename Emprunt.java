package bibliotheque;

import java.util.Date;
import java.util.Calendar;

public final class Emprunt {
	private Date _dateEmprunt;
	private Date _dateRestitution;
	private Livre _livre;
	private Adherent _adherent;
	private static int _nombreEmprunt = 0;
	
	Calendar calendar = Calendar.getInstance();
	
	public Emprunt() {}
	
	public Emprunt(Date dateEmprunt, Date dateRestitution, Livre livre, Adherent adherent) {
		_dateEmprunt = dateEmprunt;
		_dateRestitution = dateRestitution;
		_livre = livre;
		livre.ajoutEmprunt(this);
		_adherent = adherent;
		adherent.ajoutEmprunt(this);
		_nombreEmprunt++;
	}
	
	public Emprunt(Emprunt emprunt) {
		_dateEmprunt = emprunt._dateEmprunt;
		_dateRestitution = emprunt._dateRestitution;
		_livre = emprunt._livre;
		_adherent = emprunt._adherent;
		_nombreEmprunt++;
	}
	
	public static int getNombreEmprunt() {
		return _nombreEmprunt;
	}
	
	public Date getDateEmprunt() {
		return _dateEmprunt;
	}
	
	public Date getDateRestitution() {
		return _dateRestitution;
	}
	
	public Livre getLivre() {
		return _livre;
	}
	
	public Adherent getAdherent() {
		return _adherent;
	}
	
	public void setDateEmprunt(Date dateEmprunt) {
		_dateEmprunt = dateEmprunt;
	}
	
	public void setDateRestitution(Date dateRestitution) {
		_dateRestitution = dateRestitution;
	}
	
	public void emprunter() {
		_livre._nombreCopie --;
		
	}
	
	public void restituer() {
		_livre._nombreCopie++;
	}
	
	public void prolonger(Date dateProlongation) {
		_dateRestitution = dateProlongation;
	}
	
	
	/*public void prolonger(int nbrJour) {
		calendar.setTime(_dateRestitution); 
		calendar.add(Calendar.DATE, nbrJour);
		_dateRestitution = calendar.getTime();
	}*/
	
	public void afficher() {
		System.out.println("Date d'emprunt : " + _dateEmprunt);
		System.out.println("Date de restitution : " + _dateRestitution);
		System.out.println("Adherent : " + _adherent);
		System.out.println("Livre : " + _livre);
	}

}
