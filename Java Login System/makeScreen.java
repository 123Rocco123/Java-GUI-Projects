import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class makeScreen extends JFrame {
  // It's important to note that we have to declare and initialize the instance variables as soon as the class is made.
     // This is because of the fact that if we don't, then they won't get rendered into the panel when the program runs until we resize the frame.
  JTextField username = new JTextField(30);
  JPasswordField password = new JPasswordField(30);
  Button submitButton = new Button();

  public makeScreen() {
    setTitle("Test");
    setVisible(true);
    // Width * Height
    setSize(400, 400);

    // Action Listener (Username)
    (this.username).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if ((username.getText()).equals("Rocco")) {
          System.out.println("True");
        }
      }
    });

    // Action Listener (Password)
    (this.password).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Correct");
      }
    });

    // The panel below is used to store the username.
    Panel userNamePanel = new Panel();
    JLabel userNameInfo = new JLabel("Enter Username:\n");

    userNamePanel.add(userNameInfo);
    userNamePanel.add(this.username);

    // The panel and code below regards the password
    Panel userPassword = new Panel();
    JLabel passwordLabel = new JLabel("Enter password\n");

    userNamePanel.add(passwordLabel);
    userNamePanel.add(this.password);

    this.add(userPassword);

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
