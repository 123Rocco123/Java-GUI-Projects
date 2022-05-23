import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class gamepanel extends JFrame {
  JPanel gameScreen = new JPanel();

  public gamepanel() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);

    // Adding Panel to the Screen
    this.add(gameScreen);
    gamePanel();

    // Size and Location of Frame
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  // Panel Function
  public void gamePanel() {
    gameScreen.setBackground(Color.black);
    gameScreen.setPreferredSize(new Dimension(500, 500));
  }

  public void gameAlgorithm(String playerChoice) {
    switch (playerChoice) {
        case "X":
          break;
        case "O":
          break;
        default:
          break;
    }
  }
}
