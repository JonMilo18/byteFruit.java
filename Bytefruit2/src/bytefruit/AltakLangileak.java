package bytefruit;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class AltakLangileak extends JFrame {

    private static final long serialVersionUID = 1L;
    protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField txtbytefruitcom;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_3;
    private JTextField textField_8;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AltakLangileak frame = new AltakLangileak();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AltakLangileak() {
        setTitle("Langileen altak");
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
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Bajak");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Bajak oforma = new Bajak();
                   oforma.setVisible(true);
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);
        
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
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel_5 = new JLabel("NAN:");
        lblNewLabel_5.setBounds(10, 6, 45, 19);
        contentPane.add(lblNewLabel_5);
        
        textField_5 = new JTextField();
        textField_5.setText("");
        textField_5.setBounds(75, 7, 190, 19);
        contentPane.add(textField_5);
        textField_5.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Izena:");
        lblNewLabel.setBounds(10, 31, 45, 13);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(75, 28, 190, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Abizena:");
        lblNewLabel_1.setBounds(10, 54, 65, 13);
        contentPane.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(75, 51, 190, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Telefonoa:");
        lblNewLabel_2.setBounds(10, 77, 65, 13);
        contentPane.add(lblNewLabel_2);
        
        textField_2 = new JTextField();
        textField_2.setBounds(76, 74, 189, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Helbidea:");
        lblNewLabel_4.setBounds(10, 100, 84, 13);
        contentPane.add(lblNewLabel_4);
        
        textField_4 = new JTextField();
        textField_4.setBounds(75, 97, 190, 19);
        contentPane.add(textField_4);
        textField_4.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Korreo elektronikoa:");
        lblNewLabel_3.setBounds(10, 123, 129, 13);
        contentPane.add(lblNewLabel_3);
        
        txtbytefruitcom = new JTextField();
        txtbytefruitcom.setText("@bytefruit.com");
        txtbytefruitcom.setBounds(136, 120, 129, 19);
        contentPane.add(txtbytefruitcom);
        txtbytefruitcom.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Lan postua:");
        lblNewLabel_6.setBounds(10, 146, 96, 13);
        contentPane.add(lblNewLabel_6);
        
        textField_6 = new JTextField();
        textField_6.setBounds(136, 143, 129, 19);
        contentPane.add(textField_6);
        textField_6.setColumns(10);
        
        JLabel lblNewLabel_7 = new JLabel("Kontu korrontea:");
        lblNewLabel_7.setBounds(10, 169, 116, 13);
        contentPane.add(lblNewLabel_7);
        
        textField_7 = new JTextField();
        textField_7.setBounds(136, 166, 240, 19);
        contentPane.add(textField_7);
        textField_7.setColumns(10);
        
        JLabel lblNewLabel_8 = new JLabel("Erabiltzailea:");
        lblNewLabel_8.setBounds(10, 192, 116, 13);
        contentPane.add(lblNewLabel_8);
        
        textField_3 = new JTextField();
        textField_3.setBounds(136, 189, 129, 19);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_9 = new JLabel("Pasahitza");
        lblNewLabel_9.setBounds(10, 215, 96, 13);
        contentPane.add(lblNewLabel_9);
        
        textField_8 = new JTextField();
        textField_8.setBounds(136, 212, 84, 19);
        contentPane.add(textField_8);
        textField_8.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Datu basean sartu");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                PreparedStatement preparedStatement = null;

                try {
                    // Establecer la conexión a la base de datos
                    conexion = DriverManager.getConnection(URL, USER, PASSWORD);

                    // Preparar la consulta SQL con parámetros para evitar problemas de seguridad
                    String NAN = textField_5.getText();
                    String izena = textField.getText();
                    String Abizena = textField_1.getText();
                    String Telefonoa = textField_2.getText();
                    String Helbidea = textField_4.getText();
                    String Korreo_elektronikoa= txtbytefruitcom.getText();
                    String LanPostua = textField_6.getText();
                    String KontuKorrontea = textField_7.getText();
                    String Erabiltzailea = textField_3.getText();
                    String Pasahitza = textField_8.getText();
                    String LangileakAlta = "INSERT INTO langileak (NAN,Izena, Abizena, Telefonoa, Lan_postua, Helbidea, Korreo_elektronikoa, Kontu_korrontea, Erabiltzailea, Pasahitza) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    preparedStatement = conexion.prepareStatement(LangileakAlta);
                    preparedStatement.setString(1, NAN);
                    preparedStatement.setString(2, izena);
                    preparedStatement.setString(3, Abizena);
                    preparedStatement.setString(4, Telefonoa);
                    preparedStatement.setString(5, LanPostua);
                    preparedStatement.setString(6, Helbidea);
                    preparedStatement.setString(7, Korreo_elektronikoa);
                    preparedStatement.setString(8, KontuKorrontea);
                    preparedStatement.setString(9, Erabiltzailea);
                    preparedStatement.setString(10, Pasahitza);

                    // Ejecutar la consulta SQL
                    preparedStatement.executeUpdate();

                    System.out.println("Datuak basean sartuak izan dira.");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    // Cerrar la conexión y el preparedStatement en el bloque finally
                    try {
                        if (preparedStatement != null) {
                            preparedStatement.close();
                        }
                        if (conexion != null) {
                            conexion.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnNewButton_1.setBounds(279, 6, 147, 21);
        contentPane.add(btnNewButton_1);
    }
}
