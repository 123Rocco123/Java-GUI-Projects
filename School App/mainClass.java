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

    panelFunc(classesPanel, 5, 10, 250, 200, classesLabel, newClassButton);
    this.add(classesPanel);

    panelFunc(alertsPanel, 265, 10, 250, 200, alertsLabel, newAlertButton);
    this.add(alertsPanel);

    panelFunc(homeWorkPanel, 525, 10, 250, 200, homeworkLabel, newHomeworkButton);
    this.add(homeWorkPanel);

    panelFunc(reminderPanel, 5, 220, 380, 200, reminderLabel, newReminderButton);
    this.add(reminderPanel);

    panelFunc(calendarPanel, 395, 220, 380, 200, calendarLabel, addCalendarEventButton);
    this.add(calendarPanel);

    exitButton.setBounds(340, 430, 100, 25);
    this.add(exitButton);

    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }

  // Used for the setup of the panels onto the main JFrame
  public void panelFunc(JPanel panelName, int x, int y, int width, int height, JLabel name, JButton buttonName) {
    panelName.setBounds(x, y, width, height);
    panelName.setBackground(Color.white);
    panelName.setLayout(null);
    buttonName.setBounds((width / 2) - 65, (height - 35), 125, 25);
    panelName.add(buttonName);
  }
}
