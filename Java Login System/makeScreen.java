import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class makeScreen {
  Frame newPanel;

  public makeScreen() {
    this.newPanel = new Frame("Test");
    this.newPanel.setVisible(true);
  }

  public void screenProperties() {
    this.newPanel.setSize(400, 400);

    newPanel.addWindowListener (new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
