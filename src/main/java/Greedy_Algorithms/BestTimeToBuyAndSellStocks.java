package Greedy_Algorithms;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 4, 5};

        //Initialize the result and intermediate min_value properly
        int result = Integer.MIN_VALUE;
        int min_stock_price_till_now = Integer.MAX_VALUE;


        for (int price : prices) {
            //first update the min stock price
            if (price < min_stock_price_till_now) {
                min_stock_price_till_now = price;
            }
            //Subsequently update the profit thereafter
            if (result < (price - min_stock_price_till_now)) {
                result = price - min_stock_price_till_now;
            }
        }
        System.out.println(result);
    }
}
