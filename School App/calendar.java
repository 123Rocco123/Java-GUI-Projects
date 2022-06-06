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

  // Equivalent to Object[][]
  DefaultTableModel model = new DefaultTableModel(null, calendarWeek);

  int today = calendar.get(Calendar.DAY_OF_MONTH);

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

    // Days of the Week
    model.setRowCount(calendar.getActualMaximum(Calendar.WEEK_OF_MONTH));

    // First Day of the Month
       // We use "-2" because Calendar uses "Sunday" as the first day of the week
    int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 2;
    // Calendar contained in a JTable
    JTable table = new JTable(model);
    // Used to contain the Calendar
    JScrollPane pane = new JScrollPane(table);

    // Used to add the data, dates, to the calendar
    for(int day = 1; day <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); day++){
      if (day == today) {
        // Data, Row, Column
        model.setValueAt(day + " (TDY)", startDay / 7, startDay % 7);
      } else {
        // Data, Row, Column
        model.setValueAt(day, startDay / 7, startDay % 7);
      }
      startDay++;
    }

    this.add(pane);
  }
}
