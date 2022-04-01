import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class screen extends JFrame {
  public screen() {
    // Aestetics of Screen
    this.setTitle("The Adventures of Indiana Jones");
    this.setSize(500, 500);

    // The the location and visibility of the screen.
    this.setLocation(750, 200);
    this.setVisible(true);

    // Close the Application when the screen is closed.
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
