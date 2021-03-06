import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class makeScreen extends JFrame {
  // It's important to note that we have to declare and initialize the instance variables as soon as the class is made.
     // This is because of the fact that if we don't, then they won't get rendered into the panel when the program runs until we resize the frame.
  JTextField username = new JTextField(30);
  JPasswordField password = new JPasswordField(30);
  Button cancelButton = new Button("Cancel");
  Button submitButton = new Button("Submit");

  public makeScreen() {
    setTitle("Login");
    setVisible(true);
    // Width * Height
    setSize(400, 175);

    // Set the location of where the screen will be displayed initially.
    this.setLocation(750, 350);

    // Submit Button Action Listener
    (this.submitButton).addActionListener(new ActionListener() {
      Main variables = new Main();

      public void actionPerformed(ActionEvent e) {
        if ((username.getText()).equals("") || (password.getText()).equals("")) {
          username.setText("Enter Username and/or Password");
        } else if (username.getText().equals(variables.userName) && password.getText().equals(variables.password)) {
          dispose();

          homeScreen homeScreenArea = new homeScreen();
          (homeScreenArea.textArea).append("Account login successful!\nWelcome, " + variables.userName + "!");
          homeScreenArea.screenProperties();
        }
      }
    });

    // Cancel Button Action Listener
    (this.cancelButton).addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();

        homeScreen backEvent = new homeScreen();
        backEvent.screenProperties();
      }
    });

    // The panel below is used to store the username.
    Panel userNamePanel = new Panel();
    JLabel userNameInfo = new JLabel("Enter Username:\n");

    userNamePanel.add(userNameInfo);
    userNamePanel.add(this.username);

    // The panel and code below regards the password
    JLabel passwordLabel = new JLabel("Enter password\n");

    userNamePanel.add(passwordLabel);
    userNamePanel.add(this.password);
    userNamePanel.add(this.submitButton);
    userNamePanel.add(this.cancelButton);

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
