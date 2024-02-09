package bytefruit;

import java.lang.String;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

public class Bytefruit extends JFrame {

    private static final long serialVersionUID = 1L;
	protected static final String URL = "jdbc:mysql://localhost:3306/bytefruit";
	protected static final String USER = "root";
	protected static final String PASSWORD = "1WMG2023";
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Bytefruit frame = new Bytefruit();
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
    public Bytefruit() {
    	setTitle("Logina");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 513, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Erabiltzailea");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(183, 105, 96, 13);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(183, 122, 90, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Pasahitza");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(204, 161, 55, 13);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Saioa hasi");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarUsuario();
            }

            private void validarUsuario() {
                String username = textField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Lógica de validación con la base de datos
                if (verificarEnBaseDeDatos(username, password)) {
                    JOptionPane.showMessageDialog(Bytefruit.this, "Login exitoso");
                    
                    Menu oforma = new Menu();
                    oforma.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(Bytefruit.this, "Login fallido. Verifica tus credenciales.");
                }
            }

            // Método para verificar en la base de datos
            private boolean verificarEnBaseDeDatos(String username, String password) {
                try {
                    // Establecer la conexión
                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

                    // Crear la consulta parametrizada
                    String query = "SELECT * FROM langileak WHERE NAN = ? AND PK = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, username);
                        preparedStatement.setString(2, password);

                        // Ejecutar la consulta
                        ResultSet resultSet = preparedStatement.executeQuery();

                        // Verificar si se encontró un resultado
                        return resultSet.next();
                    }
                } catch (SQLException e) {
                    e.printStackTrace(); // Manejar las excepciones adecuadamente en un entorno de producción
                    return false;
                }
            }
        });
        btnNewButton.setBounds(183, 232, 96, 21);
        contentPane.add(btnNewButton);

        passwordField = new JPasswordField();
        passwordField.setBounds(183, 182, 90, 19);
        contentPane.add(passwordField);
    }
}
