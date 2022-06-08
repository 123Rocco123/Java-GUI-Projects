import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.util.*;

class journal {
  JFrame journalFrame = new JFrame("Add New Journal Entry");

  JTextField journalTitle = new JTextField();
  JTextArea journalEntry = new JTextArea();

  JButton submit = new JButton("Save Entry");
  JButton closeButton = new JButton("Close");

  Calendar timeVar = new GregorianCalendar();

  public journal() {
    journalFrame.setSize(500, 500);
    journalFrame.setLocationRelativeTo(null);
    journalFrame.setVisible(true);
    journalFrame.setLayout(null);

    journalTitle.setBounds(10, 10, 465, 25);
    journalTitle.setBorder(BorderFactory.createLineBorder(Color.black));
    journalFrame.add(journalTitle);

    // X Y WIDHT HEIGHT
    journalEntry.setBounds(10, 45, 465, 300);
    journalEntry.setBorder(BorderFactory.createLineBorder(Color.black));
    journalFrame.add(journalEntry);

    submit.setBounds(200, 355, 100, 25);
    journalFrame.add(submit);

    closeButton.setBounds(200, 390, 100, 25);
    journalFrame.add(closeButton);

    submit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          File newFile = new File("./alerts", (journalEntry.getText() + ".txt"));
          FileWriter newWriter = new FileWriter(newFile);

          newWriter.write(journalEntry.getText());
          newWriter.close();

          journalFrame.dispose();
        } catch (IOException ex) {}
      }
    });

    closeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        journalFrame.dispose();
      }
    });

    focusFunc(journalTitle, journalEntry, "Enter Entry Title Here", "Enter Content Here");
  }

  public void focusFunc(JTextField textField, JTextArea textArea, String text1, String text2) {
    textField.setText(text1);
    textArea.setText(text2);

    textField.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        if (textField.getText().equals(text1)) {
          textField.setText("");
        }
      }

      public void focusLost(FocusEvent e) {
        if (textField.getText().equals("")) {
          textField.setText(text1);
        }
      }
    });

    textArea.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        if (textArea.getText().equals(text2)) {
          textArea.setText("");
        }
      }

      public void focusLost(FocusEvent e) {
        if (textArea.getText().equals("")) {
          textArea.setText(text2);
        }
      }
    });
  }
}
