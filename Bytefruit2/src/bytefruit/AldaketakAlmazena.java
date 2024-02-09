package bytefruit;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AldaketakAlmazena extends JFrame {

    private static final long serialVersionUID = 1L;
    protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_3;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AldaketakAlmazena frame = new AldaketakAlmazena();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AldaketakAlmazena() {
        setTitle("Aldaketak almazena");
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
        mnNewMenu_1.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Bezeroak");
        mnNewMenu_1.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Eskaerak");
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

        textField = new JTextField();
        textField.setBounds(51, 45, 47, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("IDa:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 46, 31, 13);
        contentPane.add(lblNewLabel);

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

        JLabel lblNewLabel_4 = new JLabel("Marka:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(10, 133, 70, 13);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Kopurua:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(213, 110, 80, 13);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Prezioa:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(213, 133, 70, 13);
        contentPane.add(lblNewLabel_6);

        textField_1 = new JTextField();
        textField_1.setBounds(303, 109, 96, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(303, 132, 96, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(83, 109, 96, 19);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(83, 132, 96, 19);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

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
                                textField_4.setText(resultSet.getString("izena"));
                                textField_5.setText(resultSet.getString("marka"));
                                textField_3.setText(resultSet.getString("modeloa"));
                                textField_1.setText(String.valueOf(resultSet.getInt("kantitatea")));
                                textField_2.setText(String.valueOf(resultSet.getDouble("prezioaS")));
                            }
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton_1.setBounds(108, 44, 85, 21);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Aldatu");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aldaketak eguneratu
                int id = Integer.parseInt(textField.getText());
                String izena = textField_4.getText();
                String marka = textField_5.getText();
                String modeloa = textField_3.getText();
                int kopurua = Integer.parseInt(textField_1.getText());
                double prezioa = Double.parseDouble(textField_2.getText());
                // Produktuaren datuak eguneratu
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String updateQuery = "UPDATE almazena SET izena = ?, marka = ?, modeloa = ?, kantitatea = ?, prezioaS = ? WHERE ErregistroID = ?";
                    try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                        updateStatement.setString(1, izena);
                        updateStatement.setString(2, marka);
                        updateStatement.setString(3, modeloa);
                        updateStatement.setInt(4, kopurua);
                        updateStatement.setDouble(5, prezioa);
                        updateStatement.setInt(6, id);
                        int affectedRows = updateStatement.executeUpdate();
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

        btnNewButton_2.setBounds(303, 44, 85, 21);
        contentPane.add(btnNewButton_2);
        
        JLabel lblNewLabel_7 = new JLabel("Modeloa:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_7.setBounds(10, 156, 70, 13);
        contentPane.add(lblNewLabel_7);
        
        textField_3 = new JTextField();
        textField_3.setBounds(83, 155, 96, 19);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
    }
}
