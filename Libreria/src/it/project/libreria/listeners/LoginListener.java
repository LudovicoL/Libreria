package it.project.libreria.listeners;

import it.project.libreria.business.Sessione;
import it.project.libreria.business.UtenteManager;
import it.project.libreria.model.Utente;
import it.project.libreria.view.InterfacciaSelect;
import it.project.libreria.view.PannelloLogin;
import it.project.libreria.view.Registrazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginListener implements ActionListener {

	PannelloLogin pLogin;
	
	@Override
	public void actionPerformed(ActionEvent e)
	{	
		if (e.getActionCommand().equals("LOGIN"))
		{
			String username = pLogin.getTxt_username().getText();
			char[] password = pLogin.getTxt_password().getPassword();
			String PSW1 = String.valueOf(password);
		
			if(username.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Inserire Username!", "Avviso!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(PSW1.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Inserire Password!", "Avviso!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int numeroUsername = Utente.contaUsername(username);
			if(numeroUsername!=0)
			{
				String PSW2 = Utente.passwordSalvata(username);
				boolean controlloPassword = false;
				if(PSW1.equals(PSW2))
					controlloPassword=true;
				if(controlloPassword==false)
				{
					JOptionPane.showMessageDialog(null,"Password errata! Se la si e' dimenticata, rivolgersi al personale.", "Errore!", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		
			Utente u = UtenteManager.getInstance().login(username, new String(password));
			if(u == null)
				JOptionPane.showMessageDialog(null,"Caro utente non esisti, registrati!");
			else
			{
				JOptionPane.showMessageDialog(null,"Bentornato! Il tuo ID e' "+u.getID());
				pLogin.dispose();
				Utente u1=(Utente)Sessione.getInstance().mappa.put("utente_corrente",u);
				InterfacciaSelect iSelect = new InterfacciaSelect();
			}
		}

		if (e.getActionCommand().equals("REGISTRA"))
		{
			new Registrazione(pLogin, true);
		}
		
	}
	
	public LoginListener(PannelloLogin pLogin)
	{
		this.pLogin = pLogin;
	}
	
}
