import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {

        setTitle("Login Page");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check login credentials here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                //For simplicity, let's consider a basic case where username is "user" and password is "pass"
                if (isValidLogin(username, password)) {
                    JOptionPane.showMessageDialog(Login.this, "Login Successful!");
                    // You can redirect to another page or perform other actions after successful login

                    //Redirect to the Dashboard
                    dispose(); // Close the current login frame
                    openDashboard();// Open the dashboard frame
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid Username or Password!");
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());// Empty label for spacing
        panel.add(loginButton);

        //Added padding around the panel
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panel);
    }

    private boolean isValidLogin(String username, String password) {
        // Add your authntication logic here
        // For simplicity, let's consider a basic case where username is "user" and password is "pass"
        return username.equals("user") && password.equals("pass");
    }

    private void openDashboard() {
        //Create and diplay the dashboard frame
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}

// Adding the DashboardPage class below Login in the same file
class DashboardPage extends JFrame {

    public DashboardPage() {
        setTitle("Dashboard");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel welcomeLabel = new  JLabel("Welcome to the Dashboard!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirect back to teh login page
                dispose();// Close the current dashboard frame
                openLogin();// Open the login frame
            }
        });

        panel.add(welcomeLabel);
        panel.add(new JLabel()); // Emptylabell for spacing
        panel.add(logoutButton);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panel);
    }

    private void openLogin() {
        //create and display the login frame
        Login login = new Login();
        login.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DashboardPage().setVisible(true);
        });
    }
}