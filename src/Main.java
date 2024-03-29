import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

        //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        //int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};

       int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Original array: " + Arrays.toString(array));

        System.out.println(array.length);

        manipulateArray(array);

        System.out.println("Manipulated array: " + Arrays.toString(array));
    }

        public static void manipulateArray(int[] arr) {
            int n = arr.length;

            // Determine the left and right halves based on array size
            int leftSize = 0, rightSize = 0;
            int middle = (n/2)-1;

            if (n % 2 == 0) {
                // Array is even
                if (n / 2 % 2 == 0) {
                    // Both left and right halves are even
                    leftSize = n / 2;
                    rightSize = n / 2;
                } else {
                    // Left and right halves are not even
                    leftSize = (n / 2) + 1;
                    rightSize = (n / 2) + 1;
                }
            } else {
                // Array is odd
                if ((n/2) % 2 == 0) { // IF Array is odd AND both sides are EVEN
                    // Leaving the middle element intact would result in both sides being even
                    leftSize = Math.ceilDiv(n, 2); // Ceiling to ignore the middle value
                    rightSize = leftSize;
                } else {
                    // Leaving the middle element intact would result in both sides being odd
                    leftSize = Math.ceilDiv(n, 2) + 1; // + 1 to make the left side bigger since both sides are odd
                    rightSize = leftSize;
                }
            }

            // Reverse every two consecutive elements in the left half
            for (int i = 0; i <= leftSize - 2; i += 2) {
                swap(arr, i, i + 1);
            }

            // Modify the right half by changing the second element to the sum of the two elements
            for (int i = rightSize; i <= n - 2; i += 2) {
                arr[i + 1] = arr[i] + arr[i + 1];
            }
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
}