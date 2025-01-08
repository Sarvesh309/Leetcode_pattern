package DynamicProgramming.recursion;

//Coin change 2
//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//You may assume that you have an infinite number of each kind of coin.
//Input: amount = 5, coins = [1,2,5]
//Output: 4
//Explanation: there are four ways to make up the amount:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1

//TODO:- Unbounded knapsack
public class Coin_change_totalNumberOfWays {
    public static void main(String[] args) {

        int[] coins = new int[]{1, 2, 5};
        int amount = 5;
        System.out.println(maxNumberOfWaysForAmountWithGivenCoins(coins, amount, 0));
    }

    static int maxNumberOfWaysForAmountWithGivenCoins(int[] coins, int amount, int index) {
        if (amount == 0)
            return 1;

        if (amount < 0 || index >= coins.length)
            return 0;

        if (coins[index] <= amount) {
            return maxNumberOfWaysForAmountWithGivenCoins(coins, amount - coins[index], index) + maxNumberOfWaysForAmountWithGivenCoins(coins, amount, index + 1);
        } else
            return maxNumberOfWaysForAmountWithGivenCoins(coins, amount, index + 1);
    }
}
