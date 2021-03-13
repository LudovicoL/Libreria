package it.project.libreria.listeners;

import it.project.libreria.view.InterfacciaCliente;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class TableListener implements FocusListener {
	InterfacciaCliente iCliente;
	@Override
	public void focusGained(FocusEvent arg0) {
		int indexRow = iCliente.getIndexRow();
		System.out.println(indexRow);

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		

	}
	public TableListener(InterfacciaCliente iCliente) {
		this.iCliente = iCliente;
	}

}
