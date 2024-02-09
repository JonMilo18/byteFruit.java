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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AltakBezeroak extends JFrame {

    private static final long serialVersionUID = 1L;
    protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
    protected static final String USER = "root";
    protected static final String PASSWORD = "1WMG2023";
    private JPanel contentPane;
    private JTextField izenaTextField;
    private JTextField nanTextField;
    private JTextField korreoElektronikoaTextField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AltakBezeroak frame = new AltakBezeroak();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AltakBezeroak() {
        setTitle("Bezeroen altak");
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
        
        izenaTextField = new JTextField();
        izenaTextField.setBounds(75, 7, 96, 19);
        contentPane.add(izenaTextField);
        izenaTextField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("NAN:");
        lblNewLabel_1.setBounds(10, 33, 65, 13);
        contentPane.add(lblNewLabel_1);
        
        nanTextField = new JTextField();
        nanTextField.setBounds(75, 30, 96, 19);
        contentPane.add(nanTextField);
        nanTextField.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Korreo elektronikoa:");
        lblNewLabel_3.setBounds(10, 56, 129, 13);
        contentPane.add(lblNewLabel_3);
        
        korreoElektronikoaTextField = new JTextField();
        korreoElektronikoaTextField.setBounds(133, 53, 129, 19);
        contentPane.add(korreoElektronikoaTextField);
        korreoElektronikoaTextField.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Datu basean sartu");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                PreparedStatement preparedStatement = null;

                try {
                    // Establecer la conexión a la base de datos
                    conexion = DriverManager.getConnection(URL, USER, PASSWORD);

                    // Preparar la consulta SQL con parámetros para evitar problemas de seguridad
                  
                    String izena = izenaTextField.getText();
                    String nan = nanTextField.getText();
                    String korreo = korreoElektronikoaTextField.getText();
                    
                    String bezeroakAlta = "INSERT INTO bytefruit.eroslea (Izena, NAN, Korreo) VALUES (?, ?, ?)";
                    preparedStatement = conexion.prepareStatement(bezeroakAlta);
                    preparedStatement.setString(1, izena);
                    preparedStatement.setString(2, nan);
                    preparedStatement.setString(3, korreo);
                    
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
    }
}
