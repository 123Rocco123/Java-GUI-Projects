import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class homeScreen extends JFrame {
  // The Panel below is used to store all the buttons that we're going to need for the game's homescreen.
  JPanel buttonsPanel = new JPanel();

  JButton startGameButton = new JButton("Start Game");
  JButton instructionsButton = new JButton("Instructions");
  JButton quitGame = new JButton("Quit");

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
       // X Y Width Height
    buttonsPanel.setBounds(175, 325, 150, 115);
    buttonsPanel.setLayout(null);
    buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    buttonsPanel.add(startGameButton);
    startGameButton.setBounds(22, 10, 105, 25);

    buttonsPanel.add(instructionsButton);
    instructionsButton.setBounds(22, 45, 105, 25);

    buttonsPanel.add(quitGame);
    quitGame.setBounds(22, 80, 105, 25);

    // Start Game Action Listener
    startGameButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        game newGameStart = new game();

        // This will start the game, as well as 
        newGameStart.actionFunc();
      }
    });

    // Instructions Action Listner
    instructionsButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        instructions newInstructions = new instructions();
      }
    });

    // Close the game when the exit button has been pressed.
    quitGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    this.add(buttonsPanel);
  }
}
