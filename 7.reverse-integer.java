/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */
class Solution {
    public int reverse(int x) 
    {
        long output = 0;

        while(x!=0)
        {
            output = output*10 + x%10;
            x /= 10;
        }

        if(output > Integer.MAX_VALUE || output < Integer.MIN_VALUE)
            return 0;

        return (int)output;
    }
}

