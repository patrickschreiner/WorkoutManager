import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
 

public class WorkoutManager extends JFrame implements ActionListener
{
	public WorkoutManager()
	{
		super("Workout Manager");
		setLayout(new BorderLayout());
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Welcome to the Workout Manager"));
        BufferedImage image;
		try 
		{
			image = ImageIO.read(new File("barbell.png"));
	        JLabel midPanel = new JLabel(new ImageIcon(image));
	        add(midPanel, BorderLayout.CENTER);

		} 
		catch (IOException e) 
		{
		
			e.printStackTrace();
		}
        JPanel bottomPanel = new JPanel();
        JButton addButton = new JButton("Add Lift");
        addButton.addActionListener(this);
        bottomPanel.add(addButton);
        JButton viewButton = new JButton("View Workout Log");
        viewButton.addActionListener(this);
        bottomPanel.add(viewButton);
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
        
        setVisible(true);
	}
	
 
    public void actionPerformed(ActionEvent event) 
    	{ 
    		JButton button =  (JButton) event.getSource();
            String label = button.getText();
            JDialog dialog = null;
            if(label.equals("Add Lift")) 
            {      
            	if(dialog == null)
            	{ 
            		dialog = new AddLift();
            		dialog.setSize(300, 200);
                    dialog.setVisible(true);
            	}
            }                                              
            else 
            {
            	if(dialog == null) 
            	{ 
            		dialog = new ViewWorkoutLog();
            		dialog.setSize(400, 500);
            		dialog.setVisible(true);
            	}
            }
            
    	}
    
    public static void main (String args[])
    {
    	new WorkoutManager();
    }
}