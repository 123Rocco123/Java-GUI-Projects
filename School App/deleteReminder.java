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
        textAreaFunc();
      }
    });

    // Action Listener for Deleting Remniders
    deleteReminder.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        File fileToDelete = new File("./reminder");

        // Used to check if there are any reminders in the file
        if (fileToDelete.list().length > 0) {
          fileToDelete = new File("./reminder", (String)(homeworkContainer.getSelectedItem()));

          int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete: " + fileToDelete.getName());

          // Yes Option
          if (userChoice == 0) {
            if (fileToDelete.delete()) {
              JOptionPane.showMessageDialog(null, "Successfully Deleted File: " + (String)homeworkContainer.getSelectedItem());

              deleteReminderFrame.dispose();
            } else {
              JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error", JOptionPane.ERROR_MESSAGE);
            }
          }
        }
      }
    });

    // Modify Reminder Action Listener
    modifyReminder.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Check that the user has selected a file that they want to modify
        if (!((String)(homeworkContainer.getSelectedItem())).equals("")) {
          reminder reminderClass = new reminder(new File("./reminder", (String)(homeworkContainer.getSelectedItem())));
        }
      }
    });
  }

  // Used to add text to the text area
  public void textAreaFunc() {
    // Clear homeworkOutputArea
    homeworkOutputArea.setText("");

    try {
      File newFile = new File("./reminder", (String)(homeworkContainer.getSelectedItem()));

      Scanner newReader = new Scanner(newFile);

      while (newReader.hasNextLine()) {
        homeworkOutputArea.append(newReader.nextLine() + "\n");
      }

      // To avoid File type errors
      newReader.close();
    } catch (FileNotFoundException ex) {}
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
