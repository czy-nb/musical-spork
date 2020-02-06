package 界面;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import Service层.ControllerService;
import 数据结构层.NameContainer;
import 数据结构层.Part;
import 数据结构层.Tree;
import 数据结构层.TreeNode;
import 数据结构层.extExample;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;

public class AdministorInterface {

	private JFrame frame;
	static NameContainer partContainer;
	static ArrayList<TreeNode<String>> listdisease = new ArrayList<TreeNode<String>>();
	public static  JTextField textField;
	private JTextField textField_1;
	public static JTextField textField_2;
	static public String str;
	static public String str1;
	static ArrayList<TreeNode<String>> list = new ArrayList<TreeNode<String>>();
	 static Tree<String> tree = new Tree<String>();
	 static String root;
	 static Vector v1 = new Vector();
	 static ArrayList<String >  list1 = new ArrayList<String>();
	 private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministorInterface window = new AdministorInterface();
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
	public AdministorInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 1176, 738);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u8981\u521B\u5EFA\u7684\u6811\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setBounds(0, 13, 146, 18);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5907\u6CE8\uFF1A\u8F93\u5165\u8282\u70B9\u540D\u79F0\uFF0C\u9017\u53F7\u5206\u9694\uFF0C\u6839\u8282\u70B9\u4E0D\u9700\u8981");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(0, 44, 335, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(142, 13, 177, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u6811\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(341, 18, 161, 18);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(489, 16, 161, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u75C5\u79CD\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(685, 13, 155, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(844, 16, 120, 24);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		  
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 82, 286, 422);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("\u521B\u5EFA");
		btnNewButton.setBounds(126, 561, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.setBounds(507, 561, 113, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(404, 89, 286, 414);
		frame.getContentPane().add(scrollPane_2);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.setBounds(876, 561, 113, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(813, 89, 263, 422);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();

		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton_3 = new JButton("\u5237\u65B0");
		btnNewButton_3.setBounds(404, 632, 113, 27);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u540E\u53F0");
		btnNewButton_4.setBounds(623, 632, 113, 27);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new BackgroundInterface().main(null);
				
			}
		});
		String s = "disease"+" "+"id"+" "+"name";
		v1.add(s);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AdministorInterface().main(null);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 str1 = textField.getText();
				if(textField.getText().contentEquals("内科树")) {
					String s = textArea.getText();
					ControllerService service = new ControllerService();
					service.writeFile(s+"\r\n");
				}
				if(textField.getText().contentEquals("外科树")) {
					String s = textArea.getText();
					ControllerService service = new ControllerService();
					service.writeFile(s+"\r\n");
				}
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = null;
				if(textField_1.getText().contentEquals("内科树")) {
					 file=new File("d://"+textField_1.getText()+".txt");
				}
				if(textField_1.getText().contentEquals("外科树")) {
					 file=new File("d://"+textField_1.getText()+".txt");
				}
					FileReader fr;
					try {
						fr = new FileReader (file);
						BufferedReader br=new BufferedReader(fr);
						String line=null;
						
				        while((line=br.readLine())!=null){
				        	// ArrayList<String> list = new ArrayList<String>();
				        	if (!line.contains(",")) {
				        		 root = line;
				        		
				        		TreeNode<String> treeNode = new TreeNode<String>(root);
				        		tree.root=treeNode;
				        		list.add(treeNode);
				        	}
				        	else {
				        	StringTokenizer st=new StringTokenizer(line,",");
							String str1 =st.nextToken();
							String str2 = st.nextToken();
							TreeNode<String> treeNode1 = new TreeNode<String>(str1);
							TreeNode<String> treeNode2 = new TreeNode<String>(str2);
							
							list.add(treeNode1);
							list.add(treeNode2);
							buildTree(treeNode1, treeNode2);
							
				        	}
				        }
				       tree.look();
				       list1 = tree.list;
				       
				       for (String s : list1) {
				    	  // System.out.println(s);
						textArea_2.append(s+"\r\n");
					}
				       
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
	btnNewButton_2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			 str = textField_2.getText();
			extExample ext = new extExample();
			DefaultTableModel tableModel=(DefaultTableModel) table.getModel();  
			tableModel.setRowCount(0); 
		    tableModel.setColumnIdentifiers(new Object[]{"disease","id","name"});
		    Object[] object = new Object[3];
		  
		   System.out.println(str);
			try {
				
				ext.main(null);
				System.out.println(new Part("1").list.isEmpty());
				if (new Part("1").list.isEmpty()) {
					
					File file1 = new File("d:诊断信息.txt");
					Scanner in1 = new Scanner(file1);
					while(in1.hasNext()) {
						String temp = in1.nextLine();
						String[] d = temp.split(" ");
						System.out.println(d[0]);
						if (d[0].contentEquals(str)) {
							//String[] d = temp.split(" ");
							System.out.println(d[1]);
						
								for(int j=0;j<3;j++) {
									object[j] = d[j];
									
								}
								tableModel.addRow(object);
							}
						//tableModel.addRow(object);
						}
					//tableModel.addRow(object);
					}
			
				else {
					for (String string : new Part("1").list) {
						System.out.println(string);
						File file1 = new File("d:诊断信息.txt");
						Scanner in1 = new Scanner(file1);
						while(in1.hasNext()) {
							String temp = in1.nextLine();
							if (temp.contains(string)) {
								String[] d = temp.split(" ");
								for(int j=0;j<3;j++) {
									object[j] = d[j];
									
								}
								tableModel.addRow(object);
								}
							
							}
						
						}
					}
				
				 table.setModel(tableModel);    //应用表格模型
				
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
	});
	}
public static void buildTree(TreeNode<String> sub,TreeNode<String> par) {		 
	 int s = indexOf(sub);
	 int p = indexOf(par);
	 list.get(s).parent = list.get(p);
	 ArrayList<TreeNode<String>> temp = list.get(p).parts;
	 if(!temp.isEmpty()){
		  for(TreeNode<String > t:temp) {
			  if(t.data.equals(sub.data)) {
				  return ;
			  }
		  }
	  }
	 list.get(p).parts.add(list.get(s));
 }

public static int indexOf(TreeNode<String> node) {
	 for(int i = 0;i<list.size();i++) {
		 if(list.get(i).data.equals(node.data)) {
			 return i;
		 }
	 }
	return -1;
	 
}
}
