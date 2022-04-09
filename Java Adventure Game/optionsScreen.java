import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class optionsScreen extends JFrame {
  JLabel resolution = new JLabel("Screen Resolution");
  String[] resolutions = {"Programmers Choice", "Fullscreen"};
  JComboBox<String> resolutionList = new JComboBox<String>(resolutions);

  String resolution123;

  JPanel optionsPanel = new JPanel();

  public optionsScreen() {
    this.setSize(300, 300);
    this.setLocation(850, 300);
    this.setLayout(null);
    this.add(optionsPanel);
    this.setTitle("Game Options");

    optionsPanel.setBounds(10, 10, 265, 240);
    optionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    optionsPanel.add(resolution);
    resolution.setBounds(150, 10, 100, 25);

    resolutionList.setSelectedIndex(0);
    resolutionList.setBounds(150, 45, 100, 25);
    optionsPanel.add(resolutionList);

    this.setVisible(true);

    resolutionList.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        resolution123 = (String)(resolutionList.getSelectedItem());
      }
    });
  }
}
