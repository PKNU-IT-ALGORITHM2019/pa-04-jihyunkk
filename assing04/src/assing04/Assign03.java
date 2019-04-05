package assing04;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;




public class Assign03 {
	public static int []A=new int[1000];
	public static int []B=new int[10000];
	public static int []C=new int[100000];
	public static int temp[] = new int[100000];

	public static double [][]sortion=new double[][]{
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0},
			{0,0,0,0,0,0}
	};
	public static void main(String[] args) {
		
		
		for(int k=0;k<10;k++) {
		
			int j=0;
			for(int i=1000;i>0;i--) {
				A[j++]=i;
			}
			
			j=0;
			for(int i=10000;i>0;i--) {
				B[j++]=i;
			}
			j=0;
			for(int i=100000;i>0;i--) {
				C[j++]=i;
			}
			sortion[1][1]+=selectionSort(A);
			sortion[1][3]+=selectionSort(B);
			sortion[1][5]+=selectionSort(C);
			
			sortion[0][1]+=bubbleSort(A);
			sortion[0][3]+=bubbleSort(B);
			sortion[0][5]+=bubbleSort(C);
			
			sortion[2][1]+=insertionSort(A);
			sortion[2][3]+=insertionSort(B);
			sortion[2][5]+=insertionSort(C);
			
			sortion[3][1]+=mergeSort(A,0,A.length-1);
			sortion[3][3]+=mergeSort(B,0,B.length-1);
			sortion[3][5]+=mergeSort(C,0,C.length-1);
		
			sortion[4][1]+=quickSort(A,0,A.length-1);
			sortion[4][3]+=quickSort(B,0,B.length-1);
			
			
			sortion[5][1]+=middle_quickSort(A,0,A.length-1);
			sortion[5][3]+=middle_quickSort(B,0,B.length-1);
			sortion[5][5]+=middle_quickSort(C,0,C.length-1);
			
			sortion[6][1]+=rand_quickSort(A,0,A.length-1);
			sortion[6][3]+=rand_quickSort(B,0,B.length-1);
			sortion[6][5]+=rand_quickSort(C,0,C.length-1);
			
			sortion[7][1]+=heapSort(A);
			sortion[7][3]+=heapSort(B);
			sortion[7][5]+=heapSort(C);
			
			sortion[8][1]+=library(A);
			sortion[8][3]+=library(B);
			sortion[8][5]+=library(C);
		}
		
		
	
		for(int k=0;k<10;k++) {
			for(int i=0;i<1000;i++)
				A[i]=(int)(Math.random()*1000)+1;
			for(int i=0;i<10000;i++)
				B[i]=(int)(Math.random()*10000)+1;
			for(int i=0;i<100000;i++)
				C[i]=(int)(Math.random()*100000)+1;
			
			sortion[1][0]+=selectionSort(A);
			sortion[1][2]+=selectionSort(B);
			sortion[1][4]+=selectionSort(C);
			
			sortion[0][0]+=bubbleSort(A);
			sortion[0][2]+=bubbleSort(B);
			sortion[0][4]+=bubbleSort(C);
	
			sortion[2][0]+=insertionSort(A);
			sortion[2][2]+=insertionSort(B);
			sortion[2][4]+=insertionSort(C);
			
			sortion[3][0]+=mergeSort(A,0,A.length-1);
			sortion[3][2]+=mergeSort(B,0,B.length-1);
			sortion[3][4]+=mergeSort(C,0,C.length-1);
		
			sortion[4][0]+=quickSort(A,0,A.length-1);
		    sortion[4][2]+=quickSort(B,0,B.length-1);
		  
			
			sortion[5][0]+=middle_quickSort(A,0,A.length-1);
			sortion[5][2]+=middle_quickSort(B,0,B.length-1);
			sortion[5][4]+=middle_quickSort(C,0,C.length-1);
			
			sortion[6][0]+=rand_quickSort(A,0,A.length-1);
			sortion[6][2]+=rand_quickSort(B,0,B.length-1);
			sortion[6][4]+=rand_quickSort(C,0,C.length-1);
		
			sortion[7][0]+=heapSort(A);
			sortion[7][2]+=heapSort(B);
			sortion[7][4]+=heapSort(C);
			
			
			sortion[8][0]+=library(A);
			sortion[8][2]+=library(B);
			sortion[8][4]+=library(C);
			
		}
		
		print();

	}
	public static void print() {
		
		System.out.println("          "+"Random1000"+"          "+"Reverse1000"+"          "+"Random10000"+"          "+"Reverse10000"+"          "+"Random1000000"+"          "+"Reverse100000");
		System.out.print("Bubble");
		for(int i=0;i<6;i++) {
			double result=(Math.round((sortion[0][i]/10)*1000)/1000.0);
			System.out.print("   "+result+"   ");
		}
		System.out.println("");
		System.out.print("Selection");
		for(int i=0;i<6;i++) {
			double result=(Math.round((sortion[1][i]/10)*1000)/1000.0);
			System.out.print("   "+result+"   ");
		}
		System.out.println("");
		System.out.print("Insertion");
		for(int i=0;i<6;i++) {
			double result=(Math.round((sortion[2][i]/10)*1000)/1000.0);
			System.out.print("   "+result+"   ");
		}
		System.out.println("");
		System.out.print("Merge");
		for(int i=0;i<6;i++) {
			double result=(Math.round((sortion[3][i]/10)*1000)/1000.0);
			System.out.print("   "+result+"   ");
		}
		System.out.println("");
		System.out.print("Quick1");
		for(int i=0;i<6;i++) {
			double result=(Math.round((sortion[4][i]/10)*1000)/1000.0);
			System.out.print("   "+result+"   ");
		}
		System.out.println("");
		System.out.print("Quick2");
		for(int i=0;i<6;i++) {
			double result=(Math.round((sortion[5][i]/10)*1000)/1000.0);
			System.out.print("   "+result+"   ");
		}
		System.out.println("");
		System.out.print("Quick3");
		for(int i=0;i<6;i++) {
			double result=(Math.round((sortion[6][i]/10)*1000)/1000.0);
			System.out.print("   "+result+"   ");
		}
		
		System.out.println("");
		System.out.print("Hepa");
		for(int i=0;i<6;i++) {
			double result=(Math.round((sortion[7][i]/10)*1000)/1000.0);
			System.out.print("   "+result+"   ");
		}
		
		System.out.println("");
		System.out.print("Library");
		for(int i=0;i<6;i++) {
			double result=(Math.round((sortion[8][i]/10)*1000)/1000.0);
			System.out.print("   "+result+"   ");
		}
	}
	
	
	public static double selectionSort(int arr[]) {
		long start = System.currentTimeMillis();
		for(int i=0; i<arr.length; i++) {
			int minIndex = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		long end = System.currentTimeMillis();
		
		double result=(end-start)/1000.0;
		return result;
	}
	
	public static double bubbleSort(int arr[]) {
		long start = System.currentTimeMillis();
		for(int i=arr.length; i>0; i--) {
			for(int j=0; j<i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		long end = System.currentTimeMillis();
		
		double result=(end-start)/1000.0;
		return result;
	}
	 
	public static double insertionSort(int arr[]) {
		long start = System.currentTimeMillis();
		for(int i=1; i<arr.length; i++) {
			int temp = arr[i];
			int j=i-1;
			while(j >= 0 && temp < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
		long end = System.currentTimeMillis();
		
		double result=(end-start)/1000.0;
		return result;
	}

	 public static double mergeSort(int arr[], int l, int r) {
		
		 long start = System.currentTimeMillis();
		if(l<r) {
			int mid = (l+r)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr, l, mid, r);
		
		}
		long end = System.currentTimeMillis();
		
		double result=(end-start)/1000.0;
		return result;
	}

	 public static void merge(int arr[], int l, int mid, int r) {
			int i = l;
			int j = mid+1;
			int k = l;
			
			while(i<=mid && j<=r) {
				if(arr[i] <= arr[j]) {
					temp[k++] = arr[i++];
				}
				else  {
					temp[k++] = arr[j++];
				}
				
			}
			
				while(i<=mid)
					temp[k++] = arr[i++];
				
			
				while(j<=r)
					temp[k++] = arr[j++];
			
			for(int index=l; index<k; index++)
				arr[index] = temp[index];
			
		}
		
	
	
	 public static double quickSort(int arr[], int l, int r) {
		 long start = System.currentTimeMillis();
			if(l<=r){
		    int p = partition(arr, l, r);
		    quickSort(arr, l, p-1);
		    quickSort(arr, p+1, r);
		    }
			long end = System.currentTimeMillis();
			
			double result=(end-start)/1000.0;
			return result;
		}
		public static int partition(int arr[], int l,int r) {
			int pivot = arr[r];
			int i = l - 1;
			for(int j=l; j<r; j++) {
				if(arr[j] < pivot) {
					i++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			int temp = arr[i+1];
			arr[i+1] = arr[r];
			arr[r] = temp;
			return i+1;
		}
		
		public static int middle_partition(int arr[], int l,int r) {
			int middle=(l+r)/2;
			int pivot;
			int index;
			if(l>=middle&&l<=r||l<=middle&&l>=r) {
				pivot=arr[l];
				index=l;
			}
			else if(middle>=l&&middle<=r||middle<=l&&middle>=r) {
				pivot=arr[middle];
				index=middle;
			}
			else {
				pivot=arr[r];
				index=r;
			}
			int i = l - 1;
			for(int j=l; j<r; j++) {
		
				if(arr[j] < pivot) {
					i++;
					if(arr[i]==pivot) {
						index=j;
					}
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			int temp = arr[i+1];
			arr[i+1] = arr[index];
			arr[index] = temp;
			return i+1;
		}
		
		public static double  middle_quickSort(int arr[], int l, int r) {
			
			long start = System.currentTimeMillis();
			if(l<=r){
		    int p = middle_partition(arr, l, r);
		    middle_quickSort(arr, l, p-1);
		    middle_quickSort(arr, p+1, r);
		  }
			long end = System.currentTimeMillis();
			
			double result=(end-start)/1000.0;
			return result;
		}
		
		
		public static int rand_partition(int arr[], int l,int r) {
			int size=arr.length;
			int Rand=(int)(Math.random()*size);//1~size까지 중 랜덤한 수 지정
		
			int pivot = arr[Rand];
			int i = l - 1;
			for(int j=l; j<r; j++) {
				
				if(arr[j] < pivot) {
					i++;
					if(arr[i]==pivot) {
						Rand=j;
					}
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			int temp = arr[i+1];
			arr[i+1] = arr[Rand];
			arr[Rand] = temp;			
			return i+1;
		}

		public static double  rand_quickSort(int arr[], int l, int r) {
			long start = System.currentTimeMillis();
			if(l<=r){
		    int p = rand_partition(arr, l, r);
		    rand_quickSort(arr, l, p-1);
		    rand_quickSort(arr, p+1, r);
		  }
			long end = System.currentTimeMillis();
			
			double result=(end-start)/1000.0;
			return result;
		}	
		
		
		
		private static double heapSort(int[] arr) {
			long start = System.currentTimeMillis();
			
			int length = arr.length - 1;
			maxHeapBuild(arr);
			for (int i = length; i >= 1; i--) {
				swap(arr, 0, i);
				length-=1;
				maxHeapify(arr, 0);
			}
			long end = System.currentTimeMillis();
			
			double result=(end-start)/1000.0;
			return result;
		}
		private static void maxHeapBuild(int[] arr) {
			int length = arr.length;
			
			for (int i = length / 2; i >= 0; i--) {
				maxHeapify(arr, i);
			}
		}
		private static void maxHeapify(int[] arr, int i) {
			int length = arr.length;
			int leftChild = i*2;
			int rightChild = (i*2)+1;
			int k = 0;
			
			if(leftChild > length || rightChild > length) {
				return;
			}
	
			if (arr[leftChild] > arr[rightChild]) {
				k = leftChild;
			} else {
				k = rightChild;
			}
		
			if (arr[i] >= arr[k]) {
				return;
			}
			
			swap(arr, i, k);
			maxHeapify(arr, k);
		}
		public static void printArray(int arr[]) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		public static void swap(int arr[], int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		
		
		
		
		public static double library(int arr[]) {
			long start = System.currentTimeMillis();
			
			Arrays.sort(arr);
			
			
			
			
			long end = System.currentTimeMillis();
			
			double result=(end-start)/1000.0;
			return result;
			
		
		}
}