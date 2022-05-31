import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.io.*;
import java.util.*;
import java.text.*;

class reminder {
  JFrame reminderFrame = new JFrame();

  JTextField reminder = new JTextField();
  JTextField dateField = new JTextField();


  JButton submitButton = new JButton("Submit and Close");

  public reminder() {
    reminderFrame.setSize(500, 205);
    reminderFrame.setLocationRelativeTo(null);
    reminderFrame.setVisible(true);
    reminderFrame.setTitle("Add New Reminder");
    reminderFrame.setLayout(null);

    reminder.setBounds(10, 10, 465, 50);
    reminderFrame.add(reminder);

    dateField.setBounds(10, 70, 465, 50);

    /*String strDate = dateFormat.format(date);

    dateField.setText(strDate);*/
    reminderFrame.add(dateField);

    submitButton.setBounds(175, 130, 150, 25);
    reminderFrame.add(submitButton);

    focusFunction(reminder, "Write Reminder");
    focusFunction(dateField, "Enter Date Here");

    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!reminder.getText().equals("")) {
          File newFile = new File("./reminder", (reminder.getText() + ".txt"));

          try {
            FileWriter newFileWriter = new FileWriter(newFile);

            newFileWriter.write("Reminder: " + reminder.getText());
            newFileWriter.close();

            reminderFrame.dispose();
          } catch (IOException ex) {}
        }
      }
    });
  }

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
