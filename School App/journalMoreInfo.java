import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class journalMoreInfo extends JFrame {
  JTextArea readArea = new JTextArea();

  public journalMoreInfo() {
    this.setSize(500, 500);
    this.setTitle("Journal Entries");
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
}
