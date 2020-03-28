import java.util.Arrays;

/**
 * SortSquaredArray
 * 
 */
public class SortSquaredArray {

    public static void main(String[] args) {
        int[] givenArr = new int[] { -5, -3, -1, 0, 3, 5, 7, 8 };
        System.out.println("Given arr: " + Arrays.toString(givenArr));

        int[] sortedArr = sortAndSquareArray(givenArr);
        System.out.println("Sorted arr: " + Arrays.toString(sortedArr));
    }

    /**
     * Takes the given array which must be sorted ascendingly. It then squares the
     * elements and sorts its element.<br><br>
     * <b>Time complexity:</b> O(n);
     * <b>Space complexity:</b> O(n);
     * <br>
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

        // let both pointer run into each other until they hit
        for (int i = givenArr.length - 1; i > 0; i--) {
            if (Math.abs(givenArr[firstPointer]) > Math.abs(givenArr[secondPointer])) {
                sortedArr[i] = givenArr[firstPointer] * givenArr[firstPointer];
                firstPointer++;
            } else {
                sortedArr[i] = givenArr[secondPointer] * givenArr[secondPointer];
                secondPointer--;
            }
        }
        return sortedArr;
    }

}