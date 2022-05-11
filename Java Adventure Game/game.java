// Esc has keyCode 27

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class game {
  JFrame frame = new JFrame("Indiana Jones and Golden Fleece");

  JPanel gameScreen = new JPanel();
  JPanel playerFace = new JPanel();
  JPanel playerInput = new JPanel();

  JButton optionsButton = new JButton("Options");

  // These buttons are used to give players options
  JButton actionOne = new JButton();
  JButton actionTwo = new JButton();
  JButton actionThree = new JButton();

  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  public game() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setSize(500, 500);
    frame.setResizable(false);
    frame.setLayout(null);
    frame.setLocation(750, 200);

    frame.setVisible(true);

    gameScreen.setBounds(40, 10, 400, 300);
    gameScreen.setBorder(BorderFactory.createLineBorder(Color.black));
    frame.add(gameScreen);

    playerFace.setBounds(40, 320, 100, 100);
    playerFace.setBorder(BorderFactory.createLineBorder(Color.black));
    frame.add(playerFace);

    playerInput.setBounds(150, 320, 290, 100);
    playerInput.setBorder(BorderFactory.createLineBorder(Color.black));

    playerInput.setLayout(null);

    actionOne.setBounds(5, 7, 280, 25);
    actionTwo.setBounds(5, 37, 280, 25);
    actionThree.setBounds(5, 67, 280, 25);

    playerInput.add(actionOne);
    playerInput.add(actionTwo);
    playerInput.add(actionThree);

    frame.add(playerInput);

    optionsButton.setBounds(200, 425, 100, 25);
    frame.add(optionsButton);

    // The function below is used to check if the user has pressed the esc key or not.
    optionsButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          optionsScreen optionsOpen = new optionsScreen();

          optionsOpen.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
              frame.setVisible(true);
            }

            public void windowClosed(WindowEvent e) {
              switch(optionsOpen.resolution123) {
                case ("Fullscreen"):
                  frame.setSize(screenSize.width, screenSize.height);
                  frame.setLocation(0,0);
                  break;
                case ("Programmers Choice"):
                  frame.setSize(500, 500);
                  frame.setLocation(750, screenSize.height / 4);
                  break;
              }
              frame.setVisible(true);
            }
          });

          frame.setVisible(false);
      }
    });
  }
}
