import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
 
public class AddLift extends JDialog implements ActionListener
{
	JPanel bottom;
	JButton ok;
    JButton cancel;
    DialogPanel dialogPanel;
                               
    public AddLift() 
    {
    	setTitle("Add Lift");
    	ok = new JButton("OK");
        cancel = new JButton("Cancel");
        ok.addActionListener(this);
        cancel.addActionListener(this);
        bottom = new JPanel();
        bottom.add(ok);
        bottom.add(cancel);
        bottom.setBorder(BorderFactory.createEmptyBorder());
        dialogPanel = new DialogPanel();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(bottom,BorderLayout.SOUTH);
        getContentPane().add(dialogPanel,BorderLayout.CENTER);                        
    }
 
    
    public void actionPerformed(ActionEvent e) 
    	{                        
                                               
    		JButton button = (JButton) e.getSource();
    		String label = button.getText();
                                               
            if(label.equals("OK")) 
            {
            String dateString = dialogPanel.date.getText();
            String liftString = dialogPanel.lift.getText();
            String setsString = dialogPanel.sets.getText();
            String repsString = dialogPanel.reps.getText();
            int sets = Integer.parseInt(setsString);
            int reps = Integer.parseInt(repsString);
            
            	try 
            	{
            		String query = null;
              	  	Class.forName ("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://sql2.njit.edu:3306/pas47";
	                Connection connection = DriverManager.getConnection(url, "pas47", "gbOcRchUu");
	                Statement stmt = connection.createStatement();
	                query = "INSERT INTO LiftLog VALUES ('" + dateString + " ',' " + liftString + " ',' " + reps + " ',' " + sets + " ')";
	                stmt.executeUpdate(query);
	                stmt.close();                                         
	                            
	                if (connection != null) 
	                {
	                	connection.close();                                                     
	                }
	            } 
	            catch (Exception ex) 
	            {
	            	ex.printStackTrace();
	            }
            }
            else 
			{
	            //nothing done, close the dialog
			}
	        dialogPanel.reset();
	        setVisible(false);
    	}
}
                                                               