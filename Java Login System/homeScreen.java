import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class homeScreen extends JFrame{
  Button loginButton;
  Button createAccount;

  // Panel used to contain the buttons.
  Panel Buttons = new Panel();;

  public homeScreen() {
    // Set the title of the screen.
    this.setTitle("Home Screen");

    this.loginButton = new Button("Login");
    this.createAccount = new Button("Create Account");

    // Adding Buttons to the panels.
    (this.Buttons).add(this.loginButton);
    (this.Buttons).add(this.createAccount);

    this.add(this.Buttons);

    this.setLocation(750, 250);

    this.setSize(400, 400);
    this.setVisible(true);

    (this.loginButton).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        makeScreen newScreen = new makeScreen();
        newScreen.screenProperties();
      }
    });
  }

  // Close Function
  public void screenProperties() {
    this.addWindowListener (new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        dispose();
      }
    });
  }
}
