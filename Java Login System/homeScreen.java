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

    // Adding buttons to the screen
    this.add(this.Buttons);

    // Setting the location where the screne will initially appear.
    this.setLocation(750, 250);
    // Screen basic properties
    this.setSize(400, 400);
    this.setVisible(true);

    // Login Button action Listener
    (this.loginButton).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        makeScreen newScreen = new makeScreen();
        newScreen.screenProperties();
      }
    });

    // Create Account Button Action Listener
    (this.createAccount).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("TBD");
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
