package it.project.libreria.model;

public class GestoreScaffali extends Utente {

	private String CF;
	
	public GestoreScaffali(int iD, String nome, String cognome, String username,
			String password, String iD2) {
		super(iD, nome, cognome, username, password);
		this.CF = CF;
	}

	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
	}
	
}
