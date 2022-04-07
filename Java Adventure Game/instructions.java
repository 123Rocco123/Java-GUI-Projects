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
    informationPanel.setBounds(5, 30, 275, 280);

    information.append("The game is insipired off of 1980s text based\n adventure games.");
    information.append("The way that the game works is\n that you, the player, are prompted with a decision\n from the screen, and then you can write an action.");

    informationPanel.add(information);
    information.setBounds(0, 0, 275, 180);

    informationPanel.add(disposeButton);
    disposeButton.setBounds(85, 190, 100, 25);

    this.add(instructionsTitle);
    instructionsTitle.setBounds(110, 2, 100, 25);

    disposeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });

    this.setVisible(true);
  }
}
