package Two_Pointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(twoPointer(height));
    }

    private static int twoPointer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int temp;
        while (left < right) {
            int lheight = height[left];
            int rheight = height[right];
            temp = (Math.min(lheight, rheight)) * (right - left);
            if (temp > result)
                result = temp;

            if (lheight > rheight)
                right--;
            else
                left++;
        }
        return result;
    }

}
