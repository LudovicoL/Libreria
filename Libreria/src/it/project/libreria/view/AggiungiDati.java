package it.project.libreria.view;

import it.project.libreria.listeners.ScaffaliListener;
import it.project.libreria.model.Autore;
import it.project.libreria.model.CasaEditrice;
import it.project.libreria.model.Scaffale;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AggiungiDati extends JDialog
{
	JFrame parent;
	private JPanel p1;		// aggiungi autore
	private JPanel p2;		// aggiungi casa editrice
	private JPanel p3;		// aggiungi scaffale
	private JPanel p4;		// modifica autore
	private JPanel p5;		// modifica casa editrice
	private JPanel p6;		// modifica scaffale
	
	private static JTextField n1 = new JTextField (20);		// p1: Aggiungi Autore
	private static JTextField n2 = new JTextField (20);		// p2: Aggiungi Casa Editrice
	private static JTextField n31 = new JTextField (20);	// p3: Aggiungi Scaffale - Posizione
	private static JTextField n32 = new JTextField (20);	// p3: Aggiungi Scaffale - Quantita
	private static JTextField n4 = new JTextField (20);		// p4: Modifica Autore
	private static JTextField n5 = new JTextField (20);		// p5: Modifica Casa Editrice
	private static JTextField n6 = new JTextField (20); 	// p6: Modifica Scaffale
	
	private static JComboBox c4 = new JComboBox();	// p4: Modifica Autore
	private static JComboBox c5 = new JComboBox();	// p5: Modifica Casa Editrice
	private static JComboBox c6 = new JComboBox();	// p6: Modifica Scaffale
	
	private JButton b1;		// p1: Aggiungi Autore
	private JButton b2;		// p2: Aggiungi Casa Editrice
	private JButton b3;		// p3: Aggiungi Scaffale
	private JButton b4;		// p4: Modifica Autore
	private JButton b5;		// p5: Modifica Casa Editrice
	private JButton b6;		// p6: Modifica Scaffale
	
	public int finestra;
	
	public AggiungiDati(JFrame parent, boolean bloccaParent, int finestra, int autoriMax, int casaEdMax, int scaffaliMax)
	{
		super(parent, bloccaParent);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.parent = parent;
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		p1= new JPanel();
		p2= new JPanel();
		p3= new JPanel();
		p4= new JPanel();
		p5= new JPanel();
		p6= new JPanel();
		
		// Pannello Aggiungi Autore (p1)
		p1.setLayout(new GridLayout(3,1));
		p1.add(new JLabel("Aggiungi nuovo Autore:", SwingConstants.CENTER));
		p1.add(n1);
		b1=new JButton ("Aggiungi");
		b1.setActionCommand("AddAutore");
		b1.addActionListener(new ScaffaliListener(null, null, null, this));
		p1.add(b1);
		
		
		// Pannello Aggiungi Casa Editrice (p2)
		p2.setLayout(new GridLayout(3,1));
		p2.add(new JLabel("Aggiungi nuova Casa Editrice:", SwingConstants.CENTER));
		p2.add(n2);
		b2=new JButton ("Aggiungi");
		b2.setActionCommand("AddCasaEd");
		b2.addActionListener(new ScaffaliListener(null, null, null, this));
		p2.add(b2);
		
		// Pannello Aggiungi Scaffale (p3)
		p3.setLayout(new GridLayout(5,1));
		p3.add(new JLabel("Aggiungi nuovo Scaffale:", SwingConstants.CENTER));
		p3.add(n31);
		p3.add(new JLabel("Indicare la Quantita massima:", SwingConstants.CENTER));
		p3.add(n32);
		b3=new JButton ("Aggiungi");
		b3.setActionCommand("AdScaffale");
		b3.addActionListener(new ScaffaliListener(null, null, null, this));
		p3.add(b3);
		
		// Pannello Modifica Autore (p4)
		p4.setLayout(new GridLayout(4,1));
		p4.add(new JLabel("Modifica Autore esistente:", SwingConstants.CENTER));
		String listaAutori[] = new String[autoriMax];
		for (int i=0; i<autoriMax;i++)
		{
			listaAutori[i] = Autore.AutoriTotali(i);			
			c4.addItem(listaAutori[i]);
		}
		p4.add(c4);
		p4.add(n4);
		b4=new JButton ("Modifica");
		b4.setActionCommand("EditAutore");
		b4.addActionListener(new ScaffaliListener(null, null, null, this));
		p4.add(b4);
		
		// Pannello Modifica Casa Editrice (p5)
		p5.setLayout(new GridLayout(4,1));
		p5.add(new JLabel("Modifica Casa Editrice esistente:", SwingConstants.CENTER));
		String listaCasaEd[] = new String[casaEdMax];
		for (int i=0; i<casaEdMax;i++)
		{
			listaCasaEd[i] = CasaEditrice.CasaEdTotali(i);			
			c5.addItem(listaCasaEd[i]);
		}
		p5.add(c5);
		p5.add(n5);
		b5=new JButton ("Modifica");
		b5.setActionCommand("EditCasaEd");
		b5.addActionListener(new ScaffaliListener(null, null, null, this));
		p5.add(b5);
		
		// Pannello Modifica Scaffale (p6)
		p6.setLayout(new GridLayout(6,1));
		p6.add(new JLabel("Modifica Scaffale esistente:", SwingConstants.CENTER));
		int listaScaffali[] = new int[scaffaliMax];
		for (int i=0; i<scaffaliMax;i++)
		{
			listaScaffali[i] = Scaffale.ScaffaliTotali(i);
			c6.addItem(listaScaffali[i]);
		}
		p6.add(c6);
		p6.add(new JLabel("Indicare la Quantita massima:", SwingConstants.CENTER));
		p6.add(n6);
		b6=new JButton ("Modifica");
		b6.setActionCommand("EditScaffale");
		b6.addActionListener(new ScaffaliListener(null, null, null, this));
		p6.add(b6);
		
		switch(finestra)
		{
		case 1:
			c.remove(p2);
			c.remove(p3);
			c.remove(p4);
			c.remove(p5);
			c.remove(p6);
			c.add(p1);
			setSize(300, 120);
			break;
		case 2:
			c.remove(p1);
			c.remove(p3);
			c.remove(p4);
			c.remove(p5);
			c.remove(p6);
			c.add(p2);
			setSize(300, 120);
			break;
		case 3:
			c.remove(p1);
			c.remove(p2);
			c.remove(p4);
			c.remove(p5);
			c.remove(p6);
			c.add(p3);
			setSize(300, 150);
			break;
		case 4:
			c.remove(p1);
			c.remove(p2);
			c.remove(p3);
			c.remove(p5);
			c.remove(p6);
			c.add(p4);
			setSize(300, 150);
			break;
		case 5:
			c.remove(p1);
			c.remove(p2);
			c.remove(p3);
			c.remove(p4);
			c.remove(p6);
			c.add(p5);
			setSize(300, 150);
			break;
		case 6:
			c.remove(p1);
			c.remove(p2);
			c.remove(p3);
			c.remove(p4);
			c.remove(p5);
			c.add(p6);
			setSize(300, 200);
			break;
		}
		
		setResizable(false);
	    setVisible(true);
	}
	
	public static JTextField getN1()
		{ return n1; }
	public static void setN1(JTextField n1)
		{ AggiungiDati.n1 = n1; }
	public static JTextField getN2()
		{ return n2; }
	public void setN2(JTextField n2)
		{ this.n2 = n2; }
	public static JTextField getN31()
		{ return n31; }
	public void setN31(JTextField n31)
		{ this.n31 = n31; }
	public static JTextField getN32()
		{ return n32; }
	public void setN32(JTextField n32)
		{ this.n32 = n32; }
	public static JTextField getN4()
		{ return n4; }
	public void setN4(JTextField n4)
		{ this.n4 = n4; }
	public static JTextField getN5()
		{ return n5; }
	public void setN5(JTextField n5)
		{ this.n5 = n5; }
	public static JTextField getN6()
	{ return n6; }
	public void setN61(JTextField n6)
	{ this.n6 = n6; }
	public static JComboBox getC4()
		{ return c4; }
	public static void setC4(JComboBox c4)
		{ AggiungiDati.c4 = c4; }
	public static JComboBox getC5()
		{ return c5; }
	public static void setC5(JComboBox c5)
		{ AggiungiDati.c5 = c5; }
	public static JComboBox getC6()
		{ return c6; }
	public static void setC6(JComboBox c6)
		{ AggiungiDati.c6 = c6; }
}
