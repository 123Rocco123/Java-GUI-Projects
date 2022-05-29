import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;

class classes {
  JFrame testFrame = new JFrame();

  JTextField newClass = new JTextField(30);
  JTextField time = new JTextField(30);

  JButton submitButton = new JButton("Save and Close");

  public classes() {
    testFrame.setSize(500, 200);
    testFrame.setLocationRelativeTo(null);
    testFrame.setVisible(true);
    testFrame.setTitle("Add New Class");
    testFrame.setLayout(null);

    newClass.setBounds(10, 10, 465, 50);
    newClass.setText("Enter New Class Name");
    newClass.setHorizontalAlignment(SwingConstants.CENTER);
    testFrame.add(newClass);

    time.setBounds(10, 70, 465, 50);
    time.setText("Enter Time of the Class");
    time.setHorizontalAlignment(SwingConstants.CENTER);
    testFrame.add(time);

    submitButton.setBounds(175, 130, 150, 25);
    testFrame.add(submitButton);

    // Used to check if the user has selected the new class textfield
    newClass.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        newClass.setText("");
      }

      @Override
      public void focusLost(FocusEvent e) {
        newClass.setText("Enter New Class Name");
      }
    });

    // Used to check if the user has selected the time textfield
    time.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        time.setText("");
      }

      @Override
      public void focusLost(FocusEvent e) {
        time.setText("Enter Time of the Class");
      }
    });
  }
}
