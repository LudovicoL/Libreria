package it.project.libreria.listeners;

import it.project.libreria.business.LibroManager;
import it.project.libreria.business.Sessione;
import it.project.libreria.model.Libro;
import it.project.libreria.model.Notifica;
import it.project.libreria.model.Utente;
import it.project.libreria.view.InterfacciaCliente;
import it.project.libreria.view.PannelloLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteListener implements ActionListener
{
	static DefaultTableModel model;
	static DefaultTableModel model2;
	static int CounterLibri = 0;
	static Object rowData2[][];
	static int flag;
	boolean cancellaultimo;
	
	InterfacciaCliente iCliente;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("AGGIUNGI"))
		{
			int IDl = iCliente.getID();
			String Titolol = InterfacciaCliente.getTitolo();
			String Autorel = iCliente.getAutore();
			float Costol = iCliente.getCosto();
			int QuantitaLibril = iCliente.getQuantitaLibri();
			int qta = 1;
		    int CounterLibril = getCounterLibri();
		    int j =0;
		    int i = 0;
		    Object columnNames2[] = { "Titolo", "Autore","Costo","quantita" };
		    int numeroLibril = iCliente.getNumeroLibri();
		    Object rowData2[][] = new Object[numeroLibril][5];
		    char tipo = 'a';
		    int qtap = InterfacciaCliente.getQtap();
		    
		    if(Titolol.equals(null))
		    {
		    	return;
		    }
		    
		    if(CounterLibril!=0)
		    {
		    	rowData2 = getRowData2();
		    	for(i=0; i<numeroLibril;i++)
		    	{
		    		if(rowData2[i][0]==Titolol)
		    		{
		    			int val = (int) rowData2[i][3];
		    			if(val<QuantitaLibril)
		    			{
		    				val = val+1;
		    				rowData2[i][3]= val;
		    				j = i;
		    				break;
		    			}
		    			else
		    			{
		    				tipo = 'p';
		    				InterfacciaCliente.setTipo(tipo);
		    				j=i;
		    				qtap = qtap +1;
		    				InterfacciaCliente.setQtap(qtap);
		    				System.out.println(qtap);
		    				val = val+1;
		    				rowData2[i][3]= val;
		    			}
		    		}
		    	}
		    	if(rowData2[j][0]!= Titolol)
		    	{
		    		rowData2[CounterLibril][0]=Titolol;
				    rowData2[CounterLibril][1]=Autorel;
				    rowData2[CounterLibril][2]=Costol;
				    rowData2[CounterLibril][3]=qta;
				    rowData2[CounterLibril][4]=IDl;
				    setCounterLibri(CounterLibri+1);
		    	}
		    }
		    else
		    {
		    	rowData2[CounterLibril][0]=Titolol;
		    	rowData2[CounterLibril][1]=Autorel;
		    	rowData2[CounterLibril][2]=Costol;
		    	rowData2[CounterLibril][3]=qta;
		    	rowData2[CounterLibril][4]=IDl;
			    setCounterLibri(CounterLibri+1);
		    }
		    DefaultTableModel modell=getModel();
		    modell = LibroManager.setModelloTab(rowData2, columnNames2);
		    InterfacciaCliente.getTable2().setModel(modell);
		    setModel(modell);
		    setRowData2(rowData2);
		}
		if (e.getActionCommand().equals("CONFERMA"))
		{
			Utente u1=(Utente)Sessione.getInstance().mappa.get("utente_corrente");
			boolean ok1 = true;
			boolean ok2 = true;
			boolean ok12 = true;
			int IDl = 0;
			int IDu = u1.getID();
			int qta = 0;
			int numeroLibril = iCliente.getNumeroLibri();
			Object rowData2[][] = new Object[numeroLibril][5];
			rowData2 = getRowData2();
			for(int i=0; i<numeroLibril;i++)
			{
				if (rowData2[i][0] == null)
				{
					continue;
				}
				else
				{
					IDl = (int) rowData2[i][4];
					qta = (int) rowData2[i][3];
					int qtap = InterfacciaCliente.getQtap();
					qta = qta - qtap;
					ok1 = Notifica.AcquistoCliente(IDl,IDu,qta,'a');
					int diff = iCliente.getQuantitaLibri();
	    			int tot = diff - qta;
					ok12 = Libro.ModificaQuantita(tot,IDl);
					
					if (qtap == 0)
					{
						continue;
					}
					else
					{
					ok2 = Notifica.AcquistoCliente(IDl,IDu,qtap,'p');
					}
				}
				
			}
			if(ok1==true || ok2==true)
			{
				JOptionPane.showMessageDialog(null,"Ordine effettuato!");
				for(int i=0; i<numeroLibril;i++)
			    {
			    	rowData2[i][0]=null;
	    			rowData2[i][1]=null;
	    			rowData2[i][2]=null;
	    			rowData2[i][3]=null;
	    			setCounterLibri(0);
	    			iCliente.dispose();
	    			new InterfacciaCliente();
	    			
			    }
			}
			else
			{
				JOptionPane.showMessageDialog(null,"ATTENZIONE! Ordine fallito!");
		    }
		}
		if (e.getActionCommand().equals("RIMUOVI"))
		{
			
			String Titolol2 = iCliente.getTitolo2();
			String Autorel2 = iCliente.getAutore2();
			float Costol2 = iCliente.getCosto2();
			int QuantitaLibril2 = iCliente.getQuantitaLibri2();
		    int flag = iCliente.getFlag();
		    int spflag = iCliente.getSpflag();
			int qta = 1;
		    int j =0;
		    
		    Object columnNames2[] = { "Titolo", "Autore","Costo","Quantita" };
		    int numeroLibril = iCliente.getNumeroLibri();
		    Object rowData2[][] = new Object[200][4];
		    
		    
		    rowData2 = getRowData2();
		    
		    for(int i=0; i<numeroLibril;i++)
		    {
		    	rowData2[i][0]=null;
    			rowData2[i][1]=null;
    			rowData2[i][2]=null;
    			rowData2[i][3]=null;
    			setCounterLibri(0);
		    }
		    
            DefaultTableModel model2 = getModel2();
		    model2 = LibroManager.setModelloTab(rowData2, columnNames2);
		    InterfacciaCliente.getTable2().setModel(model2);
		    setModel(model2);
		    setRowData2(rowData2);
		}
		
		if (e.getActionCommand().equals("ESCI"))
        {
        	int n = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler effettura il logout?", "Logout", JOptionPane.YES_NO_OPTION);
        	if(n==JOptionPane.YES_OPTION)
        	{
        		iCliente.dispose();
        		Sessione.getInstance().svuotaSessione();
        		new PannelloLogin();
        	}
        }
		
	}
	

	private void setCancellaultimo(boolean cancellaultimo) {
		this.cancellaultimo = cancellaultimo;
	}
	public boolean getCancellaultimo() {
		return cancellaultimo;
	}

	public Object[][] getRowData2() {
		return rowData2;
	}

	public  void setRowData2(Object[][] rowData2) {
		ClienteListener.rowData2 = rowData2;
	}

	public void setModel(DefaultTableModel model)
	{
		ClienteListener.model=model;
	}
	public void setModel2(DefaultTableModel model2)
	{
		ClienteListener.model2=model2;
	}
	
	public static DefaultTableModel getModel()
	{
		return model;
	}
	
	public static DefaultTableModel getModel2()
	{
		return model2;
	}
	
	public int getCounterLibri()
	{
		return CounterLibri;
	}

	public static void setCounterLibri(int counterLibri)
	{
		CounterLibri = counterLibri;
	}

	public ClienteListener(InterfacciaCliente iCliente)
	{
		this.iCliente = iCliente;
	}
}