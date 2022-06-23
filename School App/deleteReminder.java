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
    deleteReminderFrame.setSize(500, 500);
    deleteReminderFrame.setVisible(true);
    deleteReminderFrame.setLayout(null);
    deleteReminderFrame.setLocationRelativeTo(null);

    
  }
}
