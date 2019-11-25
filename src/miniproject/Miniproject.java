/*
 * project on automatic time-table generator
 */
package miniproject;
import java.awt.*;
import java.util.*;
import java.awt.event.*;    
import javax.swing.*; 
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;



public class Miniproject {

    
 public static void main(String[] args) throws IOException{
        
     // hashmap declaration  
     
    Map<String,Batch1> B = new HashMap<String,Batch1>();
    Map<String,Course1> CO = new HashMap<String,Course1>();
    
    
    JFrame f=new JFrame();  
    JFrame s=new JFrame();  
    
    //Home Panel........
    
    JPanel home=new JPanel();
    
    JLabel l1=new JLabel("Welcome");
    l1.setBounds(250,50,850,200);
    l1.setFont(new Font("TimesRoman",Font.BOLD,35));
    
    JLabel l2=new JLabel("Automatic Scheduler");
    l2.setBounds(190,150,850,200);
    l2.setFont(new Font("TimesRoman",Font.BOLD,35));
    
    BufferedImage image = ImageIO.read(new File("C:\\Users\\chandan123\\Documents\\NetBeansProjects\\miniproject\\src\\miniproject\\ttimage.jpg"));
    JLabel label = new JLabel(new ImageIcon(image));
    label.setSize(600,500);
    label.setBounds(700,20,500,600);
    home.setLayout(null);
    home.setBackground(Color.white);
    home.add(label);
    home.add(l1);
    home.add(l2);
    
    
    //declaration...
    String[] name_of_classroom={"Select"};             //stores the names of classrooms like ise,cse,ece....
    String[] credits={"1","2","3","4","5","6","7","8","9","10"};     //stores the credits of the each subjects
    String[] subjects={"Select"};             //stores the name of the subjects
    JComboBox cr=new JComboBox(credits);
    JComboBox nc=new JComboBox(name_of_classroom);
    JComboBox co=new JComboBox(subjects);
    
    //Creating Classrooms......
    JPanel createBatch=new JPanel();
    JLabel cb1= new JLabel("Name of classroom");
    cb1.setFont(new Font("TimesRoman",Font.BOLD,20)); 
    cb1.setBounds(50,100,200,50);
    
    JTextField cb2 = new JTextField();
    cb2.setBounds(250,100,200,50);
    
    JLabel cb3 =new JLabel("Subjects");
    cb3.setFont(new Font("TimesRoman",Font.BOLD,20)); 
    cb3.setBounds(50,275,200,50);
    
    JComboBox cb4 = new JComboBox(subjects);
    cb4.setBounds(250,275,200,50);
    
    JButton cb5 = new JButton("ADD"); 
    cb5.setBounds(550,275,200,50);
    cb5.setBackground(Color.cyan);
    
    JButton cb6 = new JButton("Create");
    cb6.setBounds(550,100,200,50);
    cb6.setBackground(Color.cyan);
    
    cb6.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            nc.addItem(cb2.getText());
            B.put(cb2.getText(),new Batch1());
            B.get(cb2.getText()).setName(cb2.getText());
            JOptionPane.showMessageDialog(s,"A new classroom "+cb2.getText()+" has been created");
        }
    });
    
    cb5.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            if(cb4.getSelectedIndex()!=0)
            {
                if(B.get(cb2.getText()).adding(CO.get(cb4.getItemAt(cb4.getSelectedIndex()).toString())))
                {
                    JOptionPane.showMessageDialog(s,"A new course has been added to the batch "+cb2.getText()+"\n"+"Course: "+cb4.getItemAt(cb4.getSelectedIndex()).toString()+"\n");
                }
                else
                {
                    JOptionPane.showMessageDialog(s,"Periods are insufficient for adding this course to the batch");
                }
            }
             else
            {
                JOptionPane.showMessageDialog(s,"Select a valid course ","Message",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    });
   
    createBatch.setLayout(null);
    createBatch.setBackground(Color.orange);
    createBatch.add(cb1);
    createBatch.add(cb2);
    createBatch.add(cb3);
    createBatch.add(cb4);
    createBatch.add(cb5);
    createBatch.add(cb6);
   
   
   //Creating courses......
   JPanel createCourse=new JPanel();
    JLabel cc1= new JLabel("Name of course");
    cc1.setFont(new Font("TimesRoman",Font.BOLD,20));
    cc1.setBounds(50,100,200,50);
    
    JTextField cc2 = new JTextField();
    cc2.setBounds(250,100,200,50);
    
    JLabel cc3 = new JLabel("Credits");
    cc3.setFont(new Font("TimesRoman",Font.BOLD,20));
    cc3.setBounds(50,275,200,50);
    
    JComboBox cc4 = new JComboBox(credits);
    cc4.setBounds(250,275,200,50);
    
    JButton cc5 = new JButton("Create");
    cc5.setBounds(250,450,200,50);
    cc5.setBackground(Color.cyan);
    
    cc5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){ 
            cb4.addItem(cc2.getText());
            CO.put(cc2.getText(),new Course1());
            CO.get(cc2.getText()).setName(cc2.getText());
            CO.get(cc2.getText()).setCredits(Integer.parseInt(cc4.getItemAt(cc4.getSelectedIndex()).toString()));
            JOptionPane.showMessageDialog(s,"A new course has been created"+"\n"+"Course: "+cc2.getText()+"\n"+"Credits: "+Integer.parseInt(cc4.getItemAt(cc4.getSelectedIndex()).toString()));        
        }
    });
    
    createCourse.setLayout(null);
    createCourse.setBackground(Color.orange);
    createCourse.add(cc1);
    createCourse.add(cc2);
    createCourse.add(cc3);
    createCourse.add(cc4);
    createCourse.add(cc5);

    //Viewing
    
    JPanel view=new JPanel(); 
    JTabbedPane t=new JTabbedPane();
    JLabel vl=new JLabel("Timetable");
    vl.setBounds(530,5,250,70);
    vl.setFont(new Font("TimesRoman",Font.BOLD,20)); 
    final String[][] time = { {"1","","","","","",""},    
                               {"2","","","","","",""},    
                               {"3","","","","","",""},
                               {"4","","","","","",""}, 
                               {"5","","","","","",""}, 
                               {"6","","","","","",""} };  
        
        
    String column[]={"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    JTable jt=new JTable(time,column);
    jt.setSize(1000,100);
    JScrollPane sp=new JScrollPane(jt);
    sp.setSize(1000,150);
    sp.setBounds(100,150,1000,125);
    nc.setBounds(475,70,100,20);
    
    nc.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
            for(int i=0;i<6;i++){
                for(int j=0;j<6;j++){
			        time[i][j+1]=B.get(nc.getItemAt(nc.getSelectedIndex()).toString()).timetable[i][j];
                }
            }
            
            view.revalidate();
            view.repaint();  
        }
    });
   
    view.setLayout(null);
    view.setBackground(Color.orange);	
    view.add(vl); 
    view.add(nc);
    jt.setVisible(true);
    view.add(sp);
    sp.setVisible(true);
   
    
    
     //Adding into the frame
    t.add("Home",home);  
    t.add("Create Course",createCourse);
    t.add("Create Classrooms",createBatch);
    t.add("View",view);  
    t.setBackground(Color.green);  
    f.add(t);  
    f.setSize(1500,800);  
    t.setBounds(50,50,1200,600); 
    f.setLayout(null); 
    f.setVisible(true);
    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
}
