import java.util.Arrays;
import java.util.HashSet;

/**
 * ArrayOperations
 * 
 */
public class ArrayOperations {

    public static void main(String[] args) {
        int[] givenArr = new int[] { -5, -3, -1, 0, 3, 5, 7, 8 };
        System.out.println("Given arr: " + Arrays.toString(givenArr));

        System.out.println("---");

        int[] sortedArr = sortAndSquareArray(givenArr);
        System.out.println("Sorted arr: " + Arrays.toString(sortedArr));

        System.out.println("---");

        int[] duplicateArr = new int[] { 2, 1, 3, 5, 3, 2 };
        System.out.println("Search for first duplicate in: " + Arrays.toString(duplicateArr)); 
        int firstDuplicate = firstDuplicateBestSolution(duplicateArr);
        System.out.println("First duplicate is: " + firstDuplicate);
    }

    /**
     * <b>Asked by Google</b><br>
     * <br>
     * <b> Better solution because time complexity is O(n). But space complexity is
     * also O(n)</b> <br>
     * <br>
     * The given array contains number between 0 and {@code arr.length}. It can also
     * contain duplicates. This function determines the first found duplicate. If
     * there are multiple duplicates, it returns the one with the lowest index.
     * 
     * @param arr the array which has to be checked
     * @return the index of the first duplicate. If no duplicate found it returns
     *         -1;
     */
    private static int firstDuplicateLinearSolution(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!seen.contains(arr[i])) {
                seen.add(arr[i]);
            } else {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * <b>Asked by Google</b><br>
     * <br>
     * <b> Best solution because time and space complexity is O(n).</b> <br>
     * <br>
     * The given array contains number between 0 and {@code arr.length}. It can also
     * contain duplicates. This function determines the first found duplicate. If
     * there are multiple duplicates, it returns the one with the lowest index.
     * 
     * @param givenArr the array which has to be checked
     * @return the index of the first duplicate. If no duplicate found it returns
     *         -1;
     */
    private static int firstDuplicateBestSolution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            
            int lookupElement = Math.abs(arr[i] - 1);

            if (arr[lookupElement] < 0) {
                return Math.abs(arr[i]);    // if the element is already marked with minus, return it.
            } else {
                arr[lookupElement] = (-1) * arr[lookupElement]; // mark the element as visited with a minus
            }
        }
        return -1;
    }

    /**
     * <b>Asked by Google</b><br>
     * <br>
     * <b> Bad solution because time complexity is O(n^2).</b> <br>
     * <br>
     * The given array contains number between 0 and {@code arr.length}. It can also
     * contain duplicates. This function determines the first found duplicate. If
     * there are multiple duplicates, it returns the one with the lowest index.
     * 
     * @param givenArr the array which has to be checked
     * @return the index of the first duplicate. If no duplicate found it returns
     *         -1;
     */
    private static int firstDuplicateSquareSolution(int[] arr) {
        int minDuplicateIndex = arr.length;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    if (j < minDuplicateIndex)
                        minDuplicateIndex = j;
                }
            }
        }
        if (minDuplicateIndex == arr.length) {
            return -1;
        }
        return arr[minDuplicateIndex];
    }

    /**
     * <b>Asked by Facebook</b><br>
     * <br>
     * Takes the given array which must be sorted ascendingly. It then squares the
     * elements and sorts its element.<br>
     * <br>
     * <b>Time complexity:</b> O(n); <b>Space complexity:</b> O(n); <br>
     * 
     * Example: <br>
     * <br>
     * Given: [-5, -3, -1, 0, 3, 5, 7, 8]<br>
     * <br>
     * Expected: [0, 1, 9, 9, 25, 25, 49, 64]
     * 
     * @param arr the array which has to be sorted and squared
     */
    private static int[] sortAndSquareArray(int[] givenArr) {
        // create two pointers which will show on the most left and most right element
        int firstPointer = 0;
        int secondPointer = givenArr.length - 1;
        int[] sortedArr = new int[givenArr.length];

        // iterate the list from the end
        for (int i = givenArr.length - 1; i > 0; i--) {
            // checks whether the absolute element in the beginning is greater than the last
            // element
            if (Math.abs(givenArr[firstPointer]) > Math.abs(givenArr[secondPointer])) {
                sortedArr[i] = givenArr[firstPointer] * givenArr[firstPointer];
                firstPointer++; // moves pointer forward to then compare the next element
            } else {
                sortedArr[i] = givenArr[secondPointer] * givenArr[secondPointer];
                secondPointer--; // moves pointer backward to then compare the next element
            }
        }
        return sortedArr;
    }

}