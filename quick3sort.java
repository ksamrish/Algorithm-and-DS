import java.util.*;
public class Main {

	public static int[] partition(int l,int r, int[] arr,int n) {
		int[] ij = new int[2];
		int mid=l;
		int pivot = arr[r];
		if(r-l<=1) {
			if(arr[r]<arr[l]) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
			ij[0] = l;
			ij[1] = r;
			return ij;
		}
		while(mid<=r) {
			if(arr[mid]<pivot) {
				int temp = arr[l];
				arr[l] = arr[mid];
				arr[mid] = temp;
				l++;mid++;
 			}
			else if(arr[mid]==pivot) {
				mid++;
			}
			else if(arr[mid]>pivot) {
				int temp = arr[mid];
				arr[mid] = arr[r];
				arr[r] = temp;
				r--;
			}
		}
		ij[0] = l-1;
		ij[1] = mid;
		return ij;
	}
	
	public static int[] sort(int[] arr, int n, int l, int r) {
		if(l>=r) {
			return arr;
		}
		else {
			int ij[] = new int[2];
			ij=partition(l,r,arr,n);
//			System.out.print(ij[0]+" "+ij[1]);
			for(int i=0;i<n;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			sort(arr,n,l,ij[0]);
			sort(arr,n,ij[1],r);
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
		int l=0,r=n-1;
		sort(arr,n,l,r);
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
