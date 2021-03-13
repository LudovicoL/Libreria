package it.project.libreria.view;

import it.project.libreria.listeners.LoginListener;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PannelloLogin extends JFrame {

	private JTextField txt_username;
	private JPasswordField txt_password;
	private JButton btn_login;
	private JButton btn_reg;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;

	
	public PannelloLogin() {
		super("Libreria - Effettua login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		
		c.setLayout(new GridLayout(3,1));
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		c.add(p1);
		c.add(p2);
		c.add(p3);
		txt_username=new JTextField(20);
		txt_password = new JPasswordField(20);
		btn_login=new JButton("Effettua il login");
		btn_reg=new JButton ("Registrati");
		btn_login.setActionCommand("LOGIN");
		btn_login.addActionListener(new LoginListener(this));
		btn_reg.setActionCommand("REGISTRA");
		btn_reg.addActionListener(new LoginListener(this));
		p1.add (new JLabel ("Username"));
		p1.add(txt_username);
		p1.add (new JLabel ("Password"));
		p1.add(txt_password);
		
		p2.add(btn_login);
		p3.add (new JLabel ("Non sei registrato?"));
		p3.add(btn_reg);
		
		pack();
		setVisible(true);
		setSize(350, 200);
		setResizable(false);
		setLocation (450, 200);
		
	}

	public JTextField getTxt_username()
		{ return txt_username; }
	public void setTxt_username(JTextField txt_username)
		{ this.txt_username = txt_username; }
	public JPasswordField getTxt_password()
		{ return txt_password; }
	public void setTxt_password(JPasswordField txt_password)
		{ this.txt_password = txt_password; }
	
}