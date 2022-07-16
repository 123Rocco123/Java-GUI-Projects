import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.io.*;

class grades {
  JFrame gradesFrame = new JFrame();

  // Used to store all of the classes that the user has
  JComboBox subjectContainer = new JComboBox();

  // Used to store the 
  JTextField classContainer = new JTextField();

  // Used to contiain the Class with its grades.
  HashMap<String, ArrayList<Integer>> classGradesMap = new HashMap<String, ArrayList<Integer>>();

  public grades() {
    // JFrame Formatting
    gradesFrame.setTitle("Grades");

    gradesFrame.setSize(500, 500);
    gradesFrame.setLocationRelativeTo(null);
    gradesFrame.setResizable(false);
    gradesFrame.setLayout(null);

    gradesFrame.setVisible(true);

    JComboBoxSetup();

    // Formatting of add grades button
    addGradesBtn.setBounds(200, 405, 100, 25);
    gradesFrame.add(addGradesBtn);

    // Formatting of the grades container
    gradeContainer.setBounds(200, 370, 100, 25);
    gradesFrame.add(gradeContainer);

    // ActionListener used to allow user to add grades to their classes
    addGradesBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
  }

  public void JComboBoxSetup() {
    // HashMap Setup
    for (int i = 0; i < new File("./classes").list().length; i++) {
      // The ArrayList used for containing the grades for each class.
      ArrayList<Integer> grades = new ArrayList<Integer>();
      classGradesMap.put((String)(new File("./classes").list()[i]), grades);
    }
  }
}
