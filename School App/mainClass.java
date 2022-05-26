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

    classesPanel.setBounds(5, 10, 250, 200);
    classesPanel.setBackground(Color.white);
    this.add(classesPanel);

    alertsPanel.setBounds(265, 10, 250, 200);
    alertsPanel.setBackground(Color.white);
    this.add(alertsPanel);

    // X Y WIDTH HEIGHT
    homeWorkPanel.setBounds(525, 10, 250, 200);
    homeWorkPanel.setBackground(Color.white);
    this.add(homeWorkPanel);

    reminderPanel.setBounds(5, 220, 380, 200);
    reminderPanel.setBackground(Color.white);
    this.add(reminderPanel);

    calendarPanel.setBounds(395, 220, 380, 200);
    calendarPanel.setBackground(Color.white);
    this.add(calendarPanel);

    exitButton.setBounds(340, 430, 100, 25);
    this.add(exitButton);

    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }
}
