import GUI.*;

import javax.swing.*;

public class PhoneBookApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Dashboard().setVisible(true);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error initializing application: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}