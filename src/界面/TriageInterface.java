package 界面;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFrame;

import Entity层.PatientInfo;
import Service层.PatientService;

import Service层.CheckPatientService;
import 数据结构层.PriorityQuene;
import 数据结构层.Quene;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao层.CheckPatientDao;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TriageInterface {
	static Quene<String> queneA = new Quene<String>();
	static Quene<String> queneB = new Quene<String>();
	static Quene<String> queneC = new Quene<String>();
	static PriorityQuene<String> queneD = new PriorityQuene<String>();
	static int i;
	static String temp;
	static String docname;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TriageInterface window = new TriageInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TriageInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1224, 759);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("内科分诊");
		btnNewButton.setBounds(100, 528, 113, 54);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u67E5\u8BE2\u4FE1\u606F\uFF1A");
		lblNewLabel.setBounds(0, 13, 83, 18);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(70, 10, 143, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u5237\u65B0");
		btnNewButton_2.setBounds(659, 528, 113, 54);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 108, 281, 344);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(566, 440, 269, -328);
		frame.getContentPane().add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(566, 108, 253, 344);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u6392\u961F\u524D\u60A3\u8005");
		lblNewLabel_1.setBounds(100, 59, 102, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6392\u961F\u540E\u60A3\u8005");
		lblNewLabel_2.setBounds(659, 59, 94, 36);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.setBounds(227, 9, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\LEGION\\Desktop\\timg.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1206, 712);
		frame.getContentPane().add(lblNewLabel_3);
		File file = new File("d:"+File.separator+"需检查病人.txt");
		try {
			Scanner in= new Scanner(file);
			while(in.hasNext()) {
				String s = in.nextLine();
				String[] s1 = s.split(" ");
				if(s1[0].equals(textField.getText())) {
					 JOptionPane.showMessageDialog(null, "可以分诊");
					 docname =s1[9];
					    break;          
				}
			}
			System.out.println(docname);
//		File file1 = new File("d:"+File.separator+"patient.txt");
//		Scanner in1 = new Scanner(file1);
//		while(in1.hasNext()) {
//			String s = in1.nextLine();
//			String[] s1 = s.split(" ");
//			if(s1[9].contentEquals(docname)) {
//				textArea.append(s1[2]);
//			}
//		}
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					Scanner in= new Scanner(file);
					while(in.hasNext()) {
						String s = in.nextLine();
						String[] s1 = s.split(" ");
						if(s1[0].equals(textField.getText())) {
							 JOptionPane.showMessageDialog(null, "可以分诊");
							 docname =s1[9];
							    break;          
						}
					}
					System.out.println(docname);
				File file1 = new File("d:"+File.separator+"patient.txt");
				Scanner in1 = new Scanner(file1);
				while(in1.hasNext()) {
					String s = in1.nextLine();
					String[] s1 = s.split(" ");
					if(s1[9].contentEquals(docname)) {
						textArea.append(s1[2]+"\r\n");
					}
				}
				} catch (FileNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
			}
		});
	 	
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					File file = new File("d:"+File.separator+"patient.txt");
				
			
				 File file1 = new File("d:"+File.separator+"已就诊patient.txt"); 
				 File file2 = new File("d:"+File.separator+"需检查病人.txt");
				 File file3 = new File("d:"+File.separator+"紧急病人.txt");
				 Scanner in = new Scanner(file);
				 while(in.hasNext()) {
					 String str = in.nextLine();
					 if (str.contains(docname))
						 queneA.enqueue(str);
					 }
				
				 Scanner in2 = new Scanner(file2);
				 while(in2.hasNext()) {
					 String str = in2.nextLine();
					 if (str.contains(docname))
					 queneB.enqueue(str);
				 }
				 Scanner in3 = new Scanner(file3);
				 while(in3.hasNext()) {
					 String str = in3.nextLine();
					 if (str.contains(docname))
					 queneD.add(str);
				 }
				 	
				 	while(queneD.peek()!=null) {
				 	String pat = queneD.poll();
				 	String now = pat.substring(2,pat.length());
				 	System.out.println(now);
				 	queneC.enqueue(now);
				 	}
				 	ArrayList<String> list = new ArrayList<String>();
				 	Scanner in1 = new Scanner(file2);
			 		while(in1.hasNext()) {
				 		String str1 = in1.nextLine();
				 		if (!str1.contains(textField.getText())) {
				 			list.add(str1);
				 		
				 		}else {
				 			temp = str1;
				 			System.out.println(temp);
				 			break;
				 		}
				 	}
			 		int num = queneA.size();
			 		int j=0;
			 		//int k = queneB.size();
			 		if (queneA.size()<2) {
			 			 JOptionPane.showMessageDialog(null, "就诊人数少，直接去排队");
			 			// queneC.enqueue(temp);
			 			 while(!queneA.isEmpty()) {
			 				 String s = queneA.dequeue();
			 				queneC.enqueue(s);
			 			 }
			 			 queneC.enqueue(temp);
			 		}
			 		if(queneA.size()>=2) {
			 		for(int i=0;i<(num+1);i++) {
			 		
			 		
			 		if(j==2) {
			 			queneC.enqueue(temp);
			 			j++;
			 			
			 		}else if (queneA.size()-2>=0) {
						
						String str = queneA.dequeue();
						queneC.enqueue(str);
						
						
						j++;
						}
			 		else {
							if(queneA.size()>0) {
								String str = queneA.dequeue();
								queneC.enqueue(str);
								j++;
							}
						}
			 		
			 			//String str = queneA.dequeue();
						//queneC.enqueue(str);
						//queneC.enqueue(temp);
			 		}
//			 		if (k==queneB.size()) {
//			 			String str=queneB.dequeue();
//			 			queneC.enqueue(str);
//			 					
//			 		
//			 		}
			 		}
			 		System.out.println(queneC.size());
			 		int i1 = queneC.size();
			 		FileOutputStream fos = new FileOutputStream(file);
			 		for (int i = 0; i < i1; i++) {
						String s=queneC.dequeue();
						new PatientService().writerfile(s+"\r\n");
					}
			 		
			 		if(!list.isEmpty()) {
			 			for (String string : list) {
							new CheckPatientService().writerfile(string);
						}
			 		}
			 		Scanner scan= new Scanner(file);
					while(scan.hasNext()) {
						String s = scan.nextLine();
						String[] s1 = s.split(" ");
						String name = s1[2];
						textArea_1.append(name+"\r\n");
					}
					
			 	btnNewButton_2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						new TriageInterface().main(null);
						
					}
				});
			 	
			 	
				}catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
	}
}
