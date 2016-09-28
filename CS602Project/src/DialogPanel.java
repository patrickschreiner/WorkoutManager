import java.awt.*;
import javax.swing.*;

public class DialogPanel extends JPanel 
{
	JLabel dateLabel;
	JTextField date;
	JLabel liftLabel;
    JTextField lift;
    JLabel repsLabel;
    JTextField reps;
    JLabel setsLabel;
    JTextField sets;
    
    public DialogPanel() 
    {
    	dateLabel = new JLabel("Date (MM/DD/YYYY)");
    	date = new JTextField();
    	liftLabel = new JLabel("Lift");
        lift = new JTextField();
        repsLabel = new JLabel("Sets");
        reps = new JTextField();
        setsLabel = new JLabel("Repetitions");
        sets = new JTextField();                 
        
        add(dateLabel);
        add(date);
        add(liftLabel);
        add(lift);
        add(repsLabel);
        add(reps);
        add(setsLabel);
        add(sets);
    }
    
    public Dimension getPreferredSize() 
    {
        return new Dimension(400, 400);
    }

    public Dimension getMinimumSize() 
    {
        return new Dimension(400, 400);
    }

    public void doLayout() 
    {
        dateLabel.setBounds(10, 5, 200, 30);
        date.setBounds(120, 10, 70, 20);
    	liftLabel.setBounds(10, 35, 200, 30);
        lift.setBounds(120, 40, 120, 20);
        repsLabel.setBounds(10, 65, 200, 30);
        reps.setBounds(120, 70, 30, 20);
        setsLabel.setBounds(10, 95, 200, 30);
        sets.setBounds(120, 100, 30, 20);
    }

    public void reset() 
    {

    	dateLabel.setText("");
        date.setText("");
    	liftLabel.setText("");
        lift.setText("");
        repsLabel.setText("");
        reps.setText("");
        setsLabel.setText("");
        sets.setText("");
    }
}

           
               
                
                                
             
               
                