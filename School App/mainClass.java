import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import java.io.*;
import java.util.*;
import java.text.*;
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

  // Panes and ScrollPanes for Notifications on the Main Page
  JPanel scrollPane = new JPanel(new GridLayout(0, 1));
  JScrollPane scrollClassesPanel = new JScrollPane(scrollPane);

  JPanel scrollPaneHW = new JPanel(new GridLayout(0, 1));
  JScrollPane scrollHomeworkPanel = new JScrollPane(scrollPaneHW);

  JPanel scrollPaneRem = new JPanel(new GridLayout(0, 1));
  JScrollPane scrollReminderPanel = new JScrollPane(scrollPaneRem);

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

  // Extra Buttons
  JButton alertsMoreInformation = new JButton("More Information");

  // Quit Button
  JButton exitButton = new JButton("Quit");

  public mainClass() {
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
    innerHomeWorkPanel.add(innerScrollPane(10, 20, 210, 100, scrollHomeworkPanel));
    innerLabel(30, 0, 200, 25, "Homework | Class | Due Date", innerHomeWorkPanel);

    mainFrame.add(homeWorkPanel);

    // Reminder
    panelFunc(reminderPanel, 5, 220, 380, 200, reminderLabel, newReminderButton);
    reminderPanel.add(innerPanelFunc(10, 35, 360, 120, innerReminderPanel));
    innerReminderPanel.add(innerScrollPane(10, 20, 340, 100, scrollReminderPanel));
    innerLabel(125, 0, 200, 25, "Reminder | Due Date", innerReminderPanel);

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
        reminder reminderClass = new reminder();

        // Used to convert the reminder alert date to a date data type.
        reminderClass.reminderFrame.addWindowListener(new WindowAdapter() {
          public void windowClosed(WindowEvent closed) {
            if (!reminderClass.dateField.getText().equals("")) {
              Date convertedTime = new Date();

              scrollPaneRem.add(new Label(reminderClass.reminder.getText() + " | " + convertedTime));

              // Used to re-fresh the page to display the new page.
              mainFrame.invalidate();
              mainFrame.validate();
              mainFrame.repaint();
              try {
                convertedTime = new SimpleDateFormat("MM/dd/yyyy").parse(reminderClass.dateField.getText());
              } catch (ParseException ex) {}

              Timer timer = new Timer();

              TimerTask task = new TimerTask() {
                @Override
                public void run() {
                  JOptionPane.showMessageDialog(mainFrame, "Alert! " + reminderClass.reminder.getText());
                }
              };
              timer.schedule(task, convertedTime);
            }
          }
        });
      }
    });

    newAlertButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new alerts();
      }
    });

    newHomeworkButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        newHomework addNewHomework = new newHomework();

        (addNewHomework.homeworkFrame).addWindowListener(new WindowAdapter() {
          public void windowClosed(WindowEvent e) {
            if ((addNewHomework.newHomeworkFile).exists()) {
              scrollPaneHW.add(new JLabel(addNewHomework.newHomework.getText() + ": " + addNewHomework.homeworkClass.getText() + ": " + addNewHomework.dueDate.getText()));

              // Used to re-fresh the page to display the new page.
              mainFrame.invalidate();
              mainFrame.validate();
              mainFrame.repaint();
            }
          }
        });
      }
    });

    // Initial Function for the saved alerts and stuff.
    initialCheckerFunc();

    // Used to re-fresh page.
    mainFrame.invalidate();
    mainFrame.validate();
    mainFrame.repaint();
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
    name.setBorder(BorderFactory.createLineBorder(Color.black));
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
    // Used for files in classes directory
    if (new File("./classes").list().length > 0) {
      String className = "";
      String classTime = "";

      for (int i = 0; i < new File("./classes").list().length; i++) {
        try {
          // Make sure to change the directory to the classes folder.
             // And then pass in each of the file name's for a list.
          File file = new File("./classes", new File("./classes").list()[i]);

          // Used to read the file
          Scanner fileReader = new Scanner(file);

          while(fileReader.hasNextLine()) {
            String test = fileReader.nextLine();

            if (test.contains("Class: ")) {
              className = test.replace("Class: ", "");
            } else if (test.contains("Time Class Starts: ")) {
              classTime = test.replace("Time Class Starts: ", "");
            }
          }
          // JLabel used to append to the scroll pane for saved classes that the user added in previous sections.
          JLabel newLabel = new JLabel(className + " | " + classTime);
          scrollPane.add(newLabel);

        } catch (FileNotFoundException e) {}
      }
    }

    // Used for files in homework directory
    if (new File("./homework").list().length > 0) {
      for (int i = 0; i < new File("./homework").list().length; i++) {
        try {
          String labelString = "";

          File fileToWrite = new File("./homework", new File("./homework").list()[i]);

          Scanner fileReader = new Scanner(fileToWrite);

          while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            if (line.contains("Homework: ")) {
              line = line.replace("Homework: ", "");

              labelString += (line);
            } else if (line.contains("Class: ")) {
              line = line.replace("Class: ", "");

              labelString += (" | " + line);
            } else if (line.contains("Due Date: ")) {
              line = line.replace("Due Date: ", "");

              labelString += (" | " + line);
            }
          }
          scrollPaneHW.add(new JLabel(labelString));

        } catch (FileNotFoundException e) {}
      }
    }
  }
}
