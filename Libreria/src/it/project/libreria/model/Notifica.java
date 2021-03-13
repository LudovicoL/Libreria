package it.project.libreria.model;

import it.project.libreria.dao.NotificaDAO;

public class Notifica
{
	private int idnotifica;
	private int idutente;
	private int idlibro;
	private char tipo;
	
	public Notifica (int idnotifica1, int idutente1, int idlibro1, char tipo1)
	{
		super();
		this.idnotifica = idnotifica1;
		this.idutente = idutente1;
		this.idlibro = idlibro1;
		this.tipo = tipo1;
	}

	public int getIdnotifica()
		{ return idnotifica; }
	public void setIdnotifica(int idnotifica)
		{ this.idnotifica = idnotifica; }
	public int getIdutente()
		{ return idutente; }
	public void setIdutente(int idutente)
		{ this.idutente = idutente;	}
	public int getIdlibro()
		{ return idlibro; }
	public void setIdlibro(int idlibro)
		{ this.idlibro = idlibro; }
	public char getTipo()
		{ return tipo; }
	public void setTipo(char tipo)
		{ this.tipo = tipo; }
	
	public static int NumeroNotifichePrenotazione()
	{
		int numeronotifiche = NotificaDAO.getInstance().NumeroNotifichePrenotazione();
		return numeronotifiche;
	}
	public static int IDNotificaPrenotazione(int j)
	{
		int idNotifica = NotificaDAO.getInstance().IDNotificaPrenotazione(j);
		return idNotifica;
	}
	public static int IDUtentePrenotazione(int i)
	{
		int idUtente = NotificaDAO.getInstance().IDUtentePrenotazione(i);
		return idUtente;
	}
	public static int IDLibroPrenotazione(int i)
	{
		int idLibro = NotificaDAO.getInstance().IDLibroPrenotazione(i);
		return idLibro;
	}
	public static int QuantitaNotifichePrenotazione(int i)
	{
		int quantita = NotificaDAO.getInstance().QuantitaNotifichePrenotazione(i);
		return quantita;
	}
	public static boolean ConfermaPrenotazione(int idNotifica, int idUtente,int idLibro, int quantita)
	{
		boolean ok = NotificaDAO.getInstance().ConfermaPrenotazione(idNotifica,idUtente,idLibro,quantita);
		return ok;	
	}
	public static int NumeroNotificheAcquisto()
	{
		int numeronotifiche = NotificaDAO.getInstance().NumeroNotificheAcquisto();
		return numeronotifiche;
	}
	public static int IDNotificaAcquisto(int j)
	{
		int idNotifica = NotificaDAO.getInstance().IDNotificaAcquisto(j);
		return idNotifica;
	}
	public static int IDUtenteAcquisto(int i)
	{
		int idUtente = NotificaDAO.getInstance().IDUtenteAcquisto(i);
		return idUtente;
	}
	public static int IDLibroAcquisto(int i)
	{
		int idLibro = NotificaDAO.getInstance().IDLibroAcquisto(i);
		return idLibro;
	}
	public static int QuantitaNotificheAcquisto(int i)
	{
		int quantita = NotificaDAO.getInstance().QuantitaNotificheAcquisto(i);
		return quantita;
	}
	public static boolean ConfermaAcquisto(int idNotifica)
	{
		boolean ok = NotificaDAO.getInstance().ConfermaAcquisto(idNotifica);
		return ok;	
	}
	public static boolean AcquistoCliente(int idlibro, int idutente, int quantita, char tipo)
	{
		boolean ok = NotificaDAO.getInstance().AcquistoCliente(idlibro,idutente,quantita,tipo);
		return ok;
	}
}