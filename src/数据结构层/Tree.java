package ���ݽṹ��;

import java.io.File;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import Service��.ZhenDuanInfoService;

public class Tree <T>{
	   public TreeNode<T> root;
	  File file =new File("d:����.txt");
	public static ArrayList<String> list = new ArrayList<String>();
	  public Tree(){
		  root = null;
	  }
	  public boolean isEmpty() {
	    return root == null;
	  }
	  //����������������������
	  public void buildTree(TreeNode<T> sub,TreeNode<T> par) {
		  sub.parent = par;
		  ArrayList<TreeNode<T>> temp = par.parts;
		
		  if(!temp.isEmpty()) {
			  for(TreeNode<T> t:temp) {
				  if(t.data.equals(sub.data)) {
					  return ;
				  }
			  }
		  }
		  par.parts.add(sub);
	  }
	 
	  public void look(TreeNode<T> curR) {
		
		  
		  if(curR != null) {
			  System.out.println(curR.data);
			 list.add((String) curR.data);
			
			  if(curR.parts.size()!= 0) {//parts�ǿ�
				  for(TreeNode<T> temp :curR.parts) {
					  //System.out.println(curR.parts.size());
					  look(temp);
				  }
			  }
		  }else {
			  return ;
		  }
	  }
	  public void build(TreeNode<T> curR) {
		  if(curR != null) {
			//  System.out.println(curR.data);
			for(TreeNode<T> s:curR.parts) {
				//System.out.println(s.data);
			}
			 // new ����Service().writerfile((String)curR.data+"\r\n");
			  if(curR.parts.size()!= 0) {//parts�ǿ�
				  for(TreeNode<T> temp :curR.parts) {
					  System.out.println(curR.parts.size());
					  look(temp);
				  }
			  }
		  }else {
			  return ;
		  }
	  }
	  public void look() {
		  look(root);
	  }
	  public void build() {
		  build(root);
		 
	  }
	  public Tree (TreeNode<T> par) {
		  root = par;
	  }
	  
}
