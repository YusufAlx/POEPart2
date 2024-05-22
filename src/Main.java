//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // Database to store user credentials and names
    private static Map<String, String[]> userDatabase = new HashMap<>();
// This is the menu that the user will interact with to choose between signing up, logging in and exiting.
    public static void main(String[] args) {
        while (true) {
            String[] options = {"Sign Up", "Login", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Welcome! Choose an option:", "Login System", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    signUp();
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Goodbye.");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }
// this checks if the username meets the requirements of being 5 characters long and contains an underscore.
    private static boolean checkUserName(String username) {
        return username != null && username.length() <= 5 && username.contains("_");
    }
// this checks if the password is 8 characters long, has a capital letter, has a number and a special character.
    private static boolean checkPasswordComplexity(String password) {
        return password != null && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*");
    }
// this handles the registration process of the users and reflects if the username is correctly formatted.
    private static String registerUser(String firstName, String lastName, String username, String password) {
        if (!checkUserName(username)) {
            return "The username is incorrectly formatted";
        } else if (!checkPasswordComplexity(password)) {
            return "The password doesn't meet complexity requirements";
        } else {
            if (userDatabase.containsKey(username)) {
                return "Username already exists. Please choose a different one.";
            } else {
                userDatabase.put(username, new String[]{firstName, lastName, password});
                return "User successfully registered!";
            }
        }
    }
// this checks if the login details match with anything stored in the database
    private static boolean loginUser(String username, String password) {
        if (username != null && password != null && userDatabase.containsKey(username)) {
            String[] userData = userDatabase.get(username);
            String storedPassword = userData[2];
            return password.equals(storedPassword);
        }
        return false;
    }
// this returns if the login was successful or not
    private static String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            String[] userData = userDatabase.get(username);
            String firstName = userData[0];
            String lastName = userData[1];
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again!";
        } else {
            return "Username or password incorrect. Please try again.";
        }
    }
// this is what allows the user to input their details
    private static void signUp() {
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        String registrationStatus = registerUser(firstName, lastName, username, password);
        JOptionPane.showMessageDialog(null, registrationStatus);
    }
// this allows the user to enter their login details
    private static void login() {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        String loginStatus = returnLoginStatus(username, password);
        JOptionPane.showMessageDialog(null, loginStatus);
    }
}