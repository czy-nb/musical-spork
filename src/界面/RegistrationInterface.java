package 界面;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import Entity层.PatientInfo;
import Service层.PatientService;
import Service层.CheckPatientService;
import Service层.UrgentPatientService;
import 数据结构层.Quene;

public class RegistrationInterface {
	static Quene<PatientInfo> queneA = new Quene<PatientInfo>();
	static Quene<PatientInfo> queneB = new Quene<PatientInfo>();
	static Quene<PatientInfo> priorityquene = new Quene<PatientInfo>();
    static JTextField userText1 = new JTextField(20);
   static  JTextField userText2 = new JTextField(20);
    static JTextField userText3 = new JTextField(30);
    static JTextField userText4 = new JTextField(20);
    static  JTextField userText5 = new JTextField(20);
     static JTextField userText6 = new JTextField(30);
     static JTextField userText7 = new JTextField(30);
     static JTextField userText8 = new JTextField(30);
     static JTextField userText9 = new JTextField(30);
    static String str1;
    static String str2;
    static String str3;
     public static String doc;
     public static JFrame frame = new JFrame("欢迎登陆HIS系统 ");
    
    public static PatientInfo person = new PatientInfo();
	public static void main(String[] args) {
		
		挂号界面();
		
	}
	public static void 挂号界面() {
		// 创建 JFrame 实例
        JFrame frame = new JFrame("欢迎登陆HIS系统 ");
        // Setting the width and height of frame
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        
       
        
        frame.add(panel);
     
	
       
       
        panel.setLayout(null);
        
        
        JLabel Label1 = new JLabel("挂号ID：");
        Label1.setBounds(0,0,100,50);
        panel.add(Label1);
        
//        JTextField userText1 = new JTextField(20);
        userText1.setBounds(45,10,125,30);
        panel.add(userText1);
        Date s = new Date();
        SimpleDateFormat s1 = new SimpleDateFormat("yyyyMMddmmss");
        String s2 =s1.format(s);
        userText1.setText(s2);
        
        JLabel Label2 = new JLabel("姓名：");
        Label2.setBounds(180,0,100,50);
        panel.add(Label2);
        
//        JTextField userText2 = new JTextField(20);
        userText2.setBounds(220,10,125,30);
        panel.add(userText2);
        
        JLabel Label3 = new JLabel("性别：");
        Label3.setBounds(350,0,100,50);
        panel.add(Label3);
        JComboBox cmb=new JComboBox();    //创建JComboBox
        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem("男");
        cmb.addItem("女");
        cmb.setBounds(385, 10, 100,30);
        panel.add(cmb);
        
        JLabel Label4 = new JLabel("出生日期：");
        Label4.setBounds(500,0,100,50);
        panel.add(Label4);
        
//        JTextField userText3 = new JTextField(30);
        userText3.setBounds(560,10,180,30);
        panel.add(userText3);
        userText3.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				String s = userText3.getText();
				 char keyChar = e.getKeyChar();				

					if(!(keyChar >= '0' && keyChar <= '9'|| keyChar =='.')){

						e.consume(); 
					}//缺点，不能控制赋值黏贴的内容
				
				if(s.length() >= 10 ){

                    e.consume();

                }
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        JLabel Label5 = new JLabel("电话：");
        Label5.setBounds(0,60,100,50);
        panel.add(Label5);
        
//        JTextField userText4 = new JTextField(20);
        userText4.setBounds(45,70,125,30);
        panel.add(userText4);
        
        userText4.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				String s = userText4.getText();
				 char keyChar = e.getKeyChar();				

					if(!(keyChar >= '0' && keyChar <= '9')){

						e.consume(); 
					}//缺点，不能控制赋值黏贴的内容
				
				if(s.length() >= 11 ){

                   e.consume();

               }
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        JLabel Label6 = new JLabel("住址：");
        Label6.setBounds(180,60,100,50);
        panel.add(Label6);
        
//        JTextField userText5 = new JTextField(20);
        userText5.setBounds(220,70,125,30);
        panel.add(userText5);
        
        JLabel Label7 = new JLabel("身份证：");
        Label7.setBounds(350,60,100,50);
        panel.add(Label7);
        
//        JTextField userText6 = new JTextField(20);
        userText6.setBounds(395,70,345,30);
        panel.add(userText6);
        
        userText6.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				 String s =  userText6.getText();
				 char keyChar = e.getKeyChar();				

					if(!(keyChar >= '0' && keyChar <= '9')){

						e.consume(); 
					}//缺点，不能控制赋值黏贴的内容
	                if(s.length() >= 16) {

	                    e.consume();

	                }
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        JLabel Label8 = new JLabel("科室：");
        Label8.setBounds(0,120,125,50);
        panel.add(Label8);
        JComboBox cmb1=new JComboBox();    //创建JComboBox
        cmb1.addItem("--请选择--");    //向下拉列表中添加一项
        cmb1.addItem("1-外科");
        cmb1.addItem("2-内科");
        cmb1.addItem("3-耳鼻喉科");
        cmb1.addItem("4-妇科");
        cmb1.addItem("5-儿科");
        cmb1.addItem("6-脑科");
        cmb1.addItem("7-牙科");
        cmb1.setBounds(45, 130, 125,30);
        panel.add(cmb1);
        
			
        JLabel Label9 = new JLabel("医生：");
        Label9.setBounds(180,120,100,50);
        panel.add(Label9);
        JComboBox cmb2=new JComboBox();    //创建JComboBox
        cmb2.setBounds(220, 130, 125,30);
        panel.add(cmb2);
        cmb2.addItem("--请选择--");

	        cmb1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (cmb1.getSelectedItem().toString().equals("1-外科")){
						cmb2.addItem("王建军（普通）");
						cmb2.addItem("王思聪（省级专家）");
					}
					if (cmb1.getSelectedItem().toString().equals("2-内科")){
						cmb2.addItem("张飞");
						cmb2.addItem("朱军（省级专家）");
					}
					if (cmb1.getSelectedItem().toString().equals("3-耳鼻喉科")){
						cmb2.addItem("朱然（省级专家）");
						
					}
					if (cmb1.getSelectedItem().toString().equals("4-妇科")){
						cmb2.addItem("王报国（世界级专家）");
						cmb2.addItem("刘备（省级专家）");
					}
					if (cmb1.getSelectedItem().toString().equals("5-儿科")){
						cmb2.addItem("郑爽（普通）");
						cmb2.addItem("朱时茂（国家级专家）");
					}
					if (cmb1.getSelectedItem().toString().equals("6-脑科")){
						cmb2.addItem("刘莽（普通）");
						
					}
					if (cmb1.getSelectedItem().toString().equals("7-牙科")){
						cmb2.addItem("牛毕（省级专家）");
						cmb2.addItem("王时（省级专家）");
					}
					
				}
			});

        JLabel Label10 = new JLabel("诊费：");
        Label10.setBounds(350,120,100,50);
        panel.add(Label10);
        
        JTextField userText7 = new JTextField(20);
        userText7.setBounds(395,130,280,30);
        panel.add(userText7);
        
        JLabel Label12 = new JLabel("权值：");
        Label12.setBounds(350,160,100,50);
        panel.add(Label12);
        
        
        
        userText8.setBounds(395,170,100,30);
        panel.add(userText8);
        
        
        JLabel Label13 = new JLabel("一卡通号：");
        Label13.setBounds(0,160,100,50);
        panel.add(Label13);
        
        userText9.setBounds(80,170,200,30);
        panel.add(userText9);
        
        JButton btn1=new JButton("挂号"); 
        btn1.setBounds(850, 10, 80,40);
        panel.add(btn1);
      
        btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 System.out.println(userText9.getText());
				PatientInfo person = new PatientInfo();
				person.setCardnumber(userText9.getText());
				person.setID(userText1.getText());
				person.setName(userText2.getText());
				person.setSex(cmb.getSelectedItem().toString());
				person.setPhonenumber(userText4.getText());
				person.setBirth(userText3.getText());
				person.setAddress(userText5.getText());
				person.setIdcardnumber(userText6.getText());
				person.setKeshi(cmb1.getSelectedItem().toString());
				person.setDoc(cmb2.getSelectedItem().toString());
				PatientService service = new PatientService();
				doc = person.getDoc();
				String s = person.toString();
				service.writerfile(s+"\r\n");
				System.out.println(cmb1.getSelectedItem().toString());
				str1=cmb1.getSelectedItem().toString();
		        str2 = cmb2.getSelectedItem().toString();
		        str3=cmb.getSelectedItem().toString();
		        try {
					queneA.enqueue(person);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        JOptionPane.showMessageDialog(null, "挂号成功");
				new PatientInfoInterface().main(null);
				
				
			}
		});
        JButton btn2=new JButton("重置"); 
        btn2.setBounds(700, 120, 80,40);
        panel.add(btn2);
        btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cmb2.removeAllItems();
				cmb2.addItem("--请选择--");
				
			}
		});
     
        JButton btn3=new JButton("清空"); 
        btn3.setBounds(700, 200, 80,40);
        panel.add(btn3);
        btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				userText2.setText("");
				userText3.setText("");
				userText4.setText("");
				userText5.setText("");
				userText6.setText("");
				userText7.setText("");
				cmb.removeAllItems();
				cmb.addItem("--请选择--");
				cmb.addItem("男");
				cmb.addItem("女");
				cmb2.removeAllItems();
				cmb2.addItem("--请选择--");
			
				
			}
		});
        
        
        JLabel Label11 = new JLabel("备注：普通挂号20元，省级专家60元，国家级专家150元，世界级专家500元。");
        Label11.setBounds(100,200,1000,50);
        panel.add(Label11);
        
        JButton btn4=new JButton("检查病人挂号"); 
        btn4.setBounds(500, 300, 200,40);
        panel.add(btn4);
        btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PatientInfo person = new PatientInfo();
				person.setCardnumber(userText9.getText());
				person.setID(userText1.getText());
				person.setName(userText2.getText());
				person.setSex(cmb.getSelectedItem().toString());
				person.setPhonenumber(userText4.getText());
				person.setBirth(userText3.getText());
				person.setAddress(userText5.getText());
				person.setIdcardnumber(userText6.getText());
				person.setKeshi(cmb1.getSelectedItem().toString());
				person.setDoc(cmb2.getSelectedItem().toString());
				CheckPatientService service = new CheckPatientService();
				doc = person.getDoc();
				String s = person.toString();
				service.writerfile(s+"\r\n");
				System.out.println(cmb1.getSelectedItem().toString());
				str1=cmb1.getSelectedItem().toString();
		        str2 = cmb2.getSelectedItem().toString();
		        str3=cmb.getSelectedItem().toString();
		        try {
					queneB.enqueue(person);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        JOptionPane.showMessageDialog(null, "挂号成功");
				new PatientInfoInterface().main(null);
				
				
			}
		});
        JButton btn5=new JButton("紧急病人挂号"); 
        btn5.setBounds(500, 400, 200,40);
        panel.add(btn5);
        btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PatientInfo person = new PatientInfo();
				
				person.setCardnumber(userText9.getText());
				person.setID(userText1.getText());
				person.setName(userText2.getText());
				person.setSex(cmb.getSelectedItem().toString());
				person.setPhonenumber(userText4.getText());
				person.setBirth(userText3.getText());
				person.setAddress(userText5.getText());
				person.setIdcardnumber(userText6.getText());
				person.setKeshi(cmb1.getSelectedItem().toString());
				person.setDoc(cmb2.getSelectedItem().toString());
			//	int in = new Scanner(System.in).nextInt();
				//person.set权值(in);
				person.set权值(Integer.parseInt(userText8.getText()));
				UrgentPatientService service = new UrgentPatientService();
				doc = person.getDoc();
				String s = person.toString1();
				service.writerfile(s+"\r\n");
				System.out.println(cmb1.getSelectedItem().toString());
				str1=cmb1.getSelectedItem().toString();
		        str2 = cmb2.getSelectedItem().toString();
		        str3=cmb.getSelectedItem().toString();
		        try {
					priorityquene.enqueue(person);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        JOptionPane.showMessageDialog(null, "挂号成功");
				new PatientInfoInterface().main(null);
				
				
			}
		});
	}
	
	
}