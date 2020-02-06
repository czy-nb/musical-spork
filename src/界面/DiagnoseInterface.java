package 界面;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import Dao层.readPatientDao;
import Entity层.Records;
import Entity层.YiShengInfo;
import Entity层.ZhenDuanInfo;
import Service层.PatientService;
import Service层.PatientService1;

import Service层.YiZhuService;
import Service层.ZhenDuanInfoService;
import 数据结构层.Hashtable;
import 数据结构层.Quene;
import 数据结构层.Tree;
import 数据结构层.TreeNode;
import 数据结构层.BinarySearch;
import 数据结构层.RadixSort1;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DiagnoseInterface {
	static ArrayList<String> list5 = new ArrayList<String>();
	static Vector patient= new Vector();
	static Vector patientEnd= new Vector();
	private JFrame frame;
	static ArrayList<TreeNode<String>> listdisease = new ArrayList<TreeNode<String>>();
	 static Tree<String> tree = new Tree<String>();
	 static String root;
	 static  public String str;
	 static JTextField textField;
	 static JTextField textField_1;
	 static JTextField textField_2;
	static Quene<String> quene = new Quene<String>();
	static JTextArea textArea_1 = new JTextArea();
	static JTextField textField_4;
	static String id;
	static String name;
	static String patientid;
	static ArrayList<String> nodelist = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					DiagnoseInterface window = new DiagnoseInterface();
					window.frame.setVisible(true);
					while(!quene.isEmpty()) {
					quene.dequeue();
					}
					listdisease.clear();
					 File file=new File("d:\\内科树.txt");
						FileReader fr;
						
							 
						fr = new FileReader (file);
						
						BufferedReader br=new BufferedReader(fr);
						String line=null;
						
						// ArrayList<TreeNode<String>> list = new ArrayList<TreeNode<String>>();
						
						 //Tree<String> tree = new Tree<String>();
					    while((line=br.readLine())!=null){
					    	// ArrayList<String> list = new ArrayList<String>();
					    	if (!line.contains(",")) {
					    		 root = line;
					    		
					    		TreeNode<String> treeNode = new TreeNode<String>(root);
					    		tree.root=treeNode;
					    		listdisease.add(treeNode);
					    	}
					    	else {
					    	StringTokenizer st=new StringTokenizer(line,",");
							String str1 =st.nextToken();
							String str2 = st.nextToken();
							TreeNode<String> treeNode1 = new TreeNode<String>(str1);
							TreeNode<String> treeNode2 = new TreeNode<String>(str2);
							treeNode2.child=treeNode1;
							listdisease.add(treeNode1);
							listdisease.add(treeNode2);
							buildTree(treeNode1, treeNode2);
							
					    	}
					    }
					  // System.out.println(tree.root.parts.get(0).parts.get(0).parts.get(0).data);
					    DefaultMutableTreeNode root=new DefaultMutableTreeNode(tree.root.data);
					    for(int i=0;i<tree.root.parts.size();i++) {
					    	 DefaultMutableTreeNode node=new DefaultMutableTreeNode(tree.root.parts.get(i).data);
					   
					    	root.add(node);
					    		 for(int j=0;j<tree.root.parts.get(i).parts.size();j++) {
					    		 DefaultMutableTreeNode node1=new DefaultMutableTreeNode(tree.root.parts.get(i).parts.get(j).data);
					    		 			node.add(node1);
					    		 			root.add(node);
					    		 			if (tree.root.parts.get(i).parts.get(j).parts.size()!=0) {
					    		 			 for(int k=0;k<tree.root.parts.get(i).parts.get(j).parts.size();k++) {
					    		 	    		 DefaultMutableTreeNode node2=new DefaultMutableTreeNode(tree.root.parts.get(i).parts.get(j).parts.get(k).data);
					    		 	    		 		   node1.add(node2);	
					    		 	    		           node.add(node1);
					    		 	    		 			root.add(node);
					    		 			 }
					    		 	    
					    		 	    }
					    
					    }
					    }
						
					  JTree tree=new JTree(root);
					  tree.setBounds(1200, 10,200,300);
					window.frame.getContentPane().add(tree);
					 File file1 = new File("d://patient.txt");
						Scanner in;
						try {
							in = new Scanner(file1);
							while (in.hasNext()) {
								String str =in.nextLine();
								quene.enqueue(str);
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					tree.addTreeSelectionListener(new TreeSelectionListener() {
						
						@Override
						public void valueChanged(TreeSelectionEvent e) {
							 DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
				                     .getLastSelectedPathComponent();
							 if (node==null) {
								 return;
								 
							 }
							 Object object = node.getUserObject();
							if (node.isLeaf()) {
								String str = object.toString();
								textField_2.setText(str);
							}
							nodelist.clear();
							Enumeration enumeration;// 声明节点枚举对象
							enumeration =  ((DefaultMutableTreeNode) tree
				                     .getLastSelectedPathComponent()).preorderEnumeration(); 
							//enumeration = root.depthFirstEnumeration();
							while (enumeration.hasMoreElements()) {// 遍历节点枚举对象
								DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) enumeration	
										.nextElement();// 获得节点			
								for (int l = 0; l < node1.getLevel(); l++) {// 根据节点级别输出占位符	
									System.out.print("----");			
									}
								nodelist.add(node1.getUserObject().toString());
								
								System.out.println(node1.getUserObject());// 输出节点标签	
								}			
							System.out.println();	
							System.out.println();	
							for (String string : nodelist) {
								System.out.println(string);
							}
								
							
							
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	/**
	 * Create the application.
	 */
	public DiagnoseInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login login = new login();
		YiShengInfo doc = new YiShengInfo();
		doc = login.doc1;
		try {
			Scanner in =new Scanner(new File("d://医生信息.txt"));
			while(in.hasNext()) {
				String s = in.nextLine();
				String[] str = s.split(" ");
				if (str[0].equals(doc.getID())) {
					id = str[0];
					name = str[1];
				}
			}
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		String xa = "欢迎:"+"  "+name;
		frame = new JFrame(xa);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1424, 764);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5F85\u5C31\u8BCA\u60A3\u8005");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 13, 102, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 49, 181, 305);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		File file = new File("d://patient.txt");
		
        
       
		
		try {
			patient.clear();
			Scanner in = new Scanner(file);
			while(in.hasNext()) {
				String s = in.nextLine();
				if(s.contains(name)) {
				String[] p = s.split(" ");
				patient.add(p[2]);
				}
				
			}
			list.setListData(patient);
			
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		list.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				File file = new File("d://问诊信息.txt");
				try {
					Scanner in =new Scanner(file);
					while (in.hasNext()) {
						String s = in.nextLine();
						if (s.contains(list.getSelectedValue().toString())){
							textArea_1.setText(s);
							
						}
					
						
					}
				
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("\u60A3\u8005ID\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(395, 18, 93, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(468, 19, 124, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(606, 20, 72, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(671, 19, 100, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u60A3\u75BE\u75C5\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(785, 20, 101, 18);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(900, 19, 122, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4E0B\u4E00\u4F4D");
		btnNewButton.setBounds(1036, 18, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("\u533B\u5631");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(560, 73, 102, 32);
		frame.getContentPane().add(lblNewLabel_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(257, 126, 680, 228);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblNewLabel_5 = new JLabel("\u5C31\u8BCA\u8BB0\u5F55");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(533, 400, 118, 18);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("\u5237\u65B0");
		btnNewButton_1.setBounds(951, 492, 113, 44);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			new DiagnoseInterface().main(null);
			
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textArea_1.setText("");
		//方法一：哈希查找
				String str = quene.dequeue();
				String[] temp = str.split(" ");
			
				String ID = temp[0];
				String name = temp[2];
				textField.setText(ID);
				textField_1.setText(name);
				patientid = textField.getText();
				
				ArrayList<String> key = new ArrayList<String>();
				ArrayList<Records> data = new ArrayList<Records>();				
				File file = new File("d://问诊信息.txt");
				try {
					Scanner scanner = new Scanner(file);
				while(scanner.hasNext()) {
					String s = scanner.nextLine();
					Records p = new Records();
					String[] s1 = s.split(" ");
					p.setPatientID(s1[0]);
					p.setTime(s1[1]);
					p.setDoctorID(s1[3]);
					p.setMemo(s1[4]);
					
					key.add(s1[0]);
					data.add(p);
				}

				Hashtable table=new Hashtable();
				table.str = null;
				//System.out.println(table.size);
				for(int i=0;i<key.size();i++) {
					for (int j = 0; j < data.size(); j++) {
						
					if (data.get(j).getPatientID().contentEquals(key.get(i))) {
					//将每一个键值对一一加到构造好的哈希表中

					table.put(key.get(i), data.get(j));
					}
					//System.out.println("展示当前的hash表");

					//展示每一次添加数据之后的哈希表构成

					//table.show();

				}
				}
			
				System.out.println("展示当前的hash表");
				
				
				for(int i=0;i<key.size();i++) {
					
					//根据键值从哈希表中获取相应的数据

				if (key.get(i).contentEquals(textField.getText())) {
					//System.out.println(textField.getText());
					
					String data1 = table.get(key.get(i)).toString();
					//System.out.println(data1);
					textArea_1.append(data1+"\r\n");
					
							
				}

				}
			//方法二  二分查找法
				
//			try {	
//				String str = quene.dequeue();
//				String[] temp = str.split(" ");
//			
//				String ID = temp[0];
//				String name = temp[2];
//				textField.setText(ID);
//				textField_1.setText(name);
//				patientid = textField.getText();
//				ArrayList<Records> list = new ArrayList<Records>();
//				File file2 = new File("d://问诊信息.txt");
//				
//				Scanner in = new Scanner(file2);
//				while(in.hasNext()) {
//					Records records = new Records();
//					String line = in.nextLine();
//					System.out.println(line);
//					String[] str1 = line.split(" ");
//					
//					records.setPatientID(str1[0]);
//					records.setTime(str1[1]);
//					records.setDoctorID(str1[3]);
//					records.setMemo(str1[4]);
//					list.add(records);
//				}
//				System.out.println(list.size());
//				for (Records records2 : list) {
//					System.out.println(records2);
//				}
//				radixSort1 sort1 = new radixSort1();
//				sort1.radixSort(list);
//				
//				binarysearch search = new binarysearch();
//				int num = search.bsearchWithoutRecursion(list, Integer.valueOf(textField.getText()));
//				if(num>0) {
//				textArea_1.append(list.get(num)+"\r\n");
//				}
//  方法三：此方法为顺序查找
//				try {
//					Scanner in =new Scanner(file);
//					while (in.hasNext()) {
//						String s = in.nextLine();
//						if(s.contains(ID)) {
//							textArea_1.append(s+"\r\n");
//						}
//					
//						
//					}
//				
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5F00\u836F");
		btnNewButton_2.setBounds(951, 549, 113, 44);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(257, 448, 680, 247);
		frame.getContentPane().add(scrollPane_2);
		
		//JTextArea textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
		
		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2(name)");
		btnNewButton_3.setBounds(951, 351, 113, 27);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u67E5\u8BE2(id)");
		btnNewButton_4.setBounds(951, 327, 113, 27);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_7 = new JLabel("\u5DF2\u5C31\u8BCA\u60A3\u8005");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(26, 377, 102, 18);
		frame.getContentPane().add(lblNewLabel_7);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(14, 416, 181, 279);
		frame.getContentPane().add(scrollPane_3);
		
		JList list_1 = new JList();
		scrollPane_3.setViewportView(list_1);
		File file1 = new File("d://已就诊patient.txt");
		try{
			patientEnd.clear();
			Scanner in = new Scanner(file1);
		
		while(in.hasNext()) {
			String p = in.nextLine();
			String[] str = p.split(" ");
			patientEnd.add(str[2]);
			
		}
		list_1.setListData(patientEnd);
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		}
		list_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				File file = new File("d://问诊信息.txt");
				//File file1 = new File("d://已就诊patient");
				try {
					Scanner in =new Scanner(file);
					
					while (in.hasNext()) {
						String s = in.nextLine();
						
						
						if (s.contains(list_1.getSelectedValue().toString())){
							textArea_1.setText(s);
						}
					
						
					}
				
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
				
			}
		});
		JLabel lblNewLabel_8 = new JLabel("\u65F6\u95F4\uFF1A");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(162, 20, 72, 18);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		textField_4.setBounds(216, 19, 170, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		Date time = new Date();
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s2 =s1.format(time).toString();
        textField_4.setText(s2);
        
        JButton btnNewButton_5 = new JButton("\u8BCA\u6BD5");
        btnNewButton_5.setBounds(951, 606, 113, 44);
        frame.getContentPane().add(btnNewButton_5);
        

		btnNewButton_5.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						Records records = new Records();
						records.setTime(textField_4.getText());
						records.setPatientID(textField.getText());
						records.setDoctorID(id);
						records.setMemo(textArea.getText());
						new YiZhuService().writerfile(records.toString()+"\r\n");
						
						ZhenDuanInfo info = new ZhenDuanInfo();
						info.setID(textField.getText());
						info.setName(textField_1.getText());
						info.setDisease(textField_2.getText());
						new ZhenDuanInfoService().writerfile(info.toString()+"\r\n");
						
						String s =	(String) list.getSelectedValue();
						File file2 = new File("d://patient.txt");
						File file3 = new File("d://已就诊patient.txt");
						PatientService1 service1 = new PatientService1();
						PatientService ser = new PatientService();
						ArrayList<String> list = new ArrayList<String>();
						try {
							Scanner scan = new Scanner(file2);
							while(scan.hasNext()) {
								String p = scan.nextLine();
								if(!p.contains(textField.getText())) {
									list.add(p);
								}else {
									service1.writerfile(p+textField_2.getText()+"\r\n");
								}
							}
							FileOutputStream fos = new FileOutputStream(file2);
							for (String string : list) {
								ser.writerfile(string+"\r\n");
							}
							
							frame.dispose();
							new DiagnoseInterface().main(null);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
		

        JButton btnNewButton_6 = new JButton("\u6E05\u7A7A");
        btnNewButton_6.setBounds(951, 459, 113, 23);
        frame.getContentPane().add(btnNewButton_6);
        
        JButton btnNewButton_7 = new JButton("\u5220\u9664");
        btnNewButton_7.setBounds(951, 663, 113, 41);
        frame.getContentPane().add(btnNewButton_7);
        
        JButton btnNewButton_8 = new JButton("\u67E5\u770B(id)");
        btnNewButton_8.setBounds(951, 391, 113, 27);
        frame.getContentPane().add(btnNewButton_8);
        
        JButton btnNewButton_9 = new JButton("\u67E5\u770B(name)");
        btnNewButton_9.setBounds(951, 419, 113, 27);
        frame.getContentPane().add(btnNewButton_9);
        
        btnNewButton_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("");
				
			}
		});
        btnNewButton_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PrecribeInterface1().row1.clear();
				new PrecribeInterface1().row2.clear();
				new PrecribeInterface1().row3.clear();
				new PrecribeInterface1().row4.clear();
				new PrecribeInterface1().row5.clear();
				new PrecribeInterface1().data.clear();
				new PrecribeInterface1().names.clear();
				new PrecribeInterface1().list.clear();
				
			}
		});
        
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					查询name();
				
			
				
			}
		});
		
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
					查询id();
					
					

			

			
				
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PrescribeInterface 药品界面4 = new PrescribeInterface();
				药品界面4.main(null);
			}
		});
		
		btnNewButton_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				查看id();
				
			}
		});
		
		
		btnNewButton_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				查看name();
				
			}
		});
	}
	
	   

	
	public static void buildTree(TreeNode<String> sub,TreeNode<String> par) {		 
		 int s = indexOf(sub);
		 int p = indexOf(par);
		 listdisease.get(s).parent = listdisease.get(p);
		 ArrayList<TreeNode<String>> temp = listdisease.get(p).parts;
		 if(!temp.isEmpty()){
			  for(TreeNode<String > t:temp) {
				  if(t.data.equals(sub.data)) {
					  return ;
				  }
			  }
		  }
		 listdisease.get(p).parts.add(listdisease.get(s));
	  }
	 
	 public static int indexOf(TreeNode<String> node) {
		 for(int i = 0;i<listdisease.size();i++) {
			 if(listdisease.get(i).data.equals(node.data)) {
				 return i;
			 }
		 }
		return -1;
		 
	 }
	 public static void 查询id() {
		 ReferInterface1 jiemian = new ReferInterface1();
		
		 jiemian.ID排序();
		 jiemian.main(null);
			
	 }
	 public static void 查看id() {
		 ReferInterface2 jiemian = new ReferInterface2();
		
		 jiemian.ID排序();
		 jiemian.main(null);
			
	 }
	 public static void 查询name() {
		 ReferInterface1 jiemian = new ReferInterface1();
			jiemian.name排序();
			jiemian.main(null);
	 }
	 public static void 查看name() {
		 ReferInterface2 jiemian = new ReferInterface2();
			jiemian.name排序();
			jiemian.main(null);
	 }
}

