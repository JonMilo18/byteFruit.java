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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AldaketakEskaerak extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_4;
    private JTextField textField_5;

    protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AldaketakEskaerak frame = new AldaketakEskaerak();
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
    public AldaketakEskaerak() {
        setTitle("Aldaketak eskaerak");
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
        mnNewMenu_1.add(mntmNewMenuItem_5);

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

        textField = new JTextField();
        textField.setBounds(110, 45, 38, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Eskaera IDa:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 46, 90, 13);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Aldatua");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(26, 22, 88, 13);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Aldaketa");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(26, 87, 80, 13);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("NAN");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(10, 110, 80, 13);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Egoera:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(10, 133, 70, 18);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Data");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(213, 110, 90, 13);
        contentPane.add(lblNewLabel_5);

        textField_1 = new JTextField();
        textField_1.setBounds(303, 109, 96, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(93, 109, 96, 19);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(93, 132, 96, 21);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JButton btnNewButton_1 = new JButton("Bilatu");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String eskaeraId = textField.getText();
                buscarDatos("SELECT ID, NAN, egoera, pedidoEguna FROM bytefruit.eskaerak WHERE ID = ?", eskaeraId);
            }
        });
        btnNewButton_1.setBounds(170, 44, 80, 21);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Aldatu");
        btnNewButton_2.setBounds(303, 44, 85, 21);
        contentPane.add(btnNewButton_2);

    }

    private void buscarDatos(String query, String... parametros) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                // Establecer los parámetros de la consulta SQL
                for (int i = 0; i < parametros.length; i++) {
                    preparedStatement.setString(i + 1, parametros[i]);
                }
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Mostrar los resultados en los campos de texto
                        textField_4.setText(resultSet.getString("NAN"));
                        textField_5.setText(resultSet.getString("egoera"));
                        textField_1.setText(resultSet.getString("pedidoEguna"));
                    } else {
                        // Si no se encuentran resultados, mostrar un mensaje al usuario
                        JOptionPane.showMessageDialog(this, "Eskaera IDa ez da aurkitu", "Errorea", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Mostrar un mensaje de error al usuario si ocurre un problema con la consulta SQL
            JOptionPane.showMessageDialog(this, "Errorea eskaera bilaketa egiten: " + ex.getMessage(), "Errorea", JOptionPane.ERROR_MESSAGE);
        }
    }
}
