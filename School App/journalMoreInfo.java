import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class journalMoreInfo {
  JTextArea readArea = new JTextArea();

  JButton closeButton = new JButton("Close");

  JFrame moreInfoFrame = new JFrame("Journal Entries");

  public journalMoreInfo() {
    moreInfoFrame.setSize(500, 500);
    moreInfoFrame.setLocationRelativeTo(null);
    moreInfoFrame.setVisible(true);

    closeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        moreInfoFrame.dispose();
      }
    });
  }
}
