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
    //display change
    private void displayChange(Purse purse) {
        JPanel imagePanel = new JPanel();
        imagePanel.removeAll();

        // Access the cash map in the purse
        Map<Denomination, Integer> cash = purse.getCash();

        // Iterate over the denominations and their counts
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            Denomination money = entry.getKey();
            int count = entry.getValue();

            String imageFile = money.img();

            for (int i = 0; i < count; i++) {
                ImageIcon icon = new ImageIcon(imageFile);
                JLabel label = new JLabel();
                label.setIcon(icon);
                imagePanel.add(label);
            }
        }

        // Revalidate and repaint the panel to display the images
        imagePanel.revalidate();
        imagePanel.repaint();
    }



    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(inputField.getText());
                Purse purse = register.makeChange(amount);
                changeDisplay.setText(purse.toString());
                displayChange(purse);
            } catch (NumberFormatException ex) {
                changeDisplay.setText("Please enter a valid amount!");
            }
        }
    }
}
