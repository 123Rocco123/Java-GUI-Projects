import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class Login extends JFrame {
  JPanel ButtonsPanel = new JPanel();
  JButton newFile = new JButton("New File");
  JButton openExistingFile = new JButton("Open File");
  JTextArea information = new JTextArea("Hello,\n\nMy name is Rocco Petruccio, and this is the first \"app\" \nwhich I've created.\n\nI hope that you enjoy it.", 10, 30);

  public Login() {
    this.setSize(400,400);
    this.setLocation(750, 250);
    this.setVisible(true);
    this.setTitle("Home Screen");

    ButtonsPanel.add(information);
    ButtonsPanel.add(newFile);
    ButtonsPanel.add(openExistingFile);
    this.add(ButtonsPanel);

    // The code below is used to dipose of the current window, when the "Open File" button is pressed.
    openExistingFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        homeScreen mainScreen = new homeScreen();
        mainScreen.whatOpened = "existing";
      }
    });

    // The code below is used to dipose of the current window, when the "New File" button is pressed.
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
