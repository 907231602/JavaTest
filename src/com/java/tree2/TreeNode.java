package com.java.tree2;

public class TreeNode {
	
	private String data;
	private TreeNode ltree;
	private TreeNode rtree;
	
	public TreeNode() {
		// TODO Auto-generated constructor stub
	}
	
	TreeNode(String d,TreeNode l,TreeNode r){
		this.data=d;
		this.ltree=l;
		this.rtree=r;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public TreeNode getLtree() {
		return ltree;
	}
	public void setLtree(TreeNode ltree) {
		this.ltree = ltree;
	}
	public TreeNode getRtree() {
		return rtree;
	}
	public void setRtree(TreeNode rtree) {
		this.rtree = rtree;
	}
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", ltree=" + ltree + ", rtree=" + rtree + "]";
	}

}
