import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Login extends JFrame {
  JPanel ButtonsPanel = new JPanel();
  JButton newFile = new JButton("New File");
  JButton openExistingFile = new JButton("Open File");

  public Login() {
    this.setSize(400,400);
    this.setLocation(750, 250);
    this.setVisible(true);
    this.setTitle("Home Screen");

    ButtonsPanel.add(newFile);
    this.add(ButtonsPanel);

    newFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        homeScreen mainScreen = new homeScreen();
        mainScreen.whatOpened = "new";
      }
    });

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
