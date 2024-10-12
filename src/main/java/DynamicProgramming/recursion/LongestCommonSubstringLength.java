package DynamicProgramming.recursion;

import static java.lang.Math.max;

//Modification of LCSubsequence
public class LongestCommonSubstringLength {
    public static void main(String[] args) {
        int lcs = LCS("abcdf", "abceh", 4, 4, 0);
        System.out.println(lcs);
    }

    static int LCS(String str1, String str2, int n, int m, int count)
    {
        if (n==0 || m==0)
            return count;

        if (str1.charAt(n-1) == str2.charAt(m-1))
            return LCS(str1, str2, n-1, m-1, count+1);

        return max(count, max(LCS(str1, str2, n-1, m, 0), LCS(str1, str2, n, m-1, 0)));
    }
}
