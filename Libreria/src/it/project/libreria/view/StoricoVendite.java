package it.project.libreria.view;

import it.project.libreria.model.Libro;
import it.project.libreria.model.Utente;
import it.project.libreria.model.Vendita;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class StoricoVendite extends JDialog
{
	JFrame parent;
	private JScrollPane s1;
	private JTable table;
	
	public StoricoVendite(JFrame parent, boolean bloccaParent)
	{
		super(parent, bloccaParent);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.parent = parent;
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		int i = 0;
		int idcliente = 0;
		int idlibro = 0;
		
		int numvendite = Vendita.NumeroVendite();
	    Object rowData[][] =new Object[numvendite][5];
	    for(i=0; i<numvendite; i++)
	    {
	    	idcliente = Vendita.ElencoVenditeIdUtente(i);
	    	idlibro = Vendita.ElencoVenditeIdLibro(i);
	    	rowData[i][0] = Utente.Username(idcliente);
	    	rowData[i][1] = Libro.TitoloLibro(idlibro);
	    	rowData[i][2] = Vendita.ElencoVenditeCosto(i);
	    	rowData[i][3] = Vendita.ElencoVenditeData(i);
	    	rowData[i][4] = Vendita.ElencoVenditeQuantita(i);
	    }
	    Object columnNames[] = { "Cliente", "Libro", "Costo", "Data", "Quantita" };
	    DefaultTableModel model = new DefaultTableModel(rowData, columnNames)
		{
	    	public boolean isCellEditable(int row, int column)
			{
	    		return false;
			}
		};
		   
	    JTable table = new JTable(model);
	    table.setRowSorter(new TableRowSorter(model));
	    JScrollPane scrollPane = new JScrollPane(table);
	    c.add(scrollPane, BorderLayout.CENTER);
		
		setSize(800, 500);
		setResizable(false);
	    setVisible(true);
	}
	
}
