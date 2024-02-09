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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BajakAlmazena extends JFrame {

    private static final long serialVersionUID = 1L;
    protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BajakAlmazena frame = new BajakAlmazena();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BajakAlmazena() {
        setTitle("Almazeneko bajak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

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
        mnNewMenu.add(mntmNewMenuItem_2);

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

        JMenuItem mntmNewMenuItem_7 = new JMenuItem("Prezio historikoak");
        mnNewMenu_1.add(mntmNewMenuItem_7);

        JMenuItem mntmNewMenuItem_8 = new JMenuItem("Langileak");
        mntmNewMenuItem_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AldaketakLangileak oforma = new AldaketakLangileak();
                oforma.setVisible(true);
            }
        });
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

        // Inicializar el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Izena");
        model.addColumn("Marka");
        model.addColumn("Kopurua");
        model.addColumn("Prezioa");

        table = new JTable(model);
        table.setBounds(10, 78, 416, 128);
        contentPane.add(table);

        JLabel lblNewLabel = new JLabel("Ezabatu nahi den produktuaren IDa:");
        lblNewLabel.setBounds(10, 10, 202, 13);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(228, 7, 26, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton_1 = new JButton("Bilatu");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // IDa lortu
                int id = Integer.parseInt(textField.getText());
                // Produktuaren datuak bilatu
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "SELECT * FROM almazena WHERE ErregistroID = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setInt(1, id);
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {
                            if (resultSet.next()) {
                                // Emaitzak erakutsi
                                String izena = resultSet.getString("izena");
                                String marka = resultSet.getString("marka");
                                int kopurua = resultSet.getInt("kantitatea");
                                double prezioa = resultSet.getDouble("prezioaE");

                                // Display the results in the table
                                Object[] rowData = { izena, marka, kopurua, prezioa };
                                DefaultTableModel model = (DefaultTableModel) table.getModel();
                                model.addRow(rowData);
                            }
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_1.setBounds(264, 6, 67, 21);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Ezabatu");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // IDa lortu
                int id = Integer.parseInt(textField.getText());
                // Produktua ezabatu
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "DELETE FROM almazena WHERE ErregistroID = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setInt(1, id);
                        preparedStatement.executeUpdate();

                        // Erabiltzaileari mezu bat erakutsi
                        // Adibidez:
                        System.out.println("Produktua ezabatu da");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_2.setBounds(341, 6, 85, 21);
        contentPane.add(btnNewButton_2);
    }
}
