package it.project.libreria.view;

import it.project.libreria.listeners.RegistrazioneListener;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Registrazione extends JDialog
{
	static JFrame parent;
	private static JTextField nome;
	private static JTextField cognome;
	private static JTextField user;
	private static JPasswordField password1;
	private static JPasswordField password2;
	private JButton registra;
	private JPanel p1;
	private JPanel p2;
	
	public Registrazione (JFrame parent, boolean bloccaParent)
	{
		super(parent, bloccaParent);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.parent = parent;
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		p1 = new JPanel();
		p2 = new JPanel();
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.SOUTH);
		nome=new JTextField(20);
		cognome=new JTextField(20);
		user=new JTextField(20);
		password1 = new JPasswordField(20);
		password2 = new JPasswordField(20);
		registra=new JButton("Conferma Registrazione");
		registra.addActionListener(new RegistrazioneListener(this));
		
		p1.setLayout(new GridLayout(5,2));
		p1.add (new JLabel ("Nome", SwingConstants.CENTER));
		p1.add(nome);
		p1.add (new JLabel ("Cognome", SwingConstants.CENTER));
		p1.add(cognome);
		p1.add (new JLabel ("Username", SwingConstants.CENTER));
		p1.add(user);
		p1.add (new JLabel ("Inserisci password:", SwingConstants.CENTER));
		p1.add(password1);
		p1.add (new JLabel ("Ripeti password:", SwingConstants.CENTER));
		p1.add(password2);
		p2.add(registra);
		
		pack();
		setVisible(true);
		setSize(500, 240);
		setResizable(false);
		setLocation (450, 200);
	}

	public static JTextField getNome() {
		return nome;
	}

	public void setNome(JTextField nome) {
		this.nome = nome;
	}

	public static JTextField getCognome() {
		return cognome;
	}

	public void setCognome(JTextField cognome) {
		this.cognome = cognome;
	}

	public static JTextField getUser() {
		return user;
	}

	public void setUser(JTextField user) {
		this.user = user;
	}

	public static JPasswordField getPassword1() {
		return password1;
	}

	public void setPassword1(JPasswordField password1) {
		this.password1 = password1;
	}

	public static JPasswordField getPassword2() {
		return password2;
	}

	public void setPassword2(JPasswordField password2) {
		this.password2 = password2;
	}
	
}
