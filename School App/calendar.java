import java.util.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

class calendar extends JPanel {
  Calendar calendar = new GregorianCalendar();
  JLabel calendarTitle;

  String[] calendarArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
  String[] calendarWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
  public calendar() {
    this.setBounds(10, 35, 360, 155);
    this.setLayout(new BorderLayout());

    // JLabel Code
    calendarTitle = new JLabel(calendarArray[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.YEAR));
    calendarTitle.setBounds(100, 10, 100, 25);
    calendarTitle.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(calendarTitle, BorderLayout.NORTH);

    // First Day of Month
    calendar.set(Calendar.DAY_OF_MONTH, 1);

  }
}
