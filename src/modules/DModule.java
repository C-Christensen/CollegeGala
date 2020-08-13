package modules;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DModule {
	
	public static <T extends Comparable<T>> int binarySearch(List<T> list, T target) {
		int min = 0;
		int max = list.size() - 1;
		int mid = list.size() / 2;
		
		while(min <= max) {
			if (target.compareTo(list.get(mid)) > 0) {
				max = mid + 1;
			}else if (target.compareTo(list.get(mid)) < 0) {
				min = mid + 1;
			
			}
		}
		return mid;	
	}
	
	public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 1; j < list.size() - i; j++) {
				if(list.get(j).compareTo(list.get(j - 1)) < 0) {
					swap(list, j, j - 1);
				}
			}
		}
		
	}
	
	public static <T extends Comparable<T>> void insertionSort(List<T> list) {
		
		int j;
		for(int i = 1; i < list.size(); i++) {
			T current = list.get(i);
			for(j = i; j> 0 && current.compareTo(list.get(j - 1)) < 0; j--) {
				list.set(j, list.get(j - 1));
			}
			list.set(j, current); 
		}
		
	}
	
	public static <T extends Comparable<T>> void maxInsertSort(List<T> list) {
		
		int j;
		for(int i = 1; i < list.size(); i++) {
			T current = list.get(i);
			for(j = i; j> 0 && current.compareTo(list.get(j - 1)) > 0; j--) {
				list.set(j, list.get(j - 1));
			}
			list.set(j, current); 
		}
		
	}
	
	public static <T> void maxSelectionSort(List<T> list, Comparator<T> comp) {
		
		for(int i = 0; i < list.size(); i++) {
			int minIndex = i;
			for(int j = i + 1; j < list.size(); j++) {
				if(comp.compare(list.get(j), list.get(minIndex)) > 0) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				T min        = list.get(minIndex);
				list.set(minIndex, list.get(i));
				list.set((int) list.get(i), min);
			}
		}
		
	}
	
	static <T extends Comparable<T>> void merge(List<T> list, List<T> left, List<T> right) {
		
	}
	
	static <T extends Comparable<T>> void mergeSort(List<T> list) {
		
	}
	
	public static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
		int 	 l;
		int 	 h;
		int 	 mid;
	    T  		 temp;
		boolean  done;
		
		/*Pick middle element as pivot */
		mid   = low + (high - low) / 2;
		T pivot = list.get(mid);
		
		done = false;
		
		
		while(!done) {
			/* Increment low while list[low] < pivot */
			while(pivot.compareTo(list.get(low)) > 0){
				++low;
			}
			
			/* Decrement h while pivot < list[high] */
			while(pivot.compareTo(list.get(high)) < 0) {
				--high;
			}
			
			/* If there are zero or one item remaining,
			 * all numbers in the list are partitioned.
			 * Return the highest number.
			 */
			
			if(low >= high) {
				done = true;
			}
			else {
				/* Swap list[low] and list[high]'
				 * update low and high values
				 */
				temp = list.get(low);
				list.set(low, list.get(high));
				list.set(high, temp);
				
				++low;
				--high;
			}
		}
		
	
		return high;
	}
	
	public static <T extends Comparable<T>> void quickSort(List<T> list) {
		quickSort(list, 0, list.size() - 1);	
	}
	
	private static <T extends Comparable<T>> void quickSort(List<T> list, int left, int right) {
		int j;
		
		
		
		if (left >= right) {
			return;
		}
		
		
		j = partition(list, left, right);
		
		
		quickSort(list, left, j);
		quickSort(list, j + 1, right);
	}
	
	public static <T extends Comparable <T>> void selectionSort(List<T> list) {
		
		
		for(int i = 0; i < list.size(); i++) {
			int minIndex = i;
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(j).compareTo(list.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				T min        = list.get(minIndex);
				list.set(minIndex, list.get(i));
				list.set((int) list.get(i), min);
			}
		}
		
	}
	
	public static <T> List<T> splitFirstHalf(List<T> list){
		
		List<T> firstHalf = new ArrayList<T>();
		
		int size = list.size();
		
		for (int i = 0; i < size / 2; i++) {
			firstHalf.add(list.get(i));
		}
		
		return firstHalf;
	}
	
	public static <T> List<T> splitSecondHalf(List<T> list){
		
		List<T> secondHalf = new ArrayList<T>();
		
		int start = list.size() / 2;
		int end   = list.size() - 1;
		
		for(int i = start; i <= end; i++) {
			secondHalf.add(list.get(i));
		}
		
		return secondHalf;
	}
	
	
	
	public static <T> void swap(List<T> list, int a, int b) {
		T temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}
	
	//change the data type of swap2
	public static <T> void swap(List<T> list, T a, T b) {
		list.set(list.indexOf(a), b);
		list.set(list.indexOf(b), a);
	}

}
