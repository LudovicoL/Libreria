package it.project.libreria.model;

import java.util.Date;

public final class Cliente extends Utente {

	public final String sesso_maschile="M";
	public final String sesso_femminile="F";
	
	private String sesso;
	private Date dataNascita;
	
	public Cliente(int iD, String nome, String cognome, String username,
			String password, String iD2, String sesso, Date dataNascita) {
		super(iD, nome, cognome, username, password);
		this.sesso = sesso;
		this.dataNascita = dataNascita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	

}
