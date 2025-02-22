package labOneMakingChange;

import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Cinnacurrency!");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);

        Register register = new Register();
        RegisterPanel registerPanel = new RegisterPanel(register);
        registerPanel.setVisible(true);

        frame.add(registerPanel);
        frame.pack();
        frame.setVisible(true);
    }
}

