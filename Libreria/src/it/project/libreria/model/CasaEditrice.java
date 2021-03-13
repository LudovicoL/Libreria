package it.project.libreria.model;

import it.project.libreria.dao.CasaEditriceDAO;

public class CasaEditrice
{
	private int ID;
	private String CasaEditrice;
	
	public CasaEditrice (int id, String CasaEditrice)
	{
		super();
		this.ID = id;
		this.CasaEditrice = CasaEditrice;
	}
	
	public int getID()
		{ return ID; }
	public void setID(int id)
		{ ID = id; }
	public String getCasaEditrice()
		{ return CasaEditrice; }
	public void setCasaEditrice(String casaEditrice)
		{ CasaEditrice = casaEditrice; }
	
	public static int IdCasaEditrice (String CasaEd)
	{
		int idCasaEditricel = CasaEditriceDAO.getInstance().IdCasaEditrice(CasaEd);
		return idCasaEditricel;
	}
	public static String CasaEdTotali (int i)
	{
		String CasaEdL = CasaEditriceDAO.getInstance().CasaEdTotali(i);
		if(CasaEdL==null) return null;
		return CasaEdL;
	}
	public static int NumeroCasaEd()
	{
		int numeroCasaEd = CasaEditriceDAO.getInstance().NumeroCasaEd();
		return numeroCasaEd;
	}
	public static boolean AggiungiCasaEditrice(String casaeditrice)
	{
		boolean ok = CasaEditriceDAO.getInstance().AggiungiCasaEditrice(casaeditrice);
		return ok;
	}
	public static boolean ModificaCasaEditrice(String newcasaeditrice, int idcasaeditrice)
	{
		boolean ok = CasaEditriceDAO.getInstance().ModificaCasaEditrice(newcasaeditrice, idcasaeditrice);
		return ok;
	}
	
	
}
