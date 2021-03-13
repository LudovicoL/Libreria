package it.project.libreria.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import it.project.libreria.listeners.CassaListener;
import it.project.libreria.model.Libro;
import it.project.libreria.model.Notifica;
import it.project.libreria.model.Utente;


public class InterfacciaCassa extends JFrame
{
	private JMenuBar barra = new JMenuBar();
	private JButton btn_conferma;
	private JButton btn_rimuovi;
	private JPanel p1;
	private JPanel p2;
	private JScrollPane s1;
	private static int idNotifica;
	private static int idLibro;
	private static String titolo;
	private static int idUtente;
	private static String username;
	private static int quantitaLibri;
	
	
	public InterfacciaCassa()
	{
	    super ("CATALOGO CASSA");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    creaMenu();
	    this.setJMenuBar(barra);
	    
	    Container c = getContentPane();
		c.setLayout(new BorderLayout());
		s1=new JScrollPane();
		p1=new JPanel();
		p2=new JPanel();
		btn_conferma=new JButton ("Conferma acquisto");
		btn_conferma.setPreferredSize(new Dimension(150, 30));
	    btn_conferma.setActionCommand("VALIDA_ACQUISTO");
	    btn_conferma.addActionListener(new CassaListener(this));
		btn_rimuovi=new JButton("Rimuovi Libro");
		btn_rimuovi.setPreferredSize(new Dimension(150, 30));
	    btn_rimuovi.setActionCommand("ANNULLA_ACQUISTO");
	    btn_rimuovi.addActionListener(new CassaListener(this));
	    
	    //int numerolibri= Libro.NumeroLibri();
	    int i;
	    int idUtente, idLibro;
	    
	    int numnota = Notifica.NumeroNotificheAcquisto();
	    Object rowData[][] =new Object[numnota][6];
	    for(i=0;i < numnota;i++)
	    {
	    		idUtente = Notifica.IDUtenteAcquisto(i);
	    		idLibro = Notifica.IDLibroAcquisto(i);
	    		
	    		rowData[i][0] = Notifica.IDNotificaAcquisto(i);
	    		rowData[i][1] = idLibro;
	    		rowData[i][2] = Libro.TitoloLibro(idLibro);
	    		rowData[i][3] = idUtente;
	    		rowData[i][4] = Utente.Username(idUtente);
	    		rowData[i][5] = Notifica.QuantitaNotificheAcquisto(i); 
	    		
	    }
	    Object columnNames[] = { "ID notifica","ID Libro", "Titolo Libro","ID Utente", "Username","Quantita" };
	    DefaultTableModel model = new DefaultTableModel(rowData, columnNames)
		{
	    	public boolean isCellEditable(int row, int column)
			{
	    		return false;
			}
		};
		   
	    JTable table = new JTable(model);
	    table.setAutoCreateRowSorter(true);
	    
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    c.add(p1);
	    p1.setLayout(new BorderLayout());
	    p1.add(scrollPane, BorderLayout.CENTER);
	    c.add(p2, BorderLayout.SOUTH);
	    p2.add(btn_conferma);
	    btn_conferma.setPreferredSize(new Dimension(170, 30));
        p2.add(btn_rimuovi);
        btn_rimuovi.setPreferredSize(new Dimension(170, 30));
	        
	    setSize(1200, 500);
	    setVisible(true);
	    scrollPane.getVerticalScrollBar();
	    
	    table.getSelectionModel().addListSelectionListener(new ListSelectionListener()
	    {
	        public void valueChanged(ListSelectionEvent event)
	        {
	        	if(event.getValueIsAdjusting() == false)
	        	{
	        		int idNotifica = (int) (table.getValueAt(table.getSelectedRow(), 0));
	        		int idLibro = (int) (table.getValueAt(table.getSelectedRow(), 1));
	        	    String titolo = (table.getValueAt(table.getSelectedRow(), 2).toString());
	        	    int idUtente = (int) (table.getValueAt(table.getSelectedRow(), 3));
	        	    String username = (table.getValueAt(table.getSelectedRow(), 4).toString());
	        	    int quantitaLibri = (int) (table.getValueAt(table.getSelectedRow(), 5));
	        	    
	        	    setIdNotifica(idNotifica);
	        	    setIdLibro(idLibro);
	        	    setTitolo(titolo);
	        	    setIdUtente(idUtente);
	        	    setUsername(username);
	        	    setQuantitaLibri(quantitaLibri);
	        		
	        	}
	        }
	    });
	    
	    
	}
	public JMenuBar creaMenu()
	{
		JMenu menu;
		JMenuItem voce;
		
		menu = new JMenu("Storico");
		menu.setMnemonic(KeyEvent.VK_S);
		barra.add(menu);
		voce = new JMenuItem("Storico Vendite");
		voce.addActionListener(new CassaListener(this));
		voce.setActionCommand("STORICO_VENDITE");
		menu.add(voce);
		
		menu = new JMenu("Logout");
		menu.setMnemonic(KeyEvent.VK_L);
		barra.add(menu);
		
		voce = new JMenuItem("Esci", KeyEvent.VK_E);
		voce.addActionListener(new CassaListener(this));
		voce.setActionCommand("ESCI");
		menu.add(voce);
		
		return barra;
	}
	public static int getIdNotifica() {
		return idNotifica;
	}
	public static void setIdNotifica(int idNotifica) {
		InterfacciaCassa.idNotifica = idNotifica;
	}
	public static String getTitolo() {
		return titolo;
	}
	public static void setTitolo(String titolo) {
		InterfacciaCassa.titolo = titolo;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		InterfacciaCassa.username = username;
	}
	public static int getQuantitaLibri() {
		return quantitaLibri;
	}
	public static void setQuantitaLibri(int quantitaLibri) {
		InterfacciaCassa.quantitaLibri = quantitaLibri;
	}
	public static int getIdLibro() {
		return idLibro;
	}
	public static void setIdLibro(int idLibro) {
		InterfacciaCassa.idLibro = idLibro;
	}
	public static int getIdUtente() {
		return idUtente;
	}
	public static void setIdUtente(int idUtente) {
		InterfacciaCassa.idUtente = idUtente;
	}

}