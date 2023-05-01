package V;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Crea_ate = new JButton("Creation atelier");
		Crea_ate.setBounds(128, 48, 175, 40);
		contentPane.add(Crea_ate);
		Crea_ate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Masquer la fenêtre 1
                setVisible(false);

                // Créer et afficher la fenêtre 2
                creation creation = new creation();
                creation.setVisible(true);
            }
        });
		
		JButton enfants = new JButton("Atelier disponible");
		enfants.setBounds(128, 140, 175, 40);
		contentPane.add(enfants);
		enfants.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Masquer la fenêtre 1
                setVisible(false);

                // Créer et afficher la fenêtre 2
                liste_atelier liste_atelier = new liste_atelier();
                liste_atelier.setVisible(true);
            }
        });
	}
}
