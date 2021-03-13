package it.project.libreria.dao;

import it.project.libreria.dbinterface.DbConnection;
import java.util.Vector;

public class LibroDAO {
	private static LibroDAO instance;
	
	public static LibroDAO getInstance() {
		if(instance == null)
			instance=new LibroDAO();
		return instance;
	}
	
	public int IdLibro(String titolo, int idautore)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idLibro FROM Libri WHERE Titolo='"+titolo+"' AND Autori_idAutore="+idautore+"");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	
	public int ElencoLibriID(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idLibro FROM Libri");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public String ElencoLibriTitolo(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Titolo FROM Libri");
		if(risultato.size() == 0) return null;
		return risultato.get(i)[0];
	}
	public String ElencoLibriGenere(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Genere FROM Libri");
		if(risultato.size() == 0) return null;
		return risultato.get(i)[0];
	}
	public String ElencoLibriAutore(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Autore FROM Libri, Autori WHERE idAutore=Autori.idAutore");
		if(risultato.size() == 0) return null;
		return risultato.get(i)[0];
	}
	public String ElencoLibriCasaEditrice(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT CasaEditrice FROM Libri, CasaEditrice WHERE idCasaEditrice=CasaEditrice.idCasaEditrice");
		if(risultato.size() == 0) return null;
		return risultato.get(i)[0];
	}
	public float ElencoLibriCosto(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Costo FROM Libri");
		if(risultato.size() == 0) return -1;
		return Float.parseFloat(risultato.get(i)[0].toString());
	}
	public int ElencoLibriQuantita(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Quantita FROM Libri");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public int ElencoLibriAnnoPub(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT AnnoPubblicazione FROM Libri");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(i)[0].toString());
	}
	public int PosizioneLibro(int id, int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT idScaffale FROM Libri,Scaffale WHERE Scaffale.idScaffale=Libri.idScaffale");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[i].toString());
	}
	public int NumeroLibri()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT count(*) FROM Libri");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public int NumeroGeneri()
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT count(distinct Genere) FROM Libri");
		if(risultato.size() == 0) return -1;
		return Integer.parseInt(risultato.get(0)[0].toString());
	}
	public String GeneriTotali(int i)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Genere FROM Libri GROUP BY Genere");
		if(risultato.size() == 0) return null;
		return risultato.get(i)[0];
	}
	
	public boolean AggiungiLibro(String titolo ,String genere, int idautore, int idcasaeditrice, int idscaffale, int annopub, float costo, int quantita)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Libri (Titolo, Genere, Quantita, CasaEditrice_idCasaEditrice, Autori_idAutore, Scaffale_idScaffale, Costo, AnnoPubblicazione) VALUES ('"+titolo+"', '"+genere+"', "+quantita+", "+idcasaeditrice+", "+idautore+", "+idscaffale+", "+costo+", "+annopub+")");
		return risultato;
	}
	public boolean ModificaLibro(String titolo ,String genere, int idautore, int idcasaeditrice, int idscaffale, int annopub, float costo, int quantita, int idlibro)
	{
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("UPDATE Libri SET Titolo = '"+titolo+"', Genere = '"+genere+"', Quantita = "+quantita+", CasaEditrice_idCasaEditrice = "+idcasaeditrice+", Autori_idAutore = "+idautore+", Scaffale_idScaffale = "+idscaffale+", Costo = "+costo+", AnnoPubblicazione = "+annopub+" WHERE idLibro = "+idlibro+"");
		return risultato;
	}
	public String TitoloLibro(int idlibro)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Titolo FROM Libri WHERE idLibro="+idlibro);
		if(risultato.size() == 0) return null;
		return risultato.get(0)[0];
	}
	public float CostoLibri(int idlibro)
	{
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT Costo FROM Libri WHERE idLibro="+idlibro);
		if(risultato.size() == 0) return -1;
		return Float.parseFloat(risultato.get(0)[0].toString());
	}

	public boolean ModificaQuantita(int qta, int iDl) {
		boolean risultato = DbConnection.getInstance().eseguiAggiornamento("update Libri set Quantita = "+qta+" where idLibro = "+iDl+"");
		return risultato;
	}
}
