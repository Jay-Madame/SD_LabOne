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
    private final JPanel imagePanel;

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

        imagePanel = new JPanel();
        imagePanel.setLayout(new GridBagLayout());

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(changeDisplay), BorderLayout.CENTER);
        add(new JScrollPane(imagePanel), BorderLayout.SOUTH);

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

    private void displayImages(Purse purse) {
        imagePanel.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            String imageFile = denom.img();
            ImageIcon icon = new ImageIcon(imageFile);

            ImageIcon resizedImage = icon;
            if (denom.form().equals("bill")) {
                gbc.gridwidth = 2;
                Image image = icon.getImage();
                Image scaledImage = image.getScaledInstance(300, 100, java.awt.Image.SCALE_SMOOTH);
                resizedImage = new ImageIcon(scaledImage);
            } else if (denom.form().equals("coin")) {
                gbc.gridwidth = 1;
                Image image = icon.getImage();
                Image scaledImage = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
                resizedImage = new ImageIcon(scaledImage);
            }

            for (int i = 0; i < count; i++) {
                JLabel label = new JLabel(resizedImage);
                imagePanel.add(label, gbc);

                gbc.gridx++;

                if (gbc.gridx >= 5) {
                    gbc.gridx = 0;
                    gbc.gridy++;
                }
            }
        }

        imagePanel.revalidate();
        imagePanel.repaint();
    }
}
