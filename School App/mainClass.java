import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class mainClass extends JFrame {
  // Used to contain the different functions of the App.
  JPanel classesPanel = new JPanel();
  JPanel calendarPanel = new JPanel();
  JPanel reminderPanel = new JPanel();
  JPanel alertsPanel = new JPanel();
  JPanel homeWorkPanel = new JPanel();

  // Used to display most recent Alert / Homework / ...
  JLabel classesLabel = new JLabel("Classes");
  JLabel calendarLabel = new JLabel("Calendar");
  JLabel reminderLabel = new JLabel("Reminders");
  JLabel alertsLabel = new JLabel("Alerts");
  JLabel homeworkLabel = new JLabel("Homework");

  // JFrame Buttons
  JButton newClassButton = new JButton("Add New Class");
  JButton addCalendarEventButton = new JButton("New Event");
  JButton newReminderButton = new JButton("New Reminder");
  JButton newAlertButton = new JButton("Add New Alert");
  JButton newHomeworkButton = new JButton("Add Homework");

  // Quit Button
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

  // Used for the setup of the panels onto the main JFrame.
  public void panelFunc(JPanel panelName, int x, int y, int width, int height, JLabel name, JButton buttonName) {
    panelName.setBounds(x, y, width, height);
    panelName.setBackground(Color.white);
    panelName.setLayout(null);

    if (buttonName.equals(addCalendarEventButton)) {
      name.setBounds((width / 2) - 27, 10, 100, 25);
    } else if (buttonName.equals(newReminderButton) || buttonName.equals(newHomeworkButton)) {
      name.setBounds((width / 2) - 30, 10, 100, 25);
    } else if (buttonName.equals(newAlertButton)) {
      name.setBounds((width / 2) - 21, 10, 100, 25);
    } else {
      name.setBounds((width / 2) - 25, 10, 100, 25);
    }
    panelName.add(name);

    buttonName.setBounds((width / 2) - 65, (height - 35), 125, 25);
    panelName.add(buttonName);
  }
}
