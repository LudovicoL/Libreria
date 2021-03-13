package it.project.libreria.view;

import it.project.libreria.listeners.ScaffaliListener;
import it.project.libreria.model.Autore;
import it.project.libreria.model.Libro;
import it.project.libreria.model.CasaEditrice;
import it.project.libreria.model.Scaffale;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ModificaLibro extends JDialog implements ActionListener
{
	InterfacciaScaffali iScaffali;
	JFrame parent;
	private static JTextField n2 = new JTextField (20);	// titolo
	private static JTextField n3 = new JTextField (20);	// genere
	private static JTextField n4 = new JTextField (20);	// annopub
	private static JTextField n5 = new JTextField (20);	// costo
	private static JTextField n6 = new JTextField (20);	// quantita
	private static JComboBox c1 = new JComboBox();
	private static JComboBox c2 = new JComboBox();
	private static JComboBox c3 = new JComboBox();
	private static JComboBox c4 = new JComboBox();			// Genere
	private JButton btn_conferma;
	private JButton b1;
	private JPanel p1;
	private JPanel p2;
	private boolean a = false;
	
	public ModificaLibro(JFrame parent, boolean bloccaParent, String titolo, String autore, String genere, String casaeditrice, int annopub, float costo, int quantita, int autoriMax, int casaEdMax,int scaffaliMax, int generiMax,InterfacciaScaffali iScaffali,int count)
	{
		super(parent, bloccaParent);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.parent = parent;
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		p1=new JPanel();
		p2=new JPanel();
		c.add(p1);
		p1.setLayout(new GridLayout(10,2));
		p1.add(new JLabel("Titolo:", SwingConstants.CENTER));
		n2.setText(titolo);
		p1.add(n2);
		p1.add(new JLabel("Genere Lettereario:", SwingConstants.CENTER));
		
		if(count==0)
		{
		String listaGeneri[] = new String[generiMax];
		for(int i=0; i<generiMax;i++)
		{
			listaGeneri[i] = Libro.GeneriTotali(i);			
			c4.addItem(listaGeneri[i]);
		}
		}
		p1.add(c4);
		b1=new JButton ("Aggiungi nuovo Genere Letterario:");
		b1.setActionCommand("NUOVOGENERELETTERARIO");
		b1.addActionListener(this);
		b1.setPreferredSize(new Dimension(285, 20));
		p1.add(b1);
		n3.setEditable(a);
		p1.add(n3);
		
		p1.add(new JLabel("Anno Pubblicazione:", SwingConstants.CENTER));
		n4.setText(Integer.toString(annopub));
		p1.add(n4);
		p1.add(new JLabel("Autore:", SwingConstants.CENTER));
		
		if(count==0)
		{
		String listaAutori[] = new String[autoriMax];
		for (int i=0; i<autoriMax;i++)
		{
			listaAutori[i] = Autore.AutoriTotali(i);			
			c1.addItem(listaAutori[i]);
		}
		}
		p1.add(c1);
		p1.add(new JLabel("Casa Editrice:", SwingConstants.CENTER));
		
		if(count==0)
		{
		String listaCasaEd[] = new String[casaEdMax];
		for (int i=0; i<casaEdMax;i++)
		{
			listaCasaEd[i] = CasaEditrice.CasaEdTotali(i);			
			c2.addItem(listaCasaEd[i]);
		}
		}
		p1.add(c2);
		p1.add(new JLabel("Costo:", SwingConstants.CENTER));
		n5.setText(Float.toString(costo));
		p1.add(n5);
		p1.add(new JLabel("Scaffale:", SwingConstants.CENTER));
		
		if(count==0)
		{
		int listaScaffali[] = new int[scaffaliMax];
		for (int i=0; i<scaffaliMax;i++)
		{
			listaScaffali[i] = Scaffale.ScaffaliTotali(i);			
			c3.addItem(listaScaffali[i]);
		}
		}
		p1.add(c3);
		p1.add(new JLabel("Quantita:", SwingConstants.CENTER));
		n6.setText(Integer.toString(quantita));
		p1.add(n6);
		btn_conferma=new JButton ("Conferma modifica");
		c.add(p2);
		p2.add(btn_conferma);
		btn_conferma.setActionCommand("CONFERMAMODIFICALIBRO");
		btn_conferma.addActionListener(new ScaffaliListener(iScaffali, null, this, null));
		
		setSize(570, 320);
		setResizable(false);
	    setVisible(true);
	    count=count+1;
	    InterfacciaScaffali.setCountmod(count);
	}
	
	public static JTextField getN2()
		{ return n2; }
	public void setN2(JTextField n2)
		{ this.n2 = n2; }
	public JTextField getN3()
		{ return n3; }
	public void setN3(JTextField n3)
		{ this.n3 = n3; }
	public static JComboBox getC1()
		{	return c1; }
	public void setC1(JComboBox c1)
		{ this.c1 = c1;	}
	public static JComboBox getC2()
		{ return c2; }
	public void setC2(JComboBox c2)
		{ this.c2 = c2; }
	public static JComboBox getC3()
		{ return c3; }
	public void setC3(JComboBox c3)
		{ this.c3 = c3; }
	public static JComboBox getC4()
		{ return c4; }
	public void setC4(JComboBox c4)
		{ this.c4 = c4; }
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
	public void setN6(JTextField n6)
		{ this.n6 = n6; }

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("NUOVOGENERELETTERARIO"))
		{
			if(a==true)
			{
				a=false;
				c4.removeItem("");
				String newGenere = getN3().getText();
				if(newGenere.equals(""))
				{
					JOptionPane.showMessageDialog(null,"ATTENZIONE! Inserire il nuovo genere!", "Errore!", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				c4.addItem(newGenere);
				c4.setSelectedItem(newGenere);
				b1.setText("Aggiungi nuovo Genere Letterario:");
				n3.setEditable(a);
				n3.setText("");
				
			}
			else
			{
				a=true;
				n3.setEditable(a);
				b1.setText("Aggiungi");
			}
		}		
	}
}
