import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class homeScreen extends JFrame {
  // The Panel below is used to store all the buttons that we're going to need for the game's homescreen.
  JPanel buttonsPanel = new JPanel();

  JButton startGameButton = new JButton("Start Game");

  public homeScreen() {
    // Aestetics of Screen
    this.setTitle("The Adventures of Indiana Jones");
    this.setSize(500, 500);

    // The the location and visibility of the screen.
    this.setLocation(750, 200);
    this.setVisible(true);

    // Layout of the Screen
    this.setLayout(null);

    // Close the Application when the screen is closed.
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Panel Code
    buttonsPanel.setBounds(150, 200, 150, 200);

    buttonsPanel.add(startGameButton);
    startGameButton.setBounds(75, 50, 10, 25);

    this.add(buttonsPanel);
  }
}
