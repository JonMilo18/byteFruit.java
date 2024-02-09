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

public class AltakAlmazena extends JFrame {

    private static final long serialVersionUID = 1L;
    protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_4;
    private JTextField textField_3;
    private JTextField textField_5;
    private JTextField textField_6;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AltakAlmazena frame = new AltakAlmazena();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AltakAlmazena() {
        setTitle("Almazeneko altak");
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
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Aldaketak");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kontsultak oforma = new Kontsultak();
                oforma.setVisible(true);
            }
        });
        
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
        
        JLabel lblNewLabel = new JLabel("Izena:");
        lblNewLabel.setBounds(10, 10, 45, 13);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setBounds(75, 7, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Marka:");
        lblNewLabel_1.setBounds(10, 33, 65, 13);
        contentPane.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(75, 30, 96, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Kopurua:");
        lblNewLabel_2.setBounds(10, 77, 65, 13);
        contentPane.add(lblNewLabel_2);
        
        textField_2 = new JTextField();
        textField_2.setBounds(76, 74, 95, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("PrezioaS:");
        lblNewLabel_4.setBounds(10, 100, 84, 13);
        contentPane.add(lblNewLabel_4);
        
        textField_4 = new JTextField();
        textField_4.setBounds(75, 97, 96, 19);
        contentPane.add(textField_4);
        textField_4.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Datu basean sartu");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                PreparedStatement preparedStatement = null;

                try {
                    // Establecer la conexión a la base de datos
                    conexion = DriverManager.getConnection(URL, USER, PASSWORD);

                    // Preparar la consulta SQL con parámetros para evitar problemas de seguridad
                    String izena = textField.getText();
                    String marka = textField_1.getText();
                    int kantitatea = Integer.parseInt(textField_2.getText());
                    int prezioaS = Integer.parseInt(textField_4.getText());
                    int prezioaE = Integer.parseInt(textField_3.getText());
                    int berria = Integer.parseInt(textField_6.getText());
                    String almazenaAlta = "INSERT INTO almazena (Izena, Marka, Kantitatea, PrezioaS, PrezioaE, Berria) VALUES (?, ?, ?, ?, ?, ?)";
                    preparedStatement = conexion.prepareStatement(almazenaAlta);
                    preparedStatement.setString(1, izena);
                    preparedStatement.setString(2, marka);
                    preparedStatement.setInt(3, kantitatea);
                    preparedStatement.setInt(4, prezioaS);
                    preparedStatement.setInt(5, prezioaE);
                    preparedStatement.setInt(6, berria);


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

        btnNewButton_1.setBounds(257, 6, 169, 21);
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel_3 = new JLabel("PrezioaE:");
        lblNewLabel_3.setBounds(10, 123, 65, 13);
        contentPane.add(lblNewLabel_3);
        
        textField_3 = new JTextField();
        textField_3.setBounds(75, 120, 96, 19);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Modeloa:");
        lblNewLabel_5.setBounds(10, 54, 65, 13);
        contentPane.add(lblNewLabel_5);
        
        textField_5 = new JTextField();
        textField_5.setBounds(75, 48, 96, 19);
        contentPane.add(textField_5);
        textField_5.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Berria");
        lblNewLabel_6.setBounds(10, 150, 45, 13);
        contentPane.add(lblNewLabel_6);
        
        textField_6 = new JTextField();
        textField_6.setBounds(75, 147, 96, 19);
        contentPane.add(textField_6);
        textField_6.setColumns(10);
        
        JLabel lblNewLabel_7 = new JLabel("1 bai - 0 ez");
        lblNewLabel_7.setBounds(181, 150, 70, 13);
        contentPane.add(lblNewLabel_7);
    }
}
