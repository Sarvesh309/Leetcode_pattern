package prefix_sum;

import java.util.Arrays;

//You are given an integer array gain of length n where gain[i] is the net gain in altitude between points
//Return the highest altitude of a point.
//Input: gain = [-5,1,5,0,-7]
//Output: 1
//The altitudes are [0,-5,-4,1,1,-6].
// The highest is 1.

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
