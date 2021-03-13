package it.project.libreria.dao;

import java.util.Vector;

import it.project.libreria.dbinterface.DbConnection;

public class UtenteDAO {
	
	private static UtenteDAO instance;
	
	public static UtenteDAO getInstance() {
		if(instance == null)
			instance=new UtenteDAO();
		return instance;
	}
	
	public int login(String username, String password) {
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idUtente FROM Utente WHERE Username='"+username+"' AND Password='"+password+"'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public static boolean registrazione(String nome, String cognome, String username, String password)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Utente (Nome, Cognome, Username, Password) VALUES ('"+nome+"', '"+cognome+"', '"+username+"', '"+password+"')");
		return risultato;
	}
	public int contaUsername(String username)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT count(*) FROM Utente WHERE Username='"+username+"'");
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public String passwordSalvata(String username) {
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Password FROM Utente WHERE Username='"+username+"'");
		if(risultato.size() == 0) return null;
		return risultato.get(0)[0];
	}
	public String Username (int idutente)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Username FROM Utente WHERE idUtente='"+idutente+"'");
		if(risultato.size() == 0) return null;
		return risultato.get(0)[0];
	}
	public static boolean RegistrazioneCliente(int idutente)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Cliente (Utente_idUtente) VALUES ("+idutente+")");
		return risultato;
	}
}
