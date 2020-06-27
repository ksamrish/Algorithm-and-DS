package Algo_Sort;
import java.util.Scanner;
public class Shell {

	public static int[] shell(int[] arr, int n) {
		for(int j=n/2;j>=1;j/=2) {
			for(int i=j;i<n;i++) {
				int h=i;
				for(int k=i-j;k>=0;k-=j) {
					if(arr[k]>arr[h]) {
						int temp = arr[k];
						arr[k] = arr[h];
						arr[h] = temp;
						h=k;
					}
					else {
						break;
					}
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		shell(arr,n);
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
