package Greedy_Algorithms;

//The idea is based on the fact that a character among first (n+1) characters
// must be there in resultant number. So we pick the smallest of first (n+1) digits and put it in result,
// and recur for the remaining characters.

import java.util.Optional;

public class BuildLowestNobyRemovingNDigits {
    public static void main(String[] args) {
        String str = "4325043";
        int k = 3;
        int index = 0;
        buildLowestNumber(str, k, 0);
    }

    /**
     * @param str
     * @param k
     */
    private static void buildLowestNumber(String str, int k, int index) {

        if (k == index) {
            System.out.println(str);
            return;
        }

        String sub = str.substring(0, k + 1);
        Optional<Integer> max = sub.chars().mapToObj(ch -> (char) ch).map(Character::getNumericValue).max(Integer::compare);
        String strToRemove = max.get().toString();
        String newString = sub.replace(strToRemove, "");
        String newInput = newString + str.substring(k + 1);
        index++;
        buildLowestNumber(newInput, k, index);
    }
}
