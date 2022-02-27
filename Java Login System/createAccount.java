import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class createAccount extends JFrame{
  public createAccount() {
    this.setSize(400, 400);
    this.setVisible(true);

    this.setTitle("New Account");
    this.setLocation(750, 250);
  }

  public void screenProperties() {
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        dispose();
      }
    });
  }
}
