// Esc has keyCode 27

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Scanner;

class game {
  int number = 1;

  String optionA = "";
  String optionB = "";
  String optionC = "";

  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  File defaultFile = new File(".\\Story\\GameFileScript.txt");

  JFrame frame = new JFrame("Indiana Jones and Golden Fleece");

  // Used to contain the background image depicting the player.
     // JLabel can store both strings and images.
  JLabel imagelabel = new JLabel();

  JTextArea storyOutputScreen = new JTextArea();

  JScrollPane scrollablePane = new JScrollPane(storyOutputScreen);

  JPanel gameScreen = new JPanel();
  JPanel playerFace = new JPanel();
  JPanel playerInput = new JPanel();

  JButton optionsButton = new JButton("Options");
  JButton exitGame = new JButton("Exit Game");
  // These buttons are used to give players options
  JButton actionOne = new JButton();
  JButton actionTwo = new JButton();
  JButton actionThree = new JButton();

  public game() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setSize(500, 500);
    frame.setResizable(false);
    frame.setLayout(null);
    frame.setLocation(750, 200);

    frame.setVisible(true);

    gameScreen.setBounds(40, 10, 400, 300);
    gameScreen.setBorder(BorderFactory.createLineBorder(Color.black));
    gameScreen.setBackground(Color.black);
    gameScreen.setLayout(null);

    scrollablePane.setBounds(6,6, 388, 288);
    scrollablePane.setBackground(Color.WHITE);
    storyOutputScreen.setEditable(false);
    storyOutputScreen.setLineWrap(true);

    gameScreen.add(scrollablePane);
    frame.add(gameScreen);

    playerFace.setBounds(40, 320, 100, 100);
    playerFace.setBorder(BorderFactory.createLineBorder(Color.black));
    playerFace.setBackground(Color.green);

    // Set the imageLabel to the image of the player.
    imagelabel.setIcon(new ImageIcon(".\\Player Pictures\\healthy.png"));
    playerFace.add(imagelabel);

    frame.add(playerFace);

    playerInput.setBounds(150, 320, 290, 100);
    playerInput.setBorder(BorderFactory.createLineBorder(Color.black));

    playerInput.setLayout(null);

    actionOne.setBounds(5, 7, 280, 25);
    actionTwo.setBounds(5, 37, 280, 25);
    actionThree.setBounds(5, 67, 280, 25);

    playerInput.add(actionOne);
    playerInput.add(actionTwo);
    playerInput.add(actionThree);

    frame.add(playerInput);

    optionsButton.setBounds(200, 425, 100, 25);
    frame.add(optionsButton);

    exitGame.setBounds(310, 425, 100, 25);
    frame.add(exitGame);

    exitGame.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    // The function below is used to check if the user has pressed the esc key or not.
    optionsButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          optionsScreen optionsOpen = new optionsScreen();

          optionsOpen.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
              frame.setVisible(true);
            }

            public void windowClosed(WindowEvent e) {
              switch(optionsOpen.resolution123) {
                case ("Fullscreen"):
                  frame.setSize(screenSize.width, screenSize.height);
                  frame.setLocation(0,0);
                  break;
                case ("Programmers Choice"):
                  frame.setSize(500, 500);
                  frame.setLocation(750, screenSize.height / 4);
                  break;
              }
              frame.setVisible(true);
            }
          });

          frame.setVisible(false);
      }
    });

    try {
      // Main Algorithm which plays the story out to the text field
      Scanner fileReader = new Scanner(defaultFile);

      String line;

      while(fileReader.hasNextLine()) {
        line = fileReader.nextLine();

        if (line.contains("Options " + Integer.toString(number) + ":")) {
          number += 1;
          continue;
        } else if (line.contains("A:")) {
          optionA = line;
        } else if (line.contains("B:")) {
          optionB = line;
        } else if (line.contains("C:")) {
          optionC = line;
          break;
        } else {
          storyOutputScreen.append(line + "\n");
        }
      }

      actionOne.setText(optionA);
      actionTwo.setText(optionB);
      actionThree.setText(optionC);

      // Used to break the story and the user choices.
      storyOutputScreen.append("____________________________________________________");

      actionOne.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          actionOne.setEnabled(false);
          actionTwo.setEnabled(false);
          actionThree.setEnabled(false);

          actionOne.setText("");
          actionTwo.setText("");
          actionThree.setText("");

          storyOutputScreen.setText("");

          while(fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            // Used to check if the action that the user has chosen is the same as the story here.
            if (line.contains("(A" + (number - 1) + ")")) {
              while(fileReader.hasNextLine()) {
                // Line Update to accomodate the condition stated above.
                line = fileReader.nextLine();

                // Options Condition
                if (line.contains("Options " + Integer.toString(number) + ":")) {
                  number += 1;
                  continue;
                } // Other Actions Condition
                else if (line.contains("A:")) {
                 optionA = line;
               } else if (line.contains("B:")) {
                 optionB = line;
               } else if (line.contains("C:")) {
                 optionC = line;
                 break;
               } // End Game Condition
                else if (line.contains("End")) {
                  break;
                } // Output Condition
                else {
                  storyOutputScreen.append(line + "\n");
                }
              }
            }
          }
        }
      });

      actionTwo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          actionOne.setEnabled(false);
          actionTwo.setEnabled(false);
          actionThree.setEnabled(false);

          actionOne.setText("");
          actionTwo.setText("");
          actionThree.setText("");

          storyOutputScreen.setText("");

          while(fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            // Used to check if the action that the user has chosen is the same as the story here.
            if (line.contains("(B" + (number - 1) + ")")) {
              while(fileReader.hasNextLine()) {
                // Line Update to accomodate the condition stated above.
                line = fileReader.nextLine();

                // Options Condition
                if (line.contains("Options " + Integer.toString(number) + ":")) {
                  number += 1;
                  continue;
                } else if (line.contains("A:")) {
                  optionA = line;
                } else if (line.contains("B:")) {
                  optionB = line;
                } else if (line.contains("C:")) {
                  optionC = line;
                  break;
                } // End Game Condition
                else if (line.contains("End")) {
                  break;
                } // Output Condition
                else {
                  storyOutputScreen.append(line + "\n");
                }
              }
            }
          }
        }
      });

      actionThree.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          actionOne.setEnabled(false);
          actionTwo.setEnabled(false);
          actionThree.setEnabled(false);

          actionOne.setText("");
          actionTwo.setText("");
          actionThree.setText("");

          storyOutputScreen.setText("");

          while(fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            // Used to check if the action that the user has chosen is the same as the story here.
            if (line.contains("(C" + (number - 1) + ")")) {
              while(fileReader.hasNextLine()) {
                // Line Update to accomodate the condition stated above.
                line = fileReader.nextLine();

                // Options Condition
                if (line.contains("Options " + Integer.toString(number) + ":")) {
                  number += 1;
                  continue;
                } else if (line.contains("A:")) {
                  optionA = line;
                } else if (line.contains("B:")) {
                  optionB = line;
                } else if (line.contains("C:")) {
                  optionC = line;
                  break;
                } // End Game Condition
                else if (line.contains("End")) {
                  break;
                } // Output Condition
                else {
                  storyOutputScreen.append(line + "\n");
                }
              }
            }
          }
        }
      });

    } catch (FileNotFoundException e) {}
  }
}
