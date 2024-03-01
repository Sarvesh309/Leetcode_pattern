package Greedy_Algorithms;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};

        //Initialize the result and intermediate min_value properly
        int result = Integer.MIN_VALUE;
        int curr_min = Integer.MAX_VALUE;


        for (int price : prices) {
            //first update the min value
            if (price < curr_min) {
                curr_min = price;
            }
            //Subsequently update the profit thereafter
            if (result < (price - curr_min)) {
                result = price - curr_min;
            }
        }
        System.out.println(result);
    }
}
