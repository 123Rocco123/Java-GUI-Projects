import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.io.*;

class grades {
  JFrame gradesFrame = new JFrame();

  // Used to store all of the classes that the user has
  JComboBox subjectContainer = new JComboBox();

  // Used to store the new grade that the user wants to add to the class
  JTextField gradeContainer = new JTextField();

  // JButton used for adding grades to the classes
  JButton addGradesBtn = new JButton("Add Grades");

  // Used to contiain the Class with its grades.
  HashMap<String, Integer> classGradesMap = new HashMap<String, Integer>();

  // Used to store the amount of grades that the user has recieved for each class.
  ArrayList<Integer> gradesForClass = new ArrayList<Integer>();

  public grades() {
    // JFrame Formatting
    gradesFrame.setTitle("Grades");

    gradesFrame.setSize(500, 500);
    gradesFrame.setLocationRelativeTo(null);
    gradesFrame.setResizable(false);
    gradesFrame.setLayout(null);

    gradesFrame.setVisible(true);

    // Function Call for JComboBox
    JComboBoxSetup();

    // HashMap Setup function call
    hashMapSetup();

    String[] gradeContainerArray = new String[new File("./classes").list().length + 1];

    // For loop used to to add classes to the array for the JComboBox
    for (int i = 0; i < new File("./classes").list().length; i++) {
      gradeContainerArray[i + 1] = (String)(new File("./classes").list()[i]);
    }

    subjectContainer = new JComboBox(gradeContainerArray);

    // JComboBox Formatting
    subjectContainer.setBounds(150, 300, 200, 25);
    gradesFrame.add(subjectContainer);

    // Formatting of add grades button
    addGradesBtn.setBounds(200, 405, 100, 25);
    gradesFrame.add(addGradesBtn);

    // Formatting of the grades container
    gradeContainer.setBounds(150, 370, 200, 25);
    gradesFrame.add(gradeContainer);
    // Initial Formatting of the gradeContainer text
    gradeContainer.setText("Insert Grade (%)");
    gradeContainer.setHorizontalAlignment(JTextField.CENTER);

    // ActionListener used to allow user to add grades to their classes
    addGradesBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Used to contain the grade that the user added
        String gradeToAdd = gradeContainer.getText();
        Object chosenClass = subjectContainer.getSelectedItem();

        // If statement below is used to check if the user has inserted a grade or not
        if (!gradeContainer.getText().equals("Insert Grade (%)")) {
          // Used to add the grades to HashMap
          classGradesMap.put((String)(chosenClass), classGradesMap.get((String)(chosenClass)) + Integer.parseInt(gradeContainer.getText()));

          // Adds another point to the ArrayList value
             // Used for the cummalative grade average
          for (int x = 0; x < new File("./classes").list().length; x++) {
            if (chosenClass.equals(new File("./classes").list()[x])) {
              gradesForClass.set(x, (gradesForClass.get(x) + 1));
            }
          }
        }
      }
    });

    gradeContainer.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        if (gradeContainer.getText().equals("Insert Grade (%)")) {
          gradeContainer.setHorizontalAlignment(JTextField.LEFT);
          gradeContainer.setText("");
        }
      }

      @Override
      public void focusLost(FocusEvent e) {
        if (gradeContainer.getText().equals("")) {
          gradeContainer.setHorizontalAlignment(JTextField.CENTER);
          gradeContainer.setText("Insert Grade (%)");
        }
      }
    });
  }

  // Used to setup the HashMap
  public void hashMapSetup() {
    // Setups the HashMap with all the classes
    for (int i = 0; i < new File("./classes").list().length; i++) {
      classGradesMap.put((String)(new File("./classes").list()[i]), 0);
    }

    // Setups the ArrayList with all the classes
    for (int x = 0; x < new File("./classes").list().length; x++) {
      gradesForClass.add(0);
    }
  }

  // Used to setupt the JComboBox with the names of the classes that the user takes.
  public void JComboBoxSetup() {
    // HashMap & Array Setup
    for (int i = 0; i < new File("./classes").list().length; i++) {
      // Used to add the Classes, and the grade average
      classGradesMap.put((String)(new File("./classes").list()[i]), 0);
    }
  }
}
