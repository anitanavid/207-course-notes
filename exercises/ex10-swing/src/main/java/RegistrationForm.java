
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Exercise (Chapter 4: GUIs with Swing) — matching a layout.
 */
public class RegistrationForm {

    /**
     * Builds the registration form.
     *
     * @return the form's root panel
     */
    public static JPanel buildForm() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 1));

        JPanel firstNamePanel = new JPanel(new FlowLayout());
        firstNamePanel.add(new JLabel("First name:"));
        firstNamePanel.add(new JTextField(12));

        JPanel lastNamePanel = new JPanel(new FlowLayout());
        lastNamePanel.add(new JLabel("Last name:"));
        lastNamePanel.add(new JTextField(12));

        fieldsPanel.add(firstNamePanel);
        fieldsPanel.add(lastNamePanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(new JButton("Submit"));
        buttonPanel.add(new JButton("Cancel"));

        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    /** Shows the form in a window. */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    JFrame frame = new JFrame("Registration");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setContentPane(buildForm());
                    frame.pack();
                    frame.setVisible(true);
                });
    }
}
