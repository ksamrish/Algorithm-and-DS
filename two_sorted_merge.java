import java.util.Scanner;

public class Merge_sorted_array {

	public void merge(int[] arr1,int[] arr2,int n,int m) {
		int k=0,h=0;
		
		System.out.print("inside function");
		int[] arr3 = new int[n+m];
		for(;(k+h)<(m+n);) {
		    if((k+h)==(m+n)){
		        break;
		    }
			if(arr1[k]<=arr2[h]) {
				arr3[k+h]=arr1[k];
				k++;
				if(k==n) {
					arr1[k]=32678;
				}
			}
			if(arr1[k]>arr2[h]) {
				arr3[k+h]=arr2[h];
				h++;
				if(h==m) {
					arr2[h]=32678;
				}
			}
		}
		for(int i=0;i<(m+n);i++) {
			System.out.println(arr3[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter first array length:");
		int n = sc.nextInt();
		System.out.print("enter second array length:");
		int m = sc.nextInt();
		int[] arr1 = new int[n+1];
		int[] arr2 = new int[m+1];
		
		System.out.print("enter first array elements:");
		for(int i = 0;i<n;i++) {
			int val = sc.nextInt();
			arr1[i] = val;
		}
		System.out.print("enter second array elements:");
		for(int i = 0;i<m;i++) {
			int val = sc.nextInt();
			arr2[i] = val;
		}
		Merge_sorted_array obj = new Merge_sorted_array();
		obj.merge(arr1,arr2,n,m);
	}

}
