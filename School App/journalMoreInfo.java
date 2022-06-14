import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class journalMoreInfo {
  JTextArea readArea = new JTextArea();

  JButton closeButton = new JButton("Close");

  JFrame moreInfoFrame = new JFrame("Journal Entries");

  public journalMoreInfo(String fileName) {
    moreInfoFrame.setSize(500, 500);
    moreInfoFrame.setLocationRelativeTo(null);
    moreInfoFrame.setLayout(null);
    moreInfoFrame.setVisible(true);

    readArea.setBounds(10, 10, 480, 400);
    moreInfoFrame.add(readArea);

    closeButton.setBounds(200, 420, 100, 25);
    moreInfoFrame.add(closeButton);

    // Close Button Action Listener
    closeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        moreInfoFrame.dispose();
      }
    });
  }
}
