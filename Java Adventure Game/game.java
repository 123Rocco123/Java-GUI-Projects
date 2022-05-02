// Esc has keyCode 27

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class game implements KeyListener {
  JFrame frame = new JFrame("Indiana Jones and Golden Fleece");

  JPanel gameScreen = new JPanel();
  JPanel playerFace = new JPanel();
  JPanel playerInput = new JPanel();

  JTextArea textPlayerInput = new JTextArea();

  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  public game() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // This makes it so that this JFrame will be able to listen to the keys on the keyboard.
    frame.addKeyListener(this);

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
    textPlayerInput.setBounds(1, 1, 288, 98);
    playerInput.add(textPlayerInput);

    frame.add(playerInput);
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  // The function below is used to check if the user has pressed the esc key or not.
  @Override
  public void keyPressed(KeyEvent e) {
    switch(e.getKeyCode()) {
      // esc key condition
      case 27:
        optionsScreen optionsOpen = new optionsScreen();

        optionsOpen.addWindowListener(new WindowAdapter() {
          @Override
          public void windowClosing (WindowEvent e) {
            switch(optionsOpen.resolution123) {
              case ("Fullscreen"):
                frame.setSize(screenSize.width, screenSize.height);
                frame.setLocation(0,0);
                break;
              case ("Programmers Choice"):
                frame.setSize(500, 500);
                frame.setLocation(750, screenSize.height / 4);
                break;
              default:
                break;
            }
            frame.setVisible(true);
          }
        });

        frame.setVisible(false);
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {}
}
