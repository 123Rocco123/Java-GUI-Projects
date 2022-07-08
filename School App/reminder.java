import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import java.io.*;
import java.util.*;
import java.text.*;

class reminder {
  // JFrame
  JFrame reminderFrame = new JFrame();

  // Used to allow users to write the reminder and the date for it
  JTextField reminder = new JTextField();
  JTextField dateField = new JTextField();

  // JButtons for reminder modification
  JButton submitButton = new JButton("Submit and Close");
  JButton reWriteButton = new JButton("Overwrite Reminder");

  // Jbutton to Complete Reminders
  JButton completedReminder = new JButton("Complete Reminder");

  // Used to store the converted time
     // Used for the alerts to display to the user.
  Date convertedTime;

  // Create New Reminder
  public reminder() {
    // Initial Setup Function
    intiialSetupFunc();

    // Submit JButton Modification
    submitButton.setBounds(175, 130, 150, 25);
    reminderFrame.add(submitButton);

    // Submit JButton ActionListener
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!reminder.getText().equals("") && !reminder.getText().equals("Write Reminder")) {
          File newFile = new File("./reminder", (reminder.getText() + ".txt"));

          try {
            if (newFile.createNewFile()) {
              FileWriter newFileWriter = new FileWriter(newFile);

              newFileWriter.write("Reminder: " + reminder.getText());
              newFileWriter.write("\nTime: " + dateField.getText());
              newFileWriter.close();

              reminderFrame.dispose();
            } else {
              JOptionPane.showMessageDialog(reminderFrame, "Error! Reminder Already Exists.");
            }
          } catch (IOException ex) {}
        }
      }
    });
  }

  // Modify Reminder
     // Overwrite constructor with file parameter
  public reminder(File fileToChange) {
    // Initial Setup Function
    intiialSetupFunc();

    // Re-Write JButton Formatting
    reWriteButton.setBounds(95, 130, 150, 25);
    reminderFrame.add(reWriteButton);

    // Completed Reminder JButton Formatting
    completedReminder.setBounds(255, 130, 150, 25);
    reminderFrame.add(completedReminder);

    // Modify Reminders Button
    reWriteButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        if (!reminder.getText().equals("") && !reminder.getText().equals("Write Reminder")) {
          try {
            FileWriter FileWriterMod = new FileWriter(fileToChange);

            FileWriterMod.write("Reminder: " + reminder.getText());
            FileWriterMod.write("\nTime: " + dateField.getText());
            FileWriterMod.close();

            reminderFrame.dispose();
          } catch (IOException e) {}
        }
      }
    });

    // Completed Reminder JButton ActionListener
    completedReminder.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // String Variable used to store the name of the file.
        String fileName = fileToChange.getName();
        // Used to remove the file extension of the file name
        fileName = fileName.replace("./reminder/", "");

        // Try Statement Used for Scanner FileNotFoundException
        try {
          Scanner newFileReader = new Scanner(fileToChange);

          // Try Statement used for IOException from FileWriter
          try {
            File fileInNewLocation = new File("./reminder/completedReminder/", fileName);
            FileWriter fileWriter = new FileWriter(fileInNewLocation);

            while (newFileReader.hasNextLine()) {
              fileWriter.write(newFileReader.nextLine() + "\n");
            }
            // Close the Reader and Writer to avoid having bugs where file operations don't work
            newFileReader.close();
            fileWriter.close();

            // Create the new file, and delete the old
            File fileToDelete = new File("./reminder", fileName);
            fileToDelete.delete();
            // Close the current window
            reminderFrame.dispose();
          } catch (IOException exc) {}
        } catch (FileNotFoundException ex) {}
      }
    });
  }

  // Initial Setup Function
  public void intiialSetupFunc() {
    // JFrame Modification
    reminderFrame.setSize(500, 205);
    reminderFrame.setLocationRelativeTo(null);
    reminderFrame.setVisible(true);
    reminderFrame.setTitle("Add New Reminder");
    reminderFrame.setLayout(null);

    // Reminder JTextField Modification
    reminder.setBounds(10, 10, 465, 50);
    reminderFrame.add(reminder);

    // Datefield JTextField Modification
    dateField.setBounds(10, 70, 465, 50);
    reminderFrame.add(dateField);

    focusFunction(reminder, "Write Reminder");
    focusFunction(dateField, "Enter Date Here (MM/dd/yyyy)");
  }

  // JTextField Focus Function
  public void focusFunction(JTextField name, String defaultText) {
    name.setHorizontalAlignment(SwingConstants.CENTER);
    name.setText(defaultText);

    name.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if (name.getText().equals(defaultText)) {
          name.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent e) {
        if (name.getText().equals("")) {
          name.setText(defaultText);
        }
      }
    });
  }
}
