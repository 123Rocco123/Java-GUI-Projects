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
  }
}
