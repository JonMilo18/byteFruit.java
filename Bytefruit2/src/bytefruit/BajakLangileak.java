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
import javax.swing.JTable;
import javax.swing.JTextField;

public class BajakLangileak extends JFrame {

    private static final long serialVersionUID = 1L;
    protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BajakLangileak frame = new BajakLangileak();
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
    public BajakLangileak() {
        setTitle("Langileen bajak");
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
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Bajak oforma = new Bajak();
                   oforma.setVisible(true);
            }
        });
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
        mntmNewMenuItem_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
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
        
        table = new JTable();
        table.setBounds(10, 78, 389, 128);
        contentPane.add(table);
        
        JLabel lblNewLabel = new JLabel("Ezabatu nahi den langilearen NANa:");
        lblNewLabel.setBounds(10, 10, 213, 13);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(214, 7, 104, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Bilatu");
        btnNewButton_1.setBounds(330, 6, 85, 21);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String NAN = textField.getText();
                
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "SELECT izena, Abizena, Telefonoa, Lan_postua, Helbidea, Korreo_elektronikoa, Erabiltzailea, Pasahitza, Kontu_korrontea FROM Langileak WHERE NAN = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, NAN);
                        try (ResultSet resultSet = preparedStatement.executeQuery()) {

                            // Iteramos sobre los resultados y los añadimos a la tabla
                            while (resultSet.next()) {
                                String izena = resultSet.getString("izena");
                                String abizena = resultSet.getString("Abizena");
                                String telefonoa = resultSet.getString("Telefonoa");
                                String lanPostua = resultSet.getString("Lan_postua");
                                String helbidea = resultSet.getString("Helbidea");
                                String korreo = resultSet.getString("Korreo_elektronikoa");
                                String erabiltzailea = resultSet.getString("Erabiltzailea");
                                String pasahitza = resultSet.getString("Pasahitza");
                                String kontuKorrontea = resultSet.getString("Kontu_korrontea");

                                // Añadimos los datos a la tabla
                                Object[] rowData = { izena, abizena, telefonoa, lanPostua,helbidea, korreo, erabiltzailea, pasahitza, kontuKorrontea  };
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
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Ezabatu");
        btnNewButton_2.setBounds(330, 47, 85, 21);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // NAN lortu
                String NAN = textField.getText();
                // Langilea ezabatu
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "DELETE FROM Langileak WHERE NAN = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, NAN);
                        int affectedRows = preparedStatement.executeUpdate();

                        // Konfirmazio mezua erakutsi
                        if (affectedRows > 0) {
                            JOptionPane.showMessageDialog(null, "Langilea ezabatu da", "Eginda",
                                    JOptionPane.INFORMATION_MESSAGE);
                            // Taula garbitu
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.setRowCount(0);
                        } else {
                            JOptionPane.showMessageDialog(null, "Langilea ez da existitzen", "Errorea",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        contentPane.add(btnNewButton_2);
    }
}
