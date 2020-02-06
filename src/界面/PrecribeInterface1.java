package 界面;
	
	import java.awt.BorderLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.WindowAdapter;
	import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
	import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.ListSelectionModel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.table.DefaultTableModel;

import Entity层.drugInfo;
import Service层.drugService;
import Service层.DrugStockService;
import Service层.PatientService;
	public class PrecribeInterface1 extends JFrame
	{
		static ArrayList list  = new ArrayList();
		static ArrayList<String> list1 = new ArrayList<String>();
		 static Vector row = new Vector();
		 static Vector row1 = new Vector();
		 static Vector row2 = new Vector();
		 static Vector row3 = new Vector();
		 static Vector row4 = new Vector();
		 static Vector row5 = new Vector();
		 static drugService ps = new drugService();
		static Vector data = new Vector();
		static  Vector names = new Vector();
		static Vector row6 = new Vector();
		static String s;
	    JPanel contentPane;
	    JTable table;
	    
	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args)
	    {
	        PrecribeInterface1 frame = new PrecribeInterface1();
	        frame.setVisible(true);
	    }
	    /**
	     * Create the frame.
	     */
	
	public PrecribeInterface1()
	{
	    addWindowListener(new WindowAdapter()
	    {
	        @Override
	        public void windowActivated(WindowEvent e)
	        {
	            do_this_windowActivated(e);
	        }
	    });
	    setTitle("药品信息表");
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setBounds(100,100,800,600);
	    contentPane=new JPanel();
	    contentPane.setBorder(new EmptyBorder(5,5,5,5));
	    contentPane.setLayout(new BorderLayout(0,0));
	    setContentPane(contentPane);
	    JPanel panel=new JPanel();
	    contentPane.add(panel,BorderLayout.SOUTH);
	    JButton button=new JButton("删除");
	    JButton button1=new JButton("确认");
	    button.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	            do_button_actionPerformed(e);
	        }
	    });
	    button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = new File("d:\\drug库存.txt");
				ArrayList<String> list1 = new ArrayList<String>();
				int a = table.getRowCount();
				for (int i=0;i<a;i++) {
					String drug = (String) table.getValueAt(i, 0);
					int num = Integer.parseInt(table.getValueAt(i, 5).toString().trim());
					System.out.println(num);
					try {
						Scanner in = new Scanner(file);
						while(in.hasNext()) {
							String l = in.nextLine();
							System.out.println(l);
							String[] temp = l.split(" ");
							String drug1 = temp[0];
							int num1 = Integer.parseInt(temp[1].trim());
							System.out.println(num1);
							if(drug.contentEquals(drug1)) {
								int end = num1-num;
								if (end<0) {
									
									
										
									JOptionPane.showMessageDialog(null, "库存不足，只能开要数量为"+num1);
									s= drug+" "+num1;
									list1.add(drug+" "+0);
								}else {
									list1.add(drug+" "+end);
									s=drug+" "+num;
								}
								
								
							}else {
								if (!list1.contains(l)) {
								list1.add(l);
								}
							}
						}
						int res =JOptionPane.showConfirmDialog(null, "是否开药","是否",JOptionPane.YES_NO_OPTION);
						if(res==JOptionPane.YES_OPTION){
						FileOutputStream fos = new FileOutputStream(file);
						DrugStockService service = new DrugStockService();
						for (String string : list1) {
							System.out.println(string);
							service.writerfile(string+"\r\n");
						}
//						for(int i1=0;i1<a;i1++) {
//							for (int j=0;j<6;j++) {
//							
//						list.add(table.getValueAt(i1,j));
//						
//							}
//							
//						}
						String s1=new DiagnoseInterface().patientid;
						
						     s = s+" "+s1;
						
							 ps.writerfile(s+"\r\n");
						
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
//				for(int i=0;i<a;i++) {
//					for (int j=0;j<6;j++) {
//					
//				list.add(table.getValueAt(i,j));
//				
//					}
//				}
				
//			String s=new 问诊开药界面4().str2[0];
//			System.out.println(s);
//			String[] str = s.split(" ");
//			list.add(str[1]);
//				 ps.writerfile(list.toString()+"\r\n");
//			
			}
		});
	    panel.add(button1);
	    panel.add(button);
	    JScrollPane scrollPane=new JScrollPane();
	    contentPane.add(scrollPane,BorderLayout.CENTER);
	    table=new JTable();
	    table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    scrollPane.setViewportView(table);
	}
	public void do_this_windowActivated(WindowEvent e) {
		 DefaultTableModel tableModel=(DefaultTableModel) table.getModel();    //获得表格模型
		 tableModel.setRowCount(0);//清空表格中的数据
		 JTable table = new JTable(tableModel);
		 JScrollPane jsp = new JScrollPane(table);
		// Object[] tableDate = new Object[]{"编号","药品名称","药品规格","包装数量","药品单价","药品单位","药品数量"};
		// tableModel.setColumnIdentifiers(tableDate); //设置表头
		 
//		    tableModel.addRow(new Object[]{"",""," "," "," "," ",""});    //增加列
//		    tableModel.addRow(new Object[]{""," "," "," "," "," ",""});
//		    tableModel.addRow(new Object[]{""," "," " ,"","  ","",""});
//		    tableModel.addRow(new Object[]{ ""," "," "," "," "," ",""});
		    table.setRowHeight(30);
		    table.setModel(tableModel);    //应用表格模型   
	        tableModel.setDataVector(data, names);
	      
//	       System.out.println(table.getValueAt(0, 5));
//	        ps.writerfile(data.toString());
	}
	public void do_button_actionPerformed(ActionEvent e) {
		 DefaultTableModel model=(DefaultTableModel) table.getModel();//获得表格模型
		 
		    int[] selectedRows=table.getSelectedRows();
		    int select = table.getSelectedRow();
		   System.out.println( table.getSelectedRow());
		   model.removeRow(select);
		    
		    table.setModel(model);
		   }
	}
	