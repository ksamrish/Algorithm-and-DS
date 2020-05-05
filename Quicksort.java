import java.util.Scanner;
public class Main {

	public static int[] quicksort(int[] arr) {
	    int count=0;
	    for(int i=1;i<arr.length-1;i++){
	        if(arr[0]>arr[i]){
	            count++;
	        }
	    }
	    int curvar = arr[0];
		int i=1;
		int j=arr.length-1;
		while(i<j) {
			if(arr[i]>arr[0]&&arr[j]<arr[0]) {
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			else if(arr[i]<=arr[0]) {
				i++;
			}
			else if(arr[j]>arr[0]) {
				j--;
			}
		}
		for(int k=1;k<=count;k++){
		    arr[k-1]=arr[k];
		}
		arr[count] = curvar;
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
		quicksort(arr);
		System.out.println("After 1st quick sort: ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}



/*Time complexity:
      O(n) because we iterate only max of n/2 time and check whether i<j, so it takes max of n/2 turns to complete. so O(n/2) = O(n).
  Space complexity:
      O(1) constant time.

*/
