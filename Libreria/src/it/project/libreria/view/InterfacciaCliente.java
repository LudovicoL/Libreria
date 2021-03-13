package it.project.libreria.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import javax.swing.table.TableModel;


import it.project.libreria.business.LibroManager;

import it.project.libreria.listeners.ClienteListener;
import it.project.libreria.model.Libro;


public class InterfacciaCliente extends JFrame
{
	private JMenuBar barra = new JMenuBar();
	private JButton btn_acquista;
	private JButton btn_conferma;
	private JButton btn_rimuovi;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JScrollPane s1;
	private JScrollPane s2;
	private JTable table;
	private static JTable table2;
	private int indexRow;
	public static TableModel model2;
	private static int ID;
	private static String Titolo;
	private String Titolo2;
	private static String Autore;
	private String Autore2;
	private static float Costo;
	private float Costo2;
	private int quantitaLibri;
	private int quantitaLibri2;
	private int numeroLibri;
	public static int flag;
	public static int spflag;
	private static char tipo = 'a';
	private static int qtap;
	
	
	public InterfacciaCliente()
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
		btn_acquista=new JButton("Aggiungi Libro");
		btn_acquista.setActionCommand("AGGIUNGI");
		btn_acquista.addActionListener(new ClienteListener(this));
		btn_conferma=new JButton ("Conferma acquisto");
		btn_conferma.setActionCommand("CONFERMA");
		btn_conferma.addActionListener(new ClienteListener(this));
		btn_rimuovi=new JButton("Azzera");
		btn_rimuovi.setActionCommand("RIMUOVI");
		btn_rimuovi.addActionListener(new ClienteListener(this));
	    
		int flag = 0;
		setFlag(flag);
		int spflag=0;
		setSpflag(spflag);
		
		int CounterLibri = 0;
		ClienteListener.setCounterLibri(CounterLibri);
		
	    int numerolibri= Libro.NumeroLibri();
	    setNumeroLibri(numerolibri);
	    int i;
	    
	    Object rowData[][] =new Object[numerolibri][8];
	    for(i=0;i < numerolibri;i++)
	    {
	    		rowData[i][0] = Libro.ElencoLibriTitolo(i);
	    		rowData[i][1] = Libro.ElencoLibriAutore(i);
	    		rowData[i][2] = Libro.ElencoLibriGenere(i);
	    		rowData[i][3] = Libro.ElencoLibriCasaEditrice(i);
	    		rowData[i][4] = Libro.ElencoLibriAnnoPub(i);  
	    		rowData[i][5] = Libro.ElencoLibriCosto(i);    	
	    		rowData[i][6] = Libro.ElencoLibriQuantita(i); 
	    		rowData[i][7] = Libro.ElencoLibriID(i);
	    }
	    Object columnNames[] = { "Titolo", "Autore", "Genere Letterario","Casa Editrice","Anno Pubblicazione", "Costo","Quantita", "ID" };
	    new LibroManager();
		DefaultTableModel model = LibroManager.setModelloTab(rowData, columnNames);
	    JTable table = new JTable(model);
	    table.setAutoCreateRowSorter(true);
	  
	    Object columnNames2[] = { "Titolo", "Autore","Costo","quantita" };
	    Object rowData2[][] = new Object[numerolibri][3];
	    DefaultTableModel model2 = LibroManager.setModelloTab(rowData2, columnNames2);
	    JTable table2 = new JTable(model2);
	    setTable2(table2);

	    JScrollPane scrollPane = new JScrollPane(table);
	    JScrollPane scrollPane2 = new JScrollPane(table2);
	    c.add(p1);
	    p1.setLayout(new BorderLayout());
	    p1.add(scrollPane, BorderLayout.CENTER);
	    c.add(p2);
	    p2.setLayout(new BorderLayout());
	    p2.add(p3, BorderLayout.NORTH);
	    btn_acquista.setPreferredSize(new Dimension(150, 30));
	    p3.add(btn_acquista);
	    p2.add(scrollPane2, BorderLayout.CENTER);
	    p2.add(p4, BorderLayout.SOUTH);
	    btn_conferma.setPreferredSize(new Dimension(170, 30));
	    p4.add(btn_conferma);
	    btn_rimuovi.setPreferredSize(new Dimension(170, 30));
        p4.add(btn_rimuovi);
	        
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
	        		String Titolo = (table.getValueAt(table.getSelectedRow(), 0).toString());
	        	    String Autore = (table.getValueAt(table.getSelectedRow(), 1).toString());
	        	    float Costo = (float) (table.getValueAt(table.getSelectedRow(), 5));
	        	    int quantitaLibri = (int) (table.getValueAt(table.getSelectedRow(), 6));
	        	    int ID = (int) (table.getValueAt(table.getSelectedRow(), 7));
	        	    
	        		setTitolo(Titolo);
	        		setAutore(Autore);
	        		setCosto(Costo);
	        		setQuantitaLibri(quantitaLibri);
	        		setID(ID);
	        	}
	        }
	    });
	    
	    table2.getSelectionModel().addListSelectionListener(new ListSelectionListener()
	    {
	        public void valueChanged(ListSelectionEvent event)
	        {
	        	if(event.getValueIsAdjusting() == false)
	        	{ 
	        		int f = getFlag();
	        		if(f == 1)
	        		{
	        			int spf = getSpflag();
	        			if (spf == 1)
	        			{
	        				return;
	        			}
	        			else
	        			{
	        				int index1 = 0;         
	        				int index0 = 0;         
	        				table2.getSelectionModel().setSelectionInterval(index0, index1);
	        				f=0;
	        				setFlag(f);
	        			}
	        		}
	        		if(table2.getValueAt(table2.getSelectedRow(), 0).toString() == null)
	        		{
	        			return;
	        		}
	        		else
	        		{
	        			String Titolo2 = (table2.getValueAt(table2.getSelectedRow(), 0).toString());
	        			String Autore2 = (table2.getValueAt(table2.getSelectedRow(), 1).toString());
	        			float Costo2 = (float) (table2.getValueAt(table2.getSelectedRow(), 2));
	        			int quantitaLibri2 = (int) (table2.getValueAt(table2.getSelectedRow(), 3));

	        			setTitolo2(Titolo2);
	        			setAutore2(Autore2);
	        			setCosto2(Costo2);
	        			setQuantitaLibri2(quantitaLibri2);
	        		}
	        	}	        		
	        }
	    }); 
	}
	public JMenuBar creaMenu()
	{
		JMenu menu;
		JMenuItem voce;
		
		menu = new JMenu("Logout");
		menu.setMnemonic(KeyEvent.VK_L);
		barra.add(menu);
		
		voce = new JMenuItem("Esci", KeyEvent.VK_E);
		voce.addActionListener(new ClienteListener(this));
		voce.setActionCommand("ESCI");
		menu.add(voce);
		
		return barra;
	}
	
	public static JTable getTable2() {
		return table2;
	}
	
	public static void setTable2(JTable table2) {
		InterfacciaCliente.table2 = table2;
	}
	
	public void setNumeroLibri(int numeroLibri){
		this.numeroLibri=numeroLibri;
	}
	
	public int getNumeroLibri(){
		return numeroLibri;
	}
	
	public void setModel2(TableModel model2) {
		this.model2 = model2;
	}
	
	public static Object getmodel2() {
		return model2;
	}
	
	public void setTitolo(String Titolo) {
		this.Titolo = Titolo;
	}
	
	public static String getTitolo() {
		return Titolo;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public static int getID() {
		return ID;
	}
	
	public void setAutore(String Autore) {
		this.Autore = Autore;
	}
	
	public static String getAutore() {
		return Autore;
	}

	public void setCosto(float Costo) {
		this.Costo = Costo;
	}
	
	public static float getCosto() {
		return Costo;
	}

	public int getIndexRow() {
		return indexRow;
	}


	public void setIndexRow(int indexRow) {
		this.indexRow = indexRow;
	}

	public int getQuantitaLibri() {
		return quantitaLibri;
	}

	public void setQuantitaLibri(int quantitaLibri) {
		this.quantitaLibri = quantitaLibri;
	}

	public String getTitolo2() {
		return Titolo2;
	}

	public void setTitolo2(String Titolo2) {
		this.Titolo2 = Titolo2;
	}

	public String getAutore2() {
		return Autore2;
	}

	public void setAutore2(String Autore2) {
		this.Autore2 = Autore2;
	}

	public float getCosto2() {
		return Costo2;
	}

	public void setCosto2(float Costo2) {
		this.Costo2 = Costo2;
	}

	public int getQuantitaLibri2() {
		return quantitaLibri2;
	}

	public void setQuantitaLibri2(int quantitaLibri2) {
		this.quantitaLibri2 = quantitaLibri2;
	}

	public static int getFlag() {
		return flag;
	}

	public static void setFlag(int flag) {
		InterfacciaCliente.flag = flag;
	}
	public static int getSpflag() {
		return spflag;
	}

	public static void setSpflag(int spflag) {
		InterfacciaCliente.spflag = spflag;
	}

	public static char getTipo() {
		return tipo;
	}

	public static void setTipo(char tipo) {
		InterfacciaCliente.tipo = tipo;
	}

	public static int getQtap() {
		return qtap;
	}

	public static void setQtap(int qtap) {
		InterfacciaCliente.qtap = qtap;
	}

}