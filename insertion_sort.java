import java.util.Scanner;

public class insertion_sort {

	public int[] insertionsort(int[] array,int n) {

	    System.out.println("\nSorted array:\n");
		
		for(int i=1;i<n;i++) {					// this loop runs n-1 times 
			int temp=array[i];					
			int j=i-1;							
			while(j>=0&&temp<array[j]) {		// this loop compares with previous all element and if smaller than that, it will occupy that space, runs (n*n-1)/2 times as worst case 
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=temp;
		}
		
		return array;
	}
		

	public static void main(String[] args) {
		int i,j;
		System.out.print("Enter the number of elements in the array:");
	    Scanner input=new Scanner(System.in);
	    int n=input.nextInt();
	    int[] array=new int[n];
	    System.out.println("Enter the array elements to be sorted:");
	    for(i=0;i<n;i++)
	    {
	       int arrayinput=input.nextInt();
	       array[i]=arrayinput;
	    }
	    System.out.println("\nArray before sorting:");
	    for(i=0;i<n;i++)
	    {
	        System.out.print(array[i]+"\t");
	    }
		insertion_sort obj=new insertion_sort();
		obj.insertionsort(array,n);
		for(i=0;i<n;i++)
	    {
	        System.out.print(array[i]+"\t");    
	    }
	}

}

/*
Time complexity:
 	so worst case of O(n^2) as explained above in which worst case is (n*n-1)/2 => so n^2-n/2 , eliminating constant and lower order , it will be O(n^2).
	
Space complexity:
	O(constant) as there is no array or some other spaces handled, but some constants so O(constants) which is O(1).
*/
