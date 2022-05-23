import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class panel extends JPanel {
  public panel() {
    this.setPreferredSize(new Dimension(300, 300));
  }

  // Paint Function
     // Used to draw the graphics on the screen
  public void paint(Graphics g) {
    // Used to convert the regular graphics to newer Graphics2D.
    Graphics2D g2D = (Graphics2D) g;

    // Vertical Lines
    g2D.drawLine(100, 0, 100, 300);
    g2D.drawLine(200, 0, 200, 300);

    // Horizontal Lines
    g2D.drawLine(0, 100, 300, 100);
    g2D.drawLine(0, 200, 300, 200);
  }
}
