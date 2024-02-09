package bytefruit;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class AldaketakLangileak extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AldaketakLangileak frame = new AldaketakLangileak();
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
	public AldaketakLangileak() {
		setTitle("Aldaketak langileak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 361);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(192, 192, 192));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Kontsultak");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontsultak oforma = new Kontsultak();
				   oforma.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Altak");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Altak oforma = new Altak();
				   oforma.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Bajak");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bajak oforma = new Bajak();
				   oforma.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("Taulak");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Almazena");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AldaketakAlmazena oforma = new AldaketakAlmazena();
				   oforma.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Bezeroak");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AldaketakBezeroak oforma = new AldaketakBezeroak();
				   oforma.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Eskaerak");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AldaketakEskaerak oforma = new AldaketakEskaerak();
				   oforma.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Langileak");
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JButton btnNewButton = new JButton("Atera aplikaziotik");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		menuBar.add(btnNewButton);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Aldatua");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(26, 22, 88, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Aldaketa");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(26, 87, 80, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Izena:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 110, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Abizena:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 133, 70, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefonoa:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(213, 110, 80, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Korreoa:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(213, 131, 70, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Helbidea:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(213, 178, 70, 13);
		contentPane.add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(303, 109, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(302, 130, 150, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(303, 172, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(83, 110, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(83, 132, 96, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("NAN:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 45, 45, 19);
		contentPane.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(83, 45, 96, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Lan Postua:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(213, 201, 80, 13);
		contentPane.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setBounds(303, 200, 96, 19);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Erabiltzailea:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 178, 88, 13);
		contentPane.add(lblNewLabel_10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(93, 177, 96, 19);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Pasahitza:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 201, 80, 13);
		contentPane.add(lblNewLabel_11);
		
		textField_9 = new JTextField();
		textField_9.setBounds(83, 200, 106, 19);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Kontu korrontea:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(10, 266, 133, 13);
		contentPane.add(lblNewLabel_12);
		
		textField_10 = new JTextField();
		textField_10.setBounds(127, 265, 272, 19);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Bilatu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    // IDa lortu
			    String NAN = textField_6.getText();
			    // Produktuaren datuak bilatu
			    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			        String query = "SELECT izena, Abizena, Telefonoa, Lan_postua, Helbidea, Korreo_elektronikoa, Erabiltzailea, Pasahitza, Kontu_korrontea FROM Langileak WHERE NAN = ?";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			            preparedStatement.setString(1, NAN); // Set the value of the parameter
			            try (ResultSet resultSet = preparedStatement.executeQuery()) {
			                if (resultSet.next()) {
			                    // Emaitzak erakutsi
			                    textField_4.setText(resultSet.getString("izena"));
			                    textField_5.setText(resultSet.getString("Abizena"));
			                    textField_1.setText(resultSet.getString("Telefonoa"));
			                    textField_7.setText(resultSet.getString("Lan_postua"));
			                    textField_2.setText(resultSet.getString("Korreo_elektronikoa"));
			                    textField_3.setText(resultSet.getString("Helbidea"));
			                    textField_8.setText(resultSet.getString("Erabiltzailea"));
			                    textField_9.setText(resultSet.getString("Pasahitza"));
			                    textField_10.setText(resultSet.getString("Kontu_korrontea"));
			                }
			            }
			        }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			}
		});
		btnNewButton_1.setBounds(223, 44, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Aldatu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // Aldaketak eguneratu
				String NAN = textField_6.getText();
                String izena = textField_4.getText();
                String abizena = textField_5.getText();
                String Telefonoa = textField_1.getText();
                String Lan_postua = textField_7.getText();
                String Korreo_elektronikoa = textField_2.getText();
                String Helbidea = textField_3.getText();
                String Erabiltzailea = textField_8.getText();
                String Pasahitza = textField_9.getText();
                String Kontu_korrontea = textField_10.getText();
                
                // Produktuaren datuak eguneratu
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "UPDATE Langileak SET izena = ?, Abizena = ?, Telefonoa = ?, Lan_postua = ?, Helbidea = ?, Korreo_elektronikoa = ?, Erabiltzailea = ?, Pasahitza = ?, Kontu_korrontea = ? WHERE NAN = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, izena);
                        preparedStatement.setString(2, abizena);
                        preparedStatement.setString(3, Telefonoa);
                        preparedStatement.setString(4, Lan_postua);
                        preparedStatement.setString(5, Helbidea);
                        preparedStatement.setString(6, Korreo_elektronikoa);
                        preparedStatement.setString(7, Erabiltzailea);
                        preparedStatement.setString(8, Pasahitza);
                        preparedStatement.setString(9, Kontu_korrontea);
                        preparedStatement.setString(10, NAN);
                        int affectedRows = preparedStatement.executeUpdate();
                        if (affectedRows > 0) {
                            System.out.println("Produktuaren datuak eguneratu dira.");
                        } else {
                            System.out.println("Errorea produktuaren datuak eguneratzean.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
		});
		btnNewButton_2.setBounds(314, 44, 85, 21);
		contentPane.add(btnNewButton_2);
		
		
	}

}
