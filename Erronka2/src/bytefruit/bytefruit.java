package bytefruit;

import java.awt.EventQueue;

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
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;

public class bytefruit extends JFrame {

    private static final long serialVersionUID = 1L;
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
                    bytefruit frame = new bytefruit();
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
    public bytefruit() {
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
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                char[] password = passwordField.getPassword();

                // Erabiltzailea eta pasahitza egiaztatu
                if (username.isEmpty() || password.length == 0) {
                    JOptionPane.showMessageDialog(bytefruit.this, "Erabiltzailea edo pasahitza jarri gabe", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    // Egiaztapena ondo atera ezkero
                    JOptionPane.showMessageDialog(bytefruit.this, "Validación exitosa");
                }
               
                if (username != null) {
                	
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
