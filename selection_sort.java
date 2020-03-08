import java.util.Scanner;

public class selection_sort {

	public void selectionsort() {
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
	    for(i=0;i<n-1;i++) {
	    	for(j=i+1;j<n;j++) {
	    		if(array[i]>array[j]) {
	    			int temp=array[i];
	    			array[i]=array[j];
	    			array[j]=temp;
	    		}
	    	}
	    }
	    System.out.println("\nSorted array:");
	    for(i=0;i<n;i++)
	    {
	        System.out.print(array[i]+"\t");    
	    }
	}

	public static void main(String[] args) {
		selection_sort obj=new selection_sort();
		obj.selectionsort();
	}

}
