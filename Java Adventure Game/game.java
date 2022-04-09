// Esc has keyCode 27

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class game implements KeyListener {
  JFrame frame = new JFrame("Indiana Jones and Golden Fleece");

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
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {
    switch(e.getKeyCode()) {
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
