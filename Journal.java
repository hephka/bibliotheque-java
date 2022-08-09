package bibliotheque;

import java.sql.Date;

public final class Journal extends Document {
	private Date _dateParution;
	
	public Date getDateParution() {
		return _dateParution;
	}
	
	public void setDateParution(Date dateParution) {
		_dateParution = dateParution;
	}
	
	public Journal() {}
	
	public Journal(int num, String titre, Date dateAcquisition, int nombreCopie, Bibliotheque bibliotheque, Date dateParution) {
		super(num, titre, dateAcquisition, nombreCopie, bibliotheque);
		_dateParution = dateParution;
	}
	
	@Override
	protected void afficher() {
		System.out.println("-----Journal-----");
		super.afficher();
		System.out.println("Date de parution : " + _dateParution);
	}
	
	public String toString() {
		return _num + " | " + _titre + " | " + _dateAcquisition + " | " + _nombreCopie +  " | " + _dateParution;
	}
	
}
