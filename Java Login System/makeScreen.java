import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class makeScreen extends JFrame {
  // It's important to note that we have to declare and initialize the instance variables as soon as the class is made.
     // This is because of the fact that if we don't, then they won't get rendered into the panel when the program runs until we resize the frame.
  JTextField username = new JTextField(30);
  JPasswordField password = new JPasswordField(30);
  Button submitButton = new Button("Submit");

  public makeScreen() {
    setTitle("Test");
    setVisible(true);
    // Width * Height
    setSize(400, 175);

    // Submit Button Action Listener
    (this.submitButton).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if ((username.getText()).equals("") || (password.getText()).equals("")) {
          username.setText("Incorrect User or Password");
        }
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
    userNamePanel.add(this.submitButton);

    this.add(userPassword);

    this.add(userNamePanel);
  }

  public void screenProperties() {
    this.addWindowListener (new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        dispose();
      }
    });
  }
}
