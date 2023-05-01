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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Enfant_inscri extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enfant_inscri frame = new Enfant_inscri(null);
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
	public Enfant_inscri(String tempResult2) {
		setTitle("Enfants inscrits");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
                liste_atelier liste_atelier = new liste_atelier();
                liste_atelier.setVisible(true);
            }
        });
		
        String[] tableau = tempResult2.split(";");
		List<String> resultat = new ArrayList<String>();
		String sql = "CALL enfants_inscrit(?)";
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
		    procedurestocker.setInt(1, Integer.parseInt(tableau[0]));
		    //derrière le set vous devez précisez le type de votre parametre, une ligne doit être mise pour chaque parametre (un varchar est un string, la date peut être au format date etc)
		    ResultSet resultSet;
		    procedurestocker.execute();
		    resultSet = procedurestocker.getResultSet();
		    while(resultSet.next()) {
		        String tempResultat = "";
		        for (int i = 1; i <= 3; i++) {
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
            l1.add(i, splitTemp[0]+" "+splitTemp[1]);
        }
        
        JList<String> list_pension = new JList<>(l1);
        list_pension.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_pension.setVisibleRowCount(20);
        list_pension.setFont(new Font("Tahoma", Font.BOLD, 12));
        list_pension.setBounds(10, 41, 416, 207);
        contentPane.add(list_pension);
        
        JLabel lblNewLabel = new JLabel(tableau[1]);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel.setBounds(192, 14, 45, 13);
        contentPane.add(lblNewLabel);
        

		
	}
}
