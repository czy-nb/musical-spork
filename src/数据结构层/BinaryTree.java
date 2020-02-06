package 数据结构层;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Entity层.PatientInfo;
import 界面.main;

class Node{
    public PatientInfo data;
    public Node left;
    public Node right;
    public Node(PatientInfo data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree{
	public static ArrayList<PatientInfo> temp2 = new ArrayList<PatientInfo>();
    private Node root;
    public BinaryTree(){
        root = null;
    }

    //将date插入到排序二叉树中
    public void insert(PatientInfo data){
        Node newNode = new Node(data);
        if(root == null)
            root = newNode;
        else{
            Node current = root;
            Node parent;
            while (true) {    //寻找插入的位置
                parent = current;
                if(data.compareTo(current.data)<0){
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                        return;
                    }
                }
                else{
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    //输入数值，构建二叉树
    public void buildTree(ArrayList<PatientInfo> list){
        for (int i = 0; i<list.size(); i++) {
            insert(list.get(i));
        }
    }
    //中序遍历方法递归实现
    public void inOrder(Node localRoot){
        if (localRoot != null) {
            inOrder(localRoot.left);
            temp2.add(localRoot.data);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }
    public void inOrder(){
        this.inOrder(this.root);
    }
    //先序遍历方法递归实现
    public void preOrder(Node localRoot){
        if (localRoot != null) {
        	
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }
    public void preOrder(){
        this.preOrder(this.root);
    }
    //后序遍历方法递归实现
    public void postOrder(Node localRoot){
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }
    public void postOrder(){
        this.postOrder(this.root);
    }
    public static void main(String[] args) {
    	ArrayList<String> list = new ArrayList<String>();
    	ArrayList<PatientInfo> temp1 = new ArrayList<PatientInfo>();
    	File file = new File("d://已就诊patient.txt");
	   try {
		   Scanner in = new Scanner(file);
	   
		while(in.hasNext()) {
			
		String s = in.nextLine();
		list.add(s);
		}
					for (String string :list) {
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
        //int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };

  BinaryTree tree = new BinaryTree();

        tree.buildTree(temp1);
        //roots.values();
        tree.inOrder();
        for (PatientInfo patientInfo : temp2) {
			System.out.println(patientInfo);
		}
//        for (patientInfo patientInfo : temp1) {
//			System.out.println(patientInfo);
//		}
//        
	   }catch (Exception e) {
		// TODO: handle exception
	}
	}
    //层次遍历（利用一个队列实现）
//    public static void levelOrder(Node localRoot){  
//        if(localRoot == null)
//          return;  
//        List<Node> queue = new LinkedList<Node>();  
//        queue.add(localRoot);  
//        while(!queue.isEmpty()){  
//            Node temp = queue.poll(0);  
//            System.out.print(temp.data + " ");  
//            if(temp.left != null){  
//                queue.add(temp.left);  
//            }  
//            if(temp.right != null){  
//                queue.add(temp.right);  
//            }  
//        }  
//        System.out.println();  
//    }
//    public void levelOrder(){
//        this.levelOrder(this.root);
//    }
}