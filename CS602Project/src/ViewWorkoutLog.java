import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;

class ViewWorkoutLog extends JDialog implements ActionListener
{
	 JPanel buttons;
     JButton ok;
     JButton cancel;
     JPanel log;
     public ViewWorkoutLog() 
     {
    	  setTitle("View Workout Log");
          ok = new JButton("OK");
          ok.addActionListener(this);
          buttons = new JPanel();
          buttons.add(ok);
          buttons.setBorder(BorderFactory.createEmptyBorder());
          String view = "Workout Data \n\n";
          
          try 
          {
        	  Class.forName ("com.mysql.jdbc.Driver");
              String url = "jdbc:mysql://sql2.njit.edu:3306/pas47";
        	  Connection connection = DriverManager.getConnection(url, "pas47", "gbOcRchUu");
              Statement stmt = connection.createStatement();
              String query = "Select * from LiftLog";
              ResultSet rs = stmt.executeQuery(query);
              while (rs.next()) 
              {
            	  String date = rs.getString(1);
            	  String lift = rs.getString(2);
            	  int sets = rs.getInt(3);
            	  int reps = rs.getInt(4); 
            	  String setString = Integer.toString(sets);
            	  String repString = Integer.toString(reps);
            	  view = view + "Date: " + date + "\nLift: " + lift + "\nSets: " + setString + "\nReps: " + repString + "\n\n";
              }              
              rs.close(); 
              stmt.close();
              if (connection != null)
              { 
            	  connection.close();   
              }
          }
              
          catch(Exception e)
          {
        	  e.printStackTrace();
          }
          
          JTextArea textArea = new JTextArea(view, 25, 25);
          JScrollPane scroll = new JScrollPane(textArea);
          log = new JPanel();
          log.add(scroll);
          getContentPane().setLayout(new BorderLayout());
          getContentPane().add(buttons,BorderLayout.SOUTH);
          getContentPane().add(log,BorderLayout.CENTER);
          

     }
 
     
               
     public void actionPerformed(ActionEvent e) 
     {                        
        	setVisible(false);
     }
}                              
