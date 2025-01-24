package labOneMakingChange;

import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel {
    private Purse purse;

   public PursePanel(){
        this.purse = new Purse();
    }

    // Method to update the purse and repaint the panel
    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    // Method to draw the purse contents
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (purse == null || purse.getValue() == 0) {
            g.drawString("Empty Purse", 10, 20);
        } else {
            g.drawString(purse.toString(), 10, 20);
        }
    }
}
