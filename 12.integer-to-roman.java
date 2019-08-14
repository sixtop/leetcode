/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 *
 * https://leetcode.com/problems/integer-to-roman/description/
 *
 * algorithms
 * Medium (51.76%)
 * Likes:    649
 * Dislikes: 2022
 * Total Accepted:    252.7K
 * Total Submissions: 488.2K
 * Testcase Example:  '3'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: 3
 * Output: "III"
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "IV"
 * 
 * Example 3:
 * 
 * 
 * Input: 9
 * Output: "IX"
 * 
 * Example 4:
 * 
 * 
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 */
class Solution 
{
    public String intToRoman(int num) 
    {
        StringBuilder sb = new StringBuilder();
        int n = num%10;
        if(n <= 3 && n >= 1)
            for(int i = 0;i<n;i++) sb.append("I");
        else if(n == 4) sb.append("IV");
        else if(n >= 5 && n <=8) 
        {
            sb.append("V");
            if(n <= 8 && n >= 6)
                for(int i = 0;i<n-5;i++) sb.append("I");
        }
        else if(n == 9) sb.append("IX");

        n = (num/10)%10;
        System.out.println(sb.toString());
        if(n <= 3 && n >= 1)
            for(int i = 0;i<n;i++) sb.insert(0, "X");
        else if(n == 4) sb.insert(0, "XL");
        else if(n >= 5 && n <=8) 
        {
            sb.insert(0, "L");
            if(n <= 8 && n >= 6)
                for(int i = 0;i<n-5;i++) sb.insert(1, "X");
        }
        else if(n == 9) sb.insert(0,"XC");

        n = (num/100)%10;
        System.out.println(sb.toString());
        if(n <= 3 && n >= 1)
            for(int i = 0;i<n;i++) sb.insert(0, "C");
        else if(n == 4) sb.insert(0, "CD");
        else if(n >= 5 && n <=8) 
        {
            sb.insert(0, "D");
            if(n <= 8 && n >= 6)
                for(int i = 0;i<n-5;i++) sb.insert(1, "C");
        }
        else if(n == 9) sb.insert(0,"CM");

        n = (num/1000)%10;
        for(int i = 0;i<n;i++) sb.insert(0, "M");

        return sb.toString();
    }
}

