package it.project.libreria.model;

import it.project.libreria.dao.AutoreDAO;

public class Autore
{
	private int id;
	private String autore;
	
	public Autore (int id, String autore)
	{
		super();
		this.id = id;
		this.autore = autore;
	}

	public int getID()
		{ return id; }
	public void setID(int id1)
		{ id = id1; }
	public String getAutore()
		{ return autore; }
	public void setAutore(String autore1)
		{ autore = autore1; }
	
	public static int IdAutore(String autore)
	{
		int id = AutoreDAO.getInstance().IdAutore(autore);
		return id;
	}
	public static String AutoriTotali(int i)
	{
		String autore = AutoreDAO.getInstance().AutoriTotali(i);
		if(autore==null) return null;
		return autore;
	}
	public static int NumeroAutori()
	{
		int numeroAutori = AutoreDAO.getInstance().NumeroAutori();
		return numeroAutori;
	}
	public static boolean AggiungiAutore(String autore)
	{
		boolean ok = AutoreDAO.getInstance().AggiungiAutore(autore);
		return ok;
	}
	public static boolean ModificaAutore(String newautore, int idautore)
	{
		boolean ok = AutoreDAO.getInstance().ModificaAutore(newautore, idautore);
		return ok;
	}
}
