package ����;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import javax.swing.LookAndFeel;

import Entity��.DiseaseType;
import Service��.ControllerService;
import ���ݽṹ��.NameContainer1;
import ���ݽṹ��.Part1;
import ���ݽṹ��.Tree;
import ���ݽṹ��.TreeNode;
import ���ݽṹ��.extExample1;;


public class ControllerInterface {
	 static ArrayList<TreeNode<String>> list = new ArrayList<TreeNode<String>>();
	
	 static Tree<String> tree = new Tree<String>();
	static String s;
	//static ArrayList<String> child = new ArrayList<String>();
	File file = new File("d://tree.txt");
	Scanner in = new Scanner(System.in);
	static String root;
	public static void main(String[] args) {
		System.out.println("��ѡ�������");
		System.out.println("������-------------1");
		System.out.println("��ѯ��-------------2");
		System.out.println("��ѯ�����µĲ���--------3");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		switch(number){
			case 1: 
				 Map map = new HashMap<String, ArrayList<String>>();
			
				ArrayList<String> child = new ArrayList<String>();
				    System.out.println("�����븸�ڵ����ƣ����ŷָ�������Ǹ��ڵ㣬����Ҫ���븸�ڵ�����");	
					while(true) {
					String str = new Scanner(System.in).nextLine();
					if(str.equals("exit")) {
						break;
					}
					ControllerService service = new ControllerService();
					service.writeFile(str+"\r\n");
					}
				break;
			case 2:
				File file=new File("d:\\tree.txt");
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
		       
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			case 3:
				System.out.println("������Ҫ��ѯ�Ĳ������ƣ�");
				String s = new Scanner(System.in).next();
				
				extExample1 ext = new extExample1();
				
			try {
				ext.main(null);
				System.out.println(s);
				System.out.println("=================");
				if (new Part1("1").list.isEmpty()) {
					String str = ext.x;
					System.out.println(str);
					File file1 = new File("d:�����Ϣ.txt");
					Scanner in1 = new Scanner(file1);
					while(in1.hasNext()) {
						String temp = in1.nextLine();
						if (temp.contains(str)) {
							String[] d = temp.split(" ");
							System.out.println(d[1]+" "+d[2]);
						}
					}
				}else {
					for (String string : new Part1("1").list) {
						System.out.println(string);
						File file1 = new File("d:�����Ϣ.txt");
						Scanner in1 = new Scanner(file1);
						while(in1.hasNext()) {
							String temp = in1.nextLine();
							if (temp.contains(string)) {
								String[] d = temp.split(" ");
								System.out.println(d[1]+" "+d[2]);
							}
						}
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				break;
		}
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
	 public boolean contains(TreeNode<String> node) {
		 for(int i = 0;i<list.size();i++) {
			 if(list.get(i).data.equals(node.data)) {
				 return true;
			 }
		 }
		return false;
		 
	 }
}

