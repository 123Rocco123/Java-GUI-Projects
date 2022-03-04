import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Error extends JFrame {
  JPanel newPanel = new JPanel();
  JLabel errorLabel = new JLabel("Error! No name!");
  JButton closeButton = new JButton("Close");

  public Error() {
    newPanel.setLayout(new GridBagLayout());

    this.setSize(200, 200);
    this.setLocation(850, 350);
    this.setVisible(true);

    GridBagConstraints c = new GridBagConstraints();

    c.gridheight = 1;
    c.gridwidth = 1;

    c.gridy = 0;
    newPanel.add(errorLabel, c);

    c.gridy = 1;
    newPanel.add(closeButton, c);

    this.add(newPanel);

    closeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
  }
}
