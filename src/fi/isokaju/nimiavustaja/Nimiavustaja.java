package fi.isokaju.nimiavustaja;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Nimiavustaja {

	private JFrame frame;
	private String[] aakkoset =  {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","å","ä","ö"};
    private Kirjaimet kirjaimet;
    private char kirjain;
    private JLabel lblSanat;
    private Thread t;
    private JButton btnPysyt_1;
    private JButton btnLopeta;
    private JLabel Word;
    private StringBuilder Sb= new StringBuilder();
    private JButton btnLopeta_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nimiavustaja window = new Nimiavustaja();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the application.
	 */
	public Nimiavustaja() {
		initialize();
		
		
		
		kirjaimet = new Kirjaimet(aakkoset,this);
		
		//t = new Thread(kirjaimet);
		kirjaimet.start();
	
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Nimiavustaja");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		 lblSanat = new JLabel("Aakkoset alkaa...");
		
		frame.getContentPane().add(lblSanat, BorderLayout.CENTER);
		
		btnPysyt_1 = new JButton("Valitse kirjain");
		btnPysyt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kirjaimet.interruped();
				
				
			
			}
		});frame.getContentPane().add(btnPysyt_1, BorderLayout.WEST);
		
		btnLopeta = new JButton("Pysäytä");
		btnLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kirjaimet.interrupt();
				
				
			}
		});
		frame.getContentPane().add(btnLopeta, BorderLayout.EAST);
		
		Word = new JLabel("");
		
		frame.getContentPane().add(Word, BorderLayout.NORTH);
		
		btnLopeta_1 = new JButton("Lopeta");
		
		btnLopeta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnLopeta_1, BorderLayout.SOUTH);
		
	}
	
	
	public void tulosta(String t){
			lblSanat.setText(t);
		
		
		
	}
	
	
	public void BuildWord(String abc){
		Sb.append(abc);
		Word.setText(Sb.toString());
	}
	
	
	
	
	

}
