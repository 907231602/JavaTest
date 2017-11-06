package com.java.tree2;

import java.util.Scanner;

public class BTree {
	
	private TreeNode root;
	static Scanner scan=null;
	public TreeNode CreateTr(){
		return createTree(root);
		
	}
	
	
	/**
	 * 创建二叉树
	 * 			 A
	 * 		B		  C
	 * 	D			E	F
	 * 
	 * ABD###CE##F##
	 * @param root
	 * @return
	 */
	public TreeNode createTree(TreeNode root) {
		System.out.println("请输入二叉树数据");
		 scan=new Scanner(System.in);
		String value=  scan.next();
		
			if("#".equals(value)) {
				root=null;
				return null;
			}
			
			root=new TreeNode(value, null, null);
			
			root.setLtree(createTree(root.getLtree()));
			root.setRtree(createTree(root.getRtree()));
			
		return root;
		
	}
	
	/**
	 * 创建二叉树（结构）
	 * 			 A
	 * 		B		  C
	 * 	D			E	F
	 * 
	 * 输入： A B D # # # C E # # F # #
	 * @param root
	 * @param scanner
	 * @return
	 */
	public TreeNode createNewSanTree(TreeNode root,Scanner scanner) {
		String str= scanner.next();
		System.out.println(str+" --");
		if("#".equals(str)) {
			//root=null;
			return null;
		}
		root=new TreeNode(str, null, null);
		
		root.setLtree(createNewSanTree(root.getLtree(), scanner));
		root.setRtree(createNewSanTree(root.getRtree(), scanner));
		return root;
		
	}
	
	public void preTraverse(TreeNode root)  
    {  
        if(root!=null)  
        {  
            System.out.print(root.getData()+" ");  
            preTraverse(root.getLtree());  
            preTraverse(root.getRtree());  
        }  
    }  
	
	public static void main(String[] args) {
		BTree btree=new BTree();
		//btree.root= btree.CreateTr();
		//btree.preTraverse(btree.root);
		
		scan=new Scanner(System.in);
		btree.root=btree.createNewSanTree(btree.root, scan);
		btree.preTraverse(btree.root);
		
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

}
