package it.project.libreria.dao;

import it.project.libreria.dbinterface.DbConnection;

import java.util.Vector;

public class VenditaDAO
{
private static VenditaDAO instance;
	
	public static VenditaDAO getInstance()
	{
		if(instance == null)
			instance=new VenditaDAO();
		return instance;
	}
	
	public boolean VenditaLibro(String data, int quantita, float costo, int idutente, int idlibro)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Vendite (Data, Quantita, Costo, Cliente_Utente_idUtente, Libri_idLibro) VALUES ('"+data+"',"+quantita+","+costo+","+idutente+","+idlibro+")");
		return risultato; 
	}
	public int NumeroVendite()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT count(*) FROM Vendite");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public int ElencoVenditeIdVendita(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idVendite FROM Vendite");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public String ElencoVenditeData(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Data FROM Vendite");
		if(risultato.size() == 0) return null;
		return risultato.get(i)[0];
	}
	public int ElencoVenditeQuantita(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Quantita FROM Vendite");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public float ElencoVenditeCosto(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Costo FROM Vendite");
		if(risultato.size() == 0) return -1;
		return Float.parseFloat(risultato.get(i)[0].toString());
	}
	public int ElencoVenditeIdUtente(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Cliente_Utente_idUtente FROM Vendite");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public int ElencoVenditeIdLibro(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Libri_idLibro FROM Vendite");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
}
