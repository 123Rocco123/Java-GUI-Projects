import javax.swing.*;

import java.awt.event.*;

class instructions extends JFrame {
  JTextArea information = new JTextArea();

  JPanel informationPanel = new JPanel();

  public instructions() {
    this.setLocation(750, 200);
    this.setSize(300, 300);
    this.setLayout(false);

    informationPanel.setLayout(null);
    informationPanel.setBounds(10, 10, 280, 280);
  }
}
