package prefix_sum;

public class NoOfWaysToSplitArray {
    public static void main(String[] args) {

        int[] arr = new int[]{10, 4, -8, 7};
        int count = 0;

        int[] prefix_sum = new int[arr.length];
        prefix_sum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length-1; i++) {
            if (prefix_sum[i] > (prefix_sum[arr.length - 1] - prefix_sum[i])) {
                count++;
            }
        }
        System.out.println(count);
    }
}
