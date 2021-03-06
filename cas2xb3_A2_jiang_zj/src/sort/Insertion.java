package sort;

public class Insertion {
	
	// compare two Word's, if a has a higher rank than b
	private static boolean higher(Word a, Word b) {
		if (a.getScore() > b.getScore())
			return true;
		return false;
	}
	
	private static boolean higher(Comparable a, Comparable b) {
		if (((Word) a).getScore() >= ((Word) b).getScore())
			return true;
		return false;
	}
	
	// exchange two Wrod's in an array
	private static void swap(Comparable[] x, int a, int b) {
		Comparable t = x[a];
		x[a] = x[b];
		x[b] = t;
	}
	
	// check if the array is sorted
	public static boolean isSorted(Word[] x) {
		for (int i=0; i<x.length-1; i++) {
			if ((x[i].compareTo(x[i+1]) < 0))
				return false;
		}
		return true;
	}
	
	/**
	 * regular insertion sort
	 * @param x - the input array containing scores of words that need to be sorted.
	 */
	public static void sortInsert ( Word[] x) {
		int N = x.length;
		for (int i=0; i<N; i++) {
			for (int j=i; j>0 && higher(x[j], x[j-1]); j--) {
				// moved if inside the for to the condition of for, saved 30% of running time
				swap(x, j-1, j);
			}
		}
	}
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing scores of words that need to be sorted.
	 */
	public static void sortComparable ( Comparable[] x) {
		int N = x.length;
		for (int i=0; i<N; i++) {
			for (int j=i; j>0 && x[j].compareTo(x[j-1]) > 0; j--) {
//			for (int j=i; j>0 && higher(x[j], x[j-1]); j--) {
				// experimented with the two comparing method, turns out compareTo saves 1 ms in 4096 words
				// moved if inside the for to the condition of for, saved 30% of running time
				swap(x, j-1, j);
			}
		}
	}

	/**
	 * optimized insertion sort
	 * @param x - the input array containing scores of words that need to be sorted.
	 */
	public static void sortBinary ( Comparable[] x) {
		int N = x.length;
		for (int i=0; i<N; i++) {
			Comparable t = x[i];
			int left = 0;
			int right = i;
			while (left < right) {
				int middle = (left + right) / 2;
				if (t.compareTo(x[middle]) < 0)
					left = middle + 1;
				else
					right = middle;
			}
			for (int j=i; j>left; j--) {
				swap(x, j-1, j);
			}
		}
	}
	
    public static void main(String[] args){
        Comparable a[]=new Comparable[]{12,10,34,23,9,7,8,5,6};
        sortBinary(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
