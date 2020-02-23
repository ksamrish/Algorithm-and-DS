package Algorithms1;
import java.util.Scanner;
public class bubblesort 
{

			public static void main(String[] args) {
			    int i,j,count=0;
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
			    int k=n;
			    while(k>0)
			    {
			        
			       i=0;j=0;
			        for(j=i+1;j<n-count;j++,i++)
			        {
			            //System.out.print("\n"+count+" "+i+" "+j+" ");
			            if(array[i]<array[j])
			            {
			                int temp=array[i];
			                array[i]=array[j];
			                array[j]=temp;
			            }
			        }
			        k--;
			        count++;
			    }
			    System.out.println("\nSorted array:");
			    for(i=0;i<n;i++)
			    {
			        System.out.print(array[i]+"\t");    
			    }
			}
		}