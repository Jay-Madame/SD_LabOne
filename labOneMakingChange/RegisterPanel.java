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
                double amount = Double.parseDouble(inputField.getText());

                Purse purse = register.makeChange(amount);

                changeDisplay.setText(purse.toString());

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
        imagePanel.removeAll();


        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            String imageFile = denom.img();
            ImageIcon icon = new ImageIcon(imageFile);

            ImageIcon resizedImage = icon;
            if (denom.form().equals("bill")) {
                Image image = icon.getImage();
                Image scaledImage = image.getScaledInstance(300, 100, java.awt.Image.SCALE_SMOOTH);
                resizedImage = new ImageIcon(scaledImage);
            }

            if (denom.form().equals("coin")) {
                Image image = icon.getImage();
                Image scaledImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                resizedImage = new ImageIcon(scaledImage);
            }

            for (int i = 0; i < count; i++) {
                JLabel label = new JLabel(resizedImage);
                imagePanel.add(label);
            }
        }

        imagePanel.revalidate();
        imagePanel.repaint();
    }
}
