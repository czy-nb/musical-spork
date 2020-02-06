package 界面;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Panel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity层.PatientInfo;
import Service层.ReadPatientService;
import 数据结构层.Mycomparable;

public class AllPatientInfoInterface  {
	
	static File file = new File("d:"+File.separator+"patient.txt");
	static  ReadPatientService a = new ReadPatientService();
	static  ArrayList<String[]> temp = a.readFile(file);
    static  JFrame frame=new JFrame("患者信息总界面");
      static int num = temp.size();
    // static JTable table;
     static String[] split;
     static  ArrayList<PatientInfo> temp1 = new ArrayList<PatientInfo>() ;
	static Object[][] tableDate=new Object[num][9];
	String[] name={"挂号ID","患者姓名","性别","出生日期","电话","住址","身份证","科室","医生"};
    JTable table1=new JTable(tableDate,name);
    
	 //static DefaultTableModel tableModel=(DefaultTableModel) table.getModel(); 
public static void main(String[] args) { 
	
	File file = new File("d:"+File.separator+"patient.txt");
	 
     frame.setSize(800,600);
     frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     
    
   
  frame.setVisible(true);
 
}
     
public static void name排序() {
	
	File file=new File("d:"+File.separator+"patient.txt");
	try{
		FileReader fr=new FileReader (file);
	
	BufferedReader br=new BufferedReader(fr);
	String line=null;
    while((line=br.readLine())!=null){
    	PatientInfo p =new PatientInfo();
		StringTokenizer st=new StringTokenizer(line," ");
		
		p.setID(st.nextToken());
		p.setName(st.nextToken());
		p.setSex(st.nextToken());
		p.setBirth(st.nextToken());
		p.setAddress(st.nextToken());
		p.setPhonenumber(st.nextToken());
		p.setIdcardnumber(st.nextToken());
		p.setKeshi(st.nextToken());
		p.setDoc(st.nextToken());
		
		temp1.add(p);
}
  
        Mycomparable mycomparable = new Mycomparable();
        Collections.sort(temp1, mycomparable);
        Container contentPane=frame.getContentPane();
       
        for (int i= 0;i<temp1.size();i++) {
//      		   tableDate[i][j]=(temp.get(i))[j];
      	   
      		   String str = temp1.get(i).toString();
      		   String[] temp2 = str.split(" ");
      		   for (int z=0;z<temp2.length;z++) {
      			  String str2= temp2[z];
      				 tableDate[i][z]=str2;
      	
      			 }
      			   
      		   }
         
    
           
           
           
           String[] name={"挂号ID","患者姓名","性别","出生日期","电话","住址","身份证","科室","医生"};
           JTable table1=new JTable(tableDate,name);
           contentPane.add(new JScrollPane(table1));
          
   
	}catch (Exception e) {
		// TODO: handle exception
	}
}
  //  System.out.println(num);
  public static void ID排序() {
	  File file = new File("d:"+File.separator+"patient.txt");
	  Container contentPane=frame.getContentPane();
  for (int i= 0;i<num;i++) {
//		   tableDate[i][j]=(temp.get(i))[j];
	   
		   String[] str = temp.get(i);
		  // System.out.println(str.length);
		   for (int z=0;z<str.length;z++) {
			  String temp2 = str[z];
			    split = temp2.split(" ");
			  //System.out.println(split.length);
			 for (int j=0;j<1;j++) {
				//System.out.println(split[j]);
				 
				 tableDate[i][z]=split[j];
	
			 }
			   
		   }
   }
		  // System.out.println(temp2);
//		  String[] split = temp2.split(",");
//		  tableDate[i][j]=[j];
//		}
////		   tableDate[i][j] = strs[j];
   
     
     
     
     
     String[] name={"挂号ID","患者姓名","性别","出生日期","电话","住址","身份证","科室","医生"};
     JTable table1=new JTable(tableDate,name);
     contentPane.add(new JScrollPane(table1));
    
  }


	
     
    
     

      
}

