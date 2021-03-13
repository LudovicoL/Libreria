package it.project.libreria.listeners;

import it.project.libreria.business.Sessione;
import it.project.libreria.model.Autore;
import it.project.libreria.model.CasaEditrice;
import it.project.libreria.model.Libro;
import it.project.libreria.model.Notifica;
import it.project.libreria.model.Scaffale;
import it.project.libreria.view.AggiungiDati;
import it.project.libreria.view.AggiungiLibro;
import it.project.libreria.view.InterfacciaScaffali;
import it.project.libreria.view.ModificaLibro;
import it.project.libreria.view.PannelloLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ScaffaliListener implements ActionListener
{
	InterfacciaScaffali iScaffali;
	AggiungiLibro iAggiungi;
	ModificaLibro iModifica;
	AggiungiDati iDati;
	
 
	@Override
	public void actionPerformed(ActionEvent e) 
    {
		// InterfacciaScaffali
		
		if (e.getActionCommand().equals("AGGIUNGILIBRO"))
		{
			
			int autoriMax = Autore.NumeroAutori();
			int casaEdMax = CasaEditrice.NumeroCasaEd();
			int scaffaliMax = Scaffale.NumeroScaffali();
			int generiMax = Libro.NumeroGeneri();
			int count = iScaffali.getCountagg(); //azzera il count quando aggiungi un nuovo autore per permettere il refresh degli autori.
			new AggiungiLibro(iScaffali, true, autoriMax, casaEdMax, scaffaliMax, generiMax, count, iScaffali);
		}
        if (e.getActionCommand().equals("MODIFICALIBRO"))
        {
        	String titolo = InterfacciaScaffali.getTitolo();
			String autore = InterfacciaScaffali.getAutore();
			String genere = InterfacciaScaffali.getGenereLetterario();
			String casaEditrice = InterfacciaScaffali.getCasaEditrice();
			int annoPub = InterfacciaScaffali.getAnnoPub();
			float costo = InterfacciaScaffali.getCosto();
			int quantitaLibri = InterfacciaScaffali.getQuantitaLibri();
			int autoriMax = Autore.NumeroAutori();
			int casaEdMax = CasaEditrice.NumeroCasaEd();
			int scaffaliMax = Scaffale.NumeroScaffali();
			int generiMax = Libro.NumeroGeneri();
			int count = iScaffali.getCountmod();
			
            new ModificaLibro(iScaffali, true, titolo, autore, genere, casaEditrice, annoPub, costo, quantitaLibri, autoriMax, casaEdMax, scaffaliMax, generiMax,iScaffali,count);
        }
        
        if (e.getActionCommand().equals("CONFERMANOTIFICA"))
        {
        	int idNotifica = InterfacciaScaffali.getIdNotifica();
        	int idUtente = InterfacciaScaffali.getIdUtente();
        	int idLibro = InterfacciaScaffali.getIdLibro();
        	int quantita = InterfacciaScaffali.getQuantita();
        	
        	boolean OK = Notifica.ConfermaPrenotazione(idNotifica,idUtente,idLibro,quantita);
        	if (OK == true)
        	{
        		JOptionPane.showMessageDialog(null, "Prenotazione effettuta!", "", JOptionPane.INFORMATION_MESSAGE);
        		iScaffali.dispose();
        		new InterfacciaScaffali();
        	}
        }
        
        // JMenu in InterfacciaScaffali
    
        if (e.getActionCommand().equals("AGGIUNGI_AUTORE"))
        {
        	new AggiungiDati(iScaffali, true, 1, 0, 0, 0);
        }
        if (e.getActionCommand().equals("AGGIUNGI_CASAEDITRICE"))
        {
        	new AggiungiDati(iScaffali, true, 2, 0, 0, 0);
        }
        if (e.getActionCommand().equals("AGGIUNGI_SCAFFALE"))
        {
        	new AggiungiDati(iScaffali, true, 3, 0, 0, 0);
        }
        if (e.getActionCommand().equals("MODIFICA_AUTORE"))
        {
        	int autoriMax = Autore.NumeroAutori();
        	new AggiungiDati(iScaffali, true, 4, autoriMax, 0, 0);
        }
        if (e.getActionCommand().equals("MODIFICA_CASAEDITRICE"))
        {
        	int casaEdMax = CasaEditrice.NumeroCasaEd();
        	new AggiungiDati(iScaffali, true, 5, 0, casaEdMax, 0);
        }
        if (e.getActionCommand().equals("MODIFICA_SCAFFALE"))
        {
        	int scaffaliMax = Scaffale.NumeroScaffali();
        	new AggiungiDati(iScaffali, true, 6, 0, 0, scaffaliMax);
        }
        if (e.getActionCommand().equals("ESCI"))
        {
        	int n = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler effettura il logout?", "Logout", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		iScaffali.dispose();
        		Sessione.getInstance().svuotaSessione();
        		new PannelloLogin();
        	}
        }
        
        // AggiungiLibro
        
        if (e.getActionCommand().equals("CONFERMAAGGIUNGILIBRO"))
		{
			String titolo = AggiungiLibro.getN2().getText();
			String genere = (String) AggiungiLibro.getC4().getSelectedItem();
			String autore = (String) AggiungiLibro.getC1().getSelectedItem();
			String casaEditrice = (String) AggiungiLibro.getC2().getSelectedItem();
			int scaffale = (int) AggiungiLibro.getC3().getSelectedItem();
			String annoPubTemp = AggiungiLibro.getN4().getText();
			String costoTemp = AggiungiLibro.getN5().getText();
			String quantitaTemp = AggiungiLibro.getN6().getText();
			
			// Controlli sui campi vuoti e sui campi numerici
			// Titolo
			if(titolo.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo TITOLO vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// Anno Pubblicazione
			if(annoPubTemp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo ANNO PUBBLICAZIONE vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int annoPub;
			try
			{
				annoPub = Integer.parseInt(annoPubTemp);
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo ANNO PUBBLICAZIONE: Inserire un valore numerico!", "Errore!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// Costo
			if(costoTemp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo COSTO vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			float costo;
			try
			{
				costo = Float.parseFloat(costoTemp);
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo COSTO: Inserire un valore numerico!", "Errore!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// Quantita
			if(quantitaTemp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo QUANTITA vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int quantita;
			try
			{
				quantita = Integer.parseInt(quantitaTemp);
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo QUANTITA: Inserire un valore numerico!", "Errore!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Acquisizione ID dei campi esterni
			int idAutore = Autore.IdAutore(autore);
			int idCasaEditrice = CasaEditrice.IdCasaEditrice(casaEditrice);
			int idScaffale = Scaffale.IdScaffale(scaffale);
			
			// Esecuzione query con chiusura della finestra
			int n = JOptionPane.showConfirmDialog(null, "Confermare l'aggiunta del nuovo libro?", "Conferma", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		Libro.AggiungiLibro(titolo, genere, idAutore, idCasaEditrice, idScaffale, annoPub, costo, quantita);
        		JOptionPane.showMessageDialog(null,"Nuovo Libro aggiunto!", "", JOptionPane.INFORMATION_MESSAGE);
        		iAggiungi.dispose();
        		iScaffali.dispose();
        		AggiungiLibro.getN2().setText(null);
        		AggiungiLibro.getN4().setText(null);
        		AggiungiLibro.getN5().setText(null);
        		AggiungiLibro.getN6().setText(null);
        		new InterfacciaScaffali();
        	}
		}
        
        // ModificaLibro
        
        if (e.getActionCommand().equals("CONFERMAMODIFICALIBRO"))
        {
        	String titolo = ModificaLibro.getN2().getText();
			String genere = (String) ModificaLibro.getC4().getSelectedItem();
			String autore = (String) ModificaLibro.getC1().getSelectedItem();
			String casaEditrice = (String) ModificaLibro.getC2().getSelectedItem();
			int scaffale = (int) ModificaLibro.getC3().getSelectedItem();
			String annopubTemp = ModificaLibro.getN4().getText();
			String costoTemp = ModificaLibro.getN5().getText();
			String quantitaTemp = ModificaLibro.getN6().getText();
			
			// Controlli sui campi vuoti e sui campi numerici
			// Titolo
			if(titolo.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo TITOLO vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// Anno Pubblicazione
			if(annopubTemp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo ANNO PUBBLICAZIONE vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int annopub;
			try
			{
				annopub = Integer.parseInt(annopubTemp);
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo ANNO PUBBLICAZIONE: Inserire un valore numerico!", "Errore!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// Costo
			if(costoTemp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo COSTO vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			float costo;
			try
			{
				costo = Float.parseFloat(costoTemp);
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo COSTO: Inserire un valore numerico!", "Errore!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// Quantita
			if(quantitaTemp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo QUANTITA vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int quantita;
			try
			{
				quantita = Integer.parseInt(quantitaTemp);
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo QUANTITA: Inserire un valore numerico!", "Errore!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Acquisizione ID dei campi esterni
			int idautore = Autore.IdAutore(autore);
			int idcasaeditrice = CasaEditrice.IdCasaEditrice(casaEditrice);
			int idscaffale = Scaffale.IdScaffale(scaffale);
			int idlibro = Libro.IdLibro(titolo, idautore);
			
			// Esecuzione query con chiusura della finestra
			int n = JOptionPane.showConfirmDialog(null, "Confermare la modifica del libro?", "Conferma", JOptionPane.YES_NO_OPTION);
			if(n==JOptionPane.YES_OPTION)
			{
				Libro.ModificaLibro(titolo ,genere, idautore, idcasaeditrice, idscaffale, annopub, costo, quantita, idlibro);
				JOptionPane.showMessageDialog(null,"Modifica Libro completata!", "", JOptionPane.INFORMATION_MESSAGE);
			    iModifica.dispose();
			    iScaffali.dispose();
			    ModificaLibro.getN2().setText(null);
			    ModificaLibro.getN4().setText(null);
			    ModificaLibro.getN5().setText(null);
			    ModificaLibro.getN6().setText(null);
			    new InterfacciaScaffali();
			}
        }
        
        // AggiungiDati
        
        if (e.getActionCommand().equals("AddAutore"))
        {
        	String autore = AggiungiDati.getN1().getText();
        	if(autore.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
        	int n = JOptionPane.showConfirmDialog(null, "Confermare l'aggiunta del nuovo autore?", "Conferma", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		Autore.AggiungiAutore(autore);
        		JOptionPane.showMessageDialog(null,"Nuovo Autore aggiunto!", "", JOptionPane.INFORMATION_MESSAGE);
        		iDati.dispose();
        		AggiungiDati.getN1().setText(null);
        	}
        }
        if (e.getActionCommand().equals("AddCasaEd"))
        {
        	String casaeditrice = AggiungiDati.getN2().getText();
        	if(casaeditrice.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
        	int n = JOptionPane.showConfirmDialog(null, "Confermare l'aggiunta della nuova casa editrice?", "Conferma", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		CasaEditrice.AggiungiCasaEditrice(casaeditrice);
        		JOptionPane.showMessageDialog(null,"Nuova Casa Editrice aggiunta!", "", JOptionPane.INFORMATION_MESSAGE);
        		iDati.dispose();
        		AggiungiDati.getN2().setText(null);
        	}
        }
        if (e.getActionCommand().equals("AdScaffale"))
        {
        	String posizioneTemp = AggiungiDati.getN31().getText();
        	if(posizioneTemp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! SCAFFALE: Campo vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
        	int posizione;
			try
			{
				posizione = Integer.parseInt(posizioneTemp);
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Inserire un valore numerico!", "Errore!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String quantitaTemp = AggiungiDati.getN32().getText();
        	if(quantitaTemp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! QUANTITA: Campo vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
        	int quantita;
			try
			{
				quantita = Integer.parseInt(quantitaTemp);
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Inserire un valore numerico!", "Errore!", JOptionPane.ERROR_MESSAGE);
				return;
			}
        	int n = JOptionPane.showConfirmDialog(null, "Confermare l'aggiunta del nuovo scaffale?", "Conferma", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		Scaffale.AggiungiScaffale(posizione, quantita);
        		JOptionPane.showMessageDialog(null,"Nuovo Scaffale aggiunto!", "", JOptionPane.INFORMATION_MESSAGE);
        		iDati.dispose();
        		AggiungiDati.getN31().setText(null);
        		AggiungiDati.getN32().setText(null);
        	}
        }
        if (e.getActionCommand().equals("EditAutore"))
        {
        	String oldautore = (String) AggiungiDati.getC4().getSelectedItem();
        	String newautore = AggiungiDati.getN4().getText();
        	if(newautore.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
        	int id = Autore.IdAutore(oldautore);
        	int n = JOptionPane.showConfirmDialog(null, "Confermare la modifica?", "Conferma", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		Autore.ModificaAutore(newautore, id);
        		JOptionPane.showMessageDialog(null,"Autore modificato!", "", JOptionPane.INFORMATION_MESSAGE);
        		iDati.dispose();
        		AggiungiDati.getN4().setText(null);
        	}
        }
        if (e.getActionCommand().equals("EditCasaEd"))
        {
        	String oldcasaeditrice = (String) AggiungiDati.getC5().getSelectedItem();
        	String newcasaeditrice = AggiungiDati.getN5().getText();
        	if(newcasaeditrice.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
        	int id = CasaEditrice.IdCasaEditrice(oldcasaeditrice);
        	int n = JOptionPane.showConfirmDialog(null, "Confermare la modifica?", "Conferma", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		CasaEditrice.ModificaCasaEditrice(newcasaeditrice, id);
        		JOptionPane.showMessageDialog(null,"Casa Editrice modificata!", "", JOptionPane.INFORMATION_MESSAGE);
        		iDati.dispose();
        		AggiungiDati.getN4().setText(null);
        	}
        }
        if (e.getActionCommand().equals("EditScaffale"))
        {
        	int oldscaffale = (int) AggiungiDati.getC6().getSelectedItem();
        	String quantitaTemp = AggiungiDati.getN6().getText();
			if(quantitaTemp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! QUANTITA: Campo vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int quantita;
			try
			{
				quantita = Integer.parseInt(quantitaTemp);
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Inserire un valore numerico!", "Errore!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int id = Scaffale.IdScaffale(oldscaffale);
        	int n = JOptionPane.showConfirmDialog(null, "Confermare la modifica?", "Conferma", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		Scaffale.ModificaScaffale(quantita, id);
        		JOptionPane.showMessageDialog(null,"Scaffale modificato!", "", JOptionPane.INFORMATION_MESSAGE);
        		iDati.dispose();
        		AggiungiDati.getN6().setText(null);
        	}
        }
        
    }
	public ScaffaliListener(InterfacciaScaffali iScaffali, AggiungiLibro iAggiungi, ModificaLibro iModifica, AggiungiDati iDati)
	{
		this.iScaffali = iScaffali;
		this.iAggiungi = iAggiungi;
		this.iModifica = iModifica;
		this.iDati = iDati;
	}
}