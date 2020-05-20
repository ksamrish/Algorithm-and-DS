import java.util.Scanner;
public class Qs_middle {

	public static int[] qs(int[] arr,int l,int r) {
		if(l<r) {
		int pivot = (l+r)/2;
		int i = l;
		for(int j=l;j<=r;j++) {
		    
			if(i==(l+r)/2&&i!=r) {
					i++;
			    }
			if(j==((l+r)/2)) {
				continue;
			}
// 			if(i==r&&j==r){
// 			    continue;
// 			}
            if(i==r&&j==r&&arr[i]>arr[pivot]) {
					i--;
					continue;
				}
			if(i==r&&j==r&&arr[i]<arr[pivot]) {
					continue;
				}
				
			if(arr[j]<arr[pivot]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
			if(i==r&&j==r&&arr[i]>arr[pivot]) {
					i--;
					continue;
				}
			
		}
		int temp = arr[i];
		arr[i] = arr[pivot];
		arr[pivot] = temp;
		qs(arr,l,i-1);
		qs(arr,i+1,r);
		}
		return arr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			int val = sc.nextInt();
			arr[i] = val;
		}
		int l = 0, r = n;
		qs(arr,l,r-1);
		for(int i=0;i<n;i++) {
		System.out.print(arr[i]+"\t");
		}
 	}
}

