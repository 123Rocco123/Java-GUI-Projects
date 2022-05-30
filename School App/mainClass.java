import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.Scanner;

class mainClass {
  JFrame mainFrame = new JFrame();

  // Used to contain the different functions of the App.
  JPanel classesPanel = new JPanel();
  JPanel calendarPanel = new JPanel();
  JPanel reminderPanel = new JPanel();
  JPanel alertsPanel = new JPanel();
  JPanel homeWorkPanel = new JPanel();

  // Used to display most recent Alert / Homework / ...
  JPanel innerClassesPanel = new JPanel();
  JPanel innerCalendarPanel = new JPanel();
  JPanel innerReminderPanel = new JPanel();
  JPanel innerAlertsPanel = new JPanel();
  JPanel innerHomeWorkPanel = new JPanel();

  JPanel scrollPane = new JPanel(new GridLayout(0, 1));
  JScrollPane scrollClassesPanel = new JScrollPane(scrollPane);

  // Names of the main JPanels
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
    initialCheckerFunc();
    // JFrame Code
    mainFrame.setTitle("Rocco's School App");
    mainFrame.setSize(800, 500);
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setVisible(true);
    mainFrame.setLayout(null);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Classes
    panelFunc(classesPanel, 5, 10, 250, 200, classesLabel, newClassButton);
    classesPanel.add(innerPanelFunc(10, 35, 230, 120, innerClassesPanel));
    innerClassesPanel.add(innerScrollPane(10, 20, 210, 100, scrollClassesPanel));
    innerLabel(20, 0, 200, 25, "Name of Class | Time Class Starts", innerClassesPanel);

    mainFrame.add(classesPanel);

    // Alert
    panelFunc(alertsPanel, 265, 10, 250, 200, alertsLabel, newAlertButton);
    alertsPanel.add(innerPanelFunc(10, 35, 230, 120, innerAlertsPanel));

    mainFrame.add(alertsPanel);

    // Homework
    panelFunc(homeWorkPanel, 525, 10, 250, 200, homeworkLabel, newHomeworkButton);
    homeWorkPanel.add(innerPanelFunc(10, 35, 230, 120, innerHomeWorkPanel));

    mainFrame.add(homeWorkPanel);

    // Reminder
    panelFunc(reminderPanel, 5, 220, 380, 200, reminderLabel, newReminderButton);
    reminderPanel.add(innerPanelFunc(10, 35, 360, 120, innerReminderPanel));

    mainFrame.add(reminderPanel);

    // Calendar
    panelFunc(calendarPanel, 395, 220, 380, 200, calendarLabel, addCalendarEventButton);
    calendarPanel.add(innerPanelFunc(10, 35, 360, 120, innerCalendarPanel));

    mainFrame.add(calendarPanel);

    // Exit Button
    exitButton.setBounds(340, 430, 100, 25);
    mainFrame.add(exitButton);

    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    newClassButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        classes newClass = new classes();

        (newClass.testFrame).addWindowListener(new WindowAdapter() {
          public void windowClosed(WindowEvent e) {
            if ((newClass.newClassFile).exists()) {
              scrollPane.add(new JLabel(newClass.className + ": " + newClass.timeClassStarts));

              // Used to re-fresh the page to display the new page.
              mainFrame.invalidate();
              mainFrame.validate();
              mainFrame.repaint();
            }
          }
        });
      }
    });

    addCalendarEventButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new calendar();
      }
    });

    newReminderButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new reminder();
      }
    });

    newAlertButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new alerts();
      }
    });

    newHomeworkButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new newHomework();
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

  // Used for the inner JPanels in the JPanels.
  public JPanel innerPanelFunc(int x, int y, int width, int height, JPanel panelName) {
    panelName.setBounds(x, y, width, height);
    panelName.setLayout(null);
    return panelName;
  }

  public JScrollPane innerScrollPane(int x, int y, int width, int height, JScrollPane name) {
    name.setBounds(x, y, width, height);
    return name;
  }

  public void innerLabel(int x, int y, int width, int height, String text, JPanel panelName) {
    JLabel info = new JLabel(text);

    info.setBounds(x, y, width, height);
    panelName.add(info);
  }

  // The function is used to check if there are any files in the directories.
     // If there are files, then it will add them to the scroll panes.
  public void initialCheckerFunc() {
    if (new File("./classes").list().length > 0) {
      String className = "";
      String classTime = "";

      for (int i = 0; i < new File("./classes").list().length; i++) {
      }
    }
  }
}
