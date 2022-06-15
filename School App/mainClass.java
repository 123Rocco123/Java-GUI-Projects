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
import javax.swing.JComboBox;

import java.io.*;
import java.util.*;
import java.text.*;

class mainClass {
  JFrame mainFrame = new JFrame();

  // Used to contain the different functions of the App.
  JPanel classesPanel = new JPanel();
  JPanel calendarPanel = new JPanel();
  JPanel reminderPanel = new JPanel();
  JPanel journalPanel = new JPanel();
  JPanel homeWorkPanel = new JPanel();

  // Used to display most recent Journal / Homework / ...
  JPanel innerClassesPanel = new JPanel();
  JPanel innerCalendarPanel = new calendar();
  JPanel innerReminderPanel = new JPanel();
  JPanel innerJournalPanel = new JPanel();
  JPanel innerHomeWorkPanel = new JPanel();

  // Panes and ScrollPanes for Notifications on the Main Page
  JPanel scrollPane = new JPanel(new GridLayout(0, 1));
  JScrollPane scrollClassesPanel = new JScrollPane(scrollPane);

  JPanel scrollPaneHW = new JPanel(new GridLayout(0, 1));
  JScrollPane scrollHomeworkPanel = new JScrollPane(scrollPaneHW);

  JPanel scrollPaneRem = new JPanel(new GridLayout(0, 1));
  JScrollPane scrollReminderPanel = new JScrollPane(scrollPaneRem);

  JPanel scrollPaneJournal = new JPanel(new GridLayout(0, 1));
  JScrollPane scrollJournalPanel = new JScrollPane(scrollPaneJournal);

  // Names of the main JPanels
  JLabel classesLabel = new JLabel("Classes");
  JLabel calendarLabel = new JLabel("Calendar");
  JLabel reminderLabel = new JLabel("Reminders");
  JLabel journalLabel = new JLabel("Journal");
  JLabel homeworkLabel = new JLabel("Homework");

  // JFrame Buttons
  JButton newClassButton = new JButton("Add New Class");
  JButton newReminderButton = new JButton("New Reminder");
  JButton newJournalButton = new JButton("New Journal");
  JButton newHomeworkButton = new JButton("Add Homework");

  // Expanded Information Button
  JButton classMoreInfo = new JButton("More Info");

  // Delete and Complete Buttons
  JButton homeworkDelete = new JButton("More Info");
  // Quit Button
  JButton exitButton = new JButton("Quit");

  // Used to contain the JComboBox for Journal Initial Setup.
     // Using a gloabl variable because of "inner class must be final or effectively final" error.
  JComboBox comboBoxToAdd = new JComboBox();

  // Used to contain the reminder message for the initialize function.
     // Using a gloabl variable because of "inner class must be final or effectively final" error.
  String reminderString = "";

  public mainClass() {
    // JFrame Code
    mainFrame.setTitle("Rocco's School App");
    mainFrame.setSize(800, 500);
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setVisible(true);
    mainFrame.setLayout(null);
    mainFrame.setResizable(false);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Classes
    panelFunc(classesPanel, 5, 10, 250, 200, classesLabel, newClassButton, classMoreInfo);
    classesPanel.add(innerPanelFunc(10, 35, 230, 120, innerClassesPanel));
    innerClassesPanel.add(innerScrollPane(10, 20, 210, 100, scrollClassesPanel));
    innerLabel(20, 0, 200, 25, "Name of Class | Time Class Starts", innerClassesPanel);

    mainFrame.add(classesPanel);

    // Journal
    panelFunc(journalPanel, 265, 10, 250, 200, journalLabel, newJournalButton);
    journalPanel.add(innerPanelFunc(10, 35, 230, 120, innerJournalPanel));
    innerJournalPanel.add(innerScrollPane(10, 20, 210, 100, scrollJournalPanel));
    innerLabel(60, 0, 200, 25, "Journal Entry | Date", innerJournalPanel);

    mainFrame.add(journalPanel);

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
    panelFunc(calendarPanel, 395, 220, 380, 200, calendarLabel);
    calendarPanel.add(innerCalendarPanel);

    mainFrame.add(calendarPanel);

    refreshFunc();

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

              refreshFunc();
            }
          }
        });
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

              refreshFunc();

              try {
                convertedTime = new SimpleDateFormat("MM/dd/yyyy").parse(reminderClass.dateField.getText());
              } catch (ParseException ex) {}

              Timer timer = new Timer();

              TimerTask task = new TimerTask() {
                @Override
                public void run() {
                  JOptionPane.showMessageDialog(mainFrame, "Journal! " + reminderClass.reminder.getText());
                }
              };
              timer.schedule(task, convertedTime);
            }
          }
        });
      }
    });

    // Action Listener for Journal Panel
    newJournalButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        journal newEntry = new journal();

        // Window Listener for Journal Frame
        newEntry.journalFrame.addWindowListener(new WindowAdapter() {
          public void JComboBoxSetup() {
            String[] entriesArray = new String[new File("./alerts").list().length + 1];

            entriesArray[0] = "";
            for (int i = 0; i < new File("./alerts").list().length; i++) {
              String toAdd = new File("./alerts").list()[i];

              if (toAdd.contains(".txt")) {
                toAdd = toAdd.replace(".txt", "");

                entriesArray[i + 1] = toAdd;
              }
            }

            comboBoxToAdd = new JComboBox(entriesArray);
            scrollPaneJournal.add(comboBoxToAdd);
          }

          public void deleted() {
            scrollPaneJournal.removeAll();

            JComboBoxSetup();

            refreshFunc();
          }

          public void windowClosed(WindowEvent e) {
            if (new File("./alerts").list().length > 0) {
              scrollPaneJournal.removeAll();

              JComboBoxSetup();

              JButton chooseButton = new JButton("Choose");
              chooseButton.setBounds(140, 165, 100, 25);
              journalPanel.add(chooseButton);

              newJournalButton.setBounds(10, 165, 120, 25);

              // Used to read the selected journal entry
              chooseButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  if (!comboBoxToAdd.getSelectedItem().equals("")) {
                    String line = (String)(comboBoxToAdd.getSelectedItem());

                    journalMoreInfo newInstance = new journalMoreInfo(line);

                    (newInstance.moreInfoFrame).addWindowListener(new WindowAdapter() {
                      public void windowClosed(WindowEvent event) {
                        deleted();
                      }
                    });
                  }
                }
              });
            }

            refreshFunc();
          }
        });
      }
    });

    newHomeworkButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        newHomework addNewHomework = new newHomework();

        (addNewHomework.homeworkFrame).addWindowListener(new WindowAdapter() {
          public void windowClosed(WindowEvent e) {
            if ((addNewHomework.newHomeworkFile).exists()) {
              scrollPaneHW.add(new JLabel(addNewHomework.newHomework.getText() + ": " + addNewHomework.homeworkClass.getText() + ": " + addNewHomework.dueDate.getText()));

              // Width = 250 Height = 200

              // New Homework Button Re-Formatting
              newHomeworkButton.setBounds(10, 165, 110, 25);
              newHomeworkButton.setText("New HW");

              // Delete Button Formatting
              homeworkDelete.setBounds(130, 165, 110, 25);
              homeWorkPanel.add(homeworkDelete);

              // Create a new instance of the delete homework JFrame
              homeworkDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  
                }
              });

              refreshFunc();
            }
          }
        });
      }
    });

    // Extra Info Button Listeners
    classMoreInfo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        expandedClasses furtherInformation = new expandedClasses();

        // Clear and re-set the JScrollPane
        (furtherInformation.expandedClassesFrame).addWindowListener(new WindowAdapter() {
          public void windowClosed(WindowEvent e) {
            panelClearerFunc();
            initialCheckerFunc();

            refreshFunc();
          }
        });
      }
    });

    // Initial Function for the saved journal and stuff.
    initialCheckerFunc();

    refreshFunc();
  }

  public void refreshFunc() {
    // Used to re-fresh page.
    mainFrame.invalidate();
    mainFrame.validate();
    mainFrame.repaint();
  }

  // Used for the setup of the panels onto the main JFrame.
  public void panelFunc(JPanel panelName, int x, int y, int width, int height, JLabel name, JButton buttonName, JButton moreInfoButton) {
    panelName.setBounds(x, y, width, height);
    panelName.setBackground(Color.white);
    panelName.setLayout(null);

    if (buttonName.equals(newHomeworkButton)) {
      name.setBounds((width / 2) - 30, 10, 100, 25);
    } else if (buttonName.equals(newJournalButton)) {
      name.setBounds((width / 2) - 21, 10, 100, 25);
    } else {
      name.setBounds((width / 2) - 25, 10, 100, 25);
    }
    panelName.add(name);

    buttonName.setBounds((width / 2) - 115, (height - 35), 125, 25);
    moreInfoButton.setBounds((width / 2) + 20, (height - 35), 100, 25);

    panelName.add(buttonName);
    panelName.add(moreInfoButton);
  }

  // Used for the setup of the Panel with 1 button instead of 2.
     // Overload
  public void panelFunc(JPanel panelName, int x, int y, int width, int height, JLabel name, JButton buttonName) {
    panelName.setBounds(x, y, width, height);
    panelName.setBackground(Color.white);
    panelName.setLayout(null);

    if (buttonName.equals(newReminderButton)) {
      name.setBounds(160, 10, 100, 25);
    } else {
      name.setBounds((width / 2) - 25, 10, 100, 25);
    }
    panelName.add(name);

    buttonName.setBounds((width / 2) - 65, (height - 35), 125, 25);
    panelName.add(buttonName);
  }

  // Used for the setup of the Panel with no buttons.
     // Overload
  public void panelFunc(JPanel panelName, int x, int y, int width, int height, JLabel name) {
    panelName.setBounds(x, y, width, height);
    panelName.setBackground(Color.white);
    panelName.setLayout(null);

    name.setBounds((width / 2) - 25, 10, 100, 25);
    panelName.add(name);
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

  // Clear Panels
  public void panelClearerFunc() {
    scrollPane.removeAll();
    scrollPaneHW.removeAll();
    scrollPaneRem.removeAll();
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

          fileReader.close();
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

          fileReader.close();
        } catch (FileNotFoundException e) {}
      }
    }

    // Used for the Reminder directory
    if (new File("./reminder").list().length > 0) {
      for (int i = 0; i < new File("./reminder").list().length; i++) {
        try {
          File fileToRead = new File("./reminder", new File("./reminder").list()[i]);

          Scanner fileReader = new Scanner(fileToRead);

          Date convertedTime = new Date();

          String LabelLine = "";
          String alertDate = "";

          while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            if (line.contains("Reminder: ")) {
              line = line.replace("Reminder: ", "");
              LabelLine += line;

              reminderString = line;
            } else if (line.contains("Time: ")) {
              line = line.replace("Time: ", "");
              LabelLine += (" | " + line);

              alertDate = line;
              try {
                convertedTime = new SimpleDateFormat("MM/dd/yyyy").parse(alertDate);
              } catch (ParseException ex) {}
            }
          }
          fileReader.close();
          scrollPaneRem.add(new JLabel(LabelLine));

          Timer timer = new Timer();

          TimerTask task = new TimerTask() {
            @Override
            public void run() {
              JOptionPane.showMessageDialog(mainFrame, (reminderString));
            }
          };

          timer.schedule(task, convertedTime);
        } catch (FileNotFoundException e) {}
      }
    }

    // Used for the Journal
    if (new File("./alerts").list().length > 0) {
      String[] arrayToAdd = new String[(new File("./alerts").list().length) + 1];

      arrayToAdd[0] = "";
      for (int i = 0; i < new File("./alerts").list().length; i++) {
        String nameToChange = (new File("./alerts")).list()[i];

        if (nameToChange.contains(".txt")) {
          nameToChange = nameToChange.replace(".txt", "");
        }

        arrayToAdd[i + 1] = nameToChange;

        comboBoxToAdd = new JComboBox(arrayToAdd);
      }
      scrollPaneJournal.add(comboBoxToAdd);

      JButton chooseButton = new JButton("Choose");
      chooseButton.setBounds(140, 165, 100, 25);
      journalPanel.add(chooseButton);

      newJournalButton.setBounds(10, 165, 120, 25);

      // Used to read the selected journal entry
      chooseButton.addActionListener(new ActionListener() {
        public void JComboBoxSetup() {
          String[] entriesArray = new String[new File("./alerts").list().length + 1];

          entriesArray[0] = "";
          for (int i = 0; i < new File("./alerts").list().length; i++) {
            String toAdd = new File("./alerts").list()[i];

            if (toAdd.contains(".txt")) {
              toAdd = toAdd.replace(".txt", "");

              entriesArray[i + 1] = toAdd;
            }
          }

          comboBoxToAdd = new JComboBox(entriesArray);
          scrollPaneJournal.add(comboBoxToAdd);
        }

        public void deleted() {
          scrollPaneJournal.removeAll();

          JComboBoxSetup();

          refreshFunc();
        }

        public void actionPerformed(ActionEvent e) {
          if (!comboBoxToAdd.getSelectedItem().equals("")) {
            String line = (String)(comboBoxToAdd.getSelectedItem());

            journalMoreInfo newInstance = new journalMoreInfo(line);

            (newInstance.moreInfoFrame).addWindowListener(new WindowAdapter() {
              public void windowClosed(WindowEvent event) {
                deleted();
              }
            });
          }
        }
      });
    }
  }
}
