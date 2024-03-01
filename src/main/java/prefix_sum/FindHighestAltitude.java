package prefix_sum;

import java.util.Arrays;


//Generally subarray + even odd = prefix sum
public class FindHighestAltitude {
    public static void main(String[] args) {
        int[] gain = new int[]{-5, 1, 5, 0, -7};
        int[] result = new int[gain.length];
        result[0] = gain[0];
        for (int i = 1; i < gain.length; i++) {
            result[i] = gain[i] + result[i - 1];
        }
        System.out.println(Arrays.toString(result));
    }
}
