package 数据结构层;

import java.util.ArrayList;

public class TreeNode<T extends Object> {
	public T data;
	public ArrayList<TreeNode<T>> parts = new ArrayList<TreeNode<T>>();
	public TreeNode<T> parent;
	 public TreeNode<T> child;
	public TreeNode() {
	}
	public TreeNode(T data){
		this.data = data;
		parts =  new ArrayList<TreeNode<T>>();
		parent = null;
		child =null;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return super.toString();
	}
	
	
}