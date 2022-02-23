import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class makeScreen extends JFrame{
  // It's important to note that we have to declare and initialize the instance variables as soon as the class is made.
     // This is because of the fact that if we don't, then they won't get rendered into the panel when the program runs until we resize the frame. 
  JTextField username = new JTextField(30);
  JTextField password;

  public makeScreen() {
    setTitle("Test");
    setVisible(true);
    // Width * Height
    setSize(400, 400);

    // The panel below is used to store the username.
    Panel userNamePanel = new Panel();
    JLabel userNameInfo = new JLabel("Enter Username:\n");

    userNamePanel.add(userNameInfo);
    userNamePanel.add(this.username);

    this.add(userNamePanel);
  }

  public void screenProperties() {
    this.addWindowListener (new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
