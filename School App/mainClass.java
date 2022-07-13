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
  JButton reminderDelete = new JButton("More Info");

  // Quit Button
  JButton exitButton = new JButton("Quit");

  // New Semester Button
  JButton newSemester = new JButton("New Semester");

  // Grades Button
  JButton gradesButton = new JButton("Grades");

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

    // PANEL FORMATTINGS

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

    // BOTTOM MAINFRAME BUTTON FORMATTING

    // Exit Button
    exitButton.setBounds(215, 430, 100, 25);
    mainFrame.add(exitButton);

    // New Semester Formatting
    newSemester.setBounds(325, 430, 130, 25);
    mainFrame.add(newSemester);

    // Grades Formatting
    gradesButton.setBounds(465, 430, 100, 25);
    mainFrame.add(gradesButton);

    // BOTTOM MAINFRAME BUTTON ACTION LISTENERS

    // Quit Program Functionality
    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    // Used for the "New Semester" JButton
    newSemester.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // THis variable contains the response of the user after they've pressed the button.
        int order66 = JOptionPane.showConfirmDialog(null, "Starting a new Semester will delete previous information. Are you sure to continue? ");

        // If condition executed if order66 variable equals yes
        if (order66 == 0) {
          // Used to delete all of the files stored inside of the "alerts folder" (homework).
          for (int i = 0; i < new File("./alerts").list().length; i++) {
            File fileToDelete = new File("./alerts", (new File("./alerts").list())[i]);

            fileToDelete.delete();
          }

          // Used to delete all of the files stored inside of the "alerts folder" (homework).
          for (int i = 0; i < new File("./classes").list().length; i++) {
            File fileToDelete = new File("./classes", (new File("./classes").list())[i]);

            fileToDelete.delete();
          }

          // Used to delete all of the files stored inside of the "alerts folder" (homework).
          for (int i = 0; i < new File("./alerts").list().length; i++) {
            File fileToDelete = new File("./alerts", (new File("./alerts").list())[i]);

            fileToDelete.delete();
          }

          // Used to delete all of the files stored inside of the "alerts folder" (homework).
          for (int i = 0; i < new File("./homework").list().length; i++) {
            File fileToDelete = new File("./homework", (new File("./homework").list())[i]);
            String stringFile = (new File("./homework").list())[i];

            if (stringFile.contains(".txt")) {
              fileToDelete.delete();
            }
          }

          // Used to delete all of the files stored inside of the "alerts folder" (homework).
          for (int i = 0; i < new File("./reminder").list().length; i++) {
            File fileToDelete = new File("./reminder", (new File("./reminder").list())[i]);
            String stringFile = (new File("./reminder").list())[i];

            if (stringFile.contains(".txt")) {
              fileToDelete.delete();
            }
          }

        // Close the old window, and start a new semseter.
        mainFrame.dispose();

        // Here we are essentially using re-cursion to call the class again from the function inside of it.
           // This will result in executing all the initial functions again.
        mainClass semesterPlus = new mainClass();

        // showMessageDialog to tell the user that they've started a new semseter
        JOptionPane.showMessageDialog(null, "New Semseter, good luck.");
        }
      }
    });

    // Used to execute the Grades JFrame
    gradesButton.addActionListener(new ActionListener() {
      public void actionPerformed() {
        
      }
    });

    // Keyboard Listener
       // Used to quit the program with the escape key.
    mainFrame.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {}

      @Override
      public void keyReleased(KeyEvent arg0) {}

      // Used to quit teh program when "esc" is pressed.
      @Override
      public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if( arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
          System.exit(0);
        }
      }
    });

    // ACTION LISTENERS

    // New Class Action Listener
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

    // Reminder Button Acion Listener
    newReminderButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        reminder reminderClass = new reminder();

        // Used to convert the reminder alert date to a date data type.
        (reminderClass.reminderFrame).addWindowListener(new WindowAdapter() {
          public void windowClosed(WindowEvent closed) {
            if (!reminderClass.dateField.getText().equals("")) {
              // Remove all of the JLabels in the scrollPaneRem
              scrollPaneRem.removeAll();

              // The variable contains the current date
              Date convertedTime = new Date();
              // "fileName" variable is used for storing of the name of the file
              String fileName = "";

              // For loop used to iterate through all the files in the reminder directory
              for (int i = 0; i < (new File("./reminder").list().length) - 1; i++) {
                try {
                  File fileToRead = new File("./reminder", (new File("./reminder").list()[i]));
                  Scanner newFileReader = new Scanner(fileToRead);

                  // String Variables used to store the name and time of the reminder
                  fileName = (String)(new File("./reminder").list()[i]);
                  String experationDate = "";

                  // While Loop used to
                  while(newFileReader.hasNextLine()) {
                    experationDate = newFileReader.nextLine();
                  }

                  // To avoid file maipulation bugs
                  newFileReader.close();

                  // Remove and replace the extensions from the filename
                  fileName = fileName.replace(".\\reminder\\", "");
                  fileName = fileName.replace(".txt", "");
                  // experationDate formatting
                  experationDate = experationDate.replace("Time: ", "");

                  try {
                    convertedTime = new SimpleDateFormat("MM/dd/yyyy").parse(experationDate);
                  } catch (ParseException ex) {}
                } catch (IOException ex) {}

                scrollPaneRem.add(new JLabel(fileName + " | " + convertedTime));
                refreshFunc();

                Timer timer = new Timer();

                TimerTask task = new TimerTask() {
                  @Override
                  public void run() {
                    JOptionPane.showMessageDialog(mainFrame, "Journal! " + reminderClass.reminder.getText());
                  }
                };
                timer.schedule(task, convertedTime);

                // newReminderButton Button Re-Fromatting
                newReminderButton.setBounds(65, 165, 120, 25);

                // Reminder Delete Button Formatting and Add
                reminderDelete.setBounds(195, 165, 100, 25);
                reminderPanel.add(reminderDelete);
              }
            }
          }
        });

        // Removing previous ActionListeners
        removeActionListenerFunc(reminderDelete);

        // Reminder Delete ActionListener to delete remidners
        reminderDelete.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            deleteReminder deleteReminderObj = new deleteReminder();

            // This will be activated when the deleteReminder window has been closed
               // With the purpose of re-freshing the reminder panel so that the user can get the reminders that they have.
            (deleteReminderObj.deleteReminderFrame).addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent ev) {
                // The reason that the length is 1 instead of 0, is because of the "completedReminder" directory.
                   // If the user deletes everything, then the else statement has to be executed, since the "completedReminder" directory is inside of the "reminder" one, it will never execute.
                if (new File("./reminder").list().length > 1) {
                  // Clear all JLabels off of the screen.
                  scrollPaneRem.removeAll();
                  // Used to iterate over the reminder directory to add the labels to the JPanel.
                  for (int i = 0; i < new File("./reminder").list().length; i++) {
                    try {
                      Scanner newFileReader = new Scanner(new File("./reminder", (new File("./reminder").list())[i]));

                      // Used to store the string for the JLabel
                      String newLabelToAdd = "";
                      // Used to read the lines in the file
                      while (newFileReader.hasNextLine()) {
                        // Used to current hasNextLine()
                           // Used to avoid the "dereferncing" error from modifying newFileReader.nextLine()
                        String currentLine = newFileReader.nextLine();

                        // If and else if block is used to format the string.
                        if (currentLine.contains("Reminder: ")) {
                          newLabelToAdd += currentLine.replace("Reminder: ", "");
                        } else if (currentLine.contains("Time: ")) {
                          newLabelToAdd += currentLine.replace("Time: ", " | ");

                          // Used to add the JLabels to the Reminder JPanel
                          scrollPaneRem.add(new JLabel(newLabelToAdd));
                          newLabelToAdd = "";
                        }
                      }

                      refreshFunc();
                      // Close fileReader to avoid bugs.
                      newFileReader.close();
                    } catch (FileNotFoundException ex) {}
                  }
                }
                // If the user has decided to delete all of their reminders, then we will simply remove all the labels saved onto the JPanel.
                else {
                  scrollPaneRem.removeAll();
                  refreshFunc();
                }
              }
            });
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

    // Homework Button Action Listener
    newHomeworkButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        newHomework addNewHomework = new newHomework();

        // New Homework Window Listener
        (addNewHomework.homeworkFrame).addWindowListener(new WindowAdapter() {
          public void windowClosed(WindowEvent e) {
            if ((addNewHomework.newHomeworkFile).exists()) {
              // Used to remove any previous ActionListeners that the Delete Button had from the initialCheckerFunc.
                 // This fixes the two delete JFrames that would appear after a new homework task was added.
              removeActionListenerFunc(homeworkDelete);

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
                  deleteHomework deleteHomeworkInstance = new deleteHomework();

                  // Delete Homework JFrame Window Listener
                  (deleteHomeworkInstance.homeworkChangeFrame).addWindowListener(new WindowAdapter() {
                    // Used to delete and re-paint the JComboBox
                    public void deleted() {
                      // Used to remove everything off of the panel.
                      scrollPaneHW.removeAll();

                      File fileDirectory = new File("./homework");

                      String homework = "";

                      // Used to loop through all the files in the homework directory
                      for (int i = 0; i < fileDirectory.list().length; i++) {
                        try {
                          Scanner fileReader = new Scanner(new File("./homework", fileDirectory.list()[i]));

                          // String Add
                          while(fileReader.hasNextLine()) {
                            homework += fileReader.nextLine();
                          }

                          // JLabel String Formatting
                          homework = homework.replace("Homework: ", "");
                          homework = homework.replace("Class: ", " | ");
                          homework = homework.replace("Due Date: ", " | ");

                          scrollPaneHW.add(new JLabel(homework));
                          fileReader.close();
                        } catch (FileNotFoundException ex) {}
                      }

                      refreshFunc();
                    }

                    public void windowClosed(WindowEvent ev) {
                      deleted();
                    }
                  });
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

  // Remove JButton ActionListeners Func
  public void removeActionListenerFunc(JButton buttonToClear) {
    ActionListener[] listeners = buttonToClear.getActionListeners();

    for (int i = 0; i < listeners.length; i++) {
        buttonToClear.removeActionListener(listeners[i]);
    }
  }

  // FUNCTIONS

  // Function to Re-Fresh JPanel
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

      // New Homework Button Re-Formatting
      newHomeworkButton.setBounds(10, 165, 110, 25);
      newHomeworkButton.setText("New HW");

      // Delete Button Formatting
      homeworkDelete.setBounds(130, 165, 110, 25);
      homeWorkPanel.add(homeworkDelete);

      // Create a new instance of the delete homework JFrame
      homeworkDelete.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          deleteHomework deleteHomeworkInstance = new deleteHomework();

          // Delete Homework JFrame Window Listener
          (deleteHomeworkInstance.homeworkChangeFrame).addWindowListener(new WindowAdapter() {
            // Used to delete and re-paint the
            public void deleted() {
              // Used to remove everything off of the panel.
              scrollPaneHW.removeAll();

              File fileDirectory = new File("./homework");

              String homework = "";

              // Used to loop through all the files in the homework directory
              for (int i = 0; i < fileDirectory.list().length; i++) {
                try {
                  Scanner fileReader = new Scanner(new File("./homework", fileDirectory.list()[i]));

                  // String Add
                  while(fileReader.hasNextLine()) {
                    homework += fileReader.nextLine();
                  }

                  // JLabel String Formatting
                  homework = homework.replace("Homework: ", "");
                  homework = homework.replace("Class: ", " | ");
                  homework = homework.replace("Due Date: ", " | ");

                  scrollPaneHW.add(new JLabel(homework));
                  fileReader.close();
                } catch (FileNotFoundException ex) {}
              }

              refreshFunc();
            }

            public void windowClosed(WindowEvent ev) {
              deleted();
            }
          });
        }
      });
    }

    // Used for the Reminder directory
    if (new File("./reminder").list().length > 0) {
      // Used to remove everything from the panel and refresh the screen
      scrollPaneRem.removeAll();
      refreshFunc();

      for (int i = 0; i < new File("./reminder").list().length - 1; i++) {
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

          // newReminderButton Button Re-Fromatting 380
          newReminderButton.setBounds(65, 165, 120, 25);

          // Reminder Delete Button Formatting and Add
          reminderDelete.setBounds(195, 165, 100, 25);
          reminderPanel.add(reminderDelete);

          // Removing previous ActionListeners
          removeActionListenerFunc(reminderDelete);

          // Reminder Delete ActionListener to delete remidners
          reminderDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              deleteReminder deleteReminderObj = new deleteReminder();

              // This will be activated when the deleteReminder window has been closed
                 // With the purpose of re-freshing the reminder panel so that the user can get the reminders that they have.
              (deleteReminderObj.deleteReminderFrame).addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent ev) {
                  if (new File("./reminder").list().length > 1) {
                    // Clear all JLabels off of the screen.
                    scrollPaneRem.removeAll();
                    // Used to iterate over the reminder directory to add the labels to the JPanel.
                    for (int i = 0; i < new File("./reminder").list().length; i++) {
                      try {
                        Scanner newFileReader = new Scanner(new File("./reminder", (new File("./reminder").list())[i]));

                        // Used to store the string for the JLabel
                        String newLabelToAdd = "";
                        // Used to read the lines in the file
                        while (newFileReader.hasNextLine()) {
                          // Used to current hasNextLine()
                             // Used to avoid the "dereferncing" error from modifying newFileReader.nextLine()
                          String currentLine = newFileReader.nextLine();

                          // If and else if block is used to format the string.
                          if (currentLine.contains("Reminder: ")) {
                            newLabelToAdd += currentLine.replace("Reminder: ", "");
                          } else if (currentLine.contains("Time: ")) {
                            newLabelToAdd += currentLine.replace("Time: ", " | ");

                            // Used to add the JLabels to the Reminder JPanel
                            scrollPaneRem.add(new JLabel(newLabelToAdd));
                            newLabelToAdd = "";
                          }
                        }

                        refreshFunc();
                        // Close fileReader to avoid bugs.
                        newFileReader.close();
                      } catch (FileNotFoundException ex) {}
                    }
                  }
                  // If the user has decided to delete all of their reminders, then we will simply remove all the labels saved onto the JPanel.
                  else {
                    // Remove all the homeworks displayed in the panel
                    scrollPaneRem.removeAll();

                    // Refresh the whole screen to remove the HW
                    refreshFunc();
                  }
                }
              });
            }
          });
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

        // Function called when the button is pressed
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
