package it.project.libreria.view;

import it.project.libreria.listeners.ScaffaliListener;
import it.project.libreria.model.Libro;
import it.project.libreria.model.Notifica;
import it.project.libreria.model.Utente;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class InterfacciaScaffali extends JFrame
{
	
	private JButton btn_aggiungi;
	private JButton btn_modifica;
	private JButton btn_conferma;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JScrollPane s1;	
	private JScrollPane s2;
	private JTable table;
	private static String titolo;
	private static String autore;
	private static String genere;
	private static String casaEditrice;
	private static int annoPub;
	private static float costo;
	private static int quantitaLibri;
	private JMenuBar barra = new JMenuBar();
	private static int countagg=0;
	private static int countmod=0;
	private static int idNotifica;
	private static int idLibro;
	private static int idUtente;
	private static int quantita;
	
	
	public InterfacciaScaffali()
	{
	    super ("Catalogo Libri");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    creaMenu();
	    this.setJMenuBar(barra);
	    
	    Container c = getContentPane();
		c.setLayout(new GridLayout(2,1));
		s1=new JScrollPane();
		p1=new JPanel();
		p2=new JPanel();
		s2=new JScrollPane();
		p3=new JPanel();
		p4=new JPanel();
		btn_aggiungi=new JButton("Aggiungi Nuovo Libro");
		btn_aggiungi.setActionCommand("AGGIUNGILIBRO");
	    btn_aggiungi.addActionListener(new ScaffaliListener(this, null, null, null));
		btn_modifica=new JButton("Modifica Libro");
		btn_modifica.setActionCommand("MODIFICALIBRO");
	    btn_modifica.addActionListener(new ScaffaliListener(this, null, null, null));
		btn_conferma=new JButton ("Conferma ordine");
		btn_conferma.setActionCommand("CONFERMANOTIFICA");
		btn_conferma.addActionListener(new ScaffaliListener(this, null, null, null));
		
	    int numerolibri= Libro.NumeroLibri();
	    int i;
	    
	    Object rowData[][] =new Object[numerolibri][7];
	    for(i=0;i < numerolibri;i++)
	    {
	    		rowData[i][0] = Libro.ElencoLibriTitolo(i);
	    		rowData[i][1] = Libro.ElencoLibriAutore(i);
	    		rowData[i][2] = Libro.ElencoLibriGenere(i);
	    		rowData[i][3] = Libro.ElencoLibriCasaEditrice(i);
	    		rowData[i][4] = Libro.ElencoLibriAnnoPub(i);  
	    		rowData[i][5] = Libro.ElencoLibriCosto(i);    	
	    		rowData[i][6] = Libro.ElencoLibriQuantita(i); 
	    		
	    }
	    Object columnNames[] = { "Titolo", "Autore", "Genere Letterario","Casa Editrice","Anno Pubblicazione", "Costo","Quantita" };
	    DefaultTableModel model = new DefaultTableModel(rowData, columnNames)
		{
			   public boolean isCellEditable(int row, int column)
			   {return false;}
		};
		   
	    JTable table = new JTable(model);
	    table.setAutoCreateRowSorter(true);
	    int indexRow = table.getSelectedRow();
	    
	    int idutente = 0;
	    int idlibro = 0;
	    	    
	    int numnotp = Notifica.NumeroNotifichePrenotazione();
	    Object rowData2[][] =new Object[numnotp][6];
	    for (int j = 0; j < numnotp; j++)
	    {
	    	idutente = Notifica.IDUtentePrenotazione(j);
	    	idlibro = Notifica.IDLibroPrenotazione(j);
	    	rowData2[j][0] = Notifica.IDNotificaPrenotazione(j);
    		rowData2[j][1] = idutente;
    		rowData2[j][2] = Utente.Username(idutente);
    		rowData2[j][3] = idlibro;
    		rowData2[j][4] = Libro.TitoloLibro(idlibro);
    		rowData2[j][5] = Notifica.QuantitaNotifichePrenotazione(j);
    		
	    }
	    Object columnNames2[] = { "ID Notifica","ID Utente", "Utente,","ID Libro", "Libro","Quantita" };
	    
	    DefaultTableModel model2 = new DefaultTableModel(rowData2, columnNames2)
		{
			   public boolean isCellEditable(int row, int column)
			   {return false;}
		};
	    
	    JTable table2 = new JTable(model2);
	    table2.setAutoCreateRowSorter(true);
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    JScrollPane scrollPane2 = new JScrollPane(table2);
	    c.add(p1);
	    p1.setLayout(new BorderLayout());
	    p1.add(scrollPane, BorderLayout.CENTER);
	    c.add(p2);
	    p2.setLayout(new BorderLayout());
	    p2.add(p3, BorderLayout.NORTH);
	    btn_aggiungi.setPreferredSize(new Dimension(200, 30));
	    btn_modifica.setPreferredSize(new Dimension(200, 30));
	    p3.add(btn_aggiungi);
	    p3.add(btn_modifica);
	    
	    p2.add(scrollPane2, BorderLayout.CENTER);
	    p2.add(p4, BorderLayout.SOUTH);
	    btn_conferma.setPreferredSize(new Dimension(200, 30));
	    p4.add(btn_conferma);
	        
	    setSize(1200, 500);
	    setVisible(true);
	    scrollPane.getVerticalScrollBar();
	    scrollPane2.getVerticalScrollBar();
	    
	    table.getSelectionModel().addListSelectionListener(new ListSelectionListener()
	    {
	        public void valueChanged(ListSelectionEvent event)
	        {
	        	if(event.getValueIsAdjusting() == false)
	        	{
	        		String titolo = (table.getValueAt(table.getSelectedRow(), 0).toString());
	        	    String autore = (table.getValueAt(table.getSelectedRow(), 1).toString());
	        	    String genere = (table.getValueAt(table.getSelectedRow(), 2).toString());
	        	    String casaEditrice = (table.getValueAt(table.getSelectedRow(), 3).toString());
	        	    int annoPub = (int) (table.getValueAt(table.getSelectedRow(), 4));
	        	    float costo = (float) (table.getValueAt(table.getSelectedRow(), 5));
	        	    int quantitaLibri = (int) (table.getValueAt(table.getSelectedRow(), 6));
	        	    
	        		setTitolo(titolo);
	        		setAutore(autore);
	        		setGenereLetterario(genere);
	        		setCasaEditrice(casaEditrice);
	        		setAnnoPub(annoPub);
	        		setCosto(costo);
	        		setQuantitaLibri(quantitaLibri);
	        	}
	        }
	    });
	    
	    table2.getSelectionModel().addListSelectionListener(new ListSelectionListener()
	    {
	        public void valueChanged(ListSelectionEvent event)
	        {
	        	if(event.getValueIsAdjusting() == false)
	        	{
	        		int idNotifica = (int) (table2.getValueAt(table2.getSelectedRow(), 0));
	        		int idUtente = (int) (table2.getValueAt(table2.getSelectedRow(), 1));
	        		int idLibro = (int) (table2.getValueAt(table2.getSelectedRow(), 3));
	        		int quantita = (int) (table2.getValueAt(table2.getSelectedRow(), 5));
	        		   
	        		setIdNotifica(idNotifica);
	        		setIdUtente(idUtente);
	        		setIdLibro(idLibro);
	        		setQuantita(quantita);
	        	}
	        }
	    }); 
	}
	public JMenuBar creaMenu()
	{
		JMenu menu, submenu1, submenu2;
		JMenuItem voce;
		
		menu = new JMenu("Dati");
		menu.setMnemonic(KeyEvent.VK_D);
		barra.add(menu);
		submenu1 = new JMenu("Aggiungi");
		submenu1.setMnemonic(KeyEvent.VK_A);
		submenu2 = new JMenu("Modifica");
		submenu2.setMnemonic(KeyEvent.VK_M);
		
		menu.add(submenu1);
		menu.add(submenu2);
		
		voce = new JMenuItem("Autore");
		voce.addActionListener(new ScaffaliListener(this, null, null, null));
		voce.setActionCommand("AGGIUNGI_AUTORE");
		submenu1.add(voce);
		voce = new JMenuItem("Casa Editrice");
		voce.addActionListener(new ScaffaliListener(this, null, null, null));
		voce.setActionCommand("AGGIUNGI_CASAEDITRICE");
		submenu1.add(voce);
		voce = new JMenuItem("Scaffale");
		voce.addActionListener(new ScaffaliListener(this, null, null, null));
		voce.setActionCommand("AGGIUNGI_SCAFFALE");
		submenu1.add(voce);
		voce = new JMenuItem("Autore");
		voce.addActionListener(new ScaffaliListener(this, null, null, null));
		voce.setActionCommand("MODIFICA_AUTORE");
		submenu2.add(voce);
		voce = new JMenuItem("Casa Editrice");
		voce.addActionListener(new ScaffaliListener(this, null, null, null));
		voce.setActionCommand("MODIFICA_CASAEDITRICE");
		submenu2.add(voce);
		voce = new JMenuItem("Scaffale");
		voce.addActionListener(new ScaffaliListener(this, null, null, null));
		voce.setActionCommand("MODIFICA_SCAFFALE");
		submenu2.add(voce);
		
		menu = new JMenu("Logout");
		menu.setMnemonic(KeyEvent.VK_L);
		barra.add(menu);
		
		voce = new JMenuItem("Esci", KeyEvent.VK_E);
		voce.addActionListener(new ScaffaliListener(this, null, null, null));
		voce.setActionCommand("ESCI");
		menu.add(voce);
		
		return barra;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public static String getTitolo() {
		return titolo;
	}
	public static void setTitolo(String titolo1) {
		titolo = titolo1;
	}
	public static String getAutore() {
		return autore;
	}
	public static void setAutore(String autore1) {
		autore = autore1;
	}
	public static String getGenereLetterario() {
		return genere;
	}
	public static void setGenereLetterario(String genere1) {
		genere = genere1;
	}
	public static String getCasaEditrice() {
		return casaEditrice;
	}
	public static void setCasaEditrice(String casaEditrice1) {
		casaEditrice = casaEditrice1;
	}
	public static int getAnnoPub() {
		return annoPub;
	}
	public static void setAnnoPub(int annoPub1) {
		annoPub = annoPub1;
	}
	public static float getCosto() {
		return costo;
	}
	public static void setCosto(float costo1) {
		costo = costo1;
	}
	public static int getQuantitaLibri() {
		return quantitaLibri;
	}
	public void setQuantitaLibri(int quantitaLibri1) {
		this.quantitaLibri = quantitaLibri1;
	}
	public int getCountagg() {
		return countagg;
	}
	public static void setCountagg(int countagg) {
		InterfacciaScaffali.countagg = countagg;
	}
	public static int getCountmod() {
		return countmod;
	}
	public static void setCountmod(int countmod) {
		InterfacciaScaffali.countmod = countmod;
	}
	public static int getIdNotifica() {
		return idNotifica;
	}
	public static void setIdNotifica(int idNotifica) {
		InterfacciaScaffali.idNotifica = idNotifica;
	}
	public static int getIdLibro() {
		return idLibro;
	}
	public static void setIdLibro(int idLibro) {
		InterfacciaScaffali.idLibro = idLibro;
	}
	public static int getIdUtente() {
		return idUtente;
	}
	public static void setIdUtente(int idUtente) {
		InterfacciaScaffali.idUtente = idUtente;
	}
	public static int getQuantita() {
		return quantita;
	}
	public static void setQuantita(int quantita) {
		InterfacciaScaffali.quantita = quantita;
	}
	
	
}