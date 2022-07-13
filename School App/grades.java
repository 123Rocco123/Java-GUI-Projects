import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.io.*;

class grades {
  JFrame gradesFrame = new JFrame();

  // Used to store all of the classes that the user has
  JComboBox subjectContainer = new JComboBox();

  HashMap<String, ArrayList<Integer>> classGradesMap = new HashMap<String, ArrayList<Integer>>();

  public grades() {
    // JFrame Formatting
    gradesFrame.setTitle("Grades");

    gradesFrame.setSize(500, 500);
    gradesFrame.setLocationRelativeTo(null);
    gradesFrame.setResizable(false);
    gradesFrame.setLayout(null);

    gradesFrame.setVisible(true);
  public void JComboBoxSetup() {
    // HashMap Setup
    for (int i = 0; i < new File("./classes").list().length; i++) {
      int counterToAdd = 0;
      try {
        Scanner reader = new Scanner(new File("./classes", new File("./classes").list()[i]));

        // Iterate through the lines in the reader object.
        while (reader.hasNextLine()) {
          // Used to not create an inifite loop
          reader.nextLine();

          counterToAdd += 1;
        }

        reader.close();
      } catch (FileNotFoundException ex) {}

      // The ArrayList used for containing the grades for each class.
      ArrayList<Integer> grades = new ArrayList<Integer>();
      classGradesMap.put((String)(new File("./classes").list()[i]), grades);
    }
  }
}
