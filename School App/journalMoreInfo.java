import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class journalMoreInfo {
  JTextArea readArea = new JTextArea();

  JFrame moreInfoFrame = new JFrame("Journal Entries");

  public journalMoreInfo() {
    moreInfoFrame.setSize(500, 500);
    moreInfoFrame.setLocationRelativeTo(null);
    moreInfoFrame.setVisible(true);

  }
}
