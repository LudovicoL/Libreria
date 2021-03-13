package it.project.libreria.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import it.project.libreria.business.Sessione;
import it.project.libreria.model.Libro;
import it.project.libreria.model.Notifica;
import it.project.libreria.model.Vendita;
import it.project.libreria.view.InterfacciaCassa;
import it.project.libreria.view.PannelloLogin;
import it.project.libreria.view.StoricoVendite;

public class CassaListener implements ActionListener
{
	InterfacciaCassa iCassa;

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("VALIDA_ACQUISTO"))
		{
			
			int idNotifica = iCassa.getIdNotifica();
			int idLibro = iCassa.getIdLibro();
			String titolo = iCassa.getTitolo();
			int idUtente = iCassa.getIdUtente();
			String username = iCassa.getUsername();
			int quantitaLibri = iCassa.getQuantitaLibri();
			
			if(titolo==null)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Nessuna vendita selezionata!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			Notifica.ConfermaAcquisto(idNotifica);
			float costo = Libro.CostoLibri(idLibro);
			int costoTotale = (int)costo * quantitaLibri;
			
			GregorianCalendar gc = new GregorianCalendar();
			int mese=gc.get(gc.MONTH) + 1;
			int anno= gc.get(gc.YEAR);
			int giorno=gc.get(gc.DAY_OF_MONTH);
			int ore=gc.get(gc.HOUR);
			int minuti=gc.get(gc.MINUTE);
			
			String data = giorno+"/"+mese+"/"+anno+" "+ore+":"+minuti;
			
			int n = JOptionPane.showConfirmDialog(null, "Confermare vendita?", "Conferma", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{ 
        		Vendita.VenditaLibro(data, quantitaLibri, costoTotale, idUtente, idLibro);
        		iCassa.dispose();
        		new InterfacciaCassa();
        	}
			
		}
		if(e.getActionCommand().equals("ANNULLA_ACQUISTO"))
		{
			int idNotifica = iCassa.getIdNotifica();
			int idLibro = iCassa.getIdLibro();
			String titolo = iCassa.getTitolo();
			int idUtente = iCassa.getIdUtente();
			String username = iCassa.getUsername();
			int quantitaLibri = iCassa.getQuantitaLibri();
			
			if(titolo==null)
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Nessuna vendita selezionata!", "Errore!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			int n = JOptionPane.showConfirmDialog(null, "Annullare acquisto?", "Conferma", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		Notifica.ConfermaAcquisto(idNotifica);
        		iCassa.dispose();
    	        new InterfacciaCassa();
        	}
		}
		
		// JMenu
		
		if(e.getActionCommand().equals("STORICO_VENDITE"))
		{
			new StoricoVendite(iCassa, true);
		}
		if (e.getActionCommand().equals("ESCI"))
        {
        	int n = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler effettura il logout?", "Logout", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		iCassa.dispose();
        		Sessione.getInstance().svuotaSessione();
        		new PannelloLogin();
        	}
        }
	}
	
	public CassaListener(InterfacciaCassa iCassa)
	{
		this.iCassa = iCassa;
	}
}
