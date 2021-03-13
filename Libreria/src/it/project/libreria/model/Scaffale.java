package it.project.libreria.model;

import it.project.libreria.dao.ScaffaleDAO;

public class Scaffale
{
	private int id;
	private int scaffale;
	private int quantita;
	
	public Scaffale (int id, int scaffale, int quantita)
	{
		super();
		this.id = id;
		this.scaffale = scaffale;
		this.quantita = quantita;
	}
	
	public int getID()
		{ return id; }
	public void setID(int id1)
		{ id = id1; }
	public int getQuantita()
		{ return quantita; }
	public void setQta(int quantita1)
		{ this.quantita = quantita1; }
	public float getScaffale()
		{ return scaffale; }
	public void setScaffale(int scaffale1)
		{ scaffale = scaffale1; }
	
	public static int IdScaffale(int scaffale)
	{
		int idScaffalel = ScaffaleDAO.getInstance().IdScaffale(scaffale);
		return idScaffalel;
	}
	public static int NumeroScaffali()
	{
		int numeroScaffali = ScaffaleDAO.getInstance().NumeroScaffali();
		return numeroScaffali;
	}
	public static int ScaffaliTotali(int i)
	{
		int ScaffaliL = ScaffaleDAO.getInstance().ScaffaliTotali(i);
		return ScaffaliL;
	}
	public static boolean AggiungiScaffale(int posizione, int quantita)
	{
		boolean ok = ScaffaleDAO.getInstance().AggiungiScaffale(posizione, quantita);
		return ok;
	}
	public static int QuantitaScaffale(int idscaffale)
	{
		int idScaffalel = ScaffaleDAO.getInstance().QuantitaScaffale(idscaffale);
		return idScaffalel;
	}
	public static boolean ModificaScaffale(int quantita, int idscaffale)
	{
		boolean ok = ScaffaleDAO.getInstance().ModificaScaffale(quantita, idscaffale);
		return ok;
	}
}
