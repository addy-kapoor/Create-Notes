package scarpbook;
import javax.swing.*;
import java.time.LocalDate;
import java.sql.*;
import java.text.DateFormat;

//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Canvas;
import java.awt.SystemColor;
public class Notes extends JFrame{
	public static String notes_date1;
	public static String selectedHeading;
   JPanel p1;
   JPanel mainPanel;
   String[] headarray;
    static int i;
   Notes(){
	   
	   setSize(700,700);

	   headarray = new String[10];
   p1= new JPanel();
   p1.setBackground(SystemColor.activeCaption);
   JPanel mainPanel = new JPanel();
   mainPanel.setBackground(new Color(204, 204, 255));
   p1.setBounds(0,0,686,234);
   mainPanel.setBounds(0,231, 686, 433);
   getContentPane().setLayout(null);
   getContentPane().add(p1);
   getContentPane().add(mainPanel);
   mainPanel.setLayout(new GridLayout(0, 2, 0, 0));
   p1.setLayout(null);
   
      
   JDateChooser dateChooser = new JDateChooser();
   dateChooser.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
   dateChooser.setBounds(33, 108, 327, 33);
   p1.add(dateChooser);
   dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 14));
   dateChooser.setToolTipText("Select Date");
   DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
   Date date = new Date();
   dateChooser.setDate(date);
   notes_date1 = df.format(dateChooser.getDate());
   
      
      dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
   	   @Override
   	      public void propertyChange(PropertyChangeEvent e)  {
   		   System.out.println("called ");
   		   try {
   			    notes_date1 = df.format(((JDateChooser)e.getSource()).getDate());
   		   		Class.forName("com.mysql.cj.jdbc.Driver");
   		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scrapbook","root","root");
   		        Statement sta = con.createStatement();
   		        System.out.println("notes_date1 " + notes_date1);
   		        ResultSet results = sta.executeQuery("SELECT heading FROM createnotes where notes_date =" +"'"+notes_date1+"'"
   		        		+"and username ="+"'"+Session.userDetails.getUsername()+"'");
		   		  int rowCount=0;
		   		  while(results.next())
		   		  {       
		   			headarray[rowCount] = results.getString("heading");
		   		     rowCount++;  
		   		  }
		   		  System.out.println("row Count "+rowCount);
   		           JLabel[] labels = new JLabel[rowCount];
   		           for(i=0;i<rowCount;i++)
   		           {
   		        	mainPanel.removeAll();
		        	   mainPanel.repaint();
		        	   mainPanel.revalidate();
   		        	   labels[i]=new JLabel(headarray[i]); 
   		           } 	
   		           for(i=0;i<rowCount;i++)
   		           {
//   		         	System.out.println("selected heading :"+selectedHeading);
   		        	   labels[i].addMouseListener(new MouseAdapter() {
   		        	   		@Override
   		        	   	 
   		        	   		public void mouseClicked(MouseEvent e) {
   		        	   			selectedHeading = ( (JLabel) e.getSource()).getText();
//	   		        	   		System.out.println("selected heading :"+( (JLabel) e.getSource()).getText());
	   		        	   		new DisplayNotes();
	   		        	   	}
   		        	   });
   		        	   mainPanel.add(labels[i]);
   		        	   mainPanel.revalidate();
   		           }
   		   	   }
   		   		catch(Exception ep) {
   		   			System.out.println(ep);
   		   		}
   	      }
   	   });
   
   JButton btnNewButton = new JButton("LOG OUT");
   btnNewButton.setBounds(248, 170, 129, 33);
   p1.add(btnNewButton);
   
   btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
   btnNewButton.setVerticalAlignment(SwingConstants.TOP);
   btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
   
   JButton btnNewButton_1 = new JButton("CREATE NOTES");
   btnNewButton_1.setBounds(33, 171, 190, 33);
   p1.add(btnNewButton_1);
   btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
   
   JLabel lblNewLabel = new JLabel("User -");
   lblNewLabel.setForeground(new Color(0, 0, 0));
   lblNewLabel.setBackground(new Color(230, 230, 250));
   lblNewLabel.setFont(new Font("Vani", Font.BOLD | Font.ITALIC, 25));
   lblNewLabel.setBounds(33, 8, 88, 48);
   p1.add(lblNewLabel);
   
   JLabel lblNewLabel_1 = new JLabel(Session.userDetails.getUsername());
   lblNewLabel_1.setFont(new Font("Vani", Font.BOLD | Font.ITALIC, 25));
   lblNewLabel_1.setBounds(111, 10, 155, 45);
   p1.add(lblNewLabel_1);
   
   JLabel lblNewLabel_2 = new JLabel("select date for displaying notes");
   lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
   lblNewLabel_2.setBounds(33, 76, 284, 33);
   p1.add(lblNewLabel_2);
   
   Canvas canvas = new MyCanvas("C:\\Users\\Aditi\\Downloads\\Education_31-60_663.jpg");
   canvas.setBounds(441, 0, 245, 234);
   p1.add(canvas);
   
   btnNewButton_1.addActionListener(new ActionListener() {
   	public void actionPerformed(ActionEvent e) {
   		new CreateNotes();
   	}
   });
   btnNewButton.addActionListener(new ActionListener() {
   	public void actionPerformed(ActionEvent e) {
   		System.exit(0);
   	}
   });
    
   
   setLocationRelativeTo(null);
   setVisible(true);
   }
	public static void main(String[] args) {
		new Notes();
	}
}
