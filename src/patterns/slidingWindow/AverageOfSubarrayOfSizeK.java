package patterns.slidingWindow;

/**
 * Sliding window with avg of sub array of size k
 *
 * runtime complexity O(n)
 */
public class AverageOfSubarrayOfSizeK {

    public static double[] avgOfSubArray(int k, int arr[]) {
        double[] output = new double[arr.length - k + 1];

        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

            windowSum += arr[windowEnd];

            if (windowEnd >= k-1) {
                output[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return output;
    }

    public static void main(String ar[]) {
        double output [] = avgOfSubArray(5, new int[]{1, 5, 7, 9, 3, 7, -1 , 2});


        for(double d : output) {
            System.out.print(d + " ");
        }
    }


}
