package it.project.libreria.view;

import it.project.libreria.business.Sessione;
import it.project.libreria.model.Utente;

import javax.swing.JOptionPane;

public class InterfacciaSelect {
	
	public InterfacciaSelect(){
	
		Utente u1=(Utente)Sessione.getInstance().mappa.get("utente_corrente");
	{
		
		
		if(u1.getID()>2){
			InterfacciaCliente iCliente = new InterfacciaCliente();}
		else if(u1.getID()==1){
			InterfacciaScaffali iScaffale = new InterfacciaScaffali();}
		else if(u1.getID()==2){
			InterfacciaCassa iCassa = new InterfacciaCassa();}
		else
		{JOptionPane.showMessageDialog(null,"Caro utente non esisti, registrati!");}
	}
	}
}

