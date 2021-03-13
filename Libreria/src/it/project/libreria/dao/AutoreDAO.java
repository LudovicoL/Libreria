package it.project.libreria.dao;

import java.util.Vector;
import it.project.libreria.dbinterface.DbConnection;

public class AutoreDAO {

private static AutoreDAO instance;
	
	public static AutoreDAO getInstance() {
		if(instance == null)
			instance=new AutoreDAO();
		return instance;
	}
	
	public int IdAutore(String autore)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idAutore FROM Autori WHERE Autore = '"+autore+"'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public String AutoriTotali(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Autore FROM Autori");
		if(risultato.size() == 0) return null;
		return risultato.get(i)[0];
	}
	public int NumeroAutori()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT count(*) FROM Autori");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public boolean AggiungiAutore(String autore)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Autori (Autore) VALUES ('"+autore+"')");
		return risultato;
	}
	public boolean ModificaAutore(String newautore, int idautore)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("UPDATE Autori SET Autore = '"+newautore+"' WHERE idAutore = "+idautore);
		return risultato;
	}
}
