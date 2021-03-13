package it.project.libreria.business;

import it.project.libreria.business.UtenteManager;
import it.project.libreria.model.Utente;

public class UtenteManager {

	private static UtenteManager instance;
	
	public static UtenteManager getInstance() {
		if(instance==null)
			instance = new UtenteManager();
		return instance;
	}
	
	public Utente login(String username, String password) {
		Utente u=new Utente();
		u.setUsername(username);
		u.setPassword(password);
		if(u.login()) return u;
		else return null;
		
	}
}
