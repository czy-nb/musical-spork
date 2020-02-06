package 数据结构层;

import java.io.File;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import Service层.ZhenDuanInfoService;

public class Tree <T>{
	   public TreeNode<T> root;
	  File file =new File("d:病种.txt");
	public static ArrayList<String> list = new ArrayList<String>();
	  public Tree(){
		  root = null;
	  }
	  public boolean isEmpty() {
	    return root == null;
	  }
	  //下面两个方法用来构建树
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
			
			  if(curR.parts.size()!= 0) {//parts非空
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
			 // new 病种Service().writerfile((String)curR.data+"\r\n");
			  if(curR.parts.size()!= 0) {//parts非空
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
