import java.awt.*;
import javax.swing.*;

class homeScreen extends JFrame{
  Button loginButton;
  Button createAccount;

  Panel loginPanel;
  Panel createAccountPanel;

  public homeScreen() {
    this.loginPanel = new Panel();
    this.createAccountPanel = new Panel();

    this.loginButton = new Button("Login");
    this.createAccount = new Button("Create Account");

    (this.loginPanel).add(this.loginButton);
    this.add(this.createAccount);

    this.add(this.loginPanel);

    this.setSize(400, 400);
    this.setVisible(true);
  }
}
