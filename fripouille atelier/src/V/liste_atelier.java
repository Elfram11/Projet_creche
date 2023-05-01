package V;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class liste_atelier extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					liste_atelier frame = new liste_atelier();
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
	public liste_atelier() {
		setTitle("Liste atelier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

        

        
        JButton retour = new JButton("retour");
        retour.setBounds(10, 10, 85, 21);
        contentPane.add(retour);
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Masquer la fenêtre 1
                setVisible(false);

                // Créer et afficher la fenêtre 2
                Menu Menu = new Menu();
                Menu.setVisible(true);
            }
        });
        
        
        List<String> resultat = new ArrayList<String>();
		String sql = "CALL listerAtelier()";
		try {
		    // The newInstance() call is a work around for some
		    // broken Java implementations

		    Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
		    // handle the error
		}
		Connection conn = null;
		try {
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/fripouille?" + "user=root&password=root");
		    //La ligne juste au dessus sert a se connecter a la base de donnée (ne pas oublier de changer baseName par le nom de votre base de donnée, username et password par vos moyen de connection)
		    CallableStatement procedurestocker = conn.prepareCall(sql);
		    //Le CallableStatement permet d'executer une procedure stocker
		    //derrière le set vous devez précisez le type de votre parametre, une ligne doit être mise pour chaque parametre (un varchar est un string, la date peut être au format date etc)
		    ResultSet resultSet;
		    procedurestocker.execute();
		    resultSet = procedurestocker.getResultSet();
		    while(resultSet.next()) {
		        String tempResultat = "";
		        for (int i = 1; i <= 8; i++) {
		            String tempVariable = resultSet.getString(i);
		            if(tempVariable != null) {
		                tempResultat += tempVariable+";";
		            }
		        }
		        resultat.add(tempResultat);
		    }
		    conn.close();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		
		DefaultListModel<String> l1 = new DefaultListModel<>();
        String[] tempResult = resultat.toArray(new String[0]);
        for(int i = 0; i < tempResult.length; i++) {
            String[] splitTemp = tempResult[i].split(";");
            l1.add(i, splitTemp[1]);
        }
        /*
         * Si une ligne de la list selectionner
         * list_pension.getSelectedValue() -> recuperer la value selectionner
         * 	Si rien n'ai selectionner renvoie null
         * 	Si select renvoie la valeur selectionner (exemple : List (dessins, eau) L'utilisateur selectionne dessins, la fonction renvoie dessins, Si l'utiliteur selection rien, la fonction renvoie null)
         * 	tempResult ["1;dessins", "2;eau"]
         * tempResult[list_pension.getSelectedIndex()]
         * Enfant_incri frame = new Enfant_inscri(tempResult[list_pension.getSelectedIndex()]);
         * */
		JList<String> list_pension = new JList<>(l1);
        list_pension.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_pension.setVisibleRowCount(20);
        list_pension.setFont(new Font("Tahoma", Font.BOLD, 12));
        list_pension.setBounds(10, 41, 416, 187);
        contentPane.add(list_pension);
        
        
        JButton valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(list_pension.getSelectedValue() == null) {
        			JFrame frame = new JFrame("JOptionPane showMessageDialog error");
                    JOptionPane.showMessageDialog(frame,"Erreur, Vous devez selectionnez un atelier.");    
        		}
        		else {
        			Enfant_inscri frame = new Enfant_inscri(tempResult[list_pension.getSelectedIndex()]);
        			frame.setVisible(true);
        			dispose();
        		}
        	}
        	
        });
        valider.setBounds(154, 238, 121, 25);
        contentPane.add(valider);
        
        
        
	}
}
