package 界面;

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


import Entity层.YiShengInfo;
import Entity层.GuaHaoYuanInfo;
import Entity层.YaoJuRenYuanInfo;
import Service层.DoctorService;
import Service层.GuaHaoYuanService;
import Service层.YaoJuService;
import Service层.YaoJuService; 
	
	public class login {
	
		static String ID;
		static JFrame frame = new JFrame("欢迎登陆HIS系统 ");
		static YiShengInfo doc1 = new YiShengInfo();
		static GuaHaoYuanInfo doc2;
		static YaoJuRenYuanInfo doc3;
		
	    public static void main(String[] args) {    
	        // 创建 JFrame 实例
	  
	        // Setting the width and height of frame
	        frame.setSize(800, 600);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        /* 创建面板，这个类似于 HTML 的 div 标签
	         * 我们可以创建多个面板并在 JFrame 中指定位置
	         * 面板中我们可以添加文本字段，按钮及其他组件。
	         */
	        JPanel panel = new JPanel(); 
	        panel.setBackground(Color.LIGHT_GRAY);
	        //JLabel label1=new JLabel();
	        JLabel label1=new JLabel("欢迎登陆HIS系统 ");
	        label1.setBounds(230, 30,200, 150);
	        label1.setFont(new Font("楷体",Font.BOLD,20));
	     	
	    
					setBak();
	   		        panel.setOpaque(false);
	     	
		    ButtonGroup group=new ButtonGroup();
	  
	        panel.setLayout(null);

	        // 创建 JLabel
	        JLabel userLabel = new JLabel("User:");
	        /* 这个方法定义了组件的位置。
	         * setBounds(x, y, width, height)
	         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
	         */
	        userLabel.setBounds(180,150,100,50);
	        panel.add(userLabel);

	        /* 
	         * 创建文本域用于用户输入
	         */
	        JTextField userText = new JTextField(20);
	        userText.setBounds(220,160,165,30);
	        panel.add(userText);

	        // 输入密码的文本域
	        JLabel passwordLabel = new JLabel("Password:");
	        passwordLabel.setBounds(150,200,80,45);
	        panel.add(passwordLabel);

	        /* 
	         *这个类似用于输入的文本域
	         * 但是输入的信息会以点号代替，用于包含密码的安全性
	         */
	        JPasswordField passwordText = new JPasswordField(20);
	        passwordText.setBounds(220,200,165,30);
	        panel.add(passwordText);
	       
	        JRadioButton rb1=new JRadioButton("挂号员");//创建JRadioButton对象
	       
	        JButton loginButton = new JButton("登陆");
	        loginButton.setBounds(140, 280, 80, 25);
	        panel.add(loginButton);
	        
					 rb1.addActionListener(new ActionListener() {
				        	
							@Override
							public void actionPerformed(ActionEvent e) {
								loginButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										if(userText.getText().trim().length()==0||new String(passwordText.getPassword()).trim().length()==0){
											JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
											return;
											}
										ArrayList<GuaHaoYuanInfo> list = new ArrayList<GuaHaoYuanInfo>() ;
										GuaHaoYuanService.read();
										list = GuaHaoYuanService.read1();
										
//										System.out.println(employeeInfo.list.contains("a"));
											for(int i=0;i<list.size();i++){
											if(list.get(i).getZhanghao().equals(userText.getText().trim())&& list.get(i).getPasswords().equals(new String(passwordText.getPassword()).trim())){
											doc2=list.get(i);
											JOptionPane.showMessageDialog(null, "登录成功");
											break;
										}
											}
											if (doc2==null){
											JOptionPane.showMessageDialog(null, "用户名或密码或身份错误");
											return;
											}
											
										 ID = userText.getText().trim();
										close();
										opennext();
										
									}
								});
							}
					 
					
					});
				
				
				

	        JRadioButton rb2=new JRadioButton("医生");
	        rb2.addActionListener(new ActionListener() {
	        	
				@Override
				public void actionPerformed(ActionEvent e) {
					loginButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(userText.getText().trim().length()==0||new String(passwordText.getPassword()).trim().length()==0){
								JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
								return;
								}
							ArrayList<YiShengInfo> list = new ArrayList<YiShengInfo>() ;
							File file = new File("d://医生信息.txt");
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
								JOptionPane.showMessageDialog(null, "登录成功");
								
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
	        JRadioButton rb3=new JRadioButton("药局人员");  
	        rb3.addActionListener(new ActionListener() {
	        	
				@Override
				public void actionPerformed(ActionEvent e) {
					loginButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(userText.getText().trim().length()==0||new String(passwordText.getPassword()).trim().length()==0){
								JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
								return;
								}
							ArrayList<YaoJuRenYuanInfo> list = new ArrayList<YaoJuRenYuanInfo>() ;
							YaoJuService.read();
							list = YaoJuService.read1();
//							System.out.println(employeeInfo.list.contains("a"));
                          for (int i=0;i<list.size();i++){
								if(list.get(i).getZhanghao().equals(userText.getText().trim())&& list.get(i).getPasswords().equals(new String(passwordText.getPassword()).trim())){
								JOptionPane.showMessageDialog(null, "登录成功");
								doc3 =list.get(i);
								break;
								}
								}
								
								if (doc3==null){
								JOptionPane.showMessageDialog(null, "用户名或密码或身份错误");
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
//					new 患者信息界面().jiemian();;
//				}
//			});
	        
	        //	创建重置按钮
	        JButton resetButton = new JButton("重置");
	        resetButton.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent arg0) {
	        	// TODO 自动生成方法存根
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
		    //设置位置
		    
		    rb1.setBounds(160, 250, 80, 20);
		    rb2.setBounds(250, 250, 80, 20);
		    rb3.setBounds(350, 250, 80, 20);
	         // 添加面板
	        frame.add(panel);
	        /* 
	         * 调用用户定义的方法并添加组件到面板
	         */
	       

	        // 设置界面可见
	        frame.setVisible(true);

	    }
	   public static void close() {
		   frame.dispose();
	   }
	   public static void opennext() {
	  
//		   new 欢迎界面1().挂号员界面();
	   }
	   public static void wenzhen() {
	   
								
	   	   new DiagnoseInterface().main(null);
		 //  new 欢迎界面2().main(null);
	   }
	   public static void fayao() {
	  
//		   new 欢迎界面3().main(null);
	   }
	     public static void setBak(){ 
			   
				((JPanel)frame.getContentPane()).setOpaque(false);
				ImageIcon img = new ImageIcon("src/界面/2.jpg"); //添加图片
				JLabel background = new JLabel(img);frame.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
				background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());  
}
}