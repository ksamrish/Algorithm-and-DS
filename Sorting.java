package Algo_Sort;
import java.util.Scanner;
public class Sorting {
	
	public static int[] bubble(int[] arr, int n) {
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static int[] selection(int[] arr,int n) {
		for(int i=0;i<n-1;i++) {
			int min = arr[i];
			int index = i;
			for(int j=i;j<n;j++) {
				if(arr[j]<min) {
					min = arr[j];
					index = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		return arr;
	}
	
	public static int[] insertion(int[] arr, int n) {
		for(int i=1;i<n;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		return arr;
	}
	public static int[] mergesort(int[] arr, int start,int mid,int end) {
		int n1 = mid-start+1;
		int n2 = end-mid;
		int[] l = new int[n1];
		int[] r = new int[n2];
		for(int i=0;i<n1;i++) 
			l[i] = arr[start+i];
		for(int i=0;i<n2;i++)
			r[i] = arr[mid+1+i];
		int i=0,j=0,k=start;
		while(i<n1&&j<n2) {
			if(l[i]>r[j]) 
				arr[k++] = r[j++];
			else if(l[i]<=r[j])
				arr[k++] = l[i++]; 
		}
		while(i<n1) 
			arr[k++] = l[i++];
		while(j<n2)
			arr[k++] = r[j++];
		return arr;
	}
	public static int[] merge(int[] arr, int start, int end) {
		if(start<end) {
		int mid = (start+end)/2;
		merge(arr,start,mid);
		merge(arr,mid+1,end);
		mergesort(arr,start,mid,end);
		return arr;
		}
		else return arr;
	}
	
	public static int[] quick(int[] arr, int start, int end) {
		int i = start,j = end,mid = (start+end)/2;
		int pivot = arr[mid];
		while(i<=j) {
			while(arr[i]<pivot) {
				i++;
			}
			while(arr[j]>pivot) {
				j--;
			}
			if(i<=j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;j--;
			}
		}
		if(start<i-1)
			quick(arr,start,i-1);
		if(i<end)
			quick(arr,i,end);
		return arr;
	}
	
	public static int[] quick3(int[] arr, int start, int end) {
		int i = end, j = end, high = start;
		int pivot = arr[start];
		while(high<=i) {
			if(arr[i]==pivot) {
				i--;
			}
			else if(arr[i]<pivot) {
				int temp = arr[high];
				arr[high] = arr[i];
				arr[i] = temp;
				high++;
			}
			else {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i--;j--;
			}
		}
		if(start<high-1)
			quick3(arr,start,high-1);
		if(j+1<end)
			quick3(arr,j+1,end);
		return arr;
	}
	
	public static int[] heap(int arr[], int start, int end) {
		for(int i=end;i>0;i--) {
			for(int j=(i-1)/2;j>=0;j--) {
				int left = 2*j+1;
				int right = 2*j+2;
				int big = left;
				if(right<=i && arr[right]>arr[left]) {
					big = right;
				}
				if(arr[j]<arr[big]) {
					int temp = arr[big];
					arr[big] = arr[j];
					arr[j] = temp;
				}
			}
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
		}
		return arr;
	}
	
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
	
	public static int[] countsort(int[] a) {
		int minimum = a[0];
		int maximum = a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i]<minimum)
				minimum = a[i];
			if(a[i]>maximum)
				maximum = a[i];
		}
		for(int i=0;i<a.length;i++) {
			a[i]-=minimum;
		}
		int bucket[] = new int[maximum-minimum+1];
		for(int i=0;i<a.length;i++) {
			bucket[a[i]]++;
		}
		int index = 0;
		for(int i=0;i<bucket.length;i++) {
			if(bucket[i]==0) {
				continue;
			}
			for(int j=0;j<bucket[i];j++) {
				a[index++] = i+minimum;
			}
		}
		return a;
	}
	
	public static void radix(int[] arr, int div) {
		int[] temp = new int[10];
		int[] op = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			temp[(arr[i]/div)%10]++;
		}
		
		temp[0] = temp[0]-1;
		for(int i=1;i<10;i++) {
			temp[i] += temp[i-1];
		}
		for(int i=arr.length-1;i>=0;i--) {
			int tempo = arr[i];
			int index = temp[(arr[i]/div)%10]--;
			op[index] = tempo;
		}
		for(int i=0;i<arr.length;i++) {
			arr[i] = op[i];
		}
	}
	
	public static int[] radixsort(int[] arr) {
		int maximum = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>maximum) {
				maximum = arr[i];
			}
		}
		int length = String.valueOf(maximum).length();
		for(int i=0,div=1;i<length;i++,div*=10) {
			radix(arr,div);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 6;
		int[] arr = new int[] {168,179,181,120,142,204};

		Sorting sort = new Sorting();
		System.out.println("Before sorting:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
		
		sort.bubble(arr,n);
		System.out.println("\n\nBubble sort:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
	
		sort.selection(arr,n);
		System.out.println("\n\nSelection sort:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
	
		insertion(arr,n);
		System.out.println("\n\nInsertion sort:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
	
		merge(arr,0,n-1);
		System.out.println("\n\nMerge sort:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
	
		quick(arr,0,n-1);
		System.out.println("\n\nQuick sort:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
	
		quick3(arr,0,n-1);
		System.out.println("\n\nQuick3 sort:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
	
		heap(arr,0,n-1);
		System.out.println("\n\nHeap sort:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
		
		shell(arr,n);
		System.out.println("\n\nShell sort:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
		
		countsort(arr);
		System.out.println("\n\nCount sort:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
		
		radixsort(arr);
		System.out.println("\n\nRadix sort:");
		for(int i=0;i<n;i++) 
			System.out.print(arr[i]+" ");
	}
}

