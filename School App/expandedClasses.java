import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

class expandedClasses extends JFrame {
  int arraySize = (new File("./classes").list().length);
  String[] classArray = new String[arraySize + 1];

  String selectedItem = "";

  JPanel innerPanel = new JPanel(new GridLayout(0, 1));
  JScrollPane innerPanelScroll = new JScrollPane(innerPanel);

  JButton deleteButton = new JButton("Delete");

  public expandedClasses() {
    this.setSize(500, 500);
    this.setLocationRelativeTo(null);
    this.setBackground(Color.white);
    this.setTitle("Classes");
    this.setLayout(null);
    //this.setResizable(false);
    this.setVisible(true);

    innerPanelScroll.setBounds(10, 10, 240, 445);
    innerPanelScroll.setBorder(BorderFactory.createLineBorder(Color.black));
    this.add(innerPanelScroll);

    // Used to re-fresh page.
    this.invalidate();
    this.validate();
    this.repaint();

    if (new File("./classes").list().length > 0) {
      String className = "";
      String classTime = "";

      for (int i = 0; i < new File("./classes").list().length; i++) {
        try {
          // Make sure to change the directory to the classes folder.
             // And then pass in each of the file name's for a list.
          File file = new File("./classes", new File("./classes").list()[i]);

          // Used to read the file
          Scanner fileReader = new Scanner(file);

          while(fileReader.hasNextLine()) {
            String test = fileReader.nextLine();

            if (test.contains("Class: ")) {
              className = test.replace("Class: ", "");

              classArray[i] = className;
            } else if (test.contains("Time Class Starts: ")) {
              classTime = test.replace("Time Class Starts: ", "");
            }
          }
          // JLabel used to append to the scroll pane for saved classes that the user added in previous sections.
          JLabel newLabel = new JLabel(className + " | " + classTime);
          innerPanel.add(newLabel);

        } catch (FileNotFoundException e) {}
      }
    }

    JComboBox classes = new JComboBox(classArray);

    classes.setBounds(250, 10, 100, 25);
    this.add(classes);

    // Used to re-fresh page.
    this.invalidate();
    this.validate();
    this.repaint();

    for (int x = 0; x < classArray.length; x++) {
      System.out.println(classArray[x]);
    }
  }
}
