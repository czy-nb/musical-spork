package ����;

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

import Entity��.PatientInfo;
import Service��.PatientService;
import Service��.CheckPatientService;
import Service��.UrgentPatientService;
import ���ݽṹ��.Quene;

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
     public static JFrame frame = new JFrame("��ӭ��½HISϵͳ ");
    
    public static PatientInfo person = new PatientInfo();
	public static void main(String[] args) {
		
		�ҺŽ���();
		
	}
	public static void �ҺŽ���() {
		// ���� JFrame ʵ��
        JFrame frame = new JFrame("��ӭ��½HISϵͳ ");
        // Setting the width and height of frame
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        
       
        
        frame.add(panel);
     
	
       
       
        panel.setLayout(null);
        
        
        JLabel Label1 = new JLabel("�Һ�ID��");
        Label1.setBounds(0,0,100,50);
        panel.add(Label1);
        
//        JTextField userText1 = new JTextField(20);
        userText1.setBounds(45,10,125,30);
        panel.add(userText1);
        Date s = new Date();
        SimpleDateFormat s1 = new SimpleDateFormat("yyyyMMddmmss");
        String s2 =s1.format(s);
        userText1.setText(s2);
        
        JLabel Label2 = new JLabel("������");
        Label2.setBounds(180,0,100,50);
        panel.add(Label2);
        
//        JTextField userText2 = new JTextField(20);
        userText2.setBounds(220,10,125,30);
        panel.add(userText2);
        
        JLabel Label3 = new JLabel("�Ա�");
        Label3.setBounds(350,0,100,50);
        panel.add(Label3);
        JComboBox cmb=new JComboBox();    //����JComboBox
        cmb.addItem("--��ѡ��--");    //�������б������һ��
        cmb.addItem("��");
        cmb.addItem("Ů");
        cmb.setBounds(385, 10, 100,30);
        panel.add(cmb);
        
        JLabel Label4 = new JLabel("�������ڣ�");
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
					}//ȱ�㣬���ܿ��Ƹ�ֵ���������
				
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
        JLabel Label5 = new JLabel("�绰��");
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
					}//ȱ�㣬���ܿ��Ƹ�ֵ���������
				
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
        
        JLabel Label6 = new JLabel("סַ��");
        Label6.setBounds(180,60,100,50);
        panel.add(Label6);
        
//        JTextField userText5 = new JTextField(20);
        userText5.setBounds(220,70,125,30);
        panel.add(userText5);
        
        JLabel Label7 = new JLabel("���֤��");
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
					}//ȱ�㣬���ܿ��Ƹ�ֵ���������
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
        
        JLabel Label8 = new JLabel("���ң�");
        Label8.setBounds(0,120,125,50);
        panel.add(Label8);
        JComboBox cmb1=new JComboBox();    //����JComboBox
        cmb1.addItem("--��ѡ��--");    //�������б������һ��
        cmb1.addItem("1-���");
        cmb1.addItem("2-�ڿ�");
        cmb1.addItem("3-���Ǻ��");
        cmb1.addItem("4-����");
        cmb1.addItem("5-����");
        cmb1.addItem("6-�Կ�");
        cmb1.addItem("7-����");
        cmb1.setBounds(45, 130, 125,30);
        panel.add(cmb1);
        
			
        JLabel Label9 = new JLabel("ҽ����");
        Label9.setBounds(180,120,100,50);
        panel.add(Label9);
        JComboBox cmb2=new JComboBox();    //����JComboBox
        cmb2.setBounds(220, 130, 125,30);
        panel.add(cmb2);
        cmb2.addItem("--��ѡ��--");

	        cmb1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (cmb1.getSelectedItem().toString().equals("1-���")){
						cmb2.addItem("����������ͨ��");
						cmb2.addItem("��˼�ϣ�ʡ��ר�ң�");
					}
					if (cmb1.getSelectedItem().toString().equals("2-�ڿ�")){
						cmb2.addItem("�ŷ�");
						cmb2.addItem("�����ʡ��ר�ң�");
					}
					if (cmb1.getSelectedItem().toString().equals("3-���Ǻ��")){
						cmb2.addItem("��Ȼ��ʡ��ר�ң�");
						
					}
					if (cmb1.getSelectedItem().toString().equals("4-����")){
						cmb2.addItem("�����������缶ר�ң�");
						cmb2.addItem("������ʡ��ר�ң�");
					}
					if (cmb1.getSelectedItem().toString().equals("5-����")){
						cmb2.addItem("֣ˬ����ͨ��");
						cmb2.addItem("��ʱï�����Ҽ�ר�ң�");
					}
					if (cmb1.getSelectedItem().toString().equals("6-�Կ�")){
						cmb2.addItem("��ç����ͨ��");
						
					}
					if (cmb1.getSelectedItem().toString().equals("7-����")){
						cmb2.addItem("ţ�ϣ�ʡ��ר�ң�");
						cmb2.addItem("��ʱ��ʡ��ר�ң�");
					}
					
				}
			});

        JLabel Label10 = new JLabel("��ѣ�");
        Label10.setBounds(350,120,100,50);
        panel.add(Label10);
        
        JTextField userText7 = new JTextField(20);
        userText7.setBounds(395,130,280,30);
        panel.add(userText7);
        
        JLabel Label12 = new JLabel("Ȩֵ��");
        Label12.setBounds(350,160,100,50);
        panel.add(Label12);
        
        
        
        userText8.setBounds(395,170,100,30);
        panel.add(userText8);
        
        
        JLabel Label13 = new JLabel("һ��ͨ�ţ�");
        Label13.setBounds(0,160,100,50);
        panel.add(Label13);
        
        userText9.setBounds(80,170,200,30);
        panel.add(userText9);
        
        JButton btn1=new JButton("�Һ�"); 
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
		        JOptionPane.showMessageDialog(null, "�Һųɹ�");
				new PatientInfoInterface().main(null);
				
				
			}
		});
        JButton btn2=new JButton("����"); 
        btn2.setBounds(700, 120, 80,40);
        panel.add(btn2);
        btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cmb2.removeAllItems();
				cmb2.addItem("--��ѡ��--");
				
			}
		});
     
        JButton btn3=new JButton("���"); 
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
				cmb.addItem("--��ѡ��--");
				cmb.addItem("��");
				cmb.addItem("Ů");
				cmb2.removeAllItems();
				cmb2.addItem("--��ѡ��--");
			
				
			}
		});
        
        
        JLabel Label11 = new JLabel("��ע����ͨ�Һ�20Ԫ��ʡ��ר��60Ԫ�����Ҽ�ר��150Ԫ�����缶ר��500Ԫ��");
        Label11.setBounds(100,200,1000,50);
        panel.add(Label11);
        
        JButton btn4=new JButton("��鲡�˹Һ�"); 
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
		        JOptionPane.showMessageDialog(null, "�Һųɹ�");
				new PatientInfoInterface().main(null);
				
				
			}
		});
        JButton btn5=new JButton("�������˹Һ�"); 
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
				//person.setȨֵ(in);
				person.setȨֵ(Integer.parseInt(userText8.getText()));
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
		        JOptionPane.showMessageDialog(null, "�Һųɹ�");
				new PatientInfoInterface().main(null);
				
				
			}
		});
	}
	
	
}