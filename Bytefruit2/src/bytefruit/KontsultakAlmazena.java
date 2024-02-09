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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class KontsultakAlmazena extends JFrame {

    private static final long serialVersionUID = 1L;
    protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";
    private JPanel contentPane;
    private JPanel contentPane_1;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_9;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KontsultakAlmazena frame = new KontsultakAlmazena();
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
    public KontsultakAlmazena() {
        setTitle("Almazeneko kontsultak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 859, 600);
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
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Realizar la consulta y mostrar los resultados en la tabla
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "SELECT izena, marka, kopurua, prezioa FROM produktuak WHERE idproduktuak = ?";
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
        });
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
        table.setBounds(321, 62, 466, 424);
        contentPane_1.add(table);
        
        JLabel lblNewLabel = new JLabel("Produktuaren IDa:");
        lblNewLabel.setBounds(10, 79, 113, 13);
        contentPane_1.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(105, 76, 55, 19);
        contentPane_1.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("PrezioaS:");
        lblNewLabel_1.setBounds(10, 180, 68, 13);
        contentPane_1.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(74, 177, 86, 19);
        contentPane_1.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Kopurua:");
        lblNewLabel_2.setBounds(10, 157, 78, 13);
        contentPane_1.add(lblNewLabel_2);
        
        textField_2 = new JTextField();
        textField_2.setBounds(74, 154, 86, 19);
        contentPane_1.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(64, 128, 96, 19);
        contentPane_1.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Marka:");
        lblNewLabel_3.setBounds(10, 131, 78, 13);
        contentPane_1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Izena:");
        lblNewLabel_4.setBounds(10, 103, 45, 13);
        contentPane_1.add(lblNewLabel_4);
        
        textField_4 = new JTextField();
        textField_4.setBounds(64, 102, 96, 19);
        contentPane_1.add(textField_4);
        textField_4.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Bilatu");
        btnNewButton_1.setBounds(341, 32, 85, 21);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar si los campos de texto están vacíos
                if (textField.getText().isEmpty() && textField_1.getText().isEmpty() && textField_2.getText().isEmpty() &&
                    textField_3.getText().isEmpty() && textField_4.getText().isEmpty()&& textField_5.getText().isEmpty()&& 
                    textField_6.getText().isEmpty() && textField_9.getText().isEmpty()) {
                    // Realizar la consulta general
                    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                        String query = "SELECT * FROM almazena";
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
                        String query = "SELECT ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS FROM almazena WHERE ErregistroID = ?";
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
        contentPane_1.add(btnNewButton_1);
        
        textField_5 = new JTextField();
        textField_5.setBounds(88, 294, 47, 19);
        contentPane_1.add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(145, 294, 47, 19);
        contentPane_1.add(textField_6);
        textField_6.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Min");
        lblNewLabel_6.setBounds(90, 276, 45, 13);
        contentPane_1.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Max");
        lblNewLabel_7.setBounds(145, 276, 45, 13);
        contentPane_1.add(lblNewLabel_7);
        
        JLabel lblNewLabel_10 = new JLabel("Kopurua:");
        lblNewLabel_10.setBounds(10, 297, 56, 13);
        contentPane_1.add(lblNewLabel_10);
        
        JButton btnNewButton_2 = new JButton("Garbitu");
        btnNewButton_2.setBounds(436, 32, 85, 21);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 textField.setText("");
                 textField_1.setText("");
                 textField_2.setText("");
                 textField_3.setText("");
                 textField_4.setText("");
                 textField_5.setText("");
                 textField_6.setText("");
                 textField_9.setText("");
              
        
            }
        });
        contentPane_1.add(btnNewButton_2);
        
        JButton btnNewButton_4 = new JButton("Bilatu");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Realizar la consulta y mostrar los resultados en la tabla
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "SELECT ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS FROM almazena WHERE kantitatea BETWEEN ? AND ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setDouble(1, Double.parseDouble(textField_5.getText()));
                        preparedStatement.setDouble(2, Double.parseDouble(textField_6.getText()));
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
        });
        btnNewButton_4.setBounds(202, 293, 85, 21);
        contentPane_1.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Bilatu");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Realizar la consulta y mostrar los resultados en la tabla
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "SELECT SELECT ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS FROM almazena WHERE ErregistroID = ?";
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
        });
        btnNewButton_5.setBounds(182, 75, 85, 21);
        contentPane_1.add(btnNewButton_5);
        
        JButton btnNewButton_6 = new JButton("Bilatu");
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Realizar la consulta y mostrar los resultados en la tabla
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "SELECT SELECT ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS FROM almazena WHERE izena LIKE ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, "%" + textField_4.getText() + "%");
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
        });
        btnNewButton_6.setBounds(182, 99, 85, 21);
        contentPane_1.add(btnNewButton_6);
        
        JButton btnNewButton_7 = new JButton("Bilatu");
        btnNewButton_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Realizar la consulta y mostrar los resultados en la tabla
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "SELECT ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS FROM almazena WHERE marka LIKE ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, "%" + textField_3.getText() + "%");
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
        });
        btnNewButton_7.setBounds(182, 127, 85, 21);
        contentPane_1.add(btnNewButton_7);
        
        JButton btnNewButton_8 = new JButton("Bilatu");
        btnNewButton_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Realizar la consulta y mostrar los resultados en la tabla
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "SELECT ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS FROM almazena WHERE kantitatea = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setInt(1, Integer.parseInt(textField_2.getText()));
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
        });
        btnNewButton_8.setBounds(182, 153, 85, 21);
        contentPane_1.add(btnNewButton_8);
        
        JButton btnNewButton_9 = new JButton("Bilatu");
        btnNewButton_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Realizar la consulta y mostrar los resultados en la tabla
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "SELECT ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS FROM almazena WHERE prezioaS = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setDouble(1, Double.parseDouble(textField_1.getText()));
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
        });
        btnNewButton_9.setBounds(182, 176, 85, 21);
        contentPane_1.add(btnNewButton_9);
        
        JLabel lblNewLabel_11 = new JLabel("PrezioaE");
        lblNewLabel_11.setBounds(10, 203, 45, 13);
        contentPane_1.add(lblNewLabel_11);
        
        textField_9 = new JTextField();
        textField_9.setBounds(64, 203, 96, 19);
        contentPane_1.add(textField_9);
        textField_9.setColumns(10);
        
        JButton btnNewButton_10 = new JButton("Bilatu");
        btnNewButton_10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Realizar la consulta y mostrar los resultados en la tabla
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "SELECT ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS FROM almazena WHERE prezioaE = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setDouble(1, Double.parseDouble(textField_9.getText()));
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
        });
        btnNewButton_10.setBounds(182, 202, 85, 21);
        contentPane_1.add(btnNewButton_10);
    }
}
