import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class gamepanel extends JFrame {
  JPanel gameScreen = new panel();

  String computerPiece = "";

  public gamepanel() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    this.setTitle("Tic Tac Toe");

    // Adding Panel to the Screen
    this.add(gameScreen);

    // Size and Location of Frame
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
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
