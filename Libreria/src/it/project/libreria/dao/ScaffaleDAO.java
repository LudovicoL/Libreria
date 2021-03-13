package it.project.libreria.dao;

import it.project.libreria.dbinterface.DbConnection;
import java.util.Vector;

public class ScaffaleDAO
{
private static ScaffaleDAO instance;
	
	public static ScaffaleDAO getInstance()
	{
		if(instance == null)
			instance=new ScaffaleDAO();
		return instance;
	}
	
	public int IdScaffale(int scaffale)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idScaffale FROM Scaffale WHERE Posizione = "+scaffale+"");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public int NumeroScaffali()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT count(*) FROM Scaffale");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public int ScaffaliTotali(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idScaffale FROM Scaffale");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public boolean AggiungiScaffale(int posizione, int quantita)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Scaffale (Posizione, LibriTotali) VALUES ("+posizione+","+quantita+")");
		return risultato;
	}
	public int QuantitaScaffale(int idscaffale)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT LibriTotali FROM Scaffale WHERE idScaffale = "+idscaffale+"");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public boolean ModificaScaffale(int quantita, int idscaffale)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("UPDATE Scaffale SET LibriTotali = "+quantita+" WHERE idScaffale = "+idscaffale);
		return risultato;
	}
}
