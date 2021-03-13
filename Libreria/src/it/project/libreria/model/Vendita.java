package it.project.libreria.model;

import it.project.libreria.dao.VenditaDAO;

public class Vendita
{
	private String data;
	private int quantita;
	private float costo;
	private int idutente;
	private int idlibro;
	
	public Vendita (String data1, int quantita1, float costo1, int idutente1, int idlibro1)
	{
		super();
		this.data = data1;
		this.quantita = quantita1;
		this.costo = costo1;
		this.idutente = idutente1;
		this.idlibro = idlibro1;
	}

	public String getData()
		{ return data; }
	public void setData(String data)
		{ this.data = data; }
	public int getQuantita()
		{ return quantita; }
	public void setQuantita(int quantita)
		{ this.quantita = quantita; }
	public float getCosto()
		{ return costo; }
	public void setCosto(float costo)
		{ this.costo = costo; }
	public int getIdutente()
		{ return idutente; }
	public void setIdutente(int idutente)
		{ this.idutente = idutente; }
	public int getIdlibro()
		{ return idlibro; }
	public void setIdlibro(int idlibro)
		{ this.idlibro = idlibro; }
	
	public static boolean VenditaLibro(String data, int quantita, float costo, int idutente, int idlibro)
	{
		boolean ok = VenditaDAO.getInstance().VenditaLibro(data, quantita, costo, idutente, idlibro);
		return ok;
	}
	public static int NumeroVendite()
	{
		int numerovendite = VenditaDAO.getInstance().NumeroVendite();
		return numerovendite;
	}
	public int ElencoVenditeIdVendita(int i)
	{
		int id2 = VenditaDAO.getInstance().ElencoVenditeIdVendita(i);
		if(id2==-1) return -1;
		return id2;
	}
	public static String ElencoVenditeData(int i)
	{
		String data2 = VenditaDAO.getInstance().ElencoVenditeData(i);
		if(data2==null) return null;
		return data2;
	}
	public static int ElencoVenditeQuantita(int i)
	{
		int qta2 = VenditaDAO.getInstance().ElencoVenditeQuantita(i);
		if(qta2==-1) return -1;
		return qta2;
	}
	public static float ElencoVenditeCosto(int i)
	{
		float costo = VenditaDAO.getInstance().ElencoVenditeCosto(i);
		if(costo==-1) return -1;
		return costo;
	}
	public static int ElencoVenditeIdUtente(int i)
	{
		int id2 = VenditaDAO.getInstance().ElencoVenditeIdUtente(i);
		if(id2==-1) return -1;
		return id2;
	}
	public static int ElencoVenditeIdLibro(int i)
	{
		int id2 = VenditaDAO.getInstance().ElencoVenditeIdLibro(i);
		if(id2==-1) return -1;
		return id2;
	}
}
