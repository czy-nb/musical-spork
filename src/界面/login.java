package ����;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import Entity��.YiShengInfo;
import Entity��.GuaHaoYuanInfo;
import Entity��.YaoJuRenYuanInfo;
import Service��.DoctorService;
import Service��.GuaHaoYuanService;
import Service��.YaoJuService;
import Service��.YaoJuService; 
	
	public class login {
	
		static String ID;
		static JFrame frame = new JFrame("��ӭ��½HISϵͳ ");
		static YiShengInfo doc1 = new YiShengInfo();
		static GuaHaoYuanInfo doc2;
		static YaoJuRenYuanInfo doc3;
		
	    public static void main(String[] args) {    
	        // ���� JFrame ʵ��
	  
	        // Setting the width and height of frame
	        frame.setSize(800, 600);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        /* ������壬��������� HTML �� div ��ǩ
	         * ���ǿ��Դ��������岢�� JFrame ��ָ��λ��
	         * ��������ǿ�������ı��ֶΣ���ť�����������
	         */
	        JPanel panel = new JPanel(); 
	        panel.setBackground(Color.LIGHT_GRAY);
	        //JLabel label1=new JLabel();
	        JLabel label1=new JLabel("��ӭ��½HISϵͳ ");
	        label1.setBounds(230, 30,200, 150);
	        label1.setFont(new Font("����",Font.BOLD,20));
	     	
	    
					setBak();
	   		        panel.setOpaque(false);
	     	
		    ButtonGroup group=new ButtonGroup();
	  
	        panel.setLayout(null);

	        // ���� JLabel
	        JLabel userLabel = new JLabel("User:");
	        /* ������������������λ�á�
	         * setBounds(x, y, width, height)
	         * x �� y ָ�����Ͻǵ���λ�ã��� width �� height ָ���µĴ�С��
	         */
	        userLabel.setBounds(180,150,100,50);
	        panel.add(userLabel);

	        /* 
	         * �����ı��������û�����
	         */
	        JTextField userText = new JTextField(20);
	        userText.setBounds(220,160,165,30);
	        panel.add(userText);

	        // ����������ı���
	        JLabel passwordLabel = new JLabel("Password:");
	        passwordLabel.setBounds(150,200,80,45);
	        panel.add(passwordLabel);

	        /* 
	         *�����������������ı���
	         * �����������Ϣ���Ե�Ŵ��棬���ڰ�������İ�ȫ��
	         */
	        JPasswordField passwordText = new JPasswordField(20);
	        passwordText.setBounds(220,200,165,30);
	        panel.add(passwordText);
	       
	        JRadioButton rb1=new JRadioButton("�Һ�Ա");//����JRadioButton����
	       
	        JButton loginButton = new JButton("��½");
	        loginButton.setBounds(140, 280, 80, 25);
	        panel.add(loginButton);
	        
					 rb1.addActionListener(new ActionListener() {
				        	
							@Override
							public void actionPerformed(ActionEvent e) {
								loginButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										if(userText.getText().trim().length()==0||new String(passwordText.getPassword()).trim().length()==0){
											JOptionPane.showMessageDialog(null, "�û������벻����Ϊ��");
											return;
											}
										ArrayList<GuaHaoYuanInfo> list = new ArrayList<GuaHaoYuanInfo>() ;
										GuaHaoYuanService.read();
										list = GuaHaoYuanService.read1();
										
//										System.out.println(employeeInfo.list.contains("a"));
											for(int i=0;i<list.size();i++){
											if(list.get(i).getZhanghao().equals(userText.getText().trim())&& list.get(i).getPasswords().equals(new String(passwordText.getPassword()).trim())){
											doc2=list.get(i);
											JOptionPane.showMessageDialog(null, "��¼�ɹ�");
											break;
										}
											}
											if (doc2==null){
											JOptionPane.showMessageDialog(null, "�û������������ݴ���");
											return;
											}
											
										 ID = userText.getText().trim();
										close();
										opennext();
										
									}
								});
							}
					 
					
					});
				
				
				

	        JRadioButton rb2=new JRadioButton("ҽ��");
	        rb2.addActionListener(new ActionListener() {
	        	
				@Override
				public void actionPerformed(ActionEvent e) {
					loginButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(userText.getText().trim().length()==0||new String(passwordText.getPassword()).trim().length()==0){
								JOptionPane.showMessageDialog(null, "�û������벻����Ϊ��");
								return;
								}
							ArrayList<YiShengInfo> list = new ArrayList<YiShengInfo>() ;
							File file = new File("d://ҽ����Ϣ.txt");
							try{
							Scanner in = new Scanner(file);
							while(in.hasNext()){
							String s = in.nextLine();
							System.out.println(s);
							String[] temp = s.split(" ");
							String s1 = temp[2];
							String s2 = temp[3];
							System.out.println(temp[0]);
							System.out.println();
							if(s1.equals(userText.getText().trim())&& s2.equals(new String(passwordText.getPassword()).trim())){
								 doc1.setID(temp[0]);
								 doc1.setName(temp[1]);
								 doc1.setZhanghao(temp[2]);
								 doc1.setPasswords(temp[3]);
								JOptionPane.showMessageDialog(null, "��¼�ɹ�");
								
								 break;
								 }
							
							}
							
							}catch (Exception e1) {
					e1.printStackTrace();
				}
							
//							
								
							
							
							 close();
							wenzhen();
							 //close();
							
						}
					});
					
					
				}
			});
	        JRadioButton rb3=new JRadioButton("ҩ����Ա");  
	        rb3.addActionListener(new ActionListener() {
	        	
				@Override
				public void actionPerformed(ActionEvent e) {
					loginButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(userText.getText().trim().length()==0||new String(passwordText.getPassword()).trim().length()==0){
								JOptionPane.showMessageDialog(null, "�û������벻����Ϊ��");
								return;
								}
							ArrayList<YaoJuRenYuanInfo> list = new ArrayList<YaoJuRenYuanInfo>() ;
							YaoJuService.read();
							list = YaoJuService.read1();
//							System.out.println(employeeInfo.list.contains("a"));
                          for (int i=0;i<list.size();i++){
								if(list.get(i).getZhanghao().equals(userText.getText().trim())&& list.get(i).getPasswords().equals(new String(passwordText.getPassword()).trim())){
								JOptionPane.showMessageDialog(null, "��¼�ɹ�");
								doc3 =list.get(i);
								break;
								}
								}
								
								if (doc3==null){
								JOptionPane.showMessageDialog(null, "�û������������ݴ���");
								return;
								}
								
							 ID = userText.getText().trim();
							close();
							fayao();
							
						}
					});
					
					
				}
			});
	        
//	        loginButton.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					close();
//					new ������Ϣ����().jiemian();;
//				}
//			});
	        
	        //	�������ð�ť
	        JButton resetButton = new JButton("����");
	        resetButton.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent arg0) {
	        	// TODO �Զ����ɷ������
	        	userText.setText("");
	        	passwordText.setText("");
	        	}
	        	});
	        resetButton.setBounds(360, 280, 80, 25);
	        panel.add(resetButton);
	        group.add(rb1);
		    group.add(rb2);
		    group.add(rb3);
		    panel.add(rb1);
		    panel.add(rb2);
		    panel.add(rb3);
		    panel.add(label1);
		    //����λ��
		    
		    rb1.setBounds(160, 250, 80, 20);
		    rb2.setBounds(250, 250, 80, 20);
		    rb3.setBounds(350, 250, 80, 20);
	         // ������
	        frame.add(panel);
	        /* 
	         * �����û�����ķ����������������
	         */
	       

	        // ���ý���ɼ�
	        frame.setVisible(true);

	    }
	   public static void close() {
		   frame.dispose();
	   }
	   public static void opennext() {
	  
//		   new ��ӭ����1().�Һ�Ա����();
	   }
	   public static void wenzhen() {
	   
								
	   	   new DiagnoseInterface().main(null);
		 //  new ��ӭ����2().main(null);
	   }
	   public static void fayao() {
	  
//		   new ��ӭ����3().main(null);
	   }
	     public static void setBak(){ 
			   
				((JPanel)frame.getContentPane()).setOpaque(false);
				ImageIcon img = new ImageIcon("src/����/2.jpg"); //���ͼƬ
				JLabel background = new JLabel(img);frame.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
				background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());  
}
}