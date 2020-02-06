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
import 数据结构层.Mycomparable;
import 数据结构层.RadixSort;

public class ReferInterface2 {
	static ArrayList<String> list5 = new ArrayList<String>();
	 static  ArrayList<PatientInfo> temp1 = new ArrayList<PatientInfo>() ;
	static JScrollPane scrollPane = new JScrollPane();
	private JFrame frame;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReferInterface2 window = new ReferInterface2();
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
	public ReferInterface2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1273, 752);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	//	JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1255, 705);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		//scrollPane.setViewportView(table);
	}
	
	public static void ID排序() {

		try{
		list5.clear();
		temp1.clear();
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();  
		tableModel.setRowCount(0); 
	    tableModel.setColumnIdentifiers(new Object[]{"ID", "挂号ID", "name", "sex", "birth", "phonenumber", "address", "idcard", "keshi", "doc","disease"});
	    Object[] object = new Object[11];
	    File file = new File("d://已就诊patient.txt");
	    Scanner in = new Scanner(file);
		while(in.hasNext()) {
			
		String s = in.nextLine();
		list5.add(s);
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
					RadixSort sort = new RadixSort();
					sort.radixSort(temp1);
					
				
					
					//方法二      快速排序
				      //  QuickSort sort = new QuickSort();
				       // sort.QuickSort(temp1);
					
					
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
	
public static void name排序() {
		
		try {
		list5.clear();
		temp1.clear();
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();  
		tableModel.setRowCount(0); 
	    tableModel.setColumnIdentifiers(new Object[]{"ID", "挂号ID", "name", "sex", "birth", "phonenumber", "address", "idcard", "keshi", "doc","disease"});
	    Object[] object = new Object[11];
	    File file = new File("d://已就诊patient.txt");
	    Scanner in = new Scanner(file);
		while(in.hasNext()) {
			
		String s = in.nextLine();
		list5.add(s);
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
