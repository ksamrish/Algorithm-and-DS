import java.util.*;
public class Heap_max {

	public static int[] heap(int[] arr,int n) {
		for(int i=n;i>0;i--) {
			int half = i/2;
			for(int j=half;j>0;j--) {
				if(j*2+1<=i) {
					if(arr[j]<arr[j*2]||arr[j]<arr[j*2+1]) {
						if(arr[j*2]>=arr[j*2+1]) {
							int temp1 = arr[j];
							arr[j] = arr[j*2];
							arr[j*2] = temp1;
						}
						else {
						int temp1 = arr[j];
						arr[j] = arr[j*2+1];
						arr[j*2+1] = temp1;
						}
					}	 
				}
				else {
					if(arr[j]<arr[j*2]) {
						int temp1 = arr[j];
						arr[j] = arr[j*2];
						arr[j*2] = temp1;
					}	
				}
			}
			int temp = arr[i];
			arr[i] = arr[1];
			arr[1] = temp;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1]; //{0,168,179,181,120,142,204};
 		for(int i=1;i<=n;i++) {
 			arr[i] = sc.nextInt();
 		}
		heap(arr,n);
		for(int i=1;i<=n;i++) {
			System.out.println(arr[i]+" ");
		}
		}

}
