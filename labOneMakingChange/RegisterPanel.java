package labOneMakingChange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class RegisterPanel extends JPanel {
    private final Register register;
    private final JTextField inputField;
    private final JTextArea changeDisplay;
    private final JPanel imagePanel; // Panel to display images

    public RegisterPanel(Register register) {
        this.register = register;

        setLayout(new BorderLayout());

        // Input panel with label and text field
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(20);
        inputPanel.add(new JLabel("Enter amount:"));
        inputPanel.add(inputField);

        // Change display panel
        changeDisplay = new JTextArea(10, 20);
        changeDisplay.setEditable(false);

        // Image display panel
        imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout());

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(changeDisplay), BorderLayout.CENTER);
        add(imagePanel, BorderLayout.SOUTH);

        inputField.addActionListener(new InputListener());
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Parse the input amount
                double amount = Double.parseDouble(inputField.getText());

                // Call register to get the purse with change
                Purse purse = register.makeChange(amount);

                // Update text area with the change description
                changeDisplay.setText(purse.toString());

                // Update image panel with images of the denominations
                displayImages(purse);

            } catch (NumberFormatException ex) {
                changeDisplay.setText("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException ex) {
                changeDisplay.setText(ex.getMessage());
            }
        }
    }

    // Method to display images of the denominations in the purse
    private void displayImages(Purse purse) {
        imagePanel.removeAll(); // Clear previous images

        // Loop through the purse's denominations and their counts
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            // Load and display the image for each denomination
            String imageFile = denom.img(); // Path to the image file
            ImageIcon icon = new ImageIcon(imageFile);

            for (int i = 0; i < count; i++) {
                JLabel label = new JLabel(icon);
                imagePanel.add(label);
            }
        }

        imagePanel.revalidate();
        imagePanel.repaint();
    }
}
