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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTable;
import javax.swing.JTextField;

public class KontsultakEskaerak extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";
	private JPanel contentPane;
	private JPanel contentPane_1;
	private JTable table;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KontsultakEskaerak frame = new KontsultakEskaerak();
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
	public KontsultakEskaerak() {
		setTitle("Kontsulta eskaerak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(192, 192, 192));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menua");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Altak");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Altak oforma = new Altak();
				   oforma.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Bajak");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bajak oforma = new Bajak();
				   oforma.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Aldaketak");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aldaketak oforma = new Aldaketak();
				   oforma.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Taulak");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Almazena");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Bezeroak");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Eskaerak");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Prezio historikoak");
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Langileak");
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JButton btnNewButton = new JButton("Atera aplikaziotik");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		menuBar.add(btnNewButton);
		
		contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(255, 128, 0));
		contentPane_1.setForeground(new Color(0, 0, 0));
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 80, 652, 150);
		contentPane_1.add(table);
		
		JLabel lblNewLabel = new JLabel("Eskaera IDa:");
		lblNewLabel.setBounds(10, 13, 113, 13);
		contentPane_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(122, 10, 40, 19);
		contentPane_1.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(341, 33, 96, 19);
		contentPane_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Egoera:");
		lblNewLabel_3.setBounds(270, 36, 78, 13);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NAN");
		lblNewLabel_4.setBounds(10, 36, 78, 13);
		contentPane_1.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(122, 33, 40, 19);
		contentPane_1.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Bilatu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			        // Verificar si los campos de texto están vacíos
			        if (textField.getText().isEmpty() &&
			            textField_3.getText().isEmpty() && textField_4.getText().isEmpty()) {
			            // Realizar la consulta general
			            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			                String query = "SELECT * FROM eskaerak";
			                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
			                        // Crear un modelo de tabla para almacenar los datos
			                        DefaultTableModel tableModel = new DefaultTableModel();

			                        // Obtener metadatos de columnas
			                        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
			                        int columnCount = metaData.getColumnCount();

			                        // Añadir nombres de columnas al modelo de tabla
			                        for (int i = 1; i <= columnCount; i++) {
			                            tableModel.addColumn(metaData.getColumnName(i));
			                        }

			                        // Añadir filas al modelo de tabla
			                        while (resultSet.next()) {
			                            Object[] rowData = new Object[columnCount];
			                            for (int i = 1; i <= columnCount; i++) {
			                                rowData[i - 1] = resultSet.getObject(i);
			                            }
			                            tableModel.addRow(rowData);
			                        }

			                        // Establecer el modelo de tabla en la tabla
			                        table.setModel(tableModel);
			                    }
			                }
			            } catch (SQLException ex) {
			                ex.printStackTrace();
			            }
			        } else {
			            // Realizar la consulta con los valores proporcionados en los campos de texto
			            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			                String query = "SELECT ID, NAN, egoera, pedidoEguna FROM bytefruit.eskaerak WHERE ID = ?\", eskaeraId";
			                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			                    preparedStatement.setString(1, textField.getText());
			                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
			                        // Crear un modelo de tabla para almacenar los datos
			                        DefaultTableModel tableModel = new DefaultTableModel();

			                        // Obtener metadatos de columnas
			                        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
			                        int columnCount = metaData.getColumnCount();

			                        // Añadir nombres de columnas al modelo de tabla
			                        for (int i = 1; i <= columnCount; i++) {
			                            tableModel.addColumn(metaData.getColumnName(i));
			                        }

			                        // Añadir filas al modelo de tabla
			                        while (resultSet.next()) {
			                            Object[] rowData = new Object[columnCount];
			                            for (int i = 1; i <= columnCount; i++) {
			                                rowData[i - 1] = resultSet.getObject(i);
			                            }
			                            tableModel.addRow(rowData);
			                        }

			                        // Establecer el modelo de tabla en la tabla
			                        table.setModel(tableModel);
			                    }
			                }
			            } catch (SQLException ex) {
			                ex.printStackTrace();
			            }
			        }
			    }
		});
		btnNewButton_1.setBounds(566, 9, 85, 21);
		contentPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Garbitu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 textField.setText("");
				 textField_3.setText("");
				 textField_4.setText("");
		
			}
		});
		btnNewButton_2.setBounds(471, 9, 85, 21);
		contentPane_1.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("Bilatu");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        // Verificar si el campo de texto está vacío
		        if (!textField_3.getText().isEmpty()) {
		            // Realizar la consulta con el valor proporcionado en el campo de texto
		            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
		                String query = "SELECT * FROM eskaerak WHERE Egoera = ?";
		                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		                    preparedStatement.setString(1, textField_3.getText());
		                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                        // Crear un modelo de tabla para almacenar los datos
		                        DefaultTableModel tableModel = new DefaultTableModel();

		                        // Obtener metadatos de columnas
		                        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
		                        int columnCount = metaData.getColumnCount();

		                        // Añadir nombres de columnas al modelo de tabla
		                        for (int i = 1; i <= columnCount; i++) {
		                            tableModel.addColumn(metaData.getColumnName(i));
		                        }

		                        // Añadir filas al modelo de tabla
		                        while (resultSet.next()) {
		                            Object[] rowData = new Object[columnCount];
		                            for (int i = 1; i <= columnCount; i++) {
		                                rowData[i - 1] = resultSet.getObject(i);
		                            }
		                            tableModel.addRow(rowData);
		                        }

		                        // Establecer el modelo de tabla en la tabla
		                        table.setModel(tableModel);
		                    }
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Mesedez, Egoera bat sartu bilaketa egiteko.");
		        }
		    }
		});
		btnNewButton_5.setBounds(471, 32, 85, 21);
		contentPane_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Bilatu");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        // Verificar si el campo de texto está vacío
		        if (!textField.getText().isEmpty()) {
		            // Realizar la consulta con el valor proporcionado en el campo de texto
		            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
		                String query = "SELECT * FROM eskaerak WHERE idEskaera = ?";
		                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		                    preparedStatement.setString(1, textField.getText());
		                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                        // Crear un modelo de tabla para almacenar los datos
		                        DefaultTableModel tableModel = new DefaultTableModel();

		                        // Obtener metadatos de columnas
		                        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
		                        int columnCount = metaData.getColumnCount();

		                        // Añadir nombres de columnas al modelo de tabla
		                        for (int i = 1; i <= columnCount; i++) {
		                            tableModel.addColumn(metaData.getColumnName(i));
		                        }

		                        // Añadir filas al modelo de tabla
		                        while (resultSet.next()) {
		                            Object[] rowData = new Object[columnCount];
		                            for (int i = 1; i <= columnCount; i++) {
		                                rowData[i - 1] = resultSet.getObject(i);
		                            }
		                            tableModel.addRow(rowData);
		                        }

		                        // Establecer el modelo de tabla en la tabla
		                        table.setModel(tableModel);
		                    }
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Mesedez, ID eskaera bat sartu bilaketa egiteko.");
		        }
		    }
		});
		btnNewButton_6.setBounds(172, 9, 85, 21);
		contentPane_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Bilatu");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        // Verificar si el campo de texto está vacío
		        if (!textField_4.getText().isEmpty()) {
		            // Realizar la consulta con el valor proporcionado en el campo de texto
		            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
		                String query = "SELECT ID, NAN, egoera, pedidoEguna FROM bytefruit.eskaerak WHERE NAN = ?";
		                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		                    preparedStatement.setString(1, textField_4.getText());
		                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                        // Crear un modelo de tabla para almacenar los datos
		                        DefaultTableModel tableModel = new DefaultTableModel();

		                        // Obtener metadatos de columnas
		                        ResultSetMetaData metaData = (ResultSetMetaData) resultSet.getMetaData();
		                        int columnCount = metaData.getColumnCount();

		                        // Añadir nombres de columnas al modelo de tabla
		                        for (int i = 1; i <= columnCount; i++) {
		                            tableModel.addColumn(metaData.getColumnName(i));
		                        }

		                        // Añadir filas al modelo de tabla
		                        while (resultSet.next()) {
		                            Object[] rowData = new Object[columnCount];
		                            for (int i = 1; i <= columnCount; i++) {
		                                rowData[i - 1] = resultSet.getObject(i);
		                            }
		                            tableModel.addRow(rowData);
		                        }

		                        // Establecer el modelo de tabla en la tabla
		                        table.setModel(tableModel);
		                    }
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Mesedez, Bezero ID bat sartu bilaketa egiteko.");
		        }
		    }
		});
		btnNewButton_7.setBounds(172, 32, 85, 21);
		contentPane_1.add(btnNewButton_7);
	}
}
