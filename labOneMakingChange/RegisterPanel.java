package labOneMakingChange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register;
    private JTextField inputField;
    private JTextArea changeDisplay;

    public RegisterPanel(Register register) {
        this.register = register;

        setLayout(new BorderLayout());

        // Input panel with label and text field
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(15);
        inputPanel.add(new JLabel("Enter amount:"));
        inputPanel.add(inputField);

        // Change display panel
        changeDisplay = new JTextArea(10, 20);
        changeDisplay.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(changeDisplay), BorderLayout.CENTER);

        inputField.addActionListener(new InputListener());
    }

    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(inputField.getText());
                Purse purse = register.makeChange(amount);
                changeDisplay.setText(purse.toString());
            } catch (NumberFormatException ex) {
                changeDisplay.setText("Please enter a valid amount!");
            }
        }
    }
}
