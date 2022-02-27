import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class createAccount extends JFrame{
  public createAccount() {
    this.setSize(400, 400);
    this.setVisible(true);

    this.setTitle("New Account");
    this.setLocation(750, 250);

    // Panel containing Labels, Textfields, and Button
    Panel createAccountPanel = new Panel();
    // New Username Label and Textfield
    JLabel userNameLabel = new JLabel("Enter Username Here:\n");
    JTextField userNameEnter = new JTextField(30);
    // New Password Label and Textfield
    JLabel passwordLabel = new JLabel("Enter Password Here:\n");
    JTextField passwordEnter = new JTextField(30);
    Button submit = new Button("Submit");

    // Panel username add
    createAccountPanel.add(userNameLabel);
    createAccountPanel.add(userNameEnter);
    // Panel password add
    createAccountPanel.add(passwordLabel);
    createAccountPanel.add(passwordEnter);
    // Panel Button add
    createAccountPanel.add(submit);

    this.add(createAccountPanel);
  }

  public void screenProperties() {
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        Main testObject = new Main();
        dispose();
      }
    });
  }
}
