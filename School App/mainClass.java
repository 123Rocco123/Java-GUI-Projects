import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class mainClass extends JFrame {
  JPanel classesPanel = new JPanel();
  JPanel calendarPanel = new JPanel();
  JPanel reminderPanel = new JPanel();
  JPanel alertsPanel = new JPanel();
  JPanel homeWorkPanel = new JPanel();

  JButton exitButton = new JButton("Quit");

  public mainClass() {
    // JFrame Code
    this.setTitle("Rocco's School App");
    this.setSize(800, 500);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
