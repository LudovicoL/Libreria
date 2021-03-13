package it.project.libreria.listeners;

import it.project.libreria.model.Utente;
import it.project.libreria.view.Registrazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class RegistrazioneListener implements ActionListener
{

	Registrazione iRegistrazione;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String nome1 = Registrazione.getNome().getText();
		String cognome1 = Registrazione.getCognome().getText();
		String user = Registrazione.getUser().getText();
		char[] psw1 = Registrazione.getPassword1().getPassword();
		char[] psw2 = Registrazione.getPassword2().getPassword();
		
		String nome = nome1.toUpperCase();
		String cognome = cognome1.toUpperCase();
				

		String PSW1 = String.valueOf(psw1);
		boolean compare = false;
		
		if(nome.equals(""))
		{
			JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo NOME vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(cognome.equals(""))
		{
			JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo COGNOME vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(user.equals(""))
		{
			JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo USERNAME vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(PSW1.equals(""))
		{
			JOptionPane.showMessageDialog(null,"ATTENZIONE! Campo PASSWORD vuoto!", "Errore!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
				
		if(Arrays.equals(psw1, psw2))
			compare = true;
		if(compare==false)
		{
			JOptionPane.showMessageDialog(null,"ERRORE! Password errata!", "Errore!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int numeroUsername = Utente.contaUsername(user);
		if(numeroUsername!=0)
		{
			JOptionPane.showMessageDialog(null,"ATTENZIONE! Username non disponibile!", "Errore!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		boolean controlloreg = false;
		controlloreg = Utente.registrazione(nome, cognome, user, PSW1);
		int idutente = Utente.IdUtente(user, PSW1);
		Utente.RegistrazioneCliente(idutente);
		if(controlloreg==false)
			return;
		
		
		JOptionPane.showMessageDialog(null,"Registrazione completata!", "", JOptionPane.PLAIN_MESSAGE);
		iRegistrazione.dispose();
	}
	public RegistrazioneListener(Registrazione iRegistrazione)
	{
		this.iRegistrazione = iRegistrazione;
	}
	
}
