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
		
		System.out.println("����ͼ�и��������Ϣ");
		for(i=0;i<GM.VertexNum;i++){
			System.out.print("��"+(i+1)+"������");
			GM.Vertex[i]=(input.next().toCharArray())[0];
		}
		System.out.println("������ߵĶ��㼰Ȩֵ");
		for(k=0;k<GM.EdgeNum;k++){
			System.out.print("��"+(k+1)+"����");
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
		System.out.println("������ȱ������");
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
		System.out.print("��������ͼ������");
		GM.GType=input.nextInt();
		System.out.print("����ͼ�Ķ�������");
		GM.VertexNum=input.nextInt();
		System.out.println("����ͼ�ıߵ�����");
		GM.EdgeNum=input.nextInt();
		ClearGraphMatrix(GM);
		CreateGraphMatrix(GM);
		System.out.println("��ͼ���ڽӾ�������");
		OutGraph(GM);
		DeepGraphMatrix(GM);
	}
}

