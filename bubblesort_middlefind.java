import java.util.Scanner;
public class bubble_sort_mid {
	public int[] bubblesortmid(int[] array) {
		for(int i=0;i<=array.length/2;i++) {
			for(int j=0;j<array.length-i-1;j++) {
				if(array[j]>array[j+1]) {
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int i;
		bubble_sort_mid bsortmid = new bubble_sort_mid();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of elements in an array: ");
		int n = input.nextInt();
		System.out.println("Enter the elements in an array: ");
		int[] array = new int[n];
		for(i=0;i<n;i++) {
			int arrayInput = input.nextInt();
			array[i]=arrayInput;
		}
		bsortmid.bubblesortmid(array);
		System.out.println("Array after sorting n/2 elements : ");
		for(i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println("\n"+array[n/2]);
	}
}
