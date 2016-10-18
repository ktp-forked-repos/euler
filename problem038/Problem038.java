package problem038;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:

 192 × 1 = 192
 192 × 2 = 384
 192 × 3 = 576
 By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

 The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

 What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */

public class Problem038 {
	
	public static int[] quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
		return array;
	}

    public static boolean isPandigital(int number) {
        char[] charArray = (number + "").toCharArray();

        int[] array = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            array[i] = charArray[i] - '0';
        }

        array = quicksort(array);

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1] + 1) {
                return false;
            }
        }

        return true;
    }
	
	public static void quicksort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quicksort(arr, low, j);
 
		if (high > i)
			quicksort(arr, i, high);
	}

	public static void main(String[] args) {

        int maxPandigital = 0;

        for (int setLength = 2; setLength < 10; setLength++) {
            int[] set = getSet(setLength);

            for (int i = 2; true; i++) {
                int concatenatedProduct = getConcatenatedProduct(i, set);
                if (concatenatedProduct == -1) {
                    break;
                }


                if (isPandigital(concatenatedProduct)) {
                    if (concatenatedProduct > maxPandigital) {
                        maxPandigital = concatenatedProduct;
                    }
                }
            }
        }

        System.out.println(maxPandigital);
		
	}

    private static int getConcatenatedProduct(int i, int[] set) {
        String result = "";

        for (int a = 0; a < set.length; a++) {
            result += i * set[a];
        }

        if (result.length() < 10) {
            return Integer.parseInt(result);
        }

        return -1;
    }

    private static int[] getSet(int setLength) {
        int[] set = new int[setLength];

        for (int i = 0; i < setLength; i++) {
            set[i] = i + 1;
        }

        return set;
    }

}

// Answer: 932718654
