package ����;

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
		 JFrame frame = new JFrame("��ӭ��½HISϵͳ ");
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
		 	jiemian.names.add("ҩƷ����");
			jiemian.names.add("ҩƷ���");
			jiemian.names.add("��װ����");
			jiemian.names.add("ҩƷ����");
			jiemian.names.add("ҩƷ��λ");
			jiemian.names.add("ҩƷ����");
	    	panel.setLayout(null);
	   	JLabel Label1 = new JLabel("��ѡ��ҩƷ:");
	    	Label1.setFont(new Font("����",Font.BOLD,20));
	        Label1.setBounds(150,174,130,50);
	        panel.add(Label1);
	        JLabel Label2 = new JLabel("��ѡ��֢״:");
	    	Label2.setFont(new Font("����",Font.BOLD,20));
	        Label2.setBounds(150,13,130,50);
	        panel.add(Label2);
	        JButton bt3 = new JButton("���");
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
	        comboBox1.addItem("��ѡ��----");
	        comboBox1.addItem("�����ڿ�");
	        comboBox1.addItem("�����ڿ�");
	        comboBox2.setBounds(374,25,100,30);
	        panel.add(comboBox2);
	        
	        JComboBox comboBox3 = new JComboBox();        
	 	    comboBox3.setBounds(471,25,100,30);
	        panel.add(comboBox3);
	        
	        comboBox1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (comboBox1.getSelectedItem().equals("�����ڿ�")){
						comboBox2.addItem("��ѡ��----");
						comboBox2.addItem("����");
			 	        comboBox2.addItem("�β�");
			        }
					if (comboBox1.getSelectedItem().equals("�����ڿ�")){
						comboBox2.addItem("��ѡ��----");
						comboBox2.addItem("�β�");
			 	        comboBox2.addItem("θ��");
			 	       comboBox2.addItem("����");
			        }
				}
			});
	        comboBox2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (comboBox2.getSelectedItem().equals("����")) {
						comboBox3.addItem("��ѡ��----");
					   comboBox3.addItem("֧������");
				}
					if (comboBox2.getSelectedItem().equals("�β�")) {
						comboBox3.addItem("��ѡ��----");
						comboBox3.addItem("����");
					}
					if (comboBox2.getSelectedItem().equals("�β�")) {
						comboBox3.addItem("��ѡ��----");
						comboBox3.addItem("��Ӳ��");
					}
					if (comboBox2.getSelectedItem().equals("θ��")) {
						comboBox3.addItem("��ѡ��----");
						comboBox3.addItem("θ��");
						comboBox3.addItem("θ����");
					}
					if (comboBox2.getSelectedItem().equals("����")) {
						comboBox3.addItem("��ѡ��----");
						comboBox3.addItem("����");
						;
					}
				}
			});
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setFont(new Font("����", Font.PLAIN, 28));
	        comboBox.setModel(new DefaultComboBoxModel(new String[] {"      \u8BF7\u9009\u62E9:"}));
	        comboBox.addItem("��ѡ��");
	        comboBox3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (comboBox3.getSelectedItem().equals("����")){
			        	comboBox.addItem("�п�");
			 	        comboBox.addItem("��Ī����");
			        }
			        if (comboBox3.getSelectedItem().equals("֧������")){
			        	comboBox.addItem("�п�");
			 	        comboBox.addItem("��Ī����");
			 	       comboBox.addItem("������������");
			        }		
			        if (comboBox3.getSelectedItem().equals("θ��")){
			        	 comboBox.addItem("��ù��");
			        }		
			        if (comboBox3.getSelectedItem().equals("θ����")){
			        	
			 	        comboBox.addItem("��Ī����");
			 	       comboBox.addItem("������������");
			        }		
			        if (comboBox3.getSelectedItem().equals("��Ӳ��")){
			        	comboBox.addItem("�п�");
				        comboBox.addItem("��Ī����");
				        comboBox.addItem("��ù��");
				        comboBox.addItem("˫����");
				        comboBox.addItem("С���");
				        comboBox.addItem("������������");
			        }		
			        if (comboBox3.getSelectedItem().equals("����")){
			        	
				        comboBox.addItem("��Ī����");
				        comboBox.addItem("��ù��");
				        comboBox.addItem("˫����");
				        comboBox.addItem("������������");
			        }		
			        
				}
			});
	        


	        comboBox.setBounds(276,174,283,54);
	        panel.add(comboBox);
	        
	        comboBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					if (comboBox.getSelectedItem().equals("�п�")){
						jiemian.row.add("�п�");
						jiemian.row.add("0.5mg");
						jiemian.row.add("24");
						jiemian.row.add("40");
						jiemian.row.add("��");
						jiemian.row.add(" ");

						jiemian.data.add(jiemian.row);
						

					}
					if (comboBox.getSelectedItem().equals("��Ī����")){
						jiemian.row1.add("��Ī����");
						jiemian.row1.add("0.5mg");
						jiemian.row1.add("10");
						jiemian.row1.add("50");
						jiemian.row1.add("��");
						jiemian.row1.add(" ");
						jiemian.data.add(jiemian.row1);
						
					}
					if (comboBox.getSelectedItem().equals("��ù��")){
						jiemian.row2.add("��ù��");
						jiemian.row2.add("0.5mg");
						jiemian.row2.add("24");
						jiemian.row2.add("40");
						jiemian.row2.add("��");
						jiemian.row2.add(" ");
						jiemian.data.add(jiemian.row2);
						
					}
					if (comboBox.getSelectedItem().equals("˫����")){
						jiemian.row3.add("˫����");
						jiemian.row3.add("20ml");
						jiemian.row3.add("12");
						jiemian.row3.add("30");
						jiemian.row3.add("��");
						jiemian.row3.add(" ");
						jiemian.data.add(jiemian.row3);
						
					}
					if (comboBox.getSelectedItem().equals("С���")){
						jiemian.row4.add("С���");
						jiemian.row4.add("0.5mg");
						jiemian.row4.add("10");
						jiemian.row4.add("40");
						jiemian.row4.add("��");
						jiemian.row4.add(" ");
						jiemian.data.add(jiemian.row4);
						
					}
					if (comboBox.getSelectedItem().equals("������������")){
						jiemian.row5.add("������������");
						jiemian.row5.add("1mg");
						jiemian.row5.add("36");
						jiemian.row5.add("36");
						jiemian.row5.add("��");
						jiemian.row5.add(" ");
						jiemian.data.add(jiemian.row5);
						
					}
					
				}
			});
	       
}
}