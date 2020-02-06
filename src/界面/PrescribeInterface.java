package 界面;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;

public class PrescribeInterface {
	static PrecribeInterface1 jiemian = new PrecribeInterface1();
	
	
	public static void main(String[] args) {
		 JFrame frame = new JFrame("欢迎登陆HIS系统 ");
		    // Setting the width and height of frame
		    frame.setSize(800, 600);
		    frame.setLocationRelativeTo(null);
		    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    frame.setVisible(true);
		    
		   
		    JPanel panel = new JPanel();
		    panel.setBackground(Color.LIGHT_GRAY);
		    placeComponents( panel);
		    frame.getContentPane().add(panel);
	}
	 private static void placeComponents(JPanel panel) {
		 	jiemian.names.add("药品名称");
			jiemian.names.add("药品规格");
			jiemian.names.add("包装数量");
			jiemian.names.add("药品单价");
			jiemian.names.add("药品单位");
			jiemian.names.add("药品数量");
	    	panel.setLayout(null);
	   	JLabel Label1 = new JLabel("请选择药品:");
	    	Label1.setFont(new Font("楷体",Font.BOLD,20));
	        Label1.setBounds(150,174,130,50);
	        panel.add(Label1);
	        JLabel Label2 = new JLabel("请选择症状:");
	    	Label2.setFont(new Font("楷体",Font.BOLD,20));
	        Label2.setBounds(150,13,130,50);
	        panel.add(Label2);
	        JButton bt3 = new JButton("诊毕");
	        bt3.setBounds(320,350,100,50);
	        panel.add(bt3);
	        bt3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new PrecribeInterface1().main(null);				
				}
			});
	        JComboBox comboBox1 = new JComboBox();        
	 	    comboBox1.setBounds(276,25,100,30);
	        panel.add(comboBox1);
	        
	        JComboBox comboBox2 = new JComboBox();
	        comboBox1.addItem("请选择----");
	        comboBox1.addItem("呼吸内科");
	        comboBox1.addItem("消化内科");
	        comboBox2.setBounds(374,25,100,30);
	        panel.add(comboBox2);
	        
	        JComboBox comboBox3 = new JComboBox();        
	 	    comboBox3.setBounds(471,25,100,30);
	        panel.add(comboBox3);
	        
	        comboBox1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (comboBox1.getSelectedItem().equals("呼吸内科")){
						comboBox2.addItem("请选择----");
						comboBox2.addItem("气管");
			 	        comboBox2.addItem("肺部");
			        }
					if (comboBox1.getSelectedItem().equals("消化内科")){
						comboBox2.addItem("请选择----");
						comboBox2.addItem("肝病");
			 	        comboBox2.addItem("胃病");
			 	       comboBox2.addItem("肠道");
			        }
				}
			});
	        comboBox2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (comboBox2.getSelectedItem().equals("气管")) {
						comboBox3.addItem("请选择----");
					   comboBox3.addItem("支气管炎");
				}
					if (comboBox2.getSelectedItem().equals("肺部")) {
						comboBox3.addItem("请选择----");
						comboBox3.addItem("肺炎");
					}
					if (comboBox2.getSelectedItem().equals("肝病")) {
						comboBox3.addItem("请选择----");
						comboBox3.addItem("肝硬化");
					}
					if (comboBox2.getSelectedItem().equals("胃病")) {
						comboBox3.addItem("请选择----");
						comboBox3.addItem("胃炎");
						comboBox3.addItem("胃溃疡");
					}
					if (comboBox2.getSelectedItem().equals("肠道")) {
						comboBox3.addItem("请选择----");
						comboBox3.addItem("肠炎");
						;
					}
				}
			});
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setFont(new Font("宋体", Font.PLAIN, 28));
	        comboBox.setModel(new DefaultComboBoxModel(new String[] {"      \u8BF7\u9009\u62E9:"}));
	        comboBox.addItem("请选择：");
	        comboBox3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (comboBox3.getSelectedItem().equals("肺炎")){
			        	comboBox.addItem("感康");
			 	        comboBox.addItem("阿莫西林");
			        }
			        if (comboBox3.getSelectedItem().equals("支气管炎")){
			        	comboBox.addItem("感康");
			 	        comboBox.addItem("阿莫西林");
			 	       comboBox.addItem("莲花清瘟胶囊");
			        }		
			        if (comboBox3.getSelectedItem().equals("胃炎")){
			        	 comboBox.addItem("红霉素");
			        }		
			        if (comboBox3.getSelectedItem().equals("胃溃疡")){
			        	
			 	        comboBox.addItem("阿莫西林");
			 	       comboBox.addItem("莲花清瘟胶囊");
			        }		
			        if (comboBox3.getSelectedItem().equals("肝硬化")){
			        	comboBox.addItem("感康");
				        comboBox.addItem("阿莫西林");
				        comboBox.addItem("红霉素");
				        comboBox.addItem("双黄连");
				        comboBox.addItem("小快克");
				        comboBox.addItem("莲花清瘟胶囊");
			        }		
			        if (comboBox3.getSelectedItem().equals("肠炎")){
			        	
				        comboBox.addItem("阿莫西林");
				        comboBox.addItem("红霉素");
				        comboBox.addItem("双黄连");
				        comboBox.addItem("莲花清瘟胶囊");
			        }		
			        
				}
			});
	        


	        comboBox.setBounds(276,174,283,54);
	        panel.add(comboBox);
	        
	        comboBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					if (comboBox.getSelectedItem().equals("感康")){
						jiemian.row.add("感康");
						jiemian.row.add("0.5mg");
						jiemian.row.add("24");
						jiemian.row.add("40");
						jiemian.row.add("盒");
						jiemian.row.add(" ");

						jiemian.data.add(jiemian.row);
						

					}
					if (comboBox.getSelectedItem().equals("阿莫西林")){
						jiemian.row1.add("阿莫西林");
						jiemian.row1.add("0.5mg");
						jiemian.row1.add("10");
						jiemian.row1.add("50");
						jiemian.row1.add("盒");
						jiemian.row1.add(" ");
						jiemian.data.add(jiemian.row1);
						
					}
					if (comboBox.getSelectedItem().equals("红霉素")){
						jiemian.row2.add("红霉素");
						jiemian.row2.add("0.5mg");
						jiemian.row2.add("24");
						jiemian.row2.add("40");
						jiemian.row2.add("盒");
						jiemian.row2.add(" ");
						jiemian.data.add(jiemian.row2);
						
					}
					if (comboBox.getSelectedItem().equals("双黄连")){
						jiemian.row3.add("双黄连");
						jiemian.row3.add("20ml");
						jiemian.row3.add("12");
						jiemian.row3.add("30");
						jiemian.row3.add("盒");
						jiemian.row3.add(" ");
						jiemian.data.add(jiemian.row3);
						
					}
					if (comboBox.getSelectedItem().equals("小快克")){
						jiemian.row4.add("小快克");
						jiemian.row4.add("0.5mg");
						jiemian.row4.add("10");
						jiemian.row4.add("40");
						jiemian.row4.add("盒");
						jiemian.row4.add(" ");
						jiemian.data.add(jiemian.row4);
						
					}
					if (comboBox.getSelectedItem().equals("莲花清瘟胶囊")){
						jiemian.row5.add("莲花清瘟胶囊");
						jiemian.row5.add("1mg");
						jiemian.row5.add("36");
						jiemian.row5.add("36");
						jiemian.row5.add("盒");
						jiemian.row5.add(" ");
						jiemian.data.add(jiemian.row5);
						
					}
					
				}
			});
	       
}
}