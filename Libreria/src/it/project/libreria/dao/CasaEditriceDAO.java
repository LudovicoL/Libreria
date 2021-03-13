package it.project.libreria.dao;

import it.project.libreria.dbinterface.DbConnection;

import java.util.Vector;

public class CasaEditriceDAO
{
	private static CasaEditriceDAO instance;
	
	public static CasaEditriceDAO getInstance()
	{
		if(instance == null)
			instance=new CasaEditriceDAO();
		return instance;
	}
	
	public int IdCasaEditrice(String casaeditrice)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idCasaEditrice FROM CasaEditrice WHERE CasaEditrice = '"+casaeditrice+"'");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public String CasaEdTotali(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT CasaEditrice FROM CasaEditrice");
		if(risultato.size() == 0) return null;
		return risultato.get(i)[0];
	}
	public int NumeroCasaEd()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT count(*) FROM CasaEditrice");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public boolean AggiungiCasaEditrice(String casaeditrice)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("INSERT INTO CasaEditrice (CasaEditrice) VALUES ('"+casaeditrice+"')");
		return risultato;
	}
	public boolean ModificaCasaEditrice(String newcasaeditrice, int idcasaeditrice)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("UPDATE CasaEditrice SET CasaEditrice = '"+newcasaeditrice+"' WHERE idCasaEditrice = "+idcasaeditrice);
		return risultato;
	}
	
}
