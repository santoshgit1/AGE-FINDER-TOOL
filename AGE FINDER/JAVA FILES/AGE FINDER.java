package project;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AGE_FINDER 
{
	
	JFrame frame;
	JLabel welcome, name, DOB, asOnDate;
	JTextField txtName;
	JButton btnCalculator, btnExit, btnReset, AGE_FINDER_DateButton;
	private AGE_FINDER_DateButton dobButton;
	private AGE_FINDER_DateButton asOnButton;
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	String warningMessage;
	int asOnDay,asOnMonth,asOnYear,dobDay,dobMonth,dobYear,newDay,newMonth,newYear;
	//----------------------------------------------------------------------
	public AGE_FINDER()
	{
		frame = new JFrame("Age Calculator Program");
		frame.setSize(d.width/3, d.height/3);
		frame.setLocation(d.width/5, d.height/5);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		//----------------------------------------------------------------------
		welcome = new JLabel("Welcome to 'Age Calculator Tool' :");
		Font f = new Font("Italian",Font.BOLD,30);   // SET FONT
		welcome.setFont(f);       
		welcome.setForeground(Color.red);                // SET COLOR
	    welcome.setBounds(20, 10, 600, 40);              // (x-axis, y-axis, width, length)
		
		name = new JLabel("NAME : ");
		DOB = new JLabel("DOB : ");
		asOnDate = new JLabel("AS ON DATE : ");
		txtName = new JTextField(200);
		
		Font f1 = new Font("Times New Roman",Font.BOLD,20);
		name.setFont(f1); 
		DOB.setFont(f1); 
		asOnDate.setFont(f1); 
		//------------------------------------------------------------------------------
		btnCalculator = new JButton("Calculate");
		btnCalculator.setForeground(Color.MAGENTA);
        btnCalculator.setBounds(79, 236, 150, 49);

		btnExit = new JButton("Exit");
		btnExit.setForeground(Color.MAGENTA);
        btnExit.setBounds(330, 236, 180, 49); 
		
		Font f2 = new Font("Italian",Font.BOLD,25);   // SET FONT
		btnCalculator.setFont(f2); 
		btnExit.setFont(f2); 
        //------------------------------------------------------------------------------
		dobButton = new AGE_FINDER_DateButton();
		dobButton.setForeground(Color.blue);
		asOnButton = new AGE_FINDER_DateButton();
        asOnButton.setForeground(Color.blue);
  
        name.setBounds(40, 83, 150, 30);
        txtName.setBounds(186, 86, 250, 30);
        DOB.setBounds(40, 124, 150, 30);
        dobButton.setBounds(186, 124, 110, 30);
        asOnDate.setBounds(40, 164, 150, 30);
        asOnButton.setBounds(186, 165, 110, 30);
        
        btnCalculator.addActionListener(new CalculatorClass());
        //btnReset.addActionListener(new ResetClass());
        btnExit.addActionListener(new ExitClass());
        
        frame.getContentPane().add(welcome);
        frame.getContentPane().add(name);
        frame.getContentPane().add(txtName);
        frame.getContentPane().add(DOB);
        frame.getContentPane().add(dobButton);
        frame.getContentPane().add(asOnDate);
        frame.getContentPane().add(asOnButton);
        frame.getContentPane().add(btnCalculator);
        frame.getContentPane().add(btnExit);
        
        frame.setVisible(true);  
        frame.setResizable(false);
	    frame.setLayout(null);
	}
//----------------------------------------------	
   boolean isCorrect()
   {
			if(txtName.getText().trim().equals(""))
			{
				warningMessage = "Please enter your name first !";
				txtName.setFocusable(true);
				txtName.setText("");
				return false;
			}
			if(asOnButton.getDate().before(dobButton.getDate()))
			{
				warningMessage = "Please enter a valid As On Date or DOB !";
				asOnButton.setFocusable(true);
				return false;
			}
			return true;
   }		
//--------------------------------------------------------------------------------------------
	 class ExitClass implements ActionListener   //ExitClass.
	 {
		  public void actionPerformed(ActionEvent ae)
		  {
			  System.exit(0);
		  }
	 }
//-----------------------------------------------------------------------------------------------	
	 class CalculatorClass implements ActionListener   //CalculatorClass.
	 {
		 	@SuppressWarnings("deprecation")
		 	public void actionPerformed(ActionEvent ae){
		 		asOnDay = asOnButton.getDate().getDate();
		 		asOnMonth = asOnButton.getDate().getMonth()+1;
		 		asOnYear = asOnButton.getDate().getYear()+1900;
		 		dobDay = dobButton.getDate().getDate();
		 		dobMonth = dobButton.getDate().getMonth()+1;
		 		dobYear = dobButton.getDate().getYear()+1900;
			
		 		boolean status = isCorrect();
		 		if(status)
		 		{
								
		 			if(asOnDay>=dobDay)
		 			{
						newDay=asOnDay-dobDay;
		 			}
		 			else
		 			{
		 				newDay=(asOnDay+30)-dobDay;
		 				asOnMonth--;
		 			}
		 			if(asOnMonth>=dobMonth)
		 			{
					newMonth=asOnMonth-dobMonth;
		 			}
		 			else
		 			{
		 				newMonth=asOnMonth+12-dobMonth;
		 				asOnYear--;
		 			}
		 			newYear=asOnYear-dobYear;
		 			String asOnDateOutput = (asOnButton.getDate().getYear()+1900)+"-"+(asOnButton.getDate().getMonth()+1)+"-"+asOnButton.getDate().getDate();
		 			String output =txtName.getText().trim().toUpperCase()+",  (Your Current Age as on  "+asOnDateOutput+" is )---> [[[ "+newYear+" Years, "+newMonth+" Months, and "+newDay+" Days ]]]";
		 			JOptionPane.showMessageDialog(null,output,"YOUR AGE !",JOptionPane.INFORMATION_MESSAGE);
				
		 		}
		 		else
		 		{
		 			JOptionPane.showMessageDialog(null,warningMessage,"Warning",JOptionPane.WARNING_MESSAGE);
		 			//txtName.setText("");
		 		}
		  }
	 }		
//--------------------------------------------------------------------------------	
	public static void main(String args[])
	{
		new AGE_FINDER();
	}
}
