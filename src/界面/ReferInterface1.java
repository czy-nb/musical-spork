package 界面;

import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entity层.PatientInfo;
import 数据结构层.BinaryTree;
import 数据结构层.QuickSort;
import 数据结构层.Mycomparable;
import 数据结构层.RadixSort;

import java.awt.Color;
import java.awt.Container;

public class ReferInterface1 {
	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> list5 = new ArrayList<String>();
	static File file = new File("d:"+File.separator+"patient.txt");
	private JFrame frame;
	private static JTable table;
	static JScrollPane scrollPane = new JScrollPane();
	 static  ArrayList<PatientInfo> temp1 = new ArrayList<PatientInfo>() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReferInterface1 window = new ReferInterface1();
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
	public ReferInterface1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1217, 681);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1199, 634);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();

	}
	public static void ID排序() {

		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();  
		tableModel.setRowCount(0); 
	    tableModel.setColumnIdentifiers(new Object[]{"ID", "挂号ID", "name", "sex", "birth", "phonenumber", "address", "idcard", "keshi", "doc","disease"});
	    Object[] object = new Object[11];
	    DiagnoseInterface jiemian = new DiagnoseInterface();
		 list =  jiemian.nodelist;
		 list5.clear();
		 temp1.clear();
		 System.out.println(list.isEmpty());
		 File file1 = new File("d://已就诊patient.txt");
		// System.out.println(list.size());
		try{
			Scanner in1 = new Scanner(file1);
					while(in1.hasNext()) {
						if(list.size()==1) {
						for (String string : list) {
						String temp = in1.nextLine();
						String[] str = temp.split(" ");
						//System.out.println(str[10]);
				if (str[10].equals(string)) {
					list5.add(temp);
				}
			}
						
				}else {
					String temp = in1.nextLine();
					String[] str = temp.split(" ");
						for(int i=1;i<list.size();i++) {
							
							//System.out.println(list.get(i));
							if (str[10].contentEquals(list.get(i))) {
								list5.add(temp);
								
							}
						}
					}
					}
					for (String string :list5) {
						String[] str = string.split(" ");
						PatientInfo p = new PatientInfo();
						p.setID(str[1]);
						p.setCardnumber(str[0]);
						p.setName(str[2]);
						p.setSex(str[3]);
						p.setBirth(str[4]);
						p.setAddress(str[5]);
						p.setPhonenumber(str[6]);
						p.setIdcardnumber(str[7]);
						p.setKeshi(str[8]);
						p.setDoc(str[9]);
						p.setDisease(str[10]);
					
						temp1.add(p);
				}
//					 mycomparable mycomparable = new mycomparable();
//				        Collections.sort(temp1, mycomparable);
					
					
					//方法一      基数排序
					//radixSort sort = new radixSort();
					//sort.radixSort(temp1);
				   BinaryTree tree = new  BinaryTree();
					tree.buildTree(temp1);
				   tree.inOrder();
					
					//方法二      快速排序
				      //  QuickSort sort = new QuickSort();
				       // sort.QuickSort(temp1);
					
					//方法三 二叉树排序
					for (int i= 0;i<tree.temp2.size();i++) {
//						   tableDate[i][j]=(temp.get(i))[j];
					   
						   String str = tree.temp2.get(i).toString2();
						   
						   System.out.println(str);
						   String[] temp2 = str.split(" ");
						   for (int z=0;z<temp2.length;z++) {
							 
							  String str2= temp2[z];
							  //System.out.println(str2);
								object[z]=str2;
					
							 }
	    	        tableModel.addRow(object);
	    }
	//	System.out.println(tableModel.getColumnName(1));
	    table.setModel(tableModel);
	    scrollPane.setViewportView(table);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//scrollPane.setViewportView(table);
//		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();  
//		tableModel.setRowCount(0); 
//	    tableModel.setColumnIdentifiers(new Object[]{"ID", "挂号ID", "name", "sex", "birth", "phonenumber", "address", "idcard", "keshi", "doc","disease"});
//	    Object[] object = new Object[11];
//	    内科问诊界面 jiemian = new 内科问诊界面();
//		 list =  jiemian.nodelist;
//		 list5.clear();
//		 System.out.println(list.isEmpty());
//		 File file1 = new File("d://已就诊patient.txt");
//		// System.out.println(list.size());
//		try{
//			Scanner in1 = new Scanner(file1);
//					while(in1.hasNext()) {
//						if(list.size()==1) {
//						for (String string : list) {
//						String temp = in1.nextLine();
//						String[] str = temp.split(" ");
//						//System.out.println(str[10]);
//				if (str[10].equals(string)) {
//					list5.add(temp);
//				}
//			}
//						
//				}else {
//					String temp = in1.nextLine();
//					String[] str = temp.split(" ");
//						for(int i=1;i<list.size();i++) {
//							
//							//System.out.println(list.get(i));
//							if (str[10].contentEquals(list.get(i))) {
//								list5.add(temp);
//								
//							}
//						}
//					}
//					}
//					System.out.println(list5.size());
//					for (String s : list5) {
//						System.out.println(s);
//					}
//					for (int i= 0;i<list5.size();i++) {
////						   tableDate[i][j]=(temp.get(i))[j];
//					   
//						   String str = list5.get(i);
//						   
//						   System.out.println(str);
//						   String[] temp2 = str.split(" ");
//						   for (int z=0;z<temp2.length;z++) {
//							 
//							  String str2= temp2[z];
//							  //System.out.println(str2);
//								object[z]=str2;
//					
//							 }
//	    	        tableModel.addRow(object);
//	    }
//	//	System.out.println(tableModel.getColumnName(1));
//	    table.setModel(tableModel);
//	    scrollPane.setViewportView(table);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	public static void name排序() {
		
		
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();  
		tableModel.setRowCount(0); 
	    tableModel.setColumnIdentifiers(new Object[]{"ID", "挂号ID", "name", "sex", "birth", "phonenumber", "address", "idcard", "keshi", "doc","disease"});
	    Object[] object = new Object[11];
	    DiagnoseInterface jiemian = new DiagnoseInterface();
		 list =  jiemian.nodelist;
		 list5.clear();
		 temp1.clear();
		 System.out.println(list.isEmpty());
		 File file1 = new File("d://已就诊patient.txt");
		// System.out.println(list.size());
		try{
			Scanner in1 = new Scanner(file1);
					while(in1.hasNext()) {
						if(list.size()==1) {
						for (String string : list) {
						String temp = in1.nextLine();
						String[] str = temp.split(" ");
						//System.out.println(str[10]);
				if (str[10].equals(string)) {
					list5.add(temp);
				}
			}
						
				}else {
					String temp = in1.nextLine();
					String[] str = temp.split(" ");
						for(int i=1;i<list.size();i++) {
							
							//System.out.println(list.get(i));
							if (str[10].contentEquals(list.get(i))) {
								list5.add(temp);
								
							}
						}
					}
					}
					for (String string :list5) {
						String[] str = string.split(" ");
						PatientInfo p = new PatientInfo();
						p.setID(str[1]);
						p.setCardnumber(str[0]);
						p.setName(str[2]);
						p.setSex(str[3]);
						p.setBirth(str[4]);
						p.setAddress(str[5]);
						p.setPhonenumber(str[6]);
						p.setIdcardnumber(str[7]);
						p.setKeshi(str[8]);
						p.setDoc(str[9]);
						p.setDisease(str[10]);
					
						temp1.add(p);
				}
					 Mycomparable mycomparable = new Mycomparable();
				        Collections.sort(temp1, mycomparable);
//				        QuickSort sort = new QuickSort();
//				        sort.QuickSort(temp1);
					for (int i= 0;i<temp1.size();i++) {
//						   tableDate[i][j]=(temp.get(i))[j];
					   
						   String str = temp1.get(i).toString2();
						   
						   System.out.println(str);
						   String[] temp2 = str.split(" ");
						   for (int z=0;z<temp2.length;z++) {
							 
							  String str2= temp2[z];
							  //System.out.println(str2);
								object[z]=str2;
					
							 }
	    	        tableModel.addRow(object);
	    }
	//	System.out.println(tableModel.getColumnName(1));
	    table.setModel(tableModel);
	    scrollPane.setViewportView(table);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
