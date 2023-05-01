package V;

import java.sql.Date;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import C.connecteur;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class creation extends JFrame {

	private JPanel contentPane;
	private JTextField nomactiviter;
	private JTextField Date_ate;
	private JTextField Hdebut;
	private JTextField Hfin;
	private JTextField nbplace;
	private JTextField ageenfant;
	private JTextField NOMAtelier;
	private JTextField NBplace;
	private JTextField DMY;
	private JTextField Hstart;
	private JTextField Hend;
	private JTextField age;
	private final JTextField textField = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creation frame = new creation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*public String jour () {
		//return Date_ate.format(DateTimeFormatter.ofPattern"jj-mm-aaaa")
		//final Date date_ate = new Date();
		//return new SimpleDateFormat("dd-MM-yyyy").format(Date_ate);
	}*/

	/**
	 * Create the frame.
	 */
	public creation() {
		setTitle("Creation Atelier");
		getContentPane().setLayout(null);
		textField.setBounds(69, 42, 220, 56);
		getContentPane().add(textField);
		textField.setColumns(10);
		getContentPane().setLayout(null);
	
		/*setDefaultC
		loseOperation(JFrame.EXIT_ON_CLOSE);*/
		setBounds(100, 100, 470, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationDatelier = new JLabel("Creation d'atelier ");
		lblCreationDatelier.setBounds(156, 10, 119, 34);
		lblCreationDatelier.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblCreationDatelier);
		
		JLabel lblNewLabel = new JLabel("Nom de l'activité :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 70, 128, 34);
		contentPane.add(lblNewLabel);
		
		nomactiviter = new JTextField();
		nomactiviter.setBounds(131, 79, 144, 19);
		contentPane.add(nomactiviter);
		nomactiviter.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Date : ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 114, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		Date_ate = new JTextField();
		Date_ate.setToolTipText("");
		Date_ate.setForeground(Color.GRAY);
        Date_ate.setText("DD/MM/AAAA");
        Date_ate.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Date_ate.getText().equals("DD/MM/AAAA")) {
                    Date_ate.setText("");
                    Date_ate.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (Date_ate.getText().isEmpty()) {
                    Date_ate.setForeground(Color.GRAY);
                    Date_ate.setText("DD/MM/AAAA");
                }
            }
            });
		Date_ate.setBounds(62, 112, 96, 19);
		contentPane.add(Date_ate);
		Date_ate.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("Heure de debut :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 151, 112, 19);
		contentPane.add(lblNewLabel_2);
		
		Hdebut = new JTextField();
		Hdebut.setBounds(122, 152, 96, 19);
		Hdebut.setForeground(Color.GRAY);
        Hdebut.setText("HH:mm");
        Hdebut.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Hdebut.getText().equals("HH:mm")) {
                    Hdebut.setText("");
                    Hdebut.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (Hdebut.getText().isEmpty()) {
                    Hdebut.setForeground(Color.GRAY);
                    Hdebut.setText("HH:mm");
                }
            }
            });
		contentPane.add(Hdebut);
		Hdebut.setColumns(10);
		String Heured = Hdebut.getText();
		SimpleDateFormat Heuredebut = new SimpleDateFormat("HH:mm"); 
		
		JLabel lblNewLabel_3 = new JLabel("Heure de fin :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(252, 153, 96, 15);
		contentPane.add(lblNewLabel_3);
		
		Hfin = new JTextField();
		Hfin.setBounds(344, 152, 96, 19);
		Hfin.setForeground(Color.GRAY);
        Hfin.setText("HH:mm");
        Hfin.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Hfin.getText().equals("HH:mm")) {
                    Hfin.setText("");
                    Hfin.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (Hfin.getText().isEmpty()) {
                    Hfin.setForeground(Color.GRAY);
                    Hfin.setText("HH:mm");
                }
            }
            });
		contentPane.add(Hfin);
		Hfin.setColumns(10);
        contentPane.add(Hfin);
        
		
		JLabel lblNewLabel_4 = new JLabel("Nombre de place :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 201, 112, 19);
		contentPane.add(lblNewLabel_4);
		
		nbplace = new JTextField();
		nbplace.setBounds(131, 202, 96, 19);
		contentPane.add(nbplace);
		nbplace.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enfants concernés :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 255, 128, 19);
		contentPane.add(lblNewLabel_5);
		
		ageenfant = new JTextField();
		ageenfant.setBounds(131, 256, 96, 19);
		contentPane.add(ageenfant);
		ageenfant.setColumns(10);
		
		JButton Envoyer = new JButton("Envoyer");
		Envoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            // The newInstance() call is a work around for some
		            // broken Java implementations

		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch (Exception ex) {
		            // handle the error
		        }
		        Connection conn = null;
		        try {
		            conn =
		               DriverManager.getConnection("jdbc:mysql://localhost/fripouille?" +
		                                           "user=root&password=root");
		            
		            CallableStatement PreparedStatement = (CallableStatement) conn.prepareCall("CALL creation_atelier(?,?,?,?,?,?)");
		            PreparedStatement.setString(1, nomactiviter.getText());
		            PreparedStatement.setString(2, Date_ate.getText());
		            PreparedStatement.setString(3, Hdebut.getText());
		            PreparedStatement.setString(4, Hfin.getText());
		            PreparedStatement.setString(5, nbplace.getText());
		            PreparedStatement.setString(6, ageenfant.getText());
		            
		            PreparedStatement.execute();
		            conn.close();
		            creation main = new creation();    

		            main.setVisible(true);
		            this.dispose();
		        } catch (SQLException ex) {
		        	System.out.println(ex.toString());
		        	
		        }
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		Envoyer.setBounds(190, 307, 85, 21);
		contentPane.add(Envoyer);
		
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
                dispose();
            }
        });
	}
}
