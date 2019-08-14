/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (44.39%)
 * Likes:    1562
 * Dislikes: 1349
 * Total Accepted:    644K
 * Total Submissions: 1.5M
 * Testcase Example:  '121'
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome
 * when it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * 
 * Input: 121
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 * 
 * 
 * Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 * 
 */
class Solution {
    public boolean isPalindrome(int x) 
    {
        //negatives are always false
        if(x<0) return false;

        //get length
        int length,y=x;
        for(length = 0; ; length++){
            if(y==0) break;
            y/=10;
        }
        
        while(length>0)
        {
            if(length==1) return true;

            //get first digit
            int d1 = firstDigit(x, length);
            if(x%10 == d1)
            {
                x-=removeDigit(d1, length);
                x/=10;
                length-=2;
            }
            else return false;
        }
        return true;
    }

    private int firstDigit(int number, int length){
        for(int i = 0; i < length-1; i++)
        {
            number/=10;
        }
        return number;
    }
    private int removeDigit(int number, int length)
    {
        for(int i = 0; i < length-1; i++)
        {
            number*=10;
        }
        return number;
    }
}

