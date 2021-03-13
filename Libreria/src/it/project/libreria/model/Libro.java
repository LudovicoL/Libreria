package it.project.libreria.model;

import it.project.libreria.dao.LibroDAO;

public class Libro
{
	private int id;
	private String titolo;
	private String genere;
	private String autore;
	private int quantita;
	private String casaeditrice;
	private int annoPub;
	private float costo;
	private int scaffale;
	
	public Libro(int id1, String titolo1, String genere1, String autore1, int quantita1, String casaeditrice1, int annoPub1, float costo1, int scaffale1)
	{
		super();
		this.id = id1;
		this.titolo = titolo1;
		this.genere = genere1;
		this.autore = autore1;
		this.quantita = quantita1;
		this.casaeditrice = casaeditrice1;
		this.annoPub = annoPub1;
		this.costo = costo1;
		this.scaffale = scaffale1;
	}
	

	public int getID()
		{ return id; }
	public void setID(int id1)
		{ id = id1; }
	public String getTitolo()
		{ return titolo; }
	public void setTitolo(String titolo1)
		{ titolo = titolo1; }
	public String getGenere()
		{ return genere; }
	public void setGenere(String genere1)
		{ genere = genere1; }
	public String getAutore()
		{ return autore; }
	public void setAutore(String autore1)
		{ autore = autore1; }
	public int getQta()
		{ return quantita; }
	public void setQta(int quantita1)
		{ this.quantita = quantita1; }
	public String getCasaEditrice()
		{ return casaeditrice; }
	public void setCasaEditrice(String casaeditrice1)
		{ casaeditrice = casaeditrice1; }
	public int getAnnoPub()
		{ return annoPub; }
	public void setAnnoPub(int annoPub1)
		{	annoPub = annoPub1; }
	public float getCosto()
		{ return costo; }
	public void setCosto(float costo1)
		{ costo = costo1; }
	public float getScaffale()
		{ return scaffale; }
	public void setScaffale(int scaffale1)
		{ scaffale = scaffale1; }
	
	public static int IdLibro(String titolo, int idautore)
	{
		int id = LibroDAO.getInstance().IdLibro(titolo, idautore);
		return id;
	}
	public static int ElencoLibriID(int i)
	{
		int id2 = LibroDAO.getInstance().ElencoLibriID(i);
		if(id2==-1) return -1;
		return id2;
	}
	public static String ElencoLibriTitolo(int i)
	{
		String titolo2 = LibroDAO.getInstance().ElencoLibriTitolo(i);
		if(titolo2==null) return null;
		return titolo2;
	}
	public static String ElencoLibriGenere(int i)
	{
		String genere2 = LibroDAO.getInstance().ElencoLibriGenere(i);
		if(genere2==null) return null;
		return genere2;
	}
	public static String ElencoLibriAutore(int i)
	{
		String autore2 = LibroDAO.getInstance().ElencoLibriAutore(i);
		if(autore2==null) return null;
		return autore2;
	}
	public static String ElencoLibriCasaEditrice(int i)
	{
		String casaeditrice2 = LibroDAO.getInstance().ElencoLibriCasaEditrice(i);
		if(casaeditrice2==null) return null;
		return casaeditrice2;
	}
	public static float ElencoLibriCosto(int i)
	{
		float costo2 = LibroDAO.getInstance().ElencoLibriCosto(i);
		if(costo2==-1) return 0;
		return costo2;
	}
	public static int ElencoLibriAnnoPub(int i)
	{
		int annoPub2 = LibroDAO.getInstance().ElencoLibriAnnoPub(i);
		if(annoPub2==-1) return 0;
		return annoPub2;
	}
	public static int ElencoLibriQuantita(int i)
	{
		int quantita2 = LibroDAO.getInstance().ElencoLibriQuantita(i);
		if(quantita2==-1) return 0;
		return quantita2;
	}
	public boolean PosizioneLibro(int id, int i)
	{
		int scaffale2 = LibroDAO.getInstance().PosizioneLibro(id,i);
		if(scaffale2==-1) return false;
		this.scaffale = scaffale2;
		return true;
	}
	public static int NumeroLibri()
	{
		int numerolibri2 = LibroDAO.getInstance().NumeroLibri();
		return numerolibri2;
	}
	public static int NumeroGeneri()
	{
		int numerogeneri2 = LibroDAO.getInstance().NumeroGeneri();
		return numerogeneri2;
	}
	public static String GeneriTotali(int i)
	{
		String generi2 = LibroDAO.getInstance().GeneriTotali(i);
		if(generi2==null) return null;
		return generi2;
	}
	public static boolean AggiungiLibro(String titolo ,String genere, int idautore, int idcasaeditrice, int idscaffale, int annopub, float costo, int quantita)
	{
		boolean ok = LibroDAO.getInstance().AggiungiLibro(titolo ,genere, idautore, idcasaeditrice, idscaffale, annopub, costo, quantita);
		return ok;
	}
	public static boolean ModificaLibro(String titolo ,String genere, int idautore, int idcasaeditrice, int idscaffale, int annopub, float costo, int quantita, int idlibro)
	{
		boolean ok = LibroDAO.getInstance().ModificaLibro(titolo ,genere, idautore, idcasaeditrice, idscaffale, annopub, costo, quantita, idlibro);
		return ok;
	}
	public static String TitoloLibro(int idlibro)
	{
		String titolo = LibroDAO.getInstance().TitoloLibro(idlibro);
		return titolo;
	}
	public static float CostoLibri(int idlibro)
	{
		float costo = LibroDAO.getInstance().CostoLibri(idlibro);
		if(costo==-1) return 0;
		return costo;
	}


	public static boolean ModificaQuantita(int qta, int iDl) {
		boolean ok = LibroDAO.getInstance().ModificaQuantita(qta,iDl);
		return ok;
	}
}
