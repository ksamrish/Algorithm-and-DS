package Algo_Sort;
import java.util.Scanner;
import java.math.*;
public class Radix {

	public static int[] radix(int[] arr, int n) {
		int max=arr[0],length=0;
		
		for(int i=1;i<n;i++) {
			if(arr[i]>max)
				max = arr[i];
		}
		while(max>0) {
			max/=10;
			length++;
		}
		for(int i=0;i<length;i++) {
			int div = (int) Math.pow(10, i);
			int rem = (int) Math.pow(10, i+1); 
			for(int j=0;j<n-1;j++) {
				int min = (arr[j]%rem/div);
				int index = j;
				for(int k=j;k<n;k++) {
					if((arr[k]%rem/div)<min) {
						min = (arr[k]%rem/div);
						index = k;
					}	
				}
				if(index!=j) {
					int temp = arr[j];
					arr[j] = arr[index];
					arr[index] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		radix(arr,n);
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
