import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.Scanner;
import java.io.*;

class deleteReminder {
  JFrame deleteReminderFrame = new JFrame();

  // Used to contain the homework names
  JComboBox homeworkContainer = new JComboBox();

  // Used to contain the homework
  JTextArea homeworkOutputArea = new JTextArea();

  JButton deleteReminder = new JButton("Delete Reminder");
  JButton modifyReminder = new JButton("Modify Reminder");

  deleteReminder() {
    // JFrame Formatting
    deleteReminderFrame.setTitle("Modify Reminders");
    deleteReminderFrame.setSize(500, 240);
    deleteReminderFrame.setVisible(true);
    deleteReminderFrame.setLayout(null);
    deleteReminderFrame.setLocationRelativeTo(null);

    // Homework Container Formatting
    homeworkOutputArea.setBounds(10, 45, 460, 100);
    deleteReminderFrame.add(homeworkOutputArea);

    // JComboBox Formatting
    comboBoxSetupFunc();
    homeworkContainer.setBounds(175, 10, 150, 25);
    deleteReminderFrame.add(homeworkContainer);

    // Delete Reminder Formatting
    deleteReminder.setBounds(100, 160, 140, 25);
    deleteReminderFrame.add(deleteReminder);

    // ModifyReminder Button Formatting
    modifyReminder.setBounds(250, 160, 140, 25);
    deleteReminderFrame.add(modifyReminder);

    // JComboBox ActionListener
    homeworkContainer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Clear homeworkOutputArea
        homeworkOutputArea.setText("");

        try {
          File newFile = new File("./reminder", (String)(homeworkContainer.getSelectedItem()));

          Scanner newReader = new Scanner(newFile);

          while (newReader.hasNextLine()) {
            homeworkOutputArea.append(newReader.nextLine() + "\n");
          }
        } catch (FileNotFoundException ex) {}
      }
    });
  }

  // Used to setup the JComboBox
  public void comboBoxSetupFunc() {
    File fileChecker = new File("./reminder");

    // JComboBoxArray Formatting
    String[] JComboBoxArray = new String[fileChecker.list().length + 1];
    JComboBoxArray[0] = "";

    // Check that the reminder directory isn't empty
    if (fileChecker.list().length > 0) {
      for (int i = 0; i < fileChecker.list().length; i++) {
        JComboBoxArray[i + 1] = fileChecker.list()[i];
      }
    }

    // Re-Assign the JComboBox
    homeworkContainer = new JComboBox(JComboBoxArray);
  }
}
