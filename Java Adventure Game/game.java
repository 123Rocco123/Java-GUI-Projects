// Esc has keyCode 27

import javax.swing.*;

import java.awt.event.*;

class game extends JFrame implements KeyListener {
  public game() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // This makes it so that this JFrame will be able to listen to the keys on the keyboard.
    this.addKeyListener(this);

    this.setSize(500, 500);
    this.setResizable(false);
    this.setLayout(null);
    this.setLocation(750, 200);

    this.setVisible(true);
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {}

  @Override
  public void keyReleased(KeyEvent e) {
    
  }
}
