import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

class expandedClasses {
  JFrame expandedClassesFrame = new JFrame();

  int arraySize = (new File("./classes").list().length);
  String[] classArray = new String[arraySize + 1];

  String selectedItem = "";

  JPanel innerPanel = new JPanel(new GridLayout(0, 1));
  JScrollPane innerPanelScroll = new JScrollPane(innerPanel);

  JButton deleteButton = new JButton("Delete");
  JButton exitButton = new JButton("Exit");

  public expandedClasses() {
    classArray[0] = "";

    expandedClassesFrame.setSize(500, 500);
    expandedClassesFrame.setLocationRelativeTo(null);
    expandedClassesFrame.setBackground(Color.white);
    expandedClassesFrame.setTitle("Classes");
    expandedClassesFrame.setLayout(null);
    //expandedClassesFrame.setResizable(false);
    expandedClassesFrame.setVisible(true);

    innerPanelScroll.setBounds(10, 10, 465, 240);
    innerPanelScroll.setBorder(BorderFactory.createLineBorder(Color.black));
    expandedClassesFrame.add(innerPanelScroll);

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

              classArray[i + 1] = className;
            } else if (test.contains("Time Class Starts: ")) {
              classTime = test.replace("Time Class Starts: ", "");
            }
          }
          // JLabel used to append to the scroll pane for saved classes that the user added in previous sections.
          JLabel newLabel = new JLabel(className + " | " + classTime);
          innerPanel.add(newLabel);

          fileReader.close();
        } catch (FileNotFoundException e) {}
      }
    }

    JComboBox classes = new JComboBox(classArray);

    classes.setBounds(200, 260, 100, 25);
    expandedClassesFrame.add(classes);

    deleteButton.setBounds(200, 295, 100, 25);
    expandedClassesFrame.add(deleteButton);

    exitButton.setBounds(200, 330, 100, 25);
    expandedClassesFrame.add(exitButton);

    // Selected Dropdown
    classes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        selectedItem = String.valueOf(classes.getSelectedItem());
      }
    });

    // Delete Button
    deleteButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!selectedItem.equals("")) {
          try {
            boolean result = Files.deleteIfExists(Paths.get("./classes/" + selectedItem + ".txt"));
            if (result) {
              System.out.println("File is deleted!");
            } else {
              System.out.println("Sorry, unable to delete the file.");
            }
          } catch (IOException ex) {}
        }
      }
    });

    // Exit Button
    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        expandedClassesFrame.dispose();
      }
    });

    // Used to re-fresh page.
    expandedClassesFrame.invalidate();
    expandedClassesFrame.validate();
    expandedClassesFrame.repaint();
  }
}
