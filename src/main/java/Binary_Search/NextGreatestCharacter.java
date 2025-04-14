package Binary_Search;

//You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
// There are at least two different characters in letters.
//
//Return the smallest character in letters that is lexicographically greater than target.
// If such a character does not exist, return the first character in letters.

//Input: letters = ["c","f","j"], target = "a"
//Output: "c"
public class NextGreatestCharacter {

    public static char nextGreatestLetter = ' ';

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        char target = 'c';
        binarySearch(letters, target, 0, letters.length - 1);
        System.out.println(nextGreatestLetter != ' ' ? nextGreatestLetter : letters[0]);

    }

    static void binarySearch(char[] letters, char target, int leftIndex, int rightIndex) {
        if (rightIndex < leftIndex) {
            return;
        }
        int midIndex = (leftIndex + rightIndex) / 2;

        if (letters[midIndex] == target) {
            if (midIndex + 1 <= letters.length - 1)
                nextGreatestLetter = letters[midIndex + 1];
            return;
        } else if (letters[midIndex] > target) {
            nextGreatestLetter = letters[midIndex];
            binarySearch(letters, target, leftIndex, midIndex - 1);
        } else {
            binarySearch(letters, target, midIndex + 1, rightIndex);
        }
    }

}