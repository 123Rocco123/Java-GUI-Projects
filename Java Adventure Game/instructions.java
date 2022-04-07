import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class instructions extends JFrame {
  JTextArea information = new JTextArea(5, 30);

  JButton disposeButton = new JButton("Exit");

  JLabel instructionsTitle = new JLabel("Instructions");

  JPanel informationPanel = new JPanel();

  public instructions() {
    this.setLocation(850, 300);
    this.setSize(300, 300);
    this.setLayout(null);
    this.add(informationPanel);
    this.setResizable(false);

    information.setEditable(false);
    informationPanel.setLayout(null);
    informationPanel.setBounds(10, 10, 280, 280);
    informationPanel.setBounds(5, 30, 275, 280);
  }
}
