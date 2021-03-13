package it.project.libreria.dao;

import it.project.libreria.dbinterface.DbConnection;

import java.util.Vector;

public class NotificaDAO {

	private static NotificaDAO instance;
	
	public static NotificaDAO getInstance()
	{
		if(instance == null)
			instance=new NotificaDAO();
		return instance;
	}
	
	// Prenotazione	
	public int NumeroNotifichePrenotazione()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT count(*) FROM Notifica WHERE Tipo = 'p'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0]);
	}
	public int IDNotificaPrenotazione(int j)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idNotifica FROM Notifica WHERE Tipo = 'p'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(j)[0].toString());
	}
	public int IDUtentePrenotazione(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Utente_idUtente FROM Notifica WHERE Tipo = 'p'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public int IDLibroPrenotazione(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Libri_idLibri FROM Notifica WHERE Tipo = 'p'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public int QuantitaNotifichePrenotazione(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT quantita FROM Notifica WHERE Tipo = 'p'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public boolean ConfermaPrenotazione(int idNotifica, int idUtente,int idLibro, int quantita2) {
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("DELETE FROM Notifica WHERE idNotifica="+idNotifica+" and Utente_idUtente="+idUtente+" and Libri_idLibri ="+idLibro+" and quantita = "+quantita2+" and tipo = 'p'");
		return risultato;
	}
	
	// Acquisto
	public int NumeroNotificheAcquisto()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT count(*) FROM Notifica WHERE Tipo = 'a'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0]);
	}
	public int IDNotificaAcquisto(int j)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idNotifica FROM Notifica WHERE Tipo = 'a'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(j)[0].toString());
	}
	public int IDUtenteAcquisto(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Utente_idUtente FROM Notifica WHERE Tipo = 'a'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public int IDLibroAcquisto(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Libri_idLibri FROM Notifica WHERE Tipo = 'a'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public int QuantitaNotificheAcquisto(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT quantita FROM Notifica WHERE Tipo = 'a'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public boolean ConfermaAcquisto(int idNotifica)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("DELETE FROM Notifica WHERE idNotifica="+idNotifica);
		return risultato;
	}
	
	// Cliente
	public boolean AcquistoCliente(int idlibro, int idutente, int quantita, char tipo)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Notifica (Utente_idUtente, Libri_idLibri, quantita, Tipo) VALUES ("+idutente+","+idlibro+","+quantita+",'"+tipo+"')");
		return risultato; 
	}
	
	//ID a valore
	public int ElencoUsername(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Libri_idLibro FROM Vendite");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
}
