package com.java.Graph;

import java.util.Scanner;

class GraphMatrix {
	static final int MaxNum=20;
	static final int MaxValue=65535;
	
	char[] Vertex=new char[MaxNum];
	int GType;
	int VertexNum;
	int EdgeNum;
	int[][] EdgeWeight=new int[MaxNum][MaxNum];
	int[] isTrav=new int[MaxNum];
  }
	
 
public class Graph{
	
	static Scanner input=new Scanner(System.in);
	static void CreateGraphMatrix(GraphMatrix GM){
		int i,j,k;
		int weight;
		char EstartV,EndV;
		
		System.out.println("输入图中各顶点的信息");
		for(i=0;i<GM.VertexNum;i++){
			System.out.print("第"+(i+1)+"个顶点");
			GM.Vertex[i]=(input.next().toCharArray())[0];
		}
		System.out.println("输入各边的顶点及权值");
		for(k=0;k<GM.EdgeNum;k++){
			System.out.print("第"+(k+1)+"条边");
			EstartV=input.next().charAt(0);
			EndV=input.next().charAt(0);
			weight=input.nextInt();
			for(i=0;EstartV!=GM.Vertex[i];i++)
			{
				for(j=0;EndV!=GM.Vertex[j];j++)
					GM.EdgeWeight[i][j]=weight;
				     if(GM.GType==0){
					   GM.EdgeWeight[j][i]=weight;
				      }
			}	
		}
		
		
	}
	
	static void ClearGraphMatrix(GraphMatrix GM){
		int i,j;
		for(i=0;i<GM.VertexNum;i++){
			for(j=0;j<GM.VertexNum;j++){
				GM.EdgeWeight[i][j]=GraphMatrix.MaxValue;
			}
		}
	}
	
	static void OutGraph(GraphMatrix GM){
		int i,j;
		for(j=0;j<GM.VertexNum;j++){
			System.out.print(" "+GM.Vertex[j]);
		}
		System.out.println();
		for(i=0;i<GM.VertexNum;i++){
			 System.out.print(GM.Vertex[i]);
			 for(j=0;j<GM.VertexNum;j++){
				 if(GM.EdgeWeight[i][j]==GraphMatrix.MaxValue){
						System.out.print(" Z");
					}else{
						System.out.print(" "+GM.EdgeWeight[i][j]);
					} 
			 }
			 System.out.println();
		}
		
	}
	
	
	static void DeepTraOne(GraphMatrix GM,int n){
		int i;
		GM.isTrav[n]=1;
		System.out.print("->"+GM.Vertex[n]);
		
		for(i=0;i<GM.VertexNum;i++){
			if(GM.EdgeWeight[n][i]!=GraphMatrix.MaxValue&& GM.isTrav[n]==0){
				DeepTraOne(GM, i);
			}
		}
	}
	
	static void DeepGraphMatrix(GraphMatrix GM){
		int i;
		for(i=0;i<GM.VertexNum;i++){
			GM.isTrav[i]=0;
		}
		System.out.println("深度优先遍历结点");
		for(i=0;i<GM.VertexNum;i++){
			if(GM.isTrav[i]==0){
				DeepTraOne(GM,i);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphMatrix GM=new GraphMatrix();
		System.out.print("输入生成图的类型");
		GM.GType=input.nextInt();
		System.out.print("输入图的顶点数量");
		GM.VertexNum=input.nextInt();
		System.out.println("输入图的边的数量");
		GM.EdgeNum=input.nextInt();
		ClearGraphMatrix(GM);
		CreateGraphMatrix(GM);
		System.out.println("该图的邻接矩阵如下");
		OutGraph(GM);
		DeepGraphMatrix(GM);
	}
}

